package com.business.product.service.impl;

import com.business.product.ProductApplicationTests;
import com.business.product.dataobject.ProductCategory;
import com.business.product.service.CategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CategoryServiceImplTest extends ProductApplicationTests {

    @Autowired
    CategoryService categoryService;


    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> productCategories = categoryService.findByCategoryTypeIn(Arrays.asList(11, 22));
        Assert.assertTrue(productCategories.size() > 0);
    }
}