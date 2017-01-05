package com.cr.persistence.impl;

import org.apache.ibatis.session.SqlSession;

import com.cr.domain.DetailsTransaction;
import com.cr.domain.Transactions;
import com.cr.persistence.mapping.MyBatisUtil;
import com.cr.persistence.services.DetailsTransactionMapper;
import com.cr.persistence.services.TransactionsMapper;

public class TransactionsMapperImpl implements TransactionsMapper {

	@Override
	public int deleteByPrimaryKey(String transactionId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Transactions record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Transactions record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Transactions selectByPrimaryKey(String transactionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Transactions record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Transactions record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void registerTransaction(Transactions transactions) {
		
		try{
			final SqlSession session = MyBatisUtil.getInstance().getSqlSession();	
			TransactionsMapper transactionsMapper;
			DetailsTransactionMapper detailsTransactionMapper;
			transactionsMapper = session.getMapper(TransactionsMapper.class);
			detailsTransactionMapper = session.getMapper(DetailsTransactionMapper.class);
			transactionsMapper.insertSelective(transactions);
			
			for(DetailsTransaction detailTransaction: transactions.getListDetailsTransaction()){
				detailsTransactionMapper.insertSelective(detailTransaction);
			}
			
//			session.commit();
			
		}catch (Exception e) {
			System.out.println("Error en persistencia");
			e.printStackTrace();
//			session.close();
		}finally {
//			if(session != null){
//				session.commit();
//				session.close();	
//			}
		} 
		
	}

}
