package com.business.common;

import lombok.Data;

@Data
public class DecreaseStockInput {
    private String productId;
    private Integer productQuantity;
}
