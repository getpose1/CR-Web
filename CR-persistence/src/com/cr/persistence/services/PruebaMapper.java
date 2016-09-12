package com.cr.persistence.services;

import java.util.List;

import com.cr.domain.PruebaNombre;

public interface PruebaMapper  {
	    
    List<PruebaNombre> selectPrueba();
}