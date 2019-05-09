package com.business.product.service;

import com.business.product.dataobject.ProductInfo;

import java.util.List;

public interface ProductService {

    List<ProductInfo> findUpAll();

    List<ProductInfo> findByProductIdIn(List<String> productIds);
}
