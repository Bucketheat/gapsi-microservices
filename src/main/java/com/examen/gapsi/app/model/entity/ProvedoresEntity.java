package com.examen.gapsi.app.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.Id;
import javax.persistence.OrderBy; 
import javax.persistence.Table;
 
import lombok.AllArgsConstructor; 
import lombok.NoArgsConstructor; 


/**
 * Clase: ProvedoresEntity 
 * Descripcion: Es la entidad de la tabla provedores
 * @author LuisCalderon
 * @version 1.0.0
 * @since 25/08/2023
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="provedores")
public class ProvedoresEntity {
	
	
	
	//id de proveedores 
	//tipo Long
	//no debe de ir nullo
	@Id 
	@OrderBy("idProvedor ASC")
	@Column(name ="idProvedor", updatable = false, nullable = false)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
	//@SequenceGenerator(name = "SEQ", sequenceName = "SEQ_ID_PROVEDORES", allocationSize = 11)
	private Long idProvedor;
	
	
	//Es el nombre del proveedor
	//tipo Alfanumerico tipo String
	//no debe de ir nullo
	@Column(name ="nombre",nullable = false)
	private String nombre;
	
	
	//Es el apellido del proveedor
		//tipo Alfanumerico tipo String
		//no debe de ir nullo
	@Column(name ="apellido",nullable = false)
	private String apellido;
	
	
	//Es el telefono del proveedor
		//tipo Alfanumerico tipo String
		//no debe de ir nullo
	@Column(name ="telefono",nullable = false)
	private String telefono;
	
	
	//Es la compania que pertenece del proveedor
		//tipo Alfanumerico tipo String
		//no debe de ir nullo
	@Column(name ="compania",nullable = false)
	private String compania;

	public Long getIdProvedor() {
		return idProvedor;
	}

	public void setIdProvedor(Long idProvedor) {
		this.idProvedor = idProvedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}
	
	
	

}
