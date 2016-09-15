package com.cr.managedbeans.request;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.cr.managedbeans.view.TransactionRecord;

@ManagedBean
@ViewScoped
public class TransactionRecordRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{transactionRecord}")
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
			System.out.println("Holaaaaa");
		}
		
		System.out.println(transactionRecord.getTransaction().getListDetailsTransaction().get(0).getProduct().getProductId());
		
	}
	
}
