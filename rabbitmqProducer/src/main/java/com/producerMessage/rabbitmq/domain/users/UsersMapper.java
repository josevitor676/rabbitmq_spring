package com.producerMessage.rabbitmq.domain.users;

import java.util.List;

import com.producerMessage.rabbitmq.domain.users.UsersRecord.UsersRecordResponseDTO;

public class UsersMapper {

    public static UsersRecordResponseDTO toRecordDTO(Users entity) {
        if (entity == null) {
            return null;
        } else {
            return UsersRecordResponseDTO.builder()
                    .id(entity.getId())
                    .name(entity.getName())
                    .email(entity.getEmail())
                    .image(entity.getImage())
                    .password(entity.getPassword())
                    .firstName(entity.getFirstName())
                    .lastName(entity.getLastName())
                    .build();
        }
    }

    public static List<UsersRecordResponseDTO> toRecordListDTO(List<Users> entites) {
        return entites.stream().map((user) -> UsersMapper.toRecordDTO(user)).toList();
    }

}
