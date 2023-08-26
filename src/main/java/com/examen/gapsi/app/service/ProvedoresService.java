package com.examen.gapsi.app.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examen.gapsi.app.model.BaseReponse;
import com.examen.gapsi.app.model.ProvedorModel;
import com.examen.gapsi.app.model.entity.ProvedoresEntity;
import com.examen.gapsi.app.repository.IProvedorRepository;


@Service
public class ProvedoresService implements IProvedoresService {

	@Autowired
	IProvedorRepository provedorRepository;
	
	
	@Override
	@Transactional(readOnly = true)
	public BaseReponse obtenerProvedor(Long provedor) {
		// TODO Auto-generated method stub
		BaseReponse bsr = new  BaseReponse();
		Optional<ProvedoresEntity> provedorEntity;
		
		provedorEntity = provedorRepository.findById(provedor);
		
		if(!provedorEntity.isEmpty()) {
			bsr.setData(provedorEntity);
			bsr.setMensaje("Provedor Econtrado");
			bsr.setAccess(true);
			bsr.setStatus(HttpStatus.OK);
		}else {
			bsr.setAccess(false);
			bsr.setMensaje("No se encontro el provedor");
			bsr.setStatus(HttpStatus.BAD_REQUEST);
		}
		
		return bsr;
	}
	
	
	@Override
	@Transactional
	public BaseReponse altaProvedor(ProvedorModel provedor) {
		BaseReponse bsr = new  BaseReponse();
		ProvedoresEntity provedorEntity = createObecjts(provedor);
		List<ProvedoresEntity> listProvedor = provedorRepository.findByNombre(provedor.getNombre());
		if(listProvedor.isEmpty()) {
			ProvedoresEntity response;
			response = provedorRepository.save(provedorEntity);
			
			if(response != null) {
				bsr.setData(provedorEntity);
				bsr.setMensaje("Se guardo con éxito");
				bsr.setAccess(true);
				bsr.setStatus(HttpStatus.OK);
			}else {
				bsr.setAccess(false);
				bsr.setMensaje("No se pudo registrar");
				bsr.setStatus(HttpStatus.BAD_REQUEST);
			}
		}else {
			bsr.setAccess(false);
			bsr.setMensaje("Este provedor ya fue dado de alta");
			bsr.setStatus(HttpStatus.BAD_REQUEST);
		}
		
		return bsr;
	}
	
	
	private ProvedoresEntity createObecjts(ProvedorModel provedor) {
		ProvedoresEntity mapper = new ProvedoresEntity();
		
		mapper.setIdProvedor(provedor.getIdProvedor());
		mapper.setNombre(provedor.getNombre());
		mapper.setApellido(provedor.getApellido());
		mapper.setTelefono(provedor.getTelefono());
		mapper.setCompania(provedor.getCompania());
		return mapper;
	}


	@Override
	public BaseReponse eliminarProvedor(Long idProvedor) {
		BaseReponse bsr = new  BaseReponse();
		
		if(provedorRepository.existsById(idProvedor)) {
			provedorRepository.deleteById(idProvedor); 
			bsr.setMensaje("Provedor Eliminado");
			bsr.setAccess(true);
			bsr.setStatus(HttpStatus.OK);
		}else {
			bsr.setMensaje("Este provedor no existe");
			bsr.setAccess(true);
			bsr.setStatus(HttpStatus.OK);
		}
		
		return bsr;
	}


	@Override
	public BaseReponse listaProvedores() {
		BaseReponse bsr = new  BaseReponse();
		
		List<ProvedoresEntity> listResult = provedorRepository.findAll();
		
		if(!listResult.isEmpty()) {
			bsr.setData(listResult);
			bsr.setMensaje("Provedores encontrados");
			bsr.setAccess(true);
			bsr.setStatus(HttpStatus.OK);
		}else {
			bsr.setMensaje("No se encontro información");
			bsr.setAccess(true);
			bsr.setStatus(HttpStatus.OK);
		}
		
		return bsr;
	}

}
