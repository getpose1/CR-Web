package com.cr.persistence.impl;

import org.apache.ibatis.session.SqlSession;

import com.cr.domain.Products;
import com.cr.persistence.mapping.MyBatisUtil;
import com.cr.persistence.services.ProductsMapper;

public class ProductsMapperImpl implements ProductsMapper {

	@Override
	public int deleteByPrimaryKey(String productId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Products record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Products record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Products selectByPrimaryKey(String productId) {
		Products product = null;
		try{
			
			ProductsMapper productMapper;
			final SqlSession session = MyBatisUtil.getInstance().getSqlSession();
			productMapper = session.getMapper(ProductsMapper.class);
			product = productMapper.selectByPrimaryKey(productId);
			
		}catch (Exception e) {
			System.out.println("Error en persistencia");
			e.printStackTrace();
		}finally {

		} 
		
		return product;
	}

	@Override
	public int updateByPrimaryKeySelective(Products record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Products record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
