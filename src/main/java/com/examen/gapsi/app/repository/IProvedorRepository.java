package com.examen.gapsi.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import com.examen.gapsi.app.model.entity.ProvedoresEntity;

/**
 * Interface: IProvedorRepository 
 * Descripcion: Es el interface que se utiliza para la interaccion de los datos con JPA
 * @author LuisCalderon
 * @version 1.0.0
 * @since 25/08/2023
 */


@Repository
public interface IProvedorRepository extends JpaRepository<ProvedoresEntity, Long> {

	
	/**
	 * Metodo que funciona para buscar un proveedor por nombre usando JPA 
	 * @param es el nombre del proveedor
	 * @return List devuelve la lista de los proveedores encontrados con el mismo nombre
	 */
	 List<ProvedoresEntity> findByNombre(String nombre);
}
