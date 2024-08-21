package com.consumerMessage.rabbitmq.domain.email;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consumerMessage.rabbitmq.domain.email.EmailRecord.EmailRecordRequestDTO;
import com.consumerMessage.rabbitmq.domain.email.EmailRecord.EmailRecordResponsetDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/email")
public class EmailController {

    private final EmailService emailService;

    @PostMapping
    public void create(@RequestBody EmailRecordRequestDTO dto) {
        emailService.create(dto);
    }

    @GetMapping
    public List<EmailRecordResponsetDTO> findAll() {
        return emailService.findAll();
    }

    @GetMapping("/{id}")
    public EmailRecordResponsetDTO findById(@PathVariable Integer id) {
        return emailService.findById(id);
    }
}
