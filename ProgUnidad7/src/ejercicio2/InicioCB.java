package ejercicio2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTabbedPane;

public class InicioCB extends JFrame {
	/**
	 * Ventana para iniciar programa de cuenta bancaria (Main)
	 * 
	 * @author Robert G
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static InicioCB frame;
	static CuentaExtraer frame1;
	static TarjetaExtraer frame2;
	static CuentaIngresar frame3;
	static TarjetaIngresar frame4;
	static TransferirCuentaTarjeta frame5;
	static Cuenta cuenta = new Cuenta();
	static JLabel lblResuCuenta;
	static JLabel lblResuTarjeta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new InicioCB();
					frame.setVisible(true);
					frame1 = new CuentaExtraer();
					frame1.setVisible(false);
					frame2 = new TarjetaExtraer();
					frame2.setVisible(false);
					frame3 = new CuentaIngresar();
					frame3.setVisible(false);
					frame4 = new TarjetaIngresar();
					frame4.setVisible(false);
					frame5 = new TransferirCuentaTarjeta();
					frame5.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InicioCB() {
		setTitle("Cuenta Bancaria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 419);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label_1 = new JLabel("\u20AC");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(490, 320, 35, 30);
		contentPane.add(label_1);

		JLabel label = new JLabel("\u20AC");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(490, 275, 35, 30);
		contentPane.add(label);

		lblResuTarjeta = new JLabel("0.0");
		lblResuTarjeta.setBackground(Color.WHITE);
		lblResuTarjeta.setHorizontalAlignment(SwingConstants.LEFT);
		lblResuTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblResuTarjeta.setBounds(211, 320, 275, 30);
		contentPane.add(lblResuTarjeta);

		JButton btnIngresar = new JButton("Ingresar en la Cuenta");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame3.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnIngresar.setBounds(65, 75, 165, 41);
		contentPane.add(btnIngresar);

		JButton btbSacar = new JButton("Extraer de la Cuenta");
		btbSacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame1.setVisible(true);
				frame.setVisible(false);
			}
		});
		btbSacar.setBounds(265, 75, 165, 41);
		contentPane.add(btbSacar);

		JButton btbTransferir = new JButton("Transferir a la Tarjeta");
		btbTransferir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioCB.frame5.setVisible(true);
				InicioCB.frame.setVisible(false);
			}
		});
		btbTransferir.setBounds(465, 75, 165, 41);
		contentPane.add(btbTransferir);

		JButton btbInTarjeta = new JButton("Ingresar en la Tarjeta");
		btbInTarjeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame4.setVisible(true);
				frame.setVisible(false);
			}
		});
		btbInTarjeta.setBounds(150, 165, 165, 41);
		contentPane.add(btbInTarjeta);

		JButton btbSacTarjeta = new JButton("Extraer de la Tarjeta");
		btbSacTarjeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame2.setVisible(true);
				frame.setVisible(false);
			}
		});
		btbSacTarjeta.setBounds(350, 165, 165, 41);
		contentPane.add(btbSacTarjeta);

		JLabel LBLsALDO = new JLabel("Saldo Cuenta");
		LBLsALDO.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LBLsALDO.setBounds(65, 277, 102, 30);
		contentPane.add(LBLsALDO);

		JLabel lblTarjeta = new JLabel("Saldo Tarjeta");
		lblTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTarjeta.setBounds(65, 320, 102, 30);
		contentPane.add(lblTarjeta);

		lblResuCuenta = new JLabel("0.0");
		lblResuCuenta.setHorizontalAlignment(SwingConstants.LEFT);
		lblResuCuenta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblResuCuenta.setBackground(Color.WHITE);
		lblResuCuenta.setBounds(211, 277, 275, 30);
		contentPane.add(lblResuCuenta);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(191, 320, 324, 30);
		contentPane.add(tabbedPane_1);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(191, 277, 324, 30);
		contentPane.add(tabbedPane);
	}

	public static JLabel getLblResuCuenta() {
		return lblResuCuenta;
	}

	public static void setLblResuCuenta(JLabel lblResuCuenta) {
		InicioCB.lblResuCuenta = lblResuCuenta;
	}

	public JLabel getLblResuTarjeta() {
		return lblResuTarjeta;
	}

	public void setLblResuTarjeta(JLabel lblResuTarjeta) {
		InicioCB.lblResuTarjeta = lblResuTarjeta;
	}
}
