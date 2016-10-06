package co.edu.eam.ingesoft.pa2.credito.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity//(name="cliente")
@Table(name="cliente")
public class Cliente implements Serializable {

	@Column(name="nombre")
	private String nombre;
	@Id
	@Column(name="cedula")
	private String cedula;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Cliente(String nombre, String cedula) {
		super();
		this.nombre = nombre;
		this.cedula = cedula;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
}
