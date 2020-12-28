package presentacion.vista;


import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;

@SuppressWarnings("serial")
public class VentanaLocalidades extends JFrame {
	private static VentanaTipoContacto INSTANCE;
	private JPanel contentPane;
	@SuppressWarnings("rawtypes")
	private JComboBox comboLocalidad;
	private JButton btnSeleccionarLocalidad;
	private JButton btnAgregarNuevaLocalidad;
	private JButton btnEditarLocalidad;
	private JButton btnBorrarLocalidad;
	private JTextField txtEditarLocalidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLocalidades frame = new VentanaLocalidades();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
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
	
	@SuppressWarnings("rawtypes")
	public VentanaLocalidades() {
		Image iconoPropio = Toolkit.getDefaultToolkit().getImage(getClass().getResource("agendaIcono.png"));
		setIconImage(iconoPropio);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Seleccionar Localidad");

		setBounds(500, 300, 434, 188);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblLocalidad.setBounds(10, 24, 92, 14);
		contentPane.add(lblLocalidad);
		
		comboLocalidad = new JComboBox();
		comboLocalidad.setBounds(84, 20, 171, 22);
		contentPane.add(comboLocalidad);
		
		btnSeleccionarLocalidad = new JButton("Seleccionar");
		btnSeleccionarLocalidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnSeleccionarLocalidad.setBounds(265, 118, 143, 23);
		contentPane.add(btnSeleccionarLocalidad);
		
		btnAgregarNuevaLocalidad = new JButton("Agregar Nueva");
		btnAgregarNuevaLocalidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAgregarNuevaLocalidad.setBounds(265, 84, 143, 23);
		contentPane.add(btnAgregarNuevaLocalidad);
		
		btnEditarLocalidad = new JButton("Editar");
		btnEditarLocalidad.setBounds(265, 51, 143, 23);
		contentPane.add(btnEditarLocalidad);
		
		btnBorrarLocalidad = new JButton("Borrar");
		btnBorrarLocalidad.setBounds(265, 20, 143, 23);
		contentPane.add(btnBorrarLocalidad);
		
		txtEditarLocalidad = new JTextField();
		txtEditarLocalidad.setColumns(10);
		txtEditarLocalidad.setBounds(84, 52, 171, 20);
		contentPane.add(txtEditarLocalidad);
		
		
	}
	
	@SuppressWarnings("unchecked")
	public void setComboLocalidad(String provincia) {
		this.comboLocalidad.addItem(provincia);
	}
	
	public void mostrarVentanaLocalidad() {
		this.setVisible(true);
	}
	
	@SuppressWarnings("unchecked")
	public JComboBox<String> getComboLocalidad(){
		return this.comboLocalidad;
	}
		
	public String getlocalidadSeleccionada() {
		return (String) this.comboLocalidad.getSelectedItem();
	}
	
	public JButton getBtnSeleccionar() 
	{
		return btnSeleccionarLocalidad;
	}

	public void ocultarLocalidad() {
	
		this.setVisible(false);
		this.dispose();
		
	}

	public JButton getbtnAgregarNuevaLocalidad() {
		return btnAgregarNuevaLocalidad;
	}

	public JButton getbtnEditarLocalidad() {
		return btnEditarLocalidad;
	}

	public JButton getbtnBorrarLocalidad() {
		return btnBorrarLocalidad;
	}

	public String getlocalidadAEditar() {
		return txtEditarLocalidad.getText();
	}
	
}
