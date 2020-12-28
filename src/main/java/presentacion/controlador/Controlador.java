package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
//import org.apache.log4j.Logger;
//import org.jfree.util.Log;
import modelo.Agenda;
import persistencia.conexion.Conexion;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaProvincias;
import presentacion.vista.VentanaAgregarLocalidad;
import presentacion.vista.VentanaLocalidades;
import presentacion.reportes.ReporteEmailAgenda;

import presentacion.vista.VentanaLogin;
import presentacion.vista.VentanaPersona;
import presentacion.vista.VentanaTipoContacto;
import presentacion.vista.Vista;
import dto.CiudadDTO;
import dto.PaisesDTO;
import dto.PersonaDTO;
import dto.ProvinciaDTO;
import dto.TipoContactoDTO;
import dto.UsuarioDTO;

public class Controlador implements ActionListener {
	private Vista vista;
	private VentanaLogin login;
	private List<PersonaDTO> personasEnTabla;
	private List<TipoContactoDTO> personasEnTablaTipo;
	private List<PaisesDTO> paises;
	private List<ProvinciaDTO> provincias;
	private List<CiudadDTO> ciudades;
	private VentanaPersona ventanaPersona;
	private VentanaAgregarLocalidad ventanaAgregarLocalidad;
	private VentanaTipoContacto ventanaTipoContacto;
	private Agenda agenda;
	private int intentos;
	private VentanaProvincias ventanaProvincia;
	private VentanaLocalidades ventanaLocalidad;
	//private Logger log = Logger.getLogger(PersonaDAOSQL.class);	
	private boolean valorProvincia = false;
	private boolean valorLocalidad = false;
	private boolean paisYaCargado = false;
	
	public Controlador(Vista vista, Agenda agenda, VentanaLogin login) {
		this.login = login;
		this.login.getBtnIngresar().addActionListener(l -> ingresar(l));

		this.vista = vista;
		this.vista.getBtnAgregar().addActionListener(a -> ventanaAgregarPersona(a));
		this.vista.getBtnBorrar().addActionListener(s -> borrarPersona(s));
		this.vista.getBtnReporte().addActionListener(r -> mostrarReporte(r));
		this.vista.getBtnEditar().addActionListener(ka -> editarPersona(ka));
		this.vista.getBtnReporteEmail().addActionListener(x -> mostrarReporteEmail(x));
		
		this.ventanaPersona = VentanaPersona.getInstance();
		this.ventanaPersona.getComboPaises().addActionListener(k -> obtieneProvinciaSegunPais(k));
		this.ventanaPersona.getSeleccionarTipoContacto().addActionListener(j -> ventanaAgregarTipoContacto(j));
		this.ventanaPersona.getBtnAgregarPersona().addActionListener(p -> guardarPersona(p));
		this.ventanaPersona.getComboTipoTelefono().addActionListener(e -> tipoTelefono(e));

		this.ventanaAgregarLocalidad = new VentanaAgregarLocalidad();
		this.ventanaTipoContacto = new VentanaTipoContacto();
		this.ventanaTipoContacto.getBtnAgregar().addActionListener(n -> agregarTipoContacto(n));
		this.ventanaTipoContacto.getBtnSeleccionar().addActionListener(u -> SeleccionarTipoContacto(u));
		this.ventanaTipoContacto.getBtnBorrar().addActionListener(o -> borrarTipoContacto(o));
		this.ventanaTipoContacto.getBtnEditar().addActionListener(y -> editarTipoContacto(y));
				
		this.agenda = agenda;

	}



	private void tipoTelefono(ActionEvent e) {
		String tipo = this.ventanaPersona.getTipoTelefono();
		System.out.println(tipo);
		if (tipo == "Otro" ) {
			this.ventanaPersona.mostrarComboBoxTipoTelefono();	
			}
		else {
			this.ventanaPersona.ocultarComboBoxTipoTelefono();
		}
		
	}
	
