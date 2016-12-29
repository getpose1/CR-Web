package com.cr.managedbeans.request;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.cr.managedbeans.view.TransactionRecord;

@Named
@RequestScoped
public class TransactionRecordRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private TransactionRecord transactionRecord;

	
	public TransactionRecord getTransactionRecord() {
		return transactionRecord;
	}

	public void setTransactionRecord(TransactionRecord transactionRecord) {
		this.transactionRecord = transactionRecord;
	}

	@PostConstruct
	public void init(){}
	
	public void savedTransaction(){
		
		for(int i = 0; i < 5 ; i++){
			System.out.println(getTransactionRecord().getTransaction().getListDetailsTransaction().get(i).getProduct().getProductId());
		}
	
	}
	
}
