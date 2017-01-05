package com.cr.persistence.mapping;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	
    private static SqlSessionFactory factory = null; 
	private static MyBatisUtil instance = null;
	
	private String resource = "com/cr/persistence/mapping/mybatis-config.xml";
	private SqlSession session = null;
	
	
    private MyBatisUtil() {
    }
	
    public static synchronized MyBatisUtil getInstance() {
    	if (instance == null)
    		instance = new MyBatisUtil();
        return instance;
    }
    
    static void ss(){
    	
    }
	
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
	
    public synchronized SqlSession getSqlSession() throws Exception{
    	try{
    		if (factory==null){
	        	final Reader reader = Resources.getResourceAsReader( resource );
	        	if (reader==null){
	        		throw new Exception("Can't open MyBatis config file.");
	        	}
	        	final SqlSessionFactoryBuilder factoryBuild = new SqlSessionFactoryBuilder();
	        	factory = factoryBuild.build(reader);
    		}
	    	final SqlSession sqlSession = factory.openSession();
	    	return sqlSession;
    	}catch(IOException e){
    		throw new IOException( e );
    	}catch(Exception e){
    		throw new Exception( e );
    	}
    }

}
