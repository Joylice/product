package com.business.product.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ProductVO {
    /**
     * 类目名称
     */
    @JsonProperty("name")
    private String categoryName;
    /**
     * 类目种类
     */
    @JsonProperty("type")
    private Integer categoryType;
    /**
     * 所属商品
     */
    @JsonProperty("foods")
    List<ProductInfoVO> productInfoVOList;
}
