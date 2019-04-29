package com.business.product.controller;

import com.business.product.VO.ProductInfoVO;
import com.business.product.VO.ProductVO;
import com.business.product.VO.ResultVO;
import com.business.product.dataobject.ProductCategory;
import com.business.product.dataobject.ProductInfo;
import com.business.product.service.impl.CategoryServiceImpl;
import com.business.product.service.impl.ProductServiceImpl;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {
    @Autowired
    ProductServiceImpl productService;
    @Autowired
    CategoryServiceImpl categoryService;

    /**
     * 1.查询所有在架的商品
     * 2.获取类目type列表
     * 3.查询类目
     * 4.构造数据
     */
    @GetMapping("/product/list")
    public ResultVO<ProductVO> list() {
        List<ProductInfo> productInfos = productService.findUpAll();
        List<Integer> categoryTypeList = productInfos.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());
        List<ProductCategory> productCategories = categoryService.findByCategoryTypeIn(categoryTypeList);
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategories) {
            ProductVO productVO = new ProductVO();
            ProductInfoVO productInfoVO = new ProductInfoVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfos) {
                if (productCategory.getCategoryId() == productInfo.getCategoryType()) {
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(200);
        resultVO.setData(productVOList);
        resultVO.setMessage("成功");
        return resultVO;
    }
}
