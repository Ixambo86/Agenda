package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
//import org.apache.log4j.Logger;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class VentanaPersona extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JButton btnAgregarPersona;
	private static VentanaPersona INSTANCE;
	private JTextField txtCalle;
	private JTextField txtAltura;
	private JTextField txtPiso;
	private JTextField txtDepartamento;
	private JTextField txtTipoContacto;
	private JTextField txtFechaNacimiento;
	private JTextField txtEmail;
	private JButton btnSeleccionarTipoContacto;
	private JComboBox<String> comboPaises;
	//private Logger log = Logger.getLogger(Conexion.class);	
	private JTextField txtProvincia;
	private JTextField txtLocalidad;
	private JComboBox<String> comboBoxTipoTelefono;

	private JTextField txtTipoTelefono;
	private JLabel lblCampoObligarios;
	private JLabel lblObligatorioNombre;
	private JLabel lblObligatorioTelefono;
	private JLabel lblObligatorioEmail;
	private JLabel lblCampoEmailNoValido;
	private JLabel lblNewLabel;
	
	public static VentanaPersona getInstance()
	
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaPersona(); 	
			return new VentanaPersona();
		}
		else
			return INSTANCE;
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	private VentanaPersona() 
	{
		super();
		setBackground(new Color(30, 144, 255));
		setTitle("Agregar Contacto");
		
		Image iconoPropio = Toolkit.getDefaultToolkit().getImage(getClass().getResource("agendaIcono.png"));
		setIconImage(iconoPropio);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 362, 555);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(10, 11, 326, 494);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreYApellido = new JLabel("Nombre y apellido");
		lblNombreYApellido.setBounds(10, 30, 113, 14);
		panel.add(lblNombreYApellido);
		
		JLabel lblTelfono = new JLabel("Telefono");
		lblTelfono.setBounds(10, 55, 113, 14);
		panel.add(lblTelfono);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(133, 27, 164, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(133, 52, 164, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		btnAgregarPersona = new JButton("Agregar");
		btnAgregarPersona.setBounds(208, 460, 89, 23);
		panel.add(btnAgregarPersona);
		
		btnSeleccionarTipoContacto = new JButton("Seleccionar");
		btnSeleccionarTipoContacto.setBounds(38, 409, 105, 23);
		panel.add(btnSeleccionarTipoContacto);
		
		txtCalle = new JTextField();
		txtCalle.setBounds(133, 226, 164, 20);
		panel.add(txtCalle);
		txtCalle.setColumns(10);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(10, 232, 89, 14);
		panel.add(lblCalle);
		
		JLabel lblDirección = new JLabel("Direcci\u00F3n");
		lblDirección.setBounds(133, 201, 106, 14);
		panel.add(lblDirección);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(10, 257, 105, 14);
		panel.add(lblAltura);
		
		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(10, 282, 46, 14);
		panel.add(lblPiso);
		
		JLabel lblDepartamento = new JLabel("Dto");
		lblDepartamento.setBounds(178, 282, 37, 14);
		panel.add(lblDepartamento);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(133, 254, 164, 20);
		panel.add(txtAltura);
		txtAltura.setColumns(10);
		
		txtPiso = new JTextField();
		txtPiso.setBounds(77, 279, 46, 20);
		panel.add(txtPiso);
		txtPiso.setColumns(10);
		
		txtDepartamento = new JTextField();
		txtDepartamento.setBounds(225, 279, 46, 20);
		panel.add(txtDepartamento);
		txtDepartamento.setColumns(10);
		
		JLabel lblDatosPersonales = new JLabel("Datos Personales");
		lblDatosPersonales.setBounds(125, 5, 114, 14);
		panel.add(lblDatosPersonales);
		
		JLabel lblPaís = new JLabel("Pa\u00EDs");
		lblPaís.setBounds(10, 307, 46, 14);
		panel.add(lblPaís);
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(10, 332, 89, 14);
		panel.add(lblProvincia);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(10, 357, 89, 14);
		panel.add(lblLocalidad);
		
		JLabel lblTipoContacto = new JLabel("Tipo de Contacto");
		lblTipoContacto.setBounds(112, 384, 105, 14);
		panel.add(lblTipoContacto);
		
		txtTipoContacto = new JTextField();
		txtTipoContacto.setBounds(153, 410, 105, 23);
		panel.add(txtTipoContacto);
		txtTipoContacto.setColumns(10);
		
		JLabel lblFechaNac = new JLabel("Fec. Nac.:");
		lblFechaNac.setBounds(10, 111, 113, 14);
		panel.add(lblFechaNac);
		
		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setBounds(133, 108, 105, 20);
		panel.add(txtFechaNacimiento);
		txtFechaNacimiento.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 136, 113, 14);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(133, 133, 164, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10
				);
		
		comboPaises = new JComboBox<String>();
		comboPaises.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			}		
			}

			
		);
		
		comboPaises.setBounds(133, 304, 105, 20);
		panel.add(comboPaises);
		
		txtProvincia = new JTextField();
		txtProvincia.setBounds(133, 329, 164, 20);
		panel.add(txtProvincia);
		txtProvincia.setColumns(10);
		
		txtLocalidad = new JTextField();
		txtLocalidad.setBounds(133, 354, 164, 20);
		panel.add(txtLocalidad);
		txtLocalidad.setColumns(10);
		comboPaises.addItem("");
		
		JLabel lblTipoTelefono = new JLabel("Tipo de Tel.:");
		lblTipoTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		lblTipoTelefono.setBounds(10, 83, 113, 14);
		panel.add(lblTipoTelefono);
		
		txtTipoTelefono = new JTextField();
		txtTipoTelefono.setBounds(232, 80, 72, 20);
		panel.add(txtTipoTelefono);
		txtTipoTelefono.setColumns(10);
		
		comboBoxTipoTelefono = new JComboBox();
		comboBoxTipoTelefono.setModel(new DefaultComboBoxModel(new String[] {"Celular", "Fijo", "Otro"}));
		comboBoxTipoTelefono.setBounds(133, 79, 89, 22);
		panel.add(comboBoxTipoTelefono);
		
		lblCampoObligarios = new JLabel("* Campos Obligatorios");
		lblCampoObligarios.setBackground(SystemColor.controlText);
		lblCampoObligarios.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		lblCampoObligarios.setForeground(Color.WHITE);
		lblCampoObligarios.setBounds(66, 460, 132, 19);
		panel.add(lblCampoObligarios);
		
		lblObligatorioNombre = new JLabel("*");
		lblObligatorioNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblObligatorioNombre.setForeground(Color.WHITE);
		lblObligatorioNombre.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblObligatorioNombre.setBackground(Color.RED);
		lblObligatorioNombre.setBounds(302, 27, 24, 20);
		panel.add(lblObligatorioNombre);
		
		lblObligatorioTelefono = new JLabel("*");
		lblObligatorioTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		lblObligatorioTelefono.setForeground(Color.WHITE);
		lblObligatorioTelefono.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblObligatorioTelefono.setBackground(Color.RED);
		lblObligatorioTelefono.setBounds(302, 55, 24, 20);
		panel.add(lblObligatorioTelefono);
		
		lblObligatorioEmail = new JLabel("*");
		lblObligatorioEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblObligatorioEmail.setForeground(Color.WHITE);
		lblObligatorioEmail.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblObligatorioEmail.setBackground(Color.RED);
		lblObligatorioEmail.setBounds(302, 136, 24, 20);
		panel.add(lblObligatorioEmail);
		
		lblCampoEmailNoValido = new JLabel("Campo no posee @");
		lblCampoEmailNoValido.setForeground(Color.WHITE);
		lblCampoEmailNoValido.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		lblCampoEmailNoValido.setBounds(194, 156, 132, 19);
		panel.add(lblCampoEmailNoValido);
		
		lblNewLabel = new JLabel("Datos Opcionales:");
		lblNewLabel.setBounds(10, 186, 133, 14);
		panel.add(lblNewLabel);
			
		this.setVisible(false);
		this.txtTipoTelefono.setVisible(false);	
		this.lblObligatorioNombre.setVisible(false);
		this.lblCampoObligarios.setVisible(false);
		this.lblObligatorioEmail.setVisible(false);
		this.lblCampoEmailNoValido.setVisible(false);
		this.lblObligatorioTelefono.setVisible(false);
		
	}
	
	public void mostrarVentana()
	{
		this.setVisible(true);
	}
	
	public JTextField getTxtNombre() 
	{
		return txtNombre;
	}

	public JTextField getTxtTelefono() 
	{
		return txtTelefono;
	}
	
	public JTextField getTxtTipoTelefono() 
	{
		return txtTipoTelefono;
	}
	
	public JTextField getTxtCalle() 
	{
		return txtCalle;
	}
	
	public JTextField getTxtAltura() 
	{
		return txtAltura;
	}
	
	public JTextField getTxtPiso() 
	{
		return txtPiso;
	}
	
	public JTextField getTxtDepartamento() 
	{
		return txtDepartamento;
	}
			
	public JTextField getTxtTipoContacto() 
	{
		return txtTipoContacto;
	}
	
	public JTextField getTxtEmail() 
	{
		return txtEmail;
	}
	
	public JTextField getTxtFechaNacimiento() 
	{
		return txtFechaNacimiento;
	}
	
	public JTextField getTxtProvincia() 
	{
		return txtProvincia;
	}
	
	public JTextField getTxtLocalidad() 
	{
		return txtLocalidad;
	}
	
	public JButton getBtnAgregarPersona() 
	{
		return btnAgregarPersona;
	}
	
	public JButton getSeleccionarTipoContacto() 
	{
		return btnSeleccionarTipoContacto;
	}

	public void mostrarVentanaTipoContacto() {
		VentanaTipoContacto nF = new VentanaTipoContacto();
		nF.setVisible(true);
	}
	
	public void agregarProvincia(String provincia) {
		this.txtProvincia.setText(provincia);
	}
	
	public void agregarLocalidad(String localidad) {
		this.txtLocalidad.setText(localidad);
	}
	
	
	public void setComboPaises(String pais) {
		
		this.comboPaises.addItem(pais);
	}
	
	
	public JComboBox<String> getComboPaises(){
		return this.comboPaises;
	}
	
	public String getComboBoxTipoTelefono(){
		if((String) this.comboBoxTipoTelefono.getSelectedItem()=="Otro") {
			return txtTipoTelefono.getText();
		}else return (String) this.comboBoxTipoTelefono.getSelectedItem();
	}
	
	public String getTipoTelefono(){
		return (String) this.comboBoxTipoTelefono.getSelectedItem();
	}
	
	public String getPaisSeleccionado() {
		return (String) this.comboPaises.getSelectedItem();
	}

	public void vaciarCampoPais() {
		this.comboPaises.setSelectedIndex(0);
	}
	

	public void cerrar()
	{
		this.txtNombre.setText(null);
		this.txtTelefono.setText(null);
		this.txtTipoTelefono.setText(null);
		this.txtCalle.setText(null);
		this.txtAltura.setText(null);
		this.txtPiso.setText(null);
		this.txtDepartamento.setText(null);
		this.comboPaises.setSelectedIndex(0);
		this.comboBoxTipoTelefono.setSelectedIndex(0);
		this.txtTipoContacto.setText(null);
		this.txtEmail.setText(null);
		this.txtFechaNacimiento.setText(null);
		this.txtProvincia.setText(null);
		this.txtLocalidad.setText(null);
		this.dispose();
	}

	public void agregarTipoContacto(String tipo) {
			this.txtTipoContacto.setText(tipo);
		}


	public JComboBox<String> getComboTipoTelefono() {
		return this.comboBoxTipoTelefono;
	}


	public void mostrarComboBoxTipoTelefono() {
		this.txtTipoTelefono.setVisible(true);
	}


	public void ocultarComboBoxTipoTelefono() {
		this.txtTipoTelefono.setVisible(false);
		
	}


	public void obligatorioNombre() {
		this.lblObligatorioNombre.setVisible(true);
		this.lblCampoObligarios.setVisible(true);
	}
	
	public void nombreOK() {
		this.lblObligatorioNombre.setVisible(false);
		this.lblCampoObligarios.setVisible(false);
	}
	
	public void obligatorioTelefono() {
		this.lblObligatorioTelefono.setVisible(true);
		this.lblCampoObligarios.setVisible(true);
	}
	
	public void telefonoOK() {
		this.lblObligatorioTelefono.setVisible(false);
		this.lblCampoObligarios.setVisible(false);
	}
	
	public void obligatorioEmail() {
		this.lblObligatorioEmail.setVisible(true);
		this.lblCampoObligarios.setVisible(true);
	}
	
	public void emailOK() {
		this.lblObligatorioEmail.setVisible(false);
		this.lblCampoObligarios.setVisible(false);
		this.lblCampoEmailNoValido.setVisible(false);
	}
	
	public void emailNoValido() {
		this.lblCampoEmailNoValido.setVisible(true);
	}
}


