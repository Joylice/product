package com.business.product.VO;

import lombok.Data;

@Data
public class ResultVO<T> {
    /**
     * 错误码
     */
    private Integer code;
    /**
     * 错误信息
     */
    private String message;
    /**
     * 具体内容
     */
    private T data;
}
