package com.examen.gapsi.app.controller;
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.gapsi.app.model.BaseReponse;
import com.examen.gapsi.app.model.ProvedorModel;
import com.examen.gapsi.app.service.ProvedoresService;


/**
 * Clase: GapsiController 
 * Descripcion: Es el controlador principal para los servicios REST
 * @author LuisCalderon
 * @version 1.0.0
 * @since 25/08/2023
 */
@CrossOrigin
@RestController
@RequestMapping("/ecommerceGapsi")
public class GapsiController {
	
	//se injecta el service ProvedoresService
	@Autowired
	private ProvedoresService provedoresService;
	
	
	/**
	 * Metodo que funciona para buscar un proveedor por id
	 * @param provedorModel es el id del proveedor a buscar
	 * @return BaseReponse es el objeto base de response
	 */
	@GetMapping(path = "/obtenerProvedorById/{provedorModel}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseReponse> consultarProvedorById(@PathVariable Long provedorModel){
		BaseReponse bsr;
		bsr = provedoresService.obtenerProvedor(provedorModel);
		return new ResponseEntity<>(bsr,bsr.getStatus());
	}
	
	/**
	 * Metodo que funciona para el alta de un proveedor validado por nombre
	 * @param provedorModel es el objeto a guardar
	 * @return BaseReponse es el objeto base de response
	 */
	@PostMapping(path = "/altaProvedor", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseReponse> altaProvedor(@RequestBody ProvedorModel provedorModel){
		BaseReponse bsr;
		bsr = provedoresService.altaProvedor(provedorModel);
		return new ResponseEntity<>(bsr,bsr.getStatus());
	}
	
	
	/**
	 * Metodo que funciona para eliminar al proveedor por id
	 * @param provedor es el objeto a  eliminar
	 * @return BaseReponse es el objeto base de response
	 */
	
	@PostMapping(path = "/eliminarProvedor",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseReponse> eliminarProvedor(@RequestBody ProvedorModel provedor){
		BaseReponse bsr;
		bsr = provedoresService.eliminarProvedor(provedor.getIdProvedor());
		return new ResponseEntity<>(bsr,bsr.getStatus());
	}
	
	
	/**
	 * Metodo que funciona para obtener todos los proveedores
	 * @return BaseReponse es el objeto base de response
	 */
	@GetMapping(path = "/obtenerProvedores", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseReponse> obtenerLista(){
		BaseReponse bsr;
		bsr = provedoresService.listaProvedores();
		return new ResponseEntity<>(bsr,bsr.getStatus());
	}
	

}
