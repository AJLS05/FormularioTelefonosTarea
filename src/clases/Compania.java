package clases;

public class Compania {
	private int codigoCompania;
	private String nombreCompania;
	private String direccionCompania;
	private int numeroTelefonico;
	
	public Compania(int codigoCompania, String nombreCompania, String direccionCompania, int numeroTelefonico) {
		super();
		this.codigoCompania = codigoCompania;
		this.nombreCompania = nombreCompania;
		this.direccionCompania = direccionCompania;
		this.numeroTelefonico = numeroTelefonico;
	}
	public Compania() {
	}
	
	public int getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(int codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public String getNombreCompania() {
		return nombreCompania;
	}
	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}
	public String getDireccionCompania() {
		return direccionCompania;
	}
	public void setDireccionCompania(String direccionCompania) {
		this.direccionCompania = direccionCompania;
	}
	public int getNumeroTelefonico() {
		return numeroTelefonico;
	}
	public void setNumeroTelefonico(int numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}
	
	@Override
	public String toString() {
		return "Compania [codigoCompania=" + codigoCompania + ", nombreCompania=" + nombreCompania
				+ ", direccionCompania=" + direccionCompania + ", numeroTelefonico=" + numeroTelefonico + "]";
	}
	
	
}
