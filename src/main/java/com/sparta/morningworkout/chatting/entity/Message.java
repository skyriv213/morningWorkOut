package com.sparta.morningworkout.chatting.entity;

import com.sparta.morningworkout.chatting.dto.MessageDto;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class Message {
    private String sender;
//    private String receiver;
    private String message;
    private LocalDateTime sendTime;
    private Long chatRoomId;

    public Message(MessageDto messageDto, Long chatRoomId) {
        this.sender = messageDto.getSender();
//        this.receiver = messageDto.getReceiver();
        this.message = messageDto.getMessage();
        this.sendTime = LocalDateTime.now();
        this.chatRoomId = chatRoomId;
    }
}
