package co.edu.eam.ingesoft.pa2.credito.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="pago")
@NamedQueries({
	@NamedQuery(name="Pago.ultimacuota",query="SELECT MAX(p.numeroCuota) FROM Pago p WHERE p.prestamo.numeroPrestamo=?1"),
	@NamedQuery(name="Pago.listartodos",query="SELECT p FROM Pago p WHERE p.prestamo.numeroPrestamo=?1")
})
public class Pago implements Serializable{

	@Id
	private long id;
	
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha")
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name="prestamo")
	private Prestamo prestamo;
	
	@Column(name="numerocuota")
	private int numeroCuota;
	
	@Column(name="pagointeres")
	private double pagointeres;
	
	@Column(name="pagocapital")
	private double pagoCapital;
	
	@Column(name="saldoactual")
	private double saldoActual;
	
	public Pago() {
		id=System.nanoTime();
		fecha=new Date();
	}
	
	
	
	

	public Pago(Prestamo prestamo, int numeroCuota, double pagointeres, double pagoCapital) {
		this();
		this.prestamo = prestamo;
		this.numeroCuota = numeroCuota;
		this.pagointeres = pagointeres;
		this.pagoCapital = pagoCapital;
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
	 * @return the prestamo
	 */
	public Prestamo getPrestamo() {
		return prestamo;
	}





	/**
	 * @param prestamo the prestamo to set
	 */
	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}





	/**
	 * @return the numeroCuota
	 */
	public int getNumeroCuota() {
		return numeroCuota;
	}

	/**
	 * @param numeroCuota the numeroCuota to set
	 */
	public void setNumeroCuota(int numeroCuota) {
		this.numeroCuota = numeroCuota;
	}

	/**
	 * @return the pagointeres
	 */
	public double getPagointeres() {
		return pagointeres;
	}

	/**
	 * @param pagointeres the pagointeres to set
	 */
	public void setPagointeres(double pagointeres) {
		this.pagointeres = pagointeres;
	}

	/**
	 * @return the pagoCapital
	 */
	public double getPagoCapital() {
		return pagoCapital;
	}

	/**
	 * @param pagoCapital the pagoCapital to set
	 */
	public void setPagoCapital(double pagoCapital) {
		this.pagoCapital = pagoCapital;
	}
	
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public double getSaldoActual() {
		return saldoActual;
	}
	
	public void setSaldoActual(double saldoActual) {
		this.saldoActual = saldoActual;
	}
	
	
}