	private void obtieneProvinciaSegunPais(ActionEvent k) {
		
		if (valorProvincia == true) {
			this.ventanaProvincia.ocultarProvincia();
		}
		
		if (valorLocalidad == true) {
			this.ventanaLocalidad.ocultarLocalidad();
		}
		
		this.ventanaProvincia = new VentanaProvincias();
		this.ventanaProvincia.mostrarVentanaProvincia();
		String nombrePais = this.ventanaPersona.getComboPaises().getSelectedItem().toString();
		mostrarProvincias(nombrePais);
		valorProvincia = true;
	}

	private void mostrarProvincias(String nombrePais) {
		this.provincias = agenda.obtenerProvincias(nombrePais);
		for (ProvinciaDTO listaProvincia : this.provincias) {
			this.ventanaProvincia.setComboProvincias(listaProvincia.getNombreProvincia());
		}
		this.ventanaProvincia.getBtnSeleccionar().addActionListener(ko -> obtieneCiudadSegunProvincia(ko,nombrePais));
	}

	private void obtieneCiudadSegunProvincia(ActionEvent ko, String nombrePais) {
		this.ventanaLocalidad = new VentanaLocalidades();
		this.ventanaLocalidad.mostrarVentanaLocalidad();
		valorLocalidad = true;
		String nombreProvincia = this.ventanaProvincia.getComboProvincias().getSelectedItem().toString();
		mostrarCiudad(nombreProvincia, nombrePais);

	}

	private void mostrarCiudad(String nombreProvincia, String nombrePais) {
		this.ciudades = agenda.obtenerCiudades(nombreProvincia);
		for (CiudadDTO listaCiudades : this.ciudades) {
			this.ventanaLocalidad.setComboLocalidad(listaCiudades.getNombreCiudad());
		}
		this.ventanaLocalidad.getBtnSeleccionar().addActionListener(i -> SeleccionarLocalidad(i));
		this.ventanaLocalidad.getbtnBorrarLocalidad().addActionListener(d -> BorrarLocalidad(d));
		this.ventanaLocalidad.getbtnAgregarNuevaLocalidad().addActionListener(b -> agregarNuevaLocalidad(b, nombreProvincia, nombrePais));
		this.ventanaLocalidad.getbtnEditarLocalidad().addActionListener(c -> EditarLocalidad(c));
		
		this.ventanaProvincia.ocultarProvincia();
	}
	
	private void BorrarLocalidad(ActionEvent d) {
		String localidad = this.ventanaLocalidad.getlocalidadSeleccionada();
		this.agenda.BorrarLocalidad(localidad);
		this.ventanaLocalidad.ocultarLocalidad();
	}
	
	private void EditarLocalidad(ActionEvent c) {
		
		String localidad = this.ventanaLocalidad.getlocalidadSeleccionada();
		int idLocalidad = this.agenda.ObteneridLocalidad (localidad);
		String localidadAEditar = this.ventanaLocalidad.getlocalidadAEditar();
		this.agenda.EditarLocalidad(localidadAEditar, idLocalidad);
		this.ventanaLocalidad.ocultarLocalidad();
	}
	
	private void agregarNuevaLocalidad(ActionEvent b, String nombreProvincia, String nombrePais) {
		this.ventanaLocalidad.ocultarLocalidad();
		this.ventanaAgregarLocalidad.mostrar();		
		this.ventanaAgregarLocalidad.mostrarPaisProvincia(nombreProvincia, nombrePais) ;
		this.ventanaAgregarLocalidad.getbtnAgregar().addActionListener(f -> AgregarLocalidad(f, nombreProvincia, nombrePais));
	}
	
	private void AgregarLocalidad(ActionEvent f, String nombreProvincia, String nombrePais) {
		String nombreCiudad = this.ventanaAgregarLocalidad.getnombreCiudad().getText();
		int codigoPostal = Integer.parseInt(this.ventanaAgregarLocalidad.getcodigoPostal().getText());
		int idprovincia = this.agenda.ObteneridProvincia (nombreProvincia);
		this.agenda.agregarLocalidad(nombreCiudad, codigoPostal, idprovincia);
		this.ventanaAgregarLocalidad.ocultar();
	}




	private void SeleccionarLocalidad(ActionEvent i) {
		String localidad = this.ventanaLocalidad.getlocalidadSeleccionada();
		String provincia = this.ventanaProvincia.getprovinciaSeleccionada();
		this.ventanaPersona.agregarProvincia(provincia);
		this.ventanaPersona.agregarLocalidad(localidad);
		this.ventanaLocalidad.ocultarLocalidad();
		this.ventanaProvincia.ocultarProvincia();
		
	}

