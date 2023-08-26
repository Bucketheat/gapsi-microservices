package com.examen.gapsi.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import com.examen.gapsi.app.model.entity.ProvedoresEntity;

@Repository
public interface IProvedorRepository extends JpaRepository<ProvedoresEntity, Long> {

	
	 List<ProvedoresEntity> findByNombre(String nombre);
}
