package com.business.client;


import com.business.common.DecreaseStockInput;
import com.business.common.ProductInfoOutPut;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "product")
public interface ProductClient {
    /**
     * 获取商品信息
     *
     * @param productIds
     * @return
     */
    @PostMapping("/product/listForOrder")
    List<ProductInfoOutPut> getProductInfoList(@RequestBody List<String> productIds);

    @PostMapping("/decreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockInput> cartDTOS);
}

