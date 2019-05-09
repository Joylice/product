package com.business.product.service.impl;

import com.business.product.dataobject.ProductInfo;
import com.business.product.enums.ProductStatusEnum;
import com.business.product.repository.ProductInfoRepository;
import com.business.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> findByProductIdIn(List<String> productIds) {
        return productInfoRepository.findByProductIdIn(productIds);
    }


}
