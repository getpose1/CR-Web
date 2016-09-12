package com.cr.persistence.services;

import com.cr.domain.DetailsTransaction;

public interface DetailsTransactionMapper {
	
    int deleteByPrimaryKey(Integer detailTransactionId);

    int insert(DetailsTransaction record);

    int insertSelective(DetailsTransaction record);

    DetailsTransaction selectByPrimaryKey(Integer detailTransactionId);

    int updateByPrimaryKeySelective(DetailsTransaction record);

    int updateByPrimaryKey(DetailsTransaction record);
}