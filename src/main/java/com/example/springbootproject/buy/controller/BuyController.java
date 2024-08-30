package com.example.springbootproject.buy.controller;

import com.example.springbootproject.buy.dto.response.BuyResponse;
import com.example.springbootproject.buy.service.BuyService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/buy")
@AllArgsConstructor
@RequiredArgsConstructor
public class BuyController {


    private final BuyService buyService;

    // 구매 요청서 저장
    // 1. size id(requestParam), price, user id(path variable?)와 을 받아옴

    // @RequestMapping을 써야 하나?
    // 어떻게 2개의 entity에서 requestparam을 가져올까? user?id=1/size?id
    @PostMapping("/size") // sizeId와 product id를 받아옴
    public void askPurchase(@RequestParam("sizeId") Long sizeId, @RequestParam("productId") Long productId, @RequestBody Long price, TokenInfo tokenInfo) {
        buyService.savePurchase(sizeId, productId, price, tokenInfo);
    }

    // 일반 구매
    // 1. Sell entity의 size id 와 price가 맞으면 거래 진행



    //  즉시 구매
    // 1. 유저가 선택한 size id와 price가 sell entity의 size와 price와 맞으면 거래 진행
    // user id는 user token을 이용하고, product에 size=260와 type=buy 넣는 게 맞지 않나?
    @GetMapping("/buy")
    public BuyResponse buyNow(@PathVariable("userId") Long userId, @RequestParam("sizeId") Long sizeId, @RequestParam("price") Long price) {
        return buyService.buyNow(userId, sizeId, price);
    }





}
