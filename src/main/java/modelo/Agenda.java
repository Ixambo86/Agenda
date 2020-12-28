package modelo;

import java.util.List;
import dto.CiudadDTO;
import dto.PaisesDTO;
import dto.PersonaDTO;
import dto.ProvinciaDTO;
import dto.TipoContactoDTO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.PersonaDAO;


public class Agenda 
{
	private PersonaDAO persona;	
	
	public Agenda(DAOAbstractFactory metodo_persistencia)
	{
		this.persona = metodo_persistencia.createPersonaDAO();
	}
	
	public void agregarPersona(PersonaDTO nuevaPersona)
	{
		this.persona.insert(nuevaPersona);
	}
	
	public void editarPersona(PersonaDTO persona_a_editar) 
	{
		this.persona.edit(persona_a_editar);
	}
	
	public void borrarPersona(PersonaDTO persona_a_eliminar) 
	{
		this.persona.delete(persona_a_eliminar);
	}
	
	public List<PersonaDTO> obtenerPersonas()
	{
		return this.persona.readAll();		
	}
	
	public void agregarTipoContacto(TipoContactoDTO persona_a_agregar) 
	{
		this.persona.insertTipoContacto(persona_a_agregar);
	}
	
	public List<TipoContactoDTO> obtenerTipos()
	{
		return this.persona.readAlltipo();		
	}
	
	public List<PaisesDTO> obtenerPaises(){
		return this.persona.readAllPaises();
	}

	public List<ProvinciaDTO> obtenerProvincias(String nombrePais){
		return this.persona.readAllProvincias(nombrePais);
	}
	
	public void borrarTipoContacto(TipoContactoDTO TipoContactoDTO) {
		this.persona.deletetipo(TipoContactoDTO);
	}

	public void editarContacto(TipoContactoDTO nuevoContacto) {
		this.persona.editTipo(nuevoContacto);
	}
	
	public List<PersonaDTO> obtenerPersonasEmail() {
		return this.persona.readAllEmail();
	}

	public List<CiudadDTO> obtenerCiudades(String nombreProvincia) {
		return this.persona.readAllCiudades(nombreProvincia);
		
	}

	public void BorrarLocalidad(String localidad) {
		this.persona.deleteLocalidad(localidad);
		
	}

	public void EditarLocalidad(String localidad, int idlocalidad) {
		this.persona.editarLocalidad(localidad, idlocalidad);
		
	}

	public int ObteneridLocalidad(String localidad) {
		return this.persona.ObteneridLocalidad(localidad);
	}

	public void agregarLocalidad(String nombreCiudad, int codigoPostal, int nombreProvincia) {
		this.persona.agregarLocalidad(nombreCiudad, codigoPostal, nombreProvincia);
		
	}

	public int ObteneridProvincia(String nombreProvincia) {
		return this.persona.ObteneridProvincia(nombreProvincia);
		
	}
	
}
