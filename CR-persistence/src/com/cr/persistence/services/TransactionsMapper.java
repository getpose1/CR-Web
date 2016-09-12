package com.cr.persistence.services;

import com.cr.domain.Transactions;

public interface TransactionsMapper {
    int deleteByPrimaryKey(String transactionId);

    int insert(Transactions record);

    int insertSelective(Transactions record);

    Transactions selectByPrimaryKey(String transactionId);

    int updateByPrimaryKeySelective(Transactions record);

    int updateByPrimaryKey(Transactions record);
}