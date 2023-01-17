package com.sparta.morningworkout.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class SellerRegist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private long userId;
    @Column(nullable = false)
    private String username;

    public boolean isAccept() {
        return false;
    }
    @Column
    private String infoContent;
    @Column
    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    public SellerRegist(long userId, String username, String infoContent, CategoryEnum category) {
        this.userId = userId;
        this.username = username;
        this.infoContent = infoContent;
        this.category = category;
    }
}
