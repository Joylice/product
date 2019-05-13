package com.business.product.service;

import com.business.common.DecreaseStockInput;
import com.business.common.ProductInfoOutPut;
import com.business.product.dataobject.ProductInfo;

import java.util.List;

public interface ProductService {

    List<ProductInfo> findUpAll();

    List<ProductInfoOutPut> findByProductIdIn(List<String> productIds);

    /**
     * 扣库存
     *
     * @param carts
     */
    void decreaseStock(List<DecreaseStockInput> carts);
}
