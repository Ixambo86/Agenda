package main;

import modelo.Agenda;
import persistencia.dao.mysql.DAOSQLFactory;
import presentacion.controlador.Controlador;
import presentacion.vista.VentanaLogin;
import presentacion.vista.Vista;

public class Main 
{

	public static void main(String[] args) 
	{
		VentanaLogin login = new VentanaLogin();
		Vista vista = new Vista();
		Agenda modelo = new Agenda(new DAOSQLFactory());
		Controlador controlador = new Controlador(vista, modelo,login);
		controlador.inicializarLogin();
	}
}
