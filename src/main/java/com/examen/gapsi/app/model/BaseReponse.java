package com.examen.gapsi.app.model;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor; 
import lombok.NoArgsConstructor; 
import lombok.ToString;

 

/**
 * Clase: BaseReponse 
 * Descripcion: Es la clase que se utiliza para el response de los servicios
 * @author LuisCalderon
 * @version 1.0.0
 * @since 25/08/2023
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BaseReponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//status sirve para mostrar el estatus del resultado
	//tipo HttpStatus
	private HttpStatus status;
	
	//access sirve para saber si el proceso fue o no correcto
	//tipo booleano
	private boolean access;
	
	//mensaje sirve para mostrar el mensaje del proceso
	//tipo Alfanumerico String
	private String mensaje;
	
	//data sirve para devolver el resultado del proceso puede regresar nullo
	//tipo Object ya que es indiferente para todos los metodos
	private transient Object data;
	
	
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public boolean isAccess() {
		return access;
	}
	public void setAccess(boolean access) {
		this.access = access;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
	
}
