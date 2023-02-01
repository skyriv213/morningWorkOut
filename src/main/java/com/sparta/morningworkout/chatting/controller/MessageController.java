package com.sparta.morningworkout.chatting.controller;

import com.sparta.morningworkout.chatting.dto.MessageDto;
import com.sparta.morningworkout.chatting.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;
    private final SimpMessageSendingOperations sendingOperations;

    @MessageMapping("/send")
    public void chatMessage(MessageDto messageDto) {
        messageService.chat(messageDto);
        sendingOperations.convertAndSend("sub/receive/" + messageDto.getSender());

    }
}
