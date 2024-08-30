package com.example.springbootproject.buy.service;

import com.example.springbootproject.buy.dto.response.BuyResponse;
import com.example.springbootproject.sell.domain.Sell;
import org.springframework.web.bind.annotation.RequestParam;

public interface BuyService {
    void savePurchase(Long sizeId, Long productId, Long price, TokenInfo tokenInfo);

    BuyResponse buyNow(Long sizeId, Long price, TokenInfo tokenInfo);
}
