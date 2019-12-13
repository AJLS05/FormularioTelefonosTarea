package clases;

public class Computadoras {
	private String tipo;

	public Computadoras(String tipo) {
		super();
		this.tipo = tipo;
	}
	public Computadoras() {
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Computadoras [tipo=" + tipo + "]";
	}
	
}
