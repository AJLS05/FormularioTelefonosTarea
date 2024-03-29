package clases;

import java.io.Serializable;

public class Marca implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1552866194635152205L;
	private int codigoMarca;
	private String nombreMarca;
	
	public Marca(int codigoMarca, String nombreMarca) {
		super();
		this.codigoMarca = codigoMarca;
		this.nombreMarca = nombreMarca;
	}
	
	public int getCodigoMarca() {
		return codigoMarca;
	}
	public void setCodigoMarca(int codigoMarca) {
		this.codigoMarca = codigoMarca;
	}
	public String getNombreMarca() {
		return nombreMarca;
	}
	public void setNombreMarca(String nombreMarca) {
		this.nombreMarca = nombreMarca;
	}
	
	@Override
	public String toString() {
		return "Marca: " + nombreMarca + ", Codigo de la Marca: " + codigoMarca;
	}
	
}
