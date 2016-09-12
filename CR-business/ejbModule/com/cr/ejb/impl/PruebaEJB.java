package com.cr.ejb.impl;

import javax.ejb.Stateless;

import com.cr.domain.Products;
import com.cr.ejb.services.PruebaEjb;
import com.cr.persistence.impl.ProductsMapperImpl;

@Stateless
public class PruebaEJB implements PruebaEjb {

	@Override
	public Products pruebaEJB(String productCode) throws Exception {
		
		ProductsMapperImpl productImpl = new ProductsMapperImpl();
		
		Products prueba1 = productImpl.selectByPrimaryKey(productCode);
		
		return prueba1;
		
	}

}
