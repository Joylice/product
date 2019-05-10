package com.business.product.service.impl;

import com.business.product.DTO.CartDTO;
import com.business.product.dataobject.ProductInfo;
import com.business.product.enums.ProductStatusEnum;
import com.business.product.enums.ResultEnums;
import com.business.product.exception.ProductException;
import com.business.product.repository.ProductInfoRepository;
import com.business.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> carts) {
        for (CartDTO cartDTO : carts) {
            Optional<ProductInfo> producutInfoOptional = productInfoRepository.findById(cartDTO.getProductId());
            if (!producutInfoOptional.isPresent()) {
                throw new ProductException(ResultEnums.PRODUCT_NOT_EXIST);
            }
            ProductInfo productInfo = producutInfoOptional.get();
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) {
                throw new ProductException(ResultEnums.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }


}
