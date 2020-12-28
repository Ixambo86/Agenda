package dto;

public class PersonaDTO 
{
	private int idPersona;
	private String nombre;
	private String telefono;
	private String tipoTelefono;
	private String calle;
	private String altura;
	private String piso;
	private String departamento;
	private String pais;
	private String provincia;
	private String localidad;
	private String tipoContacto;
	private String fechaNacimiento;
	private String email;

	public PersonaDTO(int idPersona, String nombre, String telefono, String tipoTelefono, String email, String fechaNacimiento, String calle, String altura, String piso,
			String departamento, String pais, String provincia, String localidad, String tipoContacto)
	{
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.tipoTelefono = tipoTelefono;
		this.calle = calle;
		this.altura = altura;
		this.piso = piso;
		this.departamento = departamento;
		this.pais = pais;
		this.provincia = provincia;
		this.localidad = localidad;
		this.tipoContacto = tipoContacto;
		
	}
	
	public int getIdPersona() 
	{
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) 
	{
		this.idPersona = idPersona;
	}

	public String getNombre() 
	{
		return this.nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getTipoTelefono() 
	{
		return this.tipoTelefono;
	}

	public void setTipoTelefono(String tipoTelefono) 
	{
		this.tipoTelefono = tipoTelefono;
	}
	
	public String getTelefono() 
	{
		return this.telefono;
	}

	public void setTelefono(String telefono) 
	{
		this.telefono = telefono;
	}
	
	public String getEmail() 
	{
		return this.email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	public String getFechaNacimiento() 
	{
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) 
	{
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String getCalle() 
	{
		return this.calle;
	}

	public void setCalle(String calle) 
	{
		this.calle = calle;
	}
	
	public String getAltura() 
	{
		return this.altura;
	}

	public void setAltura(String altura) 
	{
		this.altura = altura;
	}
	
	public String getPiso() 
	{
		return this.piso;
	}

	public void setPiso(String piso) 
	{
		this.piso = piso;
	}
	
	public String getDepartamento() 
	{
		return this.departamento;
	}

	public void setDepartamento(String departamento) 
	{
		this.departamento = departamento;
	}
	
	public String getPais() 
	{
		return this.pais;
	}

	public void setPais(String pais) 
	{
		this.pais = pais;
	}
	
	public String getProvincia() 
	{
		return this.provincia;
	}

	public void setProvincia(String provincia) 
	{
		this.provincia = provincia;
	}
	
	public String getLocalidad() 
	{
		return this.localidad;
	}

	public void setLocalidad(String localidad) 
	{
		this.localidad = localidad;
	}
	
	public String getTipoContacto() 
	{
		return this.tipoContacto;
	}

	public void setTipoContacto(String tipoContacto) 
	{
		this.tipoContacto = tipoContacto;
	}
	
}
