package clases;

import java.io.Serializable;

public class PapaDeLosPollitos implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8210406268045593063L;
	private int tamanioPantalla;
	private int resolucion;
	private SistemaOperativo sistemaOperativo;
	private int memoriaEnBytes;
	private int memoriaInterna;
	private Marca marca;
	private Modelo modelo;
	
	public PapaDeLosPollitos(int tamanioPantalla, int resolucion, SistemaOperativo sistemaOperativo, int memoriaEnBytes,
			int memoriaInterna, Marca marca, Modelo modelo) {
		super();
		this.tamanioPantalla = tamanioPantalla;
		this.resolucion = resolucion;
		this.sistemaOperativo = sistemaOperativo;
		this.memoriaEnBytes = memoriaEnBytes;
		this.memoriaInterna = memoriaInterna;
		this.marca = marca;
		this.modelo = modelo;
	}
	public PapaDeLosPollitos() {
	}
	
	public int getTamanioPantalla() {
		return tamanioPantalla;
	}
	public void setTamaniooPantalla(int tamanioPantalla) {
		this.tamanioPantalla = tamanioPantalla;
	}
	public int getResolucion() {
		return resolucion;
	}
	public void setResolucion(int resolucion) {
		this.resolucion = resolucion;
	}
	public SistemaOperativo getSistemaOperativo() {
		return sistemaOperativo;
	}
	public void setSistemaOperativo(SistemaOperativo sistemaOperativo) {
		this.sistemaOperativo = sistemaOperativo;
	}
	public int getMemoriaEnBytes() {
		return memoriaEnBytes;
	}
	public void setMemoriaEnBytes(int memoriaEnBytes) {
		this.memoriaEnBytes = memoriaEnBytes;
	}
	public int getMemoriaInterna() {
		return memoriaInterna;
	}
	public void setMemoriaInterna(int memoriaInterna) {
		this.memoriaInterna = memoriaInterna;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	
	@Override
	public String toString() {
		return "PapaDeLosPollitos [tamanioPantalla=" + tamanioPantalla + ", resolucion=" + resolucion
				+ ", sistemaOperativo=" + sistemaOperativo + ", memoriaEnBytes=" + memoriaEnBytes + ", memoriaInterna="
				+ memoriaInterna + ", marca=" + marca + ", modelo=" + modelo + "]";
	}
	
	
}
