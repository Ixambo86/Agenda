package dto;

public class CiudadDTO
{
	private int idCiudad;
	private String nombreCiudad;
	private int codigoPostal;
	private int codigoProvincia;
	
	public CiudadDTO(int id,String nombre,int codPostal,int codProvincia) {
		this.idCiudad=id;
		this.nombreCiudad=nombre;
		this.codigoPostal=codPostal;
		this.codigoProvincia=codProvincia;
		
	}

	public CiudadDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getNombreCiudad() {
		return nombreCiudad;
	}

	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public int getCodigoProvincia() {
		return codigoProvincia;
	}

	public void setCodigoProvincia(int codigoProvincia) {
		this.codigoProvincia = codigoProvincia;
	}
	public String toString() {
		return nombreCiudad;
	}
	
}
