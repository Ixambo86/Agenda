package persistencia.dao.interfaz;

import java.util.List;

import dto.CiudadDTO;
import dto.PaisesDTO;
import dto.PersonaDTO;
import dto.ProvinciaDTO;
import dto.TipoContactoDTO;

public interface PersonaDAO 
{
	
	public boolean insert(PersonaDTO persona);

	public boolean delete(PersonaDTO persona_a_eliminar);
	
	public boolean edit(PersonaDTO persona_a_editar);
	
	public List<PersonaDTO> readAll();
	
	public boolean insertTipoContacto(TipoContactoDTO persona_a_agregar);

	public List<TipoContactoDTO> readAlltipo();

	public boolean deletetipo(TipoContactoDTO tipoContactoDTO);

	public boolean editTipo(TipoContactoDTO nuevoContacto);

	public List<PaisesDTO> readAllPaises();
	
	public List<ProvinciaDTO> readAllProvincias(String codigoPais);

	public List<PersonaDTO> readAllEmail();

	public List<CiudadDTO> readAllCiudades(String nombreProvincia);

	public boolean deleteLocalidad(String localidad);

	public boolean editarLocalidad(String localidad, int idlocalidad);

	public int ObteneridLocalidad(String localidad);

	public boolean agregarLocalidad(String nombreCiudad, int codigoPostal, int nombreProvincia);

	public int ObteneridProvincia(String nombreProvincia);
}
