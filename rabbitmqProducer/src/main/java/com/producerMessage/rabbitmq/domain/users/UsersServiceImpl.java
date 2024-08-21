package com.producerMessage.rabbitmq.domain.users;

import java.util.List;

import org.springframework.stereotype.Service;

import com.producerMessage.rabbitmq.base.BaseService;
import com.producerMessage.rabbitmq.domain.users.UsersRecord.UsersRecordResponseDTO;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsersServiceImpl extends BaseService implements UsersService {

    private final UsersRepository usersRepository;

    @Override
    @Transactional
    public List<UsersRecordResponseDTO> getAllList() {
        var usersList = usersRepository.findAll();
        return usersList.stream().map((user) -> UsersMapper.toRecordDTO(user)).toList();
    }

    @Override
    @Transactional
    public UsersRecordResponseDTO findById(String id) {
        var userFind = usersRepository.findById(id).orElseThrow();

        return UsersMapper.toRecordDTO(userFind);
    }

}
