package ejercicio2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TarjetaIngresar extends JFrame {
	/**
	 * Ventana para ingresar en tarjeta
	 * 
	 * @author Robert G
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioCB.frame4 = new TarjetaIngresar();
					InicioCB.frame4.setVisible(true);
					InicioCB.frame = new InicioCB();
					InicioCB.frame.setVisible(false);
					InicioCB.frame1 = new CuentaExtraer();
					InicioCB.frame1.setVisible(false);
					InicioCB.frame2 = new TarjetaExtraer();
					InicioCB.frame2.setVisible(false);
					InicioCB.frame3 = new CuentaIngresar();
					InicioCB.frame3.setVisible(false);
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
	public TarjetaIngresar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textCantidad = new JTextField();
		textCantidad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textCantidad.setColumns(10);
		textCantidad.setBounds(118, 131, 195, 31);
		contentPane.add(textCantidad);

		JLabel lblMensa = new JLabel("Cantidad a ingresar en la tarjeta:");
		lblMensa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMensa.setBounds(62, 74, 308, 31);
		contentPane.add(lblMensa);

		JButton button = new JButton("Ingresar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textoc = textCantidad.getText();
				double num1 = 0.0;
				try {
					num1 = Double.parseDouble(textoc);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Formato no adecuado.");
				}
				InicioCB.cuenta.ingresarSaldoTarjeta(num1);
				InicioCB.lblResuTarjeta.setText(Double.toString(InicioCB.cuenta.getSaldoTarjeta()));
				textCantidad.setText("");
				InicioCB.frame.setVisible(true);
				InicioCB.frame4.setVisible(false);
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button.setBounds(62, 198, 118, 42);
		contentPane.add(button);

		JButton button_1 = new JButton("Volver");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioCB.frame.setVisible(true);
				InicioCB.frame4.setVisible(false);
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button_1.setBounds(249, 198, 118, 42);
		contentPane.add(button_1);
	}
}
