package presentacion.vista;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class VentanaProvincias extends JFrame {

	private JPanel contentPane;
	@SuppressWarnings("rawtypes")
	private JComboBox comboProvincia;
	private JButton btnSeleccionarProvincia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaProvincias frame = new VentanaProvincias();
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
	@SuppressWarnings("rawtypes")
	public VentanaProvincias() {
		setTitle("Seleccionar Provincia");
		Image iconoPropio = Toolkit.getDefaultToolkit().getImage(getClass().getResource("agendaIcono.png"));
		setIconImage(iconoPropio);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setBounds(500, 100, 400, 100);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblProvincia.setBounds(10, 24, 92, 14);
		contentPane.add(lblProvincia);
		
		comboProvincia = new JComboBox();
		comboProvincia.setBounds(84, 20, 171, 22);
		contentPane.add(comboProvincia);
		
		btnSeleccionarProvincia = new JButton("Seleccionar");
		btnSeleccionarProvincia.setBounds(272, 20, 102, 23);
		contentPane.add(btnSeleccionarProvincia);
	}
	
	@SuppressWarnings("unchecked")
	public void setComboProvincias(String provincia) {
		this.comboProvincia.addItem(provincia);
	}
	
	@SuppressWarnings("unchecked")
	public JComboBox<String> getComboProvincias(){
		return this.comboProvincia;
	}
	
	@SuppressWarnings("unchecked")
	public JComboBox<String> getComboProvincia(){
		return this.comboProvincia;
	}
	
	public JButton getBtnSeleccionar() 
	{
		return btnSeleccionarProvincia;
	}

	public String getprovinciaSeleccionada() {
		return (String) this.comboProvincia.getSelectedItem();
		
	}

	public void mostrarVentanaProvincia() {
		this.setVisible(true);
	}

	public void ocultarProvincia() {
		this.dispose();
	}
}
