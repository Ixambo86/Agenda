package presentacion.vista;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class VentanaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;
	private JButton btnIngresar;
	private JButton btnSalir;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin frame = new VentanaLogin();
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
	public VentanaLogin() {
		try { 
			UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
		} catch(Exception e) { 
		    System.out.println("Error setting native LAF: " + e); 
		} 
		
		Image iconoPropio = Toolkit.getDefaultToolkit().getImage(getClass().getResource("agendaIcono.png"));
		setIconImage(iconoPropio);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Login Base de Datos MYSQL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Microsoft Tai Le", Font.BOLD, 14));
		lblUsuario.setBounds(107, 54, 89, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Microsoft Tai Le", Font.BOLD, 14));
		lblContrasea.setBounds(107, 105, 89, 14);
		contentPane.add(lblContrasea);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(204, 54, 96, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setDropMode(DropMode.INSERT);
		txtContraseña.setBounds(204, 105, 96, 20);
		contentPane.add(txtContraseña);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(67, 179, 89, 23);
		contentPane.add(btnIngresar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		btnSalir.setBounds(232, 179, 89, 23);
		contentPane.add(btnSalir);
	}

	
	public void loginExitosa() {
		JOptionPane.showMessageDialog(contentPane, "CONEXIÓN EXITOSA");
		dispose();
	}
	
	public void loginInvalido() {
		JOptionPane.showMessageDialog(contentPane, "USUARIO O CONTRASEÑA INVALIDOS");
		limpiarCampos();
	}
	
	public void excedeIntentos() {
		JOptionPane.showMessageDialog(contentPane,"NO SE PUEDEN REALIZAR MÁS INTENTOS.");
		System.exit(0);
	}

	protected void salir() {
		System.exit(0);
	}

	
	public void mostrarVentana()
	{
		this.setVisible(true);
	}
	
	public void limpiarCampos() {
		txtUsuario.setText(""); 
		txtContraseña.setText("");
	}

	public String getTxtUsuario() {
		return txtUsuario.getText();
	}

	@SuppressWarnings("deprecation")
	public String getTxtContraseña() {
		return txtContraseña.getText();
	}

	public JButton getBtnIngresar() {
		return btnIngresar;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setTxtUsuario(JTextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

	public void setTxtContraseña(JPasswordField txtContraseña) {
		this.txtContraseña = txtContraseña;
	}
	
	
	
}
