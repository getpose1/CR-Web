package com.cr.persistence.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cr.domain.PruebaNombre;
import com.cr.persistence.mapping.MyBatisUtil;
import com.cr.persistence.services.PruebaMapper;


public class PruebaPersistenceServices  {

	public List<PruebaNombre> selectByCountry() {
		
		SqlSession session = null;
		List<PruebaNombre> pruebaNombres = null;
		try{
			System.out.println("LLEGO A persistencia");
			PruebaNombre pruebaNombre;
			PruebaMapper pruebaMapper;
			session = new MyBatisUtil().getSession();
			pruebaMapper = session.getMapper(PruebaMapper.class);
			pruebaNombres = pruebaMapper.selectPrueba();
			
			for(int i = 0; i < pruebaNombres.size(); i++){
				pruebaNombre = pruebaNombres.get(i);
				System.out.println("Nombre:" + pruebaNombre.getNombre());
			}
			
		}catch (Exception e) {
			System.out.println("Error en persistencia");
			e.printStackTrace();
		}finally {
			if(session != null)
				session.close();
		} 
		
		return pruebaNombres;
	}
	
}
