package com.cr.managedbeans.view;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import com.cr.domain.Products;
import com.cr.ejb.services.PruebaEjb;

/**
 * Manager Bean
 * **/

public class Prueba implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Products product;
	private List<Products> products; 
	
	@EJB
	private PruebaEjb pruebaEjb;
	
	@PostConstruct
	public void init(){
		product = new Products(); 
		products = new LinkedList<>();
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}


	public void registrar(){
		
		Products productResponse;
		String productCode = null;
		try {
			System.out.println("Producto como Input:" + getProduct().getProductId());
			productCode = String.format("%012d", Integer.parseInt(product.getProductId()));
			productResponse  = pruebaEjb.pruebaEJB(productCode);
			if(productResponse != null)
				products.add(productResponse);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
