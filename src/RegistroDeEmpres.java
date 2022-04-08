import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Validaciones.Validacion;

public class RegistroDeEmpres extends JFrame implements KeyListener, ActionListener {

	private JPanel contentPane;
	private JTextField txtEmpresa;
	private JTextField txtRuc;
	private JTextField txtDireccion;
	private JTextField txtPuntoDeVentas;
	private JButton btnVentas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroDeEmpres frame = new RegistroDeEmpres();
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
	public RegistroDeEmpres() {
		setTitle("REGISTRO DE EMPRESA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 346, 295);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRO DE EMPRESA");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(78, 23, 198, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("EMPRESA");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 64, 68, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("RUC");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(10, 100, 68, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("DIRECCI\u00D3N");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_2.setBounds(10, 135, 68, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("PUNTO DE VENTAS");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_3.setBounds(10, 174, 109, 14);
		contentPane.add(lblNewLabel_1_3);
		
		txtEmpresa = new JTextField();
		txtEmpresa.addKeyListener(this);
		txtEmpresa.setBounds(128, 61, 192, 20);
		contentPane.add(txtEmpresa);
		txtEmpresa.setColumns(10);
		
		txtRuc = new JTextField();
		txtRuc.addKeyListener(this);
		txtRuc.setBounds(128, 97, 192, 20);
		contentPane.add(txtRuc);
		txtRuc.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.addKeyListener(this);
		txtDireccion.setBounds(128, 132, 192, 20);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtPuntoDeVentas = new JTextField();
		txtPuntoDeVentas.addKeyListener(this);
		txtPuntoDeVentas.setBounds(129, 171, 191, 20);
		contentPane.add(txtPuntoDeVentas);
		txtPuntoDeVentas.setColumns(10);
		
		btnVentas = new JButton("ENVIAR");
		btnVentas.addActionListener(this);
		btnVentas.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVentas.setBounds(92, 213, 156, 23);
		contentPane.add(btnVentas);
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtPuntoDeVentas) {
			keyTypedTxtPuntoDeVentasJTextField(e);
		}
		if (e.getSource() == txtDireccion) {
			keyTypedTxtDireccionJTextField(e);
		}
		if (e.getSource() == txtRuc) {
			keyTypedTxtRucJTextField(e);
		}
		if (e.getSource() == txtEmpresa) {
			keyTypedTxtEmpresaJTextField(e);
		}
	}
	protected void keyTypedTxtEmpresaJTextField(KeyEvent e) {
		//Si el texto es mayor que25
		String texto = txtEmpresa.getText().trim() + e.getKeyChar(); 
		if(texto.length()>25) {
					e.consume();
		}
	}
	protected void keyTypedTxtRucJTextField(KeyEvent e) {
		//Si el texto no es un digito
		if(!Character.isDigit(e.getKeyChar())) {
			//Se destuye envio
			e.consume();
		}
		//Si el texto es mayor que 11
		String texto = txtRuc.getText().trim() + e.getKeyChar(); 
		if(texto.length()>11) {
			e.consume();
		}
	}
	protected void keyTypedTxtDireccionJTextField(KeyEvent e) {
		//Si el texto es mayor que25
		String texto = txtDireccion.getText().trim() + e.getKeyChar(); 
		if(texto.length()>40) {
			e.consume();
		}
	}
	protected void keyTypedTxtPuntoDeVentasJTextField(KeyEvent e) {
		if(!Character.isDigit(e.getKeyChar())) {
			//Se destuye envio
			e.consume();
		}
		//Si el texto es mayor que25
		String texto = txtPuntoDeVentas.getText().trim() + e.getKeyChar(); 
		if(texto.length()>2) {
			e.consume();
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVentas) {
			actionPerformedBtnVentasJButton(e);
		}
	}
	protected void actionPerformedBtnVentasJButton(ActionEvent e) {
		String  emp = txtEmpresa.getText();
		String  ruc = txtRuc.getText();
		String  dire = txtDireccion.getText();
		String  pven = txtPuntoDeVentas.getText();
		
		if(!emp.matches(Validacion.Empresa)) {
			mensaje("El nombre de la empresa solo puede tener de 3 A 25 caracteres");
		}else if(!ruc.matches(Validacion.Ruc)){
			mensaje("La Ruc solo puede contener 11 digitos");	
		}else if(!dire.matches(Validacion.Direccion)) {
			mensaje("La dirección solo puede tener 3 a 40 caracteres");
		}else if(!pven.matches(Validacion.PuntoVentas)) {
			mensaje("El punto de ventas solo puede contener 2 caracteres");
		}else {
			mensaje("Mensaje enviado - Datos ingresados correctamente");
		}
		
	}

	 void mensaje(String men) {
		 JOptionPane.showMessageDialog(this, men);
	}
}
