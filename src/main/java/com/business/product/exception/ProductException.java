package com.business.product.exception;

import com.business.product.enums.ResultEnums;

public class ProductException extends RuntimeException {

    private String message;
    private Integer code;

    public ProductException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnums resultEnums) {
        super(resultEnums.getMessage());
        this.code = resultEnums.getCode();
    }
}
