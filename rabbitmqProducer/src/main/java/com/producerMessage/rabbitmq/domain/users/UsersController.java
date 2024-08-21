package com.producerMessage.rabbitmq.domain.users;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.producerMessage.rabbitmq.domain.users.UsersRecord.UsersRecordResponseDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/users")
public class UsersController {

    private final UsersService usersService;

    @GetMapping("list")
    public List<UsersRecordResponseDTO> getAllList() {
        return usersService.getAllList();
    }

    @GetMapping("{id}")
    public UsersRecordResponseDTO findById(@PathVariable String id) {
        return usersService.findById(id);
    }

}
