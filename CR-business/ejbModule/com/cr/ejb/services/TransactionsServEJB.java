package com.cr.ejb.services;

import javax.ejb.Local;

import com.cr.domain.Transactions;

@Local
public interface TransactionsServEJB {
	
	public void saveTransaction(Transactions transactions) throws Exception;

}
