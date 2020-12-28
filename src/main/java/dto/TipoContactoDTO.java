package dto;

public class TipoContactoDTO {
	
	private int idContacto;
	private String Tipo;
	
	public TipoContactoDTO(int idContacto, String tipo) {
		this.idContacto = idContacto;
		this.Tipo = tipo;
	}

	
	public int getIdContacto() {
		return idContacto;
	}

	public void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}


}
