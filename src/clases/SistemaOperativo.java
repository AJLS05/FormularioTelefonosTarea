package clases;

import java.io.Serializable;

public class SistemaOperativo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5766234441320240L;
	private String NombreSistemaOperativo;
	private String version;
	private int anioDeLanzamiento;
	
	public SistemaOperativo(String nombreSistemaOperativo, String version, int anioDeLanzamiento) {
		super();
		NombreSistemaOperativo = nombreSistemaOperativo;
		this.version = version;
		this.anioDeLanzamiento = anioDeLanzamiento;
		
	}
	public SistemaOperativo() {	
	}

	public String getNombreSistemaOperativo() {
		return NombreSistemaOperativo;
	}

	public void setNombreSistemaOperativo(String nombreSistemaOperativo) {
		NombreSistemaOperativo = nombreSistemaOperativo;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getAnioDeLanzamiento() {
		return anioDeLanzamiento;
	}

	public void setAnioDeLanzamiento(int anioDeLanzamiento) {
		this.anioDeLanzamiento = anioDeLanzamiento;
	}

	@Override
	public String toString() {
		return "Sistema Operativo: " + NombreSistemaOperativo + ", version: " + version
				+ ", año D eLanzamiento: " + anioDeLanzamiento;
	}
	
}
