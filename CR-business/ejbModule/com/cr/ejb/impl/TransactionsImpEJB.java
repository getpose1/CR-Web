package com.cr.ejb.impl;

import javax.ejb.Stateless;

import com.cr.domain.Transactions;
import com.cr.ejb.services.TransactionsServEJB;
import com.cr.persistence.impl.TransactionsMapperImpl;

@Stateless
public class TransactionsImpEJB implements TransactionsServEJB{

	@Override
	public void saveTransaction(Transactions transactions) {
		
		TransactionsMapperImpl transactionsMapperImpl = new TransactionsMapperImpl();
		transactionsMapperImpl.registerTransaction(transactions);
		
	}

}
