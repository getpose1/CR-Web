package com.cr.persistence.mapping;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	
	private String resource = "com/cr/persistence/mapping/mybatis-config.xml";
	private SqlSession session = null;
	
	public SqlSession  getSession(){
		
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			session = sqlMapper.openSession();
		} catch (Exception e) {
			System.out.println("Error en lectura, conexion");
			e.printStackTrace();
		}
		
		return session;
		
	}

}
