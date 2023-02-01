package com.sparta.morningworkout.chatting.controller;

import com.sparta.morningworkout.chatting.dto.RoomDto;
import com.sparta.morningworkout.chatting.service.RoomService;
import com.sparta.morningworkout.security.UserDetailsImpl;
import com.sparta.morningworkout.service.ChatRoomServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @PostMapping("/chatrooms/{productId}")
    public ResponseEntity<String> createRoom(@PathVariable Long productId,
                                             @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        roomService.createRoom(productId, userDetails.getUser());
        return ResponseEntity.status(HttpStatus.CREATED).body("채팅방 생성 완료");
    }

    @GetMapping("/chatrooms/{roomId}")
    public ResponseEntity<RoomDto> gochat(@PathVariable long roomId) {
        RoomDto room = roomService.goChat(roomId);
        return ResponseEntity.status(HttpStatus.OK).body(room);
    }
}
