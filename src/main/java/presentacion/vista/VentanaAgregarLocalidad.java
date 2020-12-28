package presentacion.vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class VentanaAgregarLocalidad extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombreCiudad;
	private JTextField txtCodigoPostal;
	private JButton btnAgregar;
	private JTextField textFieldProvincia;
	private JTextField textPais;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAgregarLocalidad frame = new VentanaAgregarLocalidad();
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
	public VentanaAgregarLocalidad() {
		setTitle("Agregar Localidad");
		Image iconoPropio = Toolkit.getDefaultToolkit().getImage(getClass().getResource("agendaIcono.png"));
		setIconImage(iconoPropio);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setBounds(100, 100, 450, 209);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nueva Localidad ");
		lblNewLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 150, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre Ciudad:");
		lblNewLabel_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblNewLabel_1.setBounds(66, 36, 114, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("C\u00F3digo Postal:");
		lblNewLabel_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblNewLabel_2.setBounds(66, 61, 118, 14);
		contentPane.add(lblNewLabel_2);
		
		txtNombreCiudad = new JTextField();
		txtNombreCiudad.setBounds(201, 33, 160, 20);
		contentPane.add(txtNombreCiudad);
		txtNombreCiudad.setColumns(10);
		
		txtCodigoPostal = new JTextField();
		txtCodigoPostal.setBounds(200, 58, 161, 20);
		contentPane.add(txtCodigoPostal);
		txtCodigoPostal.setColumns(10);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAgregar.setBounds(335, 139, 89, 23);
		contentPane.add(btnAgregar);
		
		textFieldProvincia = new JTextField();
		textFieldProvincia.setEditable(false);
		textFieldProvincia.setBounds(201, 83, 160, 20);
		contentPane.add(textFieldProvincia);
		textFieldProvincia.setColumns(10);
		
		textPais = new JTextField();
		textPais.setEditable(false);
		textPais.setBounds(201, 108, 160, 20);
		contentPane.add(textPais);
		textPais.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Provincia");
		lblNewLabel_3.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblNewLabel_3.setBounds(66, 86, 114, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Pais");
		lblNewLabel_4.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblNewLabel_4.setBounds(66, 111, 52, 14);
		contentPane.add(lblNewLabel_4);
	}

	public void mostrar() {
		this.setVisible(true);
		
	}

	public JButton getbtnAgregar() {
		return btnAgregar;
	}

	public JTextField getnombreCiudad() {
		
		return txtNombreCiudad;
	}

	public JTextField getcodigoPostal() {
		return txtCodigoPostal;
	}

	public void ocultar() {
		this.setVisible(false);
		
	}

	public void mostrarPaisProvincia(String nombreProvincia, String nombrePais) {
		this.textFieldProvincia.setText(nombreProvincia);
		this.textPais.setText(nombrePais);
	}

}
