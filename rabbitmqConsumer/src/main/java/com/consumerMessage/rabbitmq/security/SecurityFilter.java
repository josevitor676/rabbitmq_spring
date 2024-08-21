package com.consumerMessage.rabbitmq.security;

import java.io.IOException;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.consumerMessage.rabbitmq.security.authUser.ApiErrorResponse;
import com.consumerMessage.rabbitmq.security.authUser.UserDetailDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class SecurityFilter extends OncePerRequestFilter {
    private final ObjectMapper objectMapper;
    private final TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            String authHeader = request.getHeader("Authorization");
            String token = null;
            String username = null;
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                token = authHeader.substring(7);
                username = tokenService.extractUsername(token);
            }
            if (token == null) {
                filterChain.doFilter(request, response);
                return;
            }

            var dbo = tokenService.getDto(token);

            UserDetailDTO userDto = UserDetailDTO.builder().build();

            userDto = UserDetailDTO.builder()
                    .id(dbo.getId())
                    .name(dbo.getName())
                    .build();

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                if (tokenService.validateToken(token, username)) {
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                            userDto, null, null);
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }

            filterChain.doFilter(request, response);
        } catch (AccessDeniedException e) {
            ApiErrorResponse errorResponse = new ApiErrorResponse(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write(toJson(errorResponse));
        }
    }

    private String toJson(ApiErrorResponse response) {
        try {
            return objectMapper.writeValueAsString(response);
        } catch (Exception e) {
            return ""; // Return an empty string if serialization fails
        }
    }
}