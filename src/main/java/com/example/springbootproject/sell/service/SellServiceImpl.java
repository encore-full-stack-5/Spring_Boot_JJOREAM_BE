package com.example.springbootproject.sell.service;

import com.example.springbootproject.buy.repository.BuyRepository;
import com.example.springbootproject.sell.dto.response.MaxPricePerSize;
import com.example.springbootproject.sell.repository.SellRepository;
import com.example.springbootproject.size.domain.Size;
import com.example.springbootproject.size.repository.SizeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SellServiceImpl implements SellService {
    private final SellRepository sellRepository;
    private final SizeRepository sizeRepository;
    private final BuyRepository buyRepository;

    @Override
    public List<MaxPricePerSize> findMaxPricePerSize(Long productId) {
        List<MaxPricePerSize> sizeList = new ArrayList<>();
        List<Size> byProductId = sizeRepository.findAllByProductId(productId);
        for (int i = 0; i < byProductId.size(); i++ ) {
            Size sizeObject = byProductId.get(i);
            // size에서 size value를 받는다.
            String size = sizeObject.getSizeValue();
            // size_id를 가지고 최대 price를 가져온다.
            Long price = buyRepository.findBySizeIdOrderByPriceDesc(sizeObject.getId()).get(0).getPrice();
            // 이들을 하나의 record로 묶는다.
            MaxPricePerSize maxPricePerSize = new MaxPricePerSize(size, price);
            // List에 add한다.
            sizeList.add(maxPricePerSize);
        }
        return sizeList;
    }


}
