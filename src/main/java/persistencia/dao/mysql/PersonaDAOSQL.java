package persistencia.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.PersonaDAO;
import dto.CiudadDTO;
import dto.PaisesDTO;
import dto.PersonaDTO;
import dto.ProvinciaDTO;
import dto.TipoContactoDTO;

public class PersonaDAOSQL implements PersonaDAO
{
	private static final String insert = "INSERT INTO personas(idPersona, nombre, telefono,tipoTelefono, email, fechaNacimiento, calle, altura, piso, departamento, pais, provincia, localidad, tipoContacto) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM personas WHERE idPersona = ?";
	private static final String readall = "SELECT * FROM personas";
	private static final String edit = "UPDATE personas SET nombre = ?, telefono = ?,tipoTelefono = ?, email = ?, fechaNacimiento = ?, calle = ?, altura = ?, piso = ?, departamento = ?, pais = ?, provincia = ?, localidad = ?, tipoContacto = ? WHERE idPersona = ?";
	private static final String insertTipoContacto = "INSERT INTO tipocontacto(idTipo, nombre) VALUES (?, ?)";
	private static final String readalltipo = "SELECT * FROM tipocontacto";
	private static final String deleteTipo = "DELETE FROM tipocontacto WHERE idTipo = ?";
	private static final String editTipo = "UPDATE tipocontacto SET nombre = ? WHERE idTipo = ?";
	private static final String readallPais = "SELECT * FROM pais";
	private static final String readProvincia = "SELECT * FROM provincia where codPais in (SELECT idPais FROM pais WHERE nombrePais =?) ORDER BY nombreprovincia asc";
	private static final String readCiudad = "select*from ciudad where codProvincia in (select idProvincia from provincia where nombreProvincia=?) ORDER BY nombreciudad asc";
	private Logger log = Logger.getLogger(PersonaDAOSQL.class);	
	private static final String readallEmail = "SELECT * FROM personas order by (SELECT SUBSTRING(email,(LOCATE('@',email)),LENGTH(email) - LOCATE('@',email) + 1)) asc";
	private static final String deleteLocalidad = "DELETE FROM ciudad WHERE nombreCiudad = ?";
	private static final String editarLocalidad = "UPDATE ciudad SET nombreCiudad = ? WHERE idciudad = ?";
	private static final String idLocalidad = "SELECT * FROM ciudad WHERE nombreCiudad = ?";
	private static final String idProvincia = "SELECT * FROM provincia WHERE nombreProvincia = ?";
	private static final String insertLocalidad = "INSERT INTO ciudad(idCiudad, nombreCiudad, codigoPostal, codProvincia) VALUES (?, ?, ?, ?)";
	
	public List<PersonaDTO> readAllEmail() 
	{
			PreparedStatement statement;
			ResultSet resultSet; //Guarda el resultado de la query
			ArrayList<PersonaDTO> personas = new ArrayList<PersonaDTO>();
			Conexion conexion = Conexion.getConexion();
			try 
			{
				statement = conexion.getSQLConexion().prepareStatement(readallEmail);
				resultSet = statement.executeQuery();
				while(resultSet.next())
				{
					personas.add(getPersonaDTO(resultSet));
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return personas;
	}
	
	public int ObteneridLocalidad(String localidad)
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		Conexion conexion = Conexion.getConexion();
		int idciudad = 0;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(idLocalidad);
			statement.setString(1, localidad);
			log.info(statement);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				idciudad = resultSet.getInt("idCiudad");
			}

			return idciudad;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return idciudad;
	}
	
