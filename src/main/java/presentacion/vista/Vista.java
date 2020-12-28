package presentacion.vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



import dto.PersonaDTO;

import javax.swing.JButton;

import persistencia.conexion.Conexion;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

public class Vista
{
	private JFrame frmRegistroDeContactos;
	private JTable tablaPersonas;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private JButton btnEditar;
	private JButton btnReporte;
	private JButton btnReporteEmail;
	private DefaultTableModel modelPersonas;
	private  String[] nombreColumnas = {"IdPersona","Nombre y apellido","Telefono","Tipo Telefono","Email","Fec. Nac.","Calle", "Altura","Piso","Depto","Localidad","Provincia","Pais","Tipo Contacto"};

	public Vista() 
	{
		super();
		initialize();
	}


	private void initialize() 
	{
		frmRegistroDeContactos = new JFrame();
		frmRegistroDeContactos.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		frmRegistroDeContactos.setTitle("Registro de Contactos");
		frmRegistroDeContactos.setBounds(100, 100, 1170, 300);
		
		frmRegistroDeContactos.getContentPane().setLayout(null);
		
		Image iconoPropio = Toolkit.getDefaultToolkit().getImage(getClass().getResource("agendaIcono.png"));
		frmRegistroDeContactos.setIconImage(iconoPropio);
		frmRegistroDeContactos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(0, 0, 1154, 262);
		frmRegistroDeContactos.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane spPersonas = new JScrollPane();
		spPersonas.setBounds(10, 11, 1134, 182);
		panel.add(spPersonas);
		
		modelPersonas = new DefaultTableModel(null,nombreColumnas);
		tablaPersonas = new JTable(modelPersonas);
		
		tablaPersonas.getColumnModel().getColumn(0).setPreferredWidth(103);
		tablaPersonas.getColumnModel().getColumn(0).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(1).setResizable(false);
		
		spPersonas.setViewportView(tablaPersonas);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAgregar.setBounds(10, 228, 89, 23);
		panel.add(btnAgregar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(109, 228, 89, 23);
		panel.add(btnEditar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(208, 228, 89, 23);
		panel.add(btnBorrar);
		
		btnReporte = new JButton("Reporte");
		btnReporte.setBounds(307, 228, 89, 23);
		panel.add(btnReporte);
		
		btnReporteEmail = new JButton("Reporte Email");
		btnReporteEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnReporteEmail.setBounds(401, 228, 121, 23);
		panel.add(btnReporteEmail);
	}
	
	public void show()
	{
		this.frmRegistroDeContactos.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.frmRegistroDeContactos.addWindowListener(new WindowAdapter() 
		{
			@Override
		    public void windowClosing(WindowEvent e) {
		        int confirm = JOptionPane.showOptionDialog(
		             null, "Estas seguro que quieres salir de la Agenda?", 
		             "Confirmación", JOptionPane.YES_NO_OPTION,
		             JOptionPane.QUESTION_MESSAGE, null, null, null);
		        if (confirm == 0) {
		           System.exit(0);
		           Conexion.getConexion().cerrarConexion();
		        }
		    }
		});
		this.frmRegistroDeContactos.setVisible(true);
	}
	
	
	public JButton getBtnAgregar() 
	{
		return btnAgregar;
	}

	public JButton getBtnBorrar() 
	{
		return btnBorrar;
	}
	
	public JButton getBtnEditar() 
	{
		return btnEditar;
	}
	
	public JButton getBtnReporte() 
	{
		return btnReporte;
	}
	
	public JButton getBtnReporteEmail() 
	{
		return btnReporteEmail;
	}
	
	
	public DefaultTableModel getModelPersonas() 
	{
		return modelPersonas;
	}
	
	public JTable getTablaPersonas()
	{
		return tablaPersonas;
	}

	public String[] getNombreColumnas() 
	{
		return nombreColumnas;
	}

	public Integer getIdPersona() 
	{
		if(tablaPersonas.getSelectedRow()!= -1) {
			return (Integer) modelPersonas.getValueAt(tablaPersonas.getSelectedRow(),0);
		}else 
			return -1;
	}
	
	public String getNombre() 
	{
		if(tablaPersonas.getSelectedRow()!= -1) {
			return (String) modelPersonas.getValueAt(tablaPersonas.getSelectedRow(),1);
			
		}else 
			return "Vacio";
	}
	
	public String getTel() 
	{
		
		if(tablaPersonas.getSelectedRow()!= -1) {
			return (String) modelPersonas.getValueAt(tablaPersonas.getSelectedRow(),2);
		}else 
			return "Vacio";
	}
	
	public String getTipoTelefono() 
	{
		
		if(tablaPersonas.getSelectedRow()!= -1) {
			return (String) modelPersonas.getValueAt(tablaPersonas.getSelectedRow(),3);
		}else 
			return "Vacio";
	}
	
	
	public String getEmail() 
	{
		
		if(tablaPersonas.getSelectedRow()!= -1) {
			return (String) modelPersonas.getValueAt(tablaPersonas.getSelectedRow(),4);
		}else 
			return "Vacio";
	}
	
	public String getFechaNacimiento() 
	{
		
		if(tablaPersonas.getSelectedRow()!= -1) {
			return (String) modelPersonas.getValueAt(tablaPersonas.getSelectedRow(),5);
		}else 
			return "Vacio";
	}
	public String getCalle() 
	{
		if(tablaPersonas.getSelectedRow()!= -1) {
			return (String) modelPersonas.getValueAt(tablaPersonas.getSelectedRow(),6);
		}else 
			return "Vacio";
	}
	public String getAltura() 
	{
		if(tablaPersonas.getSelectedRow()!= -1) {
			return (String) modelPersonas.getValueAt(tablaPersonas.getSelectedRow(),7);
		}else 
			return "Vacio";
	}
	public String getPiso() 
	{
		if(tablaPersonas.getSelectedRow()!= -1) {
			return (String) modelPersonas.getValueAt(tablaPersonas.getSelectedRow(),8);
		}else 
			return "Vacio";
	}
	public String getDepartamento() 
	{
		if(tablaPersonas.getSelectedRow()!= -1) {
			return (String) modelPersonas.getValueAt(tablaPersonas.getSelectedRow(),9);
		}else 
			return "Vacio";
	}
	public String getPais() 
	{
		if(tablaPersonas.getSelectedRow()!= -1) {
			return (String) modelPersonas.getValueAt(tablaPersonas.getSelectedRow(),10);
		}else 
			return "Vacio";
	}
	public String getProvincia() 
	{
		if(tablaPersonas.getSelectedRow()!= -1) {
			return (String) modelPersonas.getValueAt(tablaPersonas.getSelectedRow(),11);
		}else 
			return "Vacio";
	}
	public String getLocalidad() 
	{
		if(tablaPersonas.getSelectedRow()!= -1) {
			return (String) modelPersonas.getValueAt(tablaPersonas.getSelectedRow(),12);
		}else 
			return "Vacio";
	}
	public String getTipoContacto() 
	{
		if(tablaPersonas.getSelectedRow()!= -1) {
			return (String) modelPersonas.getValueAt(tablaPersonas.getSelectedRow(),13);
		}else 
			return "Vacio";
	}
	
	public void llenarTabla(List<PersonaDTO> personasEnTabla) {
		this.getModelPersonas().setRowCount(0); //Para vaciar la tabla
		this.getModelPersonas().setColumnCount(0);
		this.getModelPersonas().setColumnIdentifiers(this.getNombreColumnas());

		for (PersonaDTO p : personasEnTabla)
		{
			int idPersona = p.getIdPersona();
			String nombre = p.getNombre();
			String tel = p.getTelefono();
			String tipoTel = p.getTipoTelefono();
			String email = p.getEmail();
			String fechaNacimiento = p.getFechaNacimiento();
			String calle = p.getCalle();
			String altura = p.getAltura();
			String piso = p.getPiso();
			String departamento = p.getDepartamento();
			String pais = p.getPais();
			String provincia = p.getProvincia();
			String localidad = p.getLocalidad();
			String tipoContacto = p.getTipoContacto();
			
			Object[] fila = {idPersona, nombre, tel, tipoTel,  email, fechaNacimiento,  calle, altura, piso, departamento, pais, provincia, localidad, tipoContacto};
			this.getModelPersonas().addRow(fila);
		}
		
	}

	public void setVisible(boolean b) {
		this.frmRegistroDeContactos.setVisible(b);
		
	}
}
