package com.examen.gapsi.app.controller;
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.gapsi.app.model.BaseReponse;
import com.examen.gapsi.app.model.ProvedorModel;
import com.examen.gapsi.app.service.ProvedoresService;


@CrossOrigin
@RestController
@RequestMapping("/ecommerceGapsi")
public class GapsiController {
	
	
	@Autowired
	private ProvedoresService provedoresService;
	
	@GetMapping(path = "/obtenerProvedorById/{provedorModel}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseReponse> consultarProvedorById(@PathVariable Long provedorModel){
		BaseReponse bsr;
		bsr = provedoresService.obtenerProvedor(provedorModel);
		return new ResponseEntity<>(bsr,bsr.getStatus());
	}
	
	@PostMapping(path = "/altaProvedor", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseReponse> altaProvedor(@RequestBody ProvedorModel provedorModel){
		BaseReponse bsr;
		bsr = provedoresService.altaProvedor(provedorModel);
		return new ResponseEntity<>(bsr,bsr.getStatus());
	}
	
	@PostMapping(path = "/eliminarProvedor",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseReponse> eliminarProvedor(@RequestBody ProvedorModel provedor){
		BaseReponse bsr;
		bsr = provedoresService.eliminarProvedor(provedor.getIdProvedor());
		return new ResponseEntity<>(bsr,bsr.getStatus());
	}
	
	@GetMapping(path = "/obtenerProvedores", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseReponse> obtenerLista(){
		BaseReponse bsr;
		bsr = provedoresService.listaProvedores();
		return new ResponseEntity<>(bsr,bsr.getStatus());
	}
	

}
