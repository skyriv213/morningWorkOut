package com.sparta.morningworkout.chatting.repository;

import com.sparta.morningworkout.chatting.entity.ChatRooms;
import com.sparta.morningworkout.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<ChatRooms,Long> {
}
