package com.sparta.morningworkout.service;

import com.sparta.morningworkout.dto.SellerRegistResponseDto;
import com.sparta.morningworkout.dto.StatusResponseDto;
import com.sparta.morningworkout.dto.UserListResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AdminService {
    Page<UserListResponseDto> showCustomerList(int page);
    Page<UserListResponseDto> showSellerList(int page);
    List<SellerRegistResponseDto> showSellerRegistList();
    StatusResponseDto acceptSellerRegist(Long authorizationRequestId);
    StatusResponseDto deleteSellerRegist(Long authorizationRequestId);

}
