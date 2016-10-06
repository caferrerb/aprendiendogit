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
@Table(name="prestamo")
public class Prestamo implements Serializable {

	@Id
	private long numeroPrestamo;
	
	private boolean finalizado;
	
	@ManyToOne
	@JoinColumn(name="cliente")
	private Cliente cliente;
	
	private double monto;
	
	private double interes;
	
	private int plazo;
	
	private double saldo;
	
	@Column(name="valorcuota")
	private double valorCuota;
	
	@Column(name="fechaaprobacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaAprobacion;
	
	
	public Prestamo() {
		numeroPrestamo=System.nanoTime();
		finalizado=false;
	}

	public Prestamo(Cliente cliente, double monto, double interes, int plazo, double valorCuota) {
		this();
		this.cliente = cliente;
		this.monto = monto;
		this.interes = interes;
		this.plazo = plazo;
		saldo=monto;
		this.valorCuota = valorCuota;
		fechaAprobacion=new Date();
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
	 * @return the interes
	 */
	public double getInteres() {
		return interes;
	}

	/**
	 * @param interes the interes to set
	 */
	public void setInteres(double interes) {
		this.interes = interes;
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
	 * @return the valorCuota
	 */
	public double getValorCuota() {
		return valorCuota;
	}

	/**
	 * @param valorCuota the valorCuota to set
	 */
	public void setValorCuota(double valorCuota) {
		this.valorCuota = valorCuota;
	}
	
	public long getNumeroPrestamo() {
		return numeroPrestamo;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public Date getFechaAprobacion() {
		return fechaAprobacion;
	}
	
}
