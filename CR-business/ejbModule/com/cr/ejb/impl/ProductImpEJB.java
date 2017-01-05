package com.cr.ejb.impl;

import javax.ejb.Stateless;

import com.cr.domain.Products;
import com.cr.ejb.services.ProductServEJB;
import com.cr.persistence.impl.ProductsMapperImpl;

@Stateless
public class ProductImpEJB implements ProductServEJB {

	@Override
	public Products productSelect(String productCode) throws Exception {
		
		ProductsMapperImpl productImpl = new ProductsMapperImpl();
		
		Products products = productImpl.selectByPrimaryKey(productCode);
		
		return products;
		
	}

}
