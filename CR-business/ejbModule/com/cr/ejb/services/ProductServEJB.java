package com.cr.ejb.services;

import javax.ejb.Local;
import com.cr.domain.Products;

@Local
public interface ProductServEJB {
	
	public Products productSelect(String productCode) throws Exception;

}
