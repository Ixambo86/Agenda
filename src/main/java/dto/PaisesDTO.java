package dto;


public class PaisesDTO {

	private int idPais;
	private String nombrePais;

	
	public PaisesDTO(int idPais, String nombrePais) {
		this.idPais = idPais;
		this.nombrePais = nombrePais;
	}

	public int getIdPais() {
		return idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}

	public String getNombrePais() {
		return nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}
	
	public String toString() {
		return nombrePais;
	}
	
}