	private void mostrarPaises() {
		this.paises = agenda.obtenerPaises();
		for (PaisesDTO listaPaises : this.paises) {
			this.ventanaPersona.setComboPaises(listaPaises.getNombrePais());
		}
		paisYaCargado = true;
	}
	
	///////////////// Metodos TipoContacto //////////////////////////////
		
	
	private void editarTipoContacto(ActionEvent y) {
		int idContacto = this.ventanaTipoContacto.getidContacto();
		String tipo = this.ventanaTipoContacto.getTxtTipo();

		TipoContactoDTO nuevoContacto = new TipoContactoDTO(idContacto, tipo);
		this.agenda.editarContacto(nuevoContacto);
		this.refrescarTabla();

	}

	public void borrarTipoContacto(ActionEvent o) {
		int[] filasSeleccionadas = this.ventanaTipoContacto.getTablaTipos().getSelectedRows();
		for (int fila : filasSeleccionadas) {
			this.agenda.borrarTipoContacto(this.personasEnTablaTipo.get(fila));
		}

		this.refrescarTablaTipo();
	}

	private void mostrarReporteEmail(ActionEvent x) {
		ReporteEmailAgenda reporteEmail = new ReporteEmailAgenda(agenda.obtenerPersonasEmail());
		
		reporteEmail.mostrar();
	}

	private String SeleccionarTipoContacto(ActionEvent u) {
		String tipo = this.ventanaTipoContacto.getTxtTipo();
		this.ventanaPersona.agregarTipoContacto(tipo);
		this.ventanaTipoContacto.cerrar();
		return tipo;
	}

	private String agregarTipoContacto(ActionEvent n) {
		String nuevoTipo = this.ventanaTipoContacto.getTxtAgregarTipo().getText();
		TipoContactoDTO tipo = new TipoContactoDTO(0, nuevoTipo);
		this.agenda.agregarTipoContacto(tipo);
		this.refrescarTablaTipo();
		return nuevoTipo;
	}

	private Object ventanaAgregarTipoContacto(ActionEvent j) {
		this.ventanaTipoContacto.mostrarVentanaTipoContacto();
		this.refrescarTablaTipo();
		return null;
	}

	////////////////// Metodos login ///////////////////////////////
	private void ingresar(ActionEvent l) {
		System.out.println("inserto de nuevo ");
		intentaLogin();
		validaConexion();
	}

	private void validaConexion() {
		if (Conexion.getRespuesta()) {
			login.loginExitosa();
			inicializar();
		} else
			controlaIntentos();

	}

	private void controlaIntentos() {
		if (intentos < 3) {
			login.loginInvalido();
			intentos++;
		} else
			login.excedeIntentos();
	}

	private UsuarioDTO datosLogin() {
		UsuarioDTO usuario = new UsuarioDTO(login.getTxtUsuario(), login.getTxtContraseña());
		return usuario;
	}

	private void intentaLogin() {
		Conexion.establecerConexion(datosLogin().getUser(), datosLogin().getPassword());
		Conexion.getConexion();
	}

	public void inicializarLogin() {
		login.mostrarVentana();

	}
	////////////////////////// Metodos Vista/////////////////////

	private void ventanaAgregarPersona(ActionEvent a) {
		this.ventanaPersona.mostrarVentana();
		if(paisYaCargado==false) {
			mostrarPaises();
		}
		
	}

