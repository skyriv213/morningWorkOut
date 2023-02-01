package com.sparta.morningworkout.chatting.entity;

import com.sparta.morningworkout.entity.ChatRoom;
import com.sparta.morningworkout.entity.Product;
import com.sparta.morningworkout.entity.Profile;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChatRooms {
    @Id
    @GeneratedValue
    @Column(name = "room_Id")
    private Long id;

    @Column(nullable = false, name = "product_id")
    private Long productId;

    @Column(nullable = false, name = "seller")
    private Long sellerId;

    @Column(nullable = false, name = "customer")
    private Long customerId;

    @ManyToOne
    private Profile profile;

    public ChatRooms(Product product, Profile profile) {
        this.productId = product.getId();
        this.sellerId = product.getUserId();
        this.customerId = profile.getId();
        this.profile = profile;
    }
}
