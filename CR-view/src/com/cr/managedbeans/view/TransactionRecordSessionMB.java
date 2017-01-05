package com.cr.managedbeans.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.cr.domain.DetailsTransaction;
import com.cr.domain.Products;
import com.cr.domain.Transactions;
import com.cr.ejb.services.ProductServEJB;


@Named
@SessionScoped
public class TransactionRecordSessionMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Transactions transaction;
	private Products product;
	@Inject
	private ProductServEJB productServEJB;
	
	@PostConstruct
	public void init(){
		transaction = new Transactions();
		product = new Products();
	}
	
	public Transactions getTransaction() {
		return transaction;
	}

	public void setTransaction(Transactions transaction) {
		this.transaction = transaction;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public void searchProduct(){
		
		Products productResponse;
		String productCode = null;
		try {
			System.out.println("Producto como Input:" + getProduct().getProductId());
		//	for(int i = 1; i < 15; i++)
		//	{
				productCode = String.format("%012d", Integer.parseInt(getProduct().getProductId()));
				
				//Verificamos si el producto ya se incluido en los detalles para no ir a buscarlo a la BD
				boolean exist = checkForProduct(productCode);
				if(!exist){
					productResponse  = productServEJB.productSelect(productCode);
					includeDetail(productResponse, 1);
				}
		//	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void includeDetail(Products productResponse, int quantityProduct)
	{
		DetailsTransaction detailTransation = null;
		if (productResponse != null){
			detailTransation = new DetailsTransaction();
			detailTransation.setProduct(productResponse);
			detailTransation.setBaseAmount(productResponse.getAmount());
			detailTransation.setDiscountAmount(productResponse.getAmount()); // Este campo se va a calcular cuando exista logica de promocion o descuento
			detailTransation.setQuantity(quantityProduct);
			detailTransation.setSubTotal(detailTransation.getDiscountAmount() * detailTransation.getQuantity());
			transaction.getListDetailsTransaction().add(detailTransation);
			calculateTotal();
		}
	}
	
	private boolean checkForProduct(String productCode){
		
		Products product;
		for(DetailsTransaction detail:transaction.getListDetailsTransaction())
		{
			product = detail.getProduct();
			if(product.getProductId().equals(productCode))
			{
				detail.setQuantity(detail.getQuantity() + 1);
				detail.setSubTotal(detail.getDiscountAmount() * detail.getQuantity());
				calculateTotal();
				return true;
			}
		}
		
		return false;
		
	}
	
	private void calculateTotal(){
		
		transaction.setSubTotalAmount(0l);
		transaction.setTotalAmount(0l);
		transaction.setTaxAmount(0l);
		
		for(DetailsTransaction detail:transaction.getListDetailsTransaction()){
			transaction.setSubTotalAmount(transaction.getSubTotalAmount() + detail.getSubTotal());
		}
		
		//Calculamos el IVA Total de la transaccion
		transaction.setTaxAmount((transaction.getSubTotalAmount() * 20) / 100);
		//Calculamos el total de la transaccion
		transaction.setTotalAmount(transaction.getSubTotalAmount() + transaction.getTaxAmount());
	}
}
