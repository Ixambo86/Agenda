package persistencia.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;


public class Conexion 
{
	public static Conexion instancia;
	private Connection connection;
	private Logger log = Logger.getLogger(Conexion.class);	
	private static String user ;
	private static String pass ;
	private static boolean respuesta = false;
	
	public Conexion()
	{
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver"); // quitar si no es necesario
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda",user,pass);
			this.connection.setAutoCommit(false);
			log.info("Conexion exitosa");
			respuesta = true;
			
		}
		catch(Exception e)
		{
			
			log.error("ConexiÃ³n fallida:", e);
			respuesta = false;
			
		}
	}

	public static Conexion getConexion()   
	{								
		instancia = null;
		if(instancia == null)
		{
			
			instancia = new Conexion();
		}			
		
		return instancia;
	}
	
	public static void establecerConexion(String usuario, String password)   
	{							
		user = usuario;
		pass = password;
		
		System.out.print("El usuario es: " + user);
		System.out.print("El la contraseña es: " + pass);
		getConexion();

	}

	public Connection getSQLConexion() 
	{
		return this.connection;
	}
	
	public void cerrarConexion()
	{
		
		try 
		{
			this.connection.close();
			
			log.info("Conexion cerrada");
			
		}
		catch (SQLException e) 
		{
			log.error("Error al cerrar la conexión!", e);
		}
		instancia = null;
	}
	
	


	public static boolean getRespuesta() {
		return respuesta;
	}



	




}