	public int ObteneridProvincia(String provincia)
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		Conexion conexion = Conexion.getConexion();
		int idprovincia = 0;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(idProvincia);
			statement.setString(1, provincia);
			log.info(statement);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				idprovincia = resultSet.getInt("idProvincia");
			}

			return idprovincia;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return idprovincia;
	}
	
	public boolean insertTipoContacto(TipoContactoDTO tipo)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insertTipoContacto);
			statement.setInt(1, tipo.getIdContacto());
			statement.setString(2, tipo.getTipo());
			
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}
	
	public boolean agregarLocalidad(String nombreCiudad, int codigoPostal, int idProvincia)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insertLocalidad);
			statement.setInt(1, 0);
			statement.setString(2, nombreCiudad);
			statement.setInt(3, codigoPostal);
			statement.setInt(4, idProvincia);
			
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}
	
	public boolean editarLocalidad(String localidad, int idlocalidad)
	{
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(editarLocalidad);
			statement.setString(1, localidad);
			statement.setInt(2, idlocalidad);
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}
	
	public boolean editTipo(TipoContactoDTO tipo)
	{
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			
			statement = conexion.prepareStatement(editTipo);
			statement.setString(1, tipo.getTipo());
			statement.setInt(2, tipo.getIdContacto());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}
	
	public boolean edit(PersonaDTO persona)
	{
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			
			statement = conexion.prepareStatement(edit);
			statement.setString(1, persona.getNombre());
			statement.setString(2, persona.getTelefono());
			statement.setString(3, persona.getTipoTelefono());
			statement.setString(4, persona.getEmail());
			statement.setString(5, persona.getFechaNacimiento());
			statement.setString(6, persona.getCalle());
			statement.setString(7, persona.getAltura());
			statement.setString(8, persona.getPiso());
			statement.setString(9, persona.getDepartamento());
			statement.setString(10, persona.getPais());
			statement.setString(11, persona.getProvincia());
			statement.setString(12, persona.getLocalidad());
			statement.setString(13, persona.getTipoContacto());
			statement.setInt(14, persona.getIdPersona());
			log.info("ERROR" +statement);
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}
	
	public boolean insert(PersonaDTO persona)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, persona.getIdPersona());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getTelefono());
			statement.setString(4, persona.getTipoTelefono());
			statement.setString(5, persona.getEmail());
			statement.setString(6, persona.getFechaNacimiento());
			statement.setString(7, persona.getCalle());
			statement.setString(8, persona.getAltura());
			statement.setString(9, persona.getPiso());
			statement.setString(10, persona.getDepartamento());
			statement.setString(11, persona.getPais());
			statement.setString(12, persona.getProvincia());
			statement.setString(13, persona.getLocalidad());
			statement.setString(14, persona.getTipoContacto());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}
	
	public boolean deletetipo(TipoContactoDTO TipoContactoDTO) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(deleteTipo);
			statement.setString(1, Integer.toString(TipoContactoDTO.getIdContacto()));
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isdeleteExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}
	
	public boolean deleteLocalidad(String localidad) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(deleteLocalidad);
			statement.setString(1, localidad);
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isdeleteExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}
	
	public boolean delete(PersonaDTO persona_a_eliminar)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Integer.toString(persona_a_eliminar.getIdPersona()));
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isdeleteExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}
	
	public List<PersonaDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<PersonaDTO> personas = new ArrayList<PersonaDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				personas.add(getPersonaDTO(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return personas;
	}
	
	public List<TipoContactoDTO> readAlltipo()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<TipoContactoDTO> TipoContactoDTO = new ArrayList<TipoContactoDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readalltipo);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				TipoContactoDTO.add(getTipoContactoDTO(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return TipoContactoDTO;
	}
	
	private TipoContactoDTO getTipoContactoDTO(ResultSet resultSet) throws SQLException{
		int id = resultSet.getInt("idTipo");
		String nombre = resultSet.getString("Nombre");
		log.info("ENTRE"+nombre);
		return new TipoContactoDTO(id, nombre);
	}

	private PersonaDTO getPersonaDTO(ResultSet resultSet) throws SQLException
	{
		int id = resultSet.getInt("idPersona");
		String nombre = resultSet.getString("Nombre");
		String tel = resultSet.getString("Telefono");
		String tipoTel = resultSet.getString("TipoTelefono");
		String email = resultSet.getString("email");
		String fechaNacimiento = resultSet.getString("fechaNacimiento");
		String calle = resultSet.getString("Calle");
		String altura = resultSet.getString("Altura");
		String piso = resultSet.getString("Piso");
		String departamento = resultSet.getString("Departamento");
		String pais = resultSet.getString("pais");
		String provincia = resultSet.getString("Provincia");
		String localidad = resultSet.getString("Localidad");
		String tipoContacto = resultSet.getString("TipoContacto");
		
		return new PersonaDTO(id, nombre, tel, tipoTel, email, fechaNacimiento, calle, altura, piso, departamento, pais,
				provincia, localidad, tipoContacto);
	}

	public List<PaisesDTO> readAllPaises()
	{
		
		PreparedStatement statement;
		ResultSet resultSet=null;; //Guarda el resultado de la query
		ArrayList<PaisesDTO> nombrePaises = new ArrayList<PaisesDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readallPais);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				nombrePaises.add(getNombrePaises(resultSet));
				
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return nombrePaises;
	}
	
	private PaisesDTO getNombrePaises(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("idPais");
		String nombre = resultSet.getString("nombrePais");
		log.info("Se cargan paises");
		return new PaisesDTO(id, nombre);
	}

	public List<ProvinciaDTO> readAllProvincias(String nombrePais)
		{
			PreparedStatement statement;
			ResultSet resultSet = null; //Guarda el resultado de la query
			ArrayList<ProvinciaDTO> nombreProvincias = new ArrayList<ProvinciaDTO>();
			Conexion conexion = Conexion.getConexion();
			try 
			{	
				statement = conexion.getSQLConexion().prepareStatement(readProvincia);
				statement.setString(1, nombrePais);
				log.info(statement);
				resultSet = statement.executeQuery();
				
				while(resultSet.next())
				{
					nombreProvincias.add(getNombreProvincias(resultSet));
				}
				log.info("Se cargan provincias");
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return nombreProvincias;
	}
		
	private ProvinciaDTO getNombreProvincias(ResultSet resultSet) throws SQLException{
	int id = resultSet.getInt("idProvincia");
	String nombre = resultSet.getString("nombreProvincia");			
	int cod = resultSet.getInt("codPais");
	
	return new ProvinciaDTO(id, nombre,cod);
	}
	
	public List<CiudadDTO> readAllCiudades(String nombreProvincia)
		{
			PreparedStatement statement;
			ResultSet resultSet; //Guarda el resultado de la query
			ArrayList<CiudadDTO> nombreCiudades = new ArrayList<CiudadDTO>();
			Conexion conexion = Conexion.getConexion();
			try 
			{
				statement = conexion.getSQLConexion().prepareStatement(readCiudad);
				statement.setString(1, nombreProvincia);
				log.info(statement);
				resultSet = statement.executeQuery();
				while(resultSet.next())
				{
					nombreCiudades.add(getNombreCiudades(resultSet));
					
				}
				log.info("Se cargan ciudades");
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return nombreCiudades;
		}
			
	private CiudadDTO getNombreCiudades(ResultSet resultSet) throws SQLException {
			int id = resultSet.getInt("idCiudad");
			String nombre = resultSet.getString("nombreCiudad");
			int codPostal = resultSet.getInt("codigoPostal");
			int codProvincia = resultSet.getInt("codProvincia");
			return new CiudadDTO(id, nombre, codPostal, codProvincia);
		}


}
