package com.business.product.repository;

import com.business.product.ProductApplicationTests;
import com.business.product.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ProductCategoryRepositoryTest extends ProductApplicationTests {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> productCategories = productCategoryRepository.findByCategoryTypeIn(Arrays.asList(11, 22));
        Assert.assertTrue(productCategories.size() > 0);
    }
}