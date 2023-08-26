package com.examen.gapsi.app.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
 
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="provedores")
public class ProvedoresEntity {
	
	@Id 
	@OrderBy("idProvedor ASC")
	@Column(name ="idProvedor", updatable = false, nullable = false)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
	//@SequenceGenerator(name = "SEQ", sequenceName = "SEQ_ID_PROVEDORES", allocationSize = 11)
	private Long idProvedor;
	
	@Column(name ="nombre",nullable = false)
	private String nombre;
	
	@Column(name ="apellido",nullable = false)
	private String apellido;
	
	@Column(name ="telefono",nullable = false)
	private String telefono;
	
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
