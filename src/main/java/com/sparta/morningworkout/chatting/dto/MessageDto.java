package com.sparta.morningworkout.chatting.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {
    private long roomId;
    private long productId;
    private String sender;
//    private String receiver;
    private String message;
}
