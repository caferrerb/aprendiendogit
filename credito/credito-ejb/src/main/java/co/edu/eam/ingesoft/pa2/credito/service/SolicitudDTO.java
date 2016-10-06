package co.edu.eam.ingesoft.pa2.credito.service;

public class SolicitudDTO {

	private String cedula;
	
	private double monto;
	
	private int numeroCuotas;

	public SolicitudDTO() {
		super();
	}

	public SolicitudDTO(String cedula, double monto, int numeroCuotas) {
		super();
		this.cedula = cedula;
		this.monto = monto;
		this.numeroCuotas = numeroCuotas;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public int getNumeroCuotas() {
		return numeroCuotas;
	}

	public void setNumeroCuotas(int numeroCuotas) {
		this.numeroCuotas = numeroCuotas;
	}
	
	
	
	
}
