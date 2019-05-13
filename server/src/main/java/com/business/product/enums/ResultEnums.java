package com.business.product.enums;

import lombok.Getter;

@Getter
public enum ResultEnums {
    PRODUCT_NOT_EXIST(1, "商品不存在"),
    PRODUCT_STOCK_ERROR(2, "库存错误");

    private String message;
    private Integer code;

    ResultEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
