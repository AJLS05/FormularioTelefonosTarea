package clases;

public class smartTV {
	private int tamanioPantalla;
	private Marca marca;
	private SistemaOperativo sistemaOperativo;
	
	public smartTV(int tamanioPantalla, Marca marca, SistemaOperativo sistemaOperativo) {
		super();
		this.tamanioPantalla = tamanioPantalla;
		this.marca = marca;
		this.sistemaOperativo = sistemaOperativo;
	}

	public int getTamanioPantalla() {
		return tamanioPantalla;
	}

	public void setTamanioPantalla(int tamanioPantalla) {
		this.tamanioPantalla = tamanioPantalla;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public SistemaOperativo getSistemaOperativo() {
		return sistemaOperativo;
	}

	public void setSistemaOperativo(SistemaOperativo sistemaOperativo) {
		this.sistemaOperativo = sistemaOperativo;
	}

	@Override
	public String toString() {
		return "smartTV [tamanioPantalla=" + tamanioPantalla + ", marca=" + marca + ", sistemaOperativo="
				+ sistemaOperativo + "]";
	}
	
	
}
