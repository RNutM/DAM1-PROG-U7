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

public class CuentaExtraer extends JFrame {
	/**
	 * Ventana para extraer de cuenta
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
					InicioCB.frame5 = new TransferirCuentaTarjeta();
					InicioCB.frame5.setVisible(false);
					InicioCB.frame = new InicioCB();
					InicioCB.frame.setVisible(false);
					InicioCB.frame1 = new CuentaExtraer();
					InicioCB.frame1.setVisible(true);
					InicioCB.frame2 = new TarjetaExtraer();
					InicioCB.frame2.setVisible(false);
					InicioCB.frame3 = new CuentaIngresar();
					InicioCB.frame3.setVisible(false);
					InicioCB.frame4 = new TarjetaIngresar();
					InicioCB.frame4.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CuentaExtraer() {
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

		JLabel lblMensa = new JLabel("Cantidad a extraer de la cuenta:");
		lblMensa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMensa.setBounds(63, 74, 305, 31);
		contentPane.add(lblMensa);

		JButton button = new JButton("Extraer");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textoc = textCantidad.getText();
				double num1 = 0.0;
				try {
					num1 = Double.parseDouble(textoc);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Formato no adecuado.");
				}
				InicioCB.cuenta.sacarSaldoCuenta(num1);
				InicioCB.lblResuCuenta.setText(Double.toString(InicioCB.cuenta.getSaldoCuenta()));
				textCantidad.setText("");
				InicioCB.frame.setVisible(true);
				InicioCB.frame1.setVisible(false);
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button.setBounds(63, 198, 118, 42);
		contentPane.add(button);

		JButton button_1 = new JButton("Volver");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioCB.frame.setVisible(true);
				InicioCB.frame1.setVisible(false);
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button_1.setBounds(250, 198, 118, 42);
		contentPane.add(button_1);
	}
}
