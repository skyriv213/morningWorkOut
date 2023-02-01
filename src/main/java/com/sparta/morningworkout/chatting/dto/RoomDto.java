package com.sparta.morningworkout.chatting.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RoomDto {
    private long roomId;
    private long productId;


}
