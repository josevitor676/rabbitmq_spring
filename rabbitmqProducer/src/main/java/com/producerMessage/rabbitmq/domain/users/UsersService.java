package com.producerMessage.rabbitmq.domain.users;

import java.util.List;

import com.producerMessage.rabbitmq.domain.users.UsersRecord.UsersRecordResponseDTO;

public interface UsersService {

    public List<UsersRecordResponseDTO> getAllList();

    public UsersRecordResponseDTO findById(String id);
}
