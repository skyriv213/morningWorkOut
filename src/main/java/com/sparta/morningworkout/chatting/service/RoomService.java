package com.sparta.morningworkout.chatting.service;

import com.sparta.morningworkout.chatting.dto.RoomDto;
import com.sparta.morningworkout.chatting.entity.ChatRooms;
import com.sparta.morningworkout.chatting.repository.RoomRepository;
import com.sparta.morningworkout.entity.Product;
import com.sparta.morningworkout.entity.Profile;
import com.sparta.morningworkout.entity.User;
import com.sparta.morningworkout.repository.ProductRepository;
import com.sparta.morningworkout.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;
    private final ProductRepository productRepository;
    private final ProfileRepository profileRepository;
    public void createRoom(Long productId, User customer) {
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new IllegalArgumentException("상품이 존재하지 않습니다.")
        );

        Profile profile = profileRepository.findById(customer.getId()).orElseThrow(
                () -> new IllegalArgumentException("사용자가 존재하지 않습니다.")
        );
        ChatRooms chatRooms = new ChatRooms(product, profile);
        roomRepository.save(chatRooms);
    }

    public RoomDto goChat(long roomId) {
        ChatRooms rooms = roomRepository.findById(roomId).orElseThrow(
                () -> new IllegalArgumentException("채팅방이 존재하지 않습니다.")
        );
        return RoomDto.builder().roomId(rooms.getId()).productId(rooms.getProductId()).build();
    }

}
