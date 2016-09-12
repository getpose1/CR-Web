package com.cr.ejb.services;

import javax.ejb.Local;
import com.cr.domain.Products;

@Local
public interface PruebaEjb {
	
	public Products pruebaEJB(String productCode) throws Exception;

}