	private void guardarPersona(ActionEvent p) {
		
		String nombre = this.ventanaPersona.getTxtNombre().getText();
		String tel = this.ventanaPersona.getTxtTelefono().getText();
		String tipoTel = this.ventanaPersona.getComboBoxTipoTelefono();
		String email = this.ventanaPersona.getTxtEmail().getText();
		String fechaNacimiento = this.ventanaPersona.getTxtFechaNacimiento().getText();
		String calle = this.ventanaPersona.getTxtCalle().getText();
		String altura = this.ventanaPersona.getTxtAltura().getText();
		String piso = this.ventanaPersona.getTxtPiso().getText();
		String departamento = this.ventanaPersona.getTxtDepartamento().getText();
		String pais = this.ventanaPersona.getPaisSeleccionado();
		String provincia = this.ventanaPersona.getTxtProvincia().getText();
		String localidad = this.ventanaPersona.getTxtLocalidad().getText();
		String tipoContacto = this.ventanaPersona.getTxtTipoContacto().getText();
		
		PersonaDTO nuevaPersona = new PersonaDTO(0, nombre, tel, tipoTel, email, fechaNacimiento, calle, altura, piso,
				departamento, pais, provincia, localidad, tipoContacto);
		
		if(validacionDeDatos(nuevaPersona)) {
			this.agenda.agregarPersona(nuevaPersona);
			this.refrescarTabla();
			this.ventanaPersona.cerrar();
			this.ventanaProvincia.ocultarProvincia();
		}
		
	}

	private void editarPersona(ActionEvent ka) {
		int idNombre = this.vista.getIdPersona();
		String nombre = this.vista.getNombre();
		String tel = this.vista.getTel();
		String tipoTel = this.vista.getTipoTelefono();
		String email = this.vista.getEmail();
		String fechaNacimiento = this.vista.getFechaNacimiento();
		String calle = this.vista.getCalle();
		String altura = this.vista.getAltura();
		String piso = this.vista.getPiso();
		String departamento = this.vista.getDepartamento();
		String pais = this.vista.getPais();
		String provincia = this.vista.getProvincia();
		String localidad = this.vista.getLocalidad();
		String tipoContacto = this.vista.getTipoContacto();
		PersonaDTO nuevaPersona2 = new PersonaDTO(idNombre, nombre, tel, tipoTel, email, fechaNacimiento, calle, altura,
				piso, departamento, pais, provincia, localidad, tipoContacto);
		this.agenda.editarPersona(nuevaPersona2);
		this.refrescarTabla();
	//	this.ventanaPersona.cerrar();
	}

	public void borrarPersona(ActionEvent s) {
		int[] filasSeleccionadas = this.vista.getTablaPersonas().getSelectedRows();
		for (int fila : filasSeleccionadas) {
			this.agenda.borrarPersona(this.personasEnTabla.get(fila));
		}

		this.refrescarTabla();
	}

	public void inicializar() {
		this.refrescarTabla();
		this.vista.show();
	}

	private void refrescarTabla() {
		this.personasEnTabla = agenda.obtenerPersonas();
		this.vista.llenarTabla(this.personasEnTabla);
	}

	private void refrescarTablaTipo() {
		this.personasEnTablaTipo = agenda.obtenerTipos();
		this.ventanaTipoContacto.llenarTabla(this.personasEnTablaTipo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

	//////////////////////////// Metodos Reportes///////////////////////

	private void mostrarReporte(ActionEvent r) {
		ReporteAgenda reporte = new ReporteAgenda(agenda.obtenerPersonas());
		reporte.mostrar();
	}
	
	////////////////////////////Metodos Validación de datos///////////////////////
	
	private boolean validacionDeDatos(PersonaDTO nuevaPersona) {
		boolean validacion = validarNombre(nuevaPersona.getNombre()) 
				& validarTelefono(nuevaPersona.getTelefono()) 
				& validarEmail(nuevaPersona.getEmail());
		return validacion;
	}

	private boolean validarEmail(String email) {
		if (email.length()==0) {
			 this.ventanaPersona.obligatorioEmail();
			 return false;
		}
		else if (!email.contains("@")) {
			 this.ventanaPersona.emailNoValido();
			 return false;
		}
		this.ventanaPersona.emailOK();
		return true;
	}

	private boolean validarTelefono(String telefono) {
		if (telefono.length()==0) {
			 this.ventanaPersona.obligatorioTelefono();
			 return false;
		}
		this.ventanaPersona.telefonoOK();
		return true;
	}

	private boolean validarNombre(String nombre) {
		if (nombre.length()==0) {// que la primera letra sea Mayúscula
			 this.ventanaPersona.obligatorioNombre();
			 return false;
		}
		this.ventanaPersona.nombreOK();
		return true;
	}
	


}
