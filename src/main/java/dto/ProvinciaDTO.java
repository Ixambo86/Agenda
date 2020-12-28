package dto;

public class ProvinciaDTO {
	private int idProvincia;
	private String nombreProvincia;
	private int codPais;
	
	public ProvinciaDTO(int id,String nombre,int codPais) {
		this.idProvincia = id;
		this.nombreProvincia = nombre;
		this.codPais = codPais;
	}

	public int getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getNombreProvincia() {
		return nombreProvincia;
	}

	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}

	public int getCodPais() {
		return codPais;
	}

	public void setCodPais(int codPais) {
		this.codPais = codPais;
	}

	public String toString() {
		return nombreProvincia;
	}

}
