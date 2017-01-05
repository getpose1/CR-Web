package com.cr.managedbeans.request;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.cr.domain.DetailsTransaction;
import com.cr.domain.Products;
import com.cr.domain.Transactions;
import com.cr.ejb.services.TransactionsServEJB;
import com.cr.managedbeans.view.TransactionRecordSessionMB;



@Named
@RequestScoped
public class TransactionRecordRequestMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private TransactionsServEJB transactionsServEJB;
	
	@Inject
	private TransactionRecordSessionMB transactionRecordSessionMB;
	
	@PostConstruct
	public void init(){
		Products product = new Products();
		product.setAmount(0l);
	}
	
	public TransactionRecordSessionMB getTransactionRecordSessionMB() {
		return transactionRecordSessionMB;
	}




	public void setTransactionRecordSessionMB(TransactionRecordSessionMB transactionRecordSessionMB) {
		this.transactionRecordSessionMB = transactionRecordSessionMB;
	}




	public void savedTransaction(){
		Transactions transactions = getTransactionRecordSessionMB().getTransaction();
		
		Calendar calendar = Calendar.getInstance();
		transactions.setCreated(new Date());
		transactions.setCreatedBy(123456789);
		transactions.setTransactionId("" + calendar.get(Calendar.YEAR) + calendar.get(Calendar.MONTH) + calendar.get(Calendar.DAY_OF_MONTH) + calendar.get(Calendar.HOUR_OF_DAY) + calendar.get(Calendar.SECOND) + calendar.get(Calendar.MILLISECOND));
		System.out.println("" + calendar.get(Calendar.YEAR) + calendar.get(Calendar.MONTH) + calendar.get(Calendar.DAY_OF_MONTH) + calendar.get(Calendar.HOUR_OF_DAY) + calendar.get(Calendar.SECOND) + calendar.get(Calendar.MILLISECOND));
		System.out.println("SubTotal:" + transactions.getSubTotalAmount());
		System.out.println("Impuestos:" + transactions.getTaxAmount());
		System.out.println("Total:" + transactions.getTotalAmount());
		transactions.setType("V");
		
		
		 int i = 1;
		for(DetailsTransaction detail : getTransactionRecordSessionMB().getTransaction().getListDetailsTransaction()){
			System.out.println(detail.getProduct().getProductId());
			System.out.println("Base :" + detail.getBaseAmount());
			System.out.println("Subtotal:" + detail.getSubTotal());
			System.out.println("Cantidad:" + detail.getQuantity());
			
			detail.setTransactionId(transactions.getTransactionId());
			detail.setDetailTransactionId(i++);
		}
		
		try {
			transactionsServEJB.saveTransaction(transactions);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
}
