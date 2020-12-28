package presentacion.vista;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import dto.TipoContactoDTO;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class VentanaTipoContacto extends JFrame {

	private JPanel contentPane;
	private JTable tableTipoContacto;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private static VentanaTipoContacto INSTANCE;
	private JButton btnEditar;
	private DefaultTableModel modelContacto;
	private  String[] nombreColumnas = {"Numero","Tipos"};
	private JButton btnSeleccionar;
	private JTextField textAgregarTipo;
	

	/**
	 * Create the frame.
	 */
	public VentanaTipoContacto() {
		setTitle("Seleccionar Tipo de Contacto");
		
		Image iconoPropio = Toolkit.getDefaultToolkit().getImage(getClass().getResource("agendaIcono.png"));
		setIconImage(iconoPropio);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setBounds(600, 200, 454, 233);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		modelContacto = new DefaultTableModel(null,nombreColumnas);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(220, 21, 89, 23);
		contentPane.add(btnAgregar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(220, 55, 89, 23);
		contentPane.add(btnEditar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(220, 89, 89, 23);
		contentPane.add(btnBorrar);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(305, 160, 108, 23);
		contentPane.add(btnSeleccionar);
		
		textAgregarTipo = new JTextField();
		textAgregarTipo.setBounds(322, 21, 86, 22);
		contentPane.add(textAgregarTipo);
		textAgregarTipo.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 176, 130);
		contentPane.add(scrollPane);
		tableTipoContacto = new JTable(modelContacto);
		scrollPane.setViewportView(tableTipoContacto);
		
		
	}
	
	public static VentanaTipoContacto getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaTipoContacto(); 
			System.out.println("ssssss");
			return new VentanaTipoContacto();
		}
		else
			System.out.println("ssssss");
			return INSTANCE;
	}
	
	public JButton getBtnAgregar() 
	{
		return btnAgregar;
	}
	
	public Integer getidContacto() {
		if (tableTipoContacto.getSelectedRow() != -1) {
			return (Integer) tableTipoContacto.getValueAt(tableTipoContacto.getSelectedRow(), 0);
		} else
			return  -1 ;
	}
	
	public String getTxtTipo() {
		if (tableTipoContacto.getSelectedRow() != -1) {
			return (String) tableTipoContacto.getValueAt(tableTipoContacto.getSelectedRow(), 1);
		} else
			return "Vacio";
	}
	
	public void cerrar()
	{
		this.dispose();
	}
	
	public JButton getBtnBorrar() 
	{
		return btnBorrar;
	}
	
	public JButton getBtnEditar() 
	{
		return btnEditar;
	}
	
	public JButton getBtnSeleccionar() 
	{
		return btnSeleccionar;
	}
	
	public void mostrarVentanaTipoContacto() {
		this.setVisible(true);
	}
	
	public JTextField getTxtAgregarTipo() 
	{
		return textAgregarTipo;
	}
	
	public String[] getNombreColumnas() 
	{
		return nombreColumnas;
	}
	
	public DefaultTableModel getModelContactos() 
	{
		return modelContacto;
	}
	
	public JTable getTablaTipos()
	{
		return tableTipoContacto;
	}
	
	
	
	public void llenarTabla(List<TipoContactoDTO> tiposEnTabla) {
		this.getModelContactos().setRowCount(0); //Para vaciar la tabla
		this.getModelContactos().setColumnCount(0);
		this.getModelContactos().setColumnIdentifiers(this.getNombreColumnas());
		for (TipoContactoDTO p : tiposEnTabla)
		{
			int idContacto = p.getIdContacto();
			String nombre = p.getTipo();
			
			Object[] fila = {idContacto, nombre};
			this.modelContacto.addRow(fila);
		}
		
	}
}
