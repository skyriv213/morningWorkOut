package com.sparta.morningworkout.entity;

import com.sparta.morningworkout.dto.product.ProductUpdateRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@Entity
@SuperBuilder
@NoArgsConstructor
public class Product extends TimeStamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private long userId;
    @Column(nullable = false)
    private String productName;
    @Column(nullable = false)
    private int price;
    @Column(nullable = false)
    private int point;
    @Column
    @Enumerated(EnumType.STRING)
    private CategoryEnum category;
    public Product(long userId, String productName, int price, CategoryEnum category){
         this.userId = userId;
         this.productName = productName;
         this.price = price;
         this.category = category;
         this.point = price*2;
    }
    public void update(ProductUpdateRequestDto productUpdateRequestDto) {
        this.price = productUpdateRequestDto.getPrice();
    }
}
