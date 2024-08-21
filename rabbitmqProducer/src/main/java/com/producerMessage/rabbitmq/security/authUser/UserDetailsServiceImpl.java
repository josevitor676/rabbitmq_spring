package com.producerMessage.rabbitmq.security.authUser;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.producerMessage.rabbitmq.domain.users.Users;
import com.producerMessage.rabbitmq.domain.users.UsersRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsersRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final Optional<Users> userByLogin = userRepository.findByEmail(email);

        final Users usuario = userByLogin.get();

        return UserDetailDTO.builder()
                .id(usuario.getId())
                .name(usuario.getName())
                .password(usuario.getPassword())
                .email(usuario.getEmail())
                .firstName(usuario.getFirstName())
                .lastName(usuario.getLastName())
                .build();
    }

}