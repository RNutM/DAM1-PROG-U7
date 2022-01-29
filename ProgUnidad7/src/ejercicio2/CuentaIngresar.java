package ejercicio2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CuentaIngresar extends JFrame {
	/**
	 * Ventana para ingresar en cuenta
	 * 
	 * @author Robert G
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCantida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioCB.frame3 = new CuentaIngresar();
					InicioCB.frame3.setVisible(true);
					InicioCB.frame = new InicioCB();
					InicioCB.frame.setVisible(false);
					InicioCB.frame1 = new CuentaExtraer();
					InicioCB.frame1.setVisible(false);
					InicioCB.frame2 = new TarjetaExtraer();
					InicioCB.frame2.setVisible(false);
					InicioCB.frame4 = new TarjetaIngresar();
					InicioCB.frame4.setVisible(false);
					InicioCB.frame5 = new TransferirCuentaTarjeta();
					InicioCB.frame5.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CuentaIngresar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textCantida = new JTextField();
		textCantida.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textCantida.setBounds(118, 131, 195, 31);
		contentPane.add(textCantida);
		textCantida.setColumns(10);

		JLabel lblMensaje = new JLabel("Cantidad a ingresar en la cuenta:");
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMensaje.setBounds(63, 74, 305, 31);
		contentPane.add(lblMensaje);

		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textoc = textCantida.getText();
				double num1 = 0.0;
				try {
					num1 = Double.parseDouble(textoc);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Formato no adecuado.");
				}
				InicioCB.cuenta.ingresarSaldoCuenta(num1);
				InicioCB.lblResuCuenta.setText(Double.toString(InicioCB.cuenta.getSaldoCuenta()));
				textCantida.setText("");
				InicioCB.frame.setVisible(true);
				InicioCB.frame3.setVisible(false);
			}
		});
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnIngresar.setBounds(63, 198, 118, 42);
		contentPane.add(btnIngresar);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioCB.frame.setVisible(true);
				InicioCB.frame3.setVisible(false);
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVolver.setBounds(250, 198, 118, 42);
		contentPane.add(btnVolver);
	}
}
