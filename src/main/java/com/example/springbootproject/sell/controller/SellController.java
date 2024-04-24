package com.example.springbootproject.sell.controller;

import com.example.springbootproject.auth.service.AuthService;
import com.example.springbootproject.buy.dto.response.MinPricePerSize;
import com.example.springbootproject.buy.service.BuyService;
import com.example.springbootproject.sell.domain.Sell;
import com.example.springbootproject.sell.dto.request.SellRequest;
import com.example.springbootproject.sell.dto.response.MaxPricePerSize;
import com.example.springbootproject.sell.service.SellService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
public class SellController {
    SellService sellService;
    // 해당 product_id를 가진 sell entity를 가져와야 한다.
    // product_id를 가지고 size list를 가져온다.
    // SELECT size_id FROM size WHERE product_id = ? (path variable)

    // 받아온 sizeId를 기준으로 sell entity를 뒤지는데 size와 price만 출력한다.
    // SELECT size.size_value, price FROM sell
    // INNER JOIN size ON size.size_id = ? (받아온 값, loop돌려서 하나씩 빼야함)


    // 판매 버튼 누르고 사이즈별 가격나올 때 사용
    @GetMapping("/products/{productId1}/sell")
    public List<MaxPricePerSize> getMaxPricePerSize(@PathVariable Long productId1) {
        // token 인증 필요

        // 최대 가격 가져오기
        return sellService.findMaxPricePerSize(productId1);
    }

    // 구매 버튼에서 상품 선택하고 희망 구매 가격 입력할 때 사용
    // 일반 구매 : 입찰 가격 및 경매 마감 기한을 작성해서 구매 요청서 저장하고 point 차감
//    @PostMapping("buy/{productId}")
//    public void askForPurchase(@PathVariable Long productId,
//                               @RequestParam("size") String sizeValue,
//                               @RequestBody Long price,
//                               @RequestBody Integer duration,
//                               Long userId) {
//        // userId 는 token 사용
//        buyService.savePurchase(productId, sizeValue, price, duration, userId);
//
//        // pointHistory 차감
//    }
//
//
    // 즉시 판매
    void buyNow(Long price) {

    }

    // OrderHistory에 추가
}
