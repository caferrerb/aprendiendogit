package co.edu.eam.ingesoft.pa2.credito.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="solicitud")
public class Solicitud implements Serializable{
	
	@Id
	private long id;
	
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha")
	private Date fecha;
	
	
	@ManyToOne
	@JoinColumn(name="cliente")
	private Cliente cliente;
	
	private double monto;
	
	private int plazo;
	
	private boolean aprobado;
	
	@Column(name="salario")
	private double salarioDevengado;
	
	@Column
	private double interes;
	
	public Solicitud() {
		id=System.nanoTime();
		fecha=new Date();
		aprobado=false;
	}
	
	

	public Solicitud(Cliente cliente, double monto, int plazo, double salarioDevengado,double interes) {
		this();
		this.cliente = cliente;
		this.monto = monto;
		this.plazo = plazo;
		this.salarioDevengado = salarioDevengado;
		this.interes=interes;
	}



	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the monto
	 */
	public double getMonto() {
		return monto;
	}

	/**
	 * @param monto the monto to set
	 */
	public void setMonto(double monto) {
		this.monto = monto;
	}

	/**
	 * @return the plazo
	 */
	public int getPlazo() {
		return plazo;
	}

	/**
	 * @param plazo the plazo to set
	 */
	public void setPlazo(int plazo) {
		this.plazo = plazo;
	}

	/**
	 * @return the salarioDevengado
	 */
	public double getSalarioDevengado() {
		return salarioDevengado;
	}

	/**
	 * @param salarioDevengado the salarioDevengado to set
	 */
	public void setSalarioDevengado(double salarioDevengado) {
		this.salarioDevengado = salarioDevengado;
	}
	
	public boolean isAprobado() {
		return aprobado;
	}
	
	public void setAprobado(boolean aprobado) {
		this.aprobado = aprobado;
	}
	
	public double getInteres() {
		return interes;
	}
	
	
}
