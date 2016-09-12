package com.cr.persistence.services;

import com.cr.domain.Products;

public interface ProductsMapper {
	
    int deleteByPrimaryKey(String productId);

    int insert(Products record);

    int insertSelective(Products record);

    Products selectByPrimaryKey(String productId);

    int updateByPrimaryKeySelective(Products record);

    int updateByPrimaryKey(Products record);
}