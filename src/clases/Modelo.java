package clases;

import java.io.Serializable;

public class Modelo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3782234136907590083L;
	private String modelo;

	public Modelo(String modelo) {
		super();
		this.modelo = modelo;
	}
	public Modelo() {
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	@Override
	public String toString() {
		return "Modelo: " + modelo;
	}
	
}
