package com.example.springbootproject.sell.service;

import com.example.springbootproject.sell.dto.response.MaxPricePerSize;

import java.util.List;

public interface SellService {
    //즉시 판매 버튼 눌렀을때
    // 가장 높은 가격을 제시한 사람 표시
    List<MaxPricePerSize> findMaxPricePerSize(Long productId);

}
