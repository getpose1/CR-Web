package com.cr.managedbeans.view;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.cr.domain.Products;
import com.cr.ejb.services.ProductServEJB;

/**
 * Manager Bean
 * **/

@ManagedBean(name = "ProductRecord")
@ViewScoped
public class ProductRecord implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Products product;
	private List<Products> products; 
	
	@EJB
	private ProductServEJB productServEJB;
	
	@ManagedProperty(value = "#{transactionRecord}")
	private TransactionRecordSessionMB transactionRecord;

	
	public TransactionRecordSessionMB getTransactionRecord() {
		return transactionRecord;
	}

	public void setTransactionRecord(TransactionRecordSessionMB transactionRecord) {
		this.transactionRecord = transactionRecord;
	}
	
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
		
		for(int i = 0; i < 5 ; i++){
			System.out.println("Holaaaaa");
		}
		
		System.out.println(transactionRecord.getTransaction().getListDetailsTransaction().get(0).getProduct().getProductId());
		
		
	}

}
