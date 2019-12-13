package clases;

import java.io.Serializable;
import java.util.ArrayList;

public class Telefono extends PapaDeLosPollitos implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 799544382031369881L;
	private int numero;
	private String compania;
	private int capacidadDeCamara;
	//private String MarcaDeProcesador; //No se llena en el formulario
	ArrayList<String> otrosComponentes = new ArrayList<String>();
	
	public Telefono(int tamanioPantalla, int resolucion, SistemaOperativo sistemaOperativo, int memoriaEnBytes,
			int memoriaInterna, Marca marca, Modelo modelo, int numero, String compania, int capacidadDeCamara,
			ArrayList<String> otrosComponentes) {
		super(tamanioPantalla, resolucion, sistemaOperativo, memoriaEnBytes, memoriaInterna, marca, modelo);
		this.numero = numero;
		this.compania = compania;
		this.capacidadDeCamara = capacidadDeCamara;
		this.otrosComponentes = otrosComponentes;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	public int getCapacidadDeCamara() {
		return capacidadDeCamara;
	}

	public void setCapacidadDeCamara(int capacidadDeCamara) {
		this.capacidadDeCamara = capacidadDeCamara;
	}

	public ArrayList<String> getOtrosComponentes() {
		return otrosComponentes;
	}

	public void setOtrosComponentes(ArrayList<String> otrosComponentes) {
		this.otrosComponentes = otrosComponentes;
	}

	@Override
	public String toString() {
		return "Telefono: Tamaño de la Pantalla:" + getTamanioPantalla() + ", Resolucion: " + getResolucion()
				+ ", Sistema Operativo: " + getSistemaOperativo() + ", Memoria En Bytes: " + getMemoriaEnBytes()
				+ ", Memoria Interna: " + getMemoriaInterna() + ", Marca: " + getMarca() + ", Modelo: "
				+ getModelo() + ", numero: " + numero + ", compañia:" + compania + ", capacidad De Camara: "
				+ capacidadDeCamara + ", Otros Componentes: " + otrosComponentes;
	}
	
}
