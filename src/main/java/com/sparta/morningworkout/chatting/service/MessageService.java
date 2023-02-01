package com.sparta.morningworkout.chatting.service;

import com.sparta.morningworkout.chatting.dto.MessageDto;
import com.sparta.morningworkout.chatting.entity.ChatRooms;
import com.sparta.morningworkout.chatting.entity.Message;
import com.sparta.morningworkout.chatting.repository.RoomRepository;
import com.sparta.morningworkout.repository.PointRepository;
import com.sparta.morningworkout.repository.ProductRepository;
import com.sparta.morningworkout.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MessageService {
    //    private final MessageRepository messageRepository;
    private final RoomRepository roomRepository;
    private final ProductRepository productRepository;
    private final ProfileRepository profileRepository;
    private final PointRepository pointRepository;

    public void chat(MessageDto messageDto) {
        ChatRooms rooms = roomRepository.findById(messageDto.getRoomId()).orElseThrow(
                () -> new IllegalArgumentException("채팅방이 존재하지 않습니다.")
        );

        if (messageDto.getProductId() != rooms.getProductId()) {
            throw new IllegalArgumentException("해당 상품의 채팅방이 존재하지 않습니다.");
        } else {
            Message messages = new Message(messageDto, rooms.getId());

        }
    }
}
