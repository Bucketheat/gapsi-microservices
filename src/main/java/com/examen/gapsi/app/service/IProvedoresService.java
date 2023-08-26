package com.examen.gapsi.app.service;

import com.examen.gapsi.app.model.BaseReponse;
import com.examen.gapsi.app.model.ProvedorModel;

public interface IProvedoresService {

	BaseReponse obtenerProvedor(Long provedor);
	
	BaseReponse altaProvedor(ProvedorModel provedor);
	
	
	BaseReponse eliminarProvedor(Long idProvedor);
	
	BaseReponse listaProvedores();
	
	 
}
