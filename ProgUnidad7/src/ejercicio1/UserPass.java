package ejercicio1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UserPass extends JFrame {
	/**
	 * Practicando con Ventanas ejercicio1
	 * 
	 * @author Robert G
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsu;
	private JPasswordField txtCon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPass frame = new UserPass();
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
	public UserPass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 44, 136, 136, 0 };
		gbl_contentPane.rowHeights = new int[] { 56, 38, 38, 43, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblUsu = new JLabel("Usuario:");
		lblUsu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblUsu = new GridBagConstraints();
		gbc_lblUsu.fill = GridBagConstraints.BOTH;
		gbc_lblUsu.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsu.gridx = 1;
		gbc_lblUsu.gridy = 1;
		contentPane.add(lblUsu, gbc_lblUsu);

		txtUsu = new JTextField();
		txtUsu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtUsu.setColumns(10);
		GridBagConstraints gbc_txtUsu = new GridBagConstraints();
		gbc_txtUsu.fill = GridBagConstraints.BOTH;
		gbc_txtUsu.insets = new Insets(0, 0, 5, 0);
		gbc_txtUsu.gridx = 2;
		gbc_txtUsu.gridy = 1;
		contentPane.add(txtUsu, gbc_txtUsu);

		JLabel lblCon = new JLabel("Contrase\u00F1a:");
		lblCon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblCon = new GridBagConstraints();
		gbc_lblCon.fill = GridBagConstraints.BOTH;
		gbc_lblCon.insets = new Insets(0, 0, 5, 5);
		gbc_lblCon.gridx = 1;
		gbc_lblCon.gridy = 2;
		contentPane.add(lblCon, gbc_lblCon);

		txtCon = new JPasswordField();
		txtCon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_txtCon = new GridBagConstraints();
		gbc_txtCon.fill = GridBagConstraints.BOTH;
		gbc_txtCon.insets = new Insets(0, 0, 5, 0);
		gbc_txtCon.gridx = 2;
		gbc_txtCon.gridy = 2;
		contentPane.add(txtCon, gbc_txtCon);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				if (txtCon.getText().equals("1234") && txtUsu.getText().equals("Usuario")) {
					JOptionPane.showMessageDialog(null, "¡Bienvenido!");
				} else {
					JOptionPane.showMessageDialog(null, "¡¡El usuario o la contraseña son incorrectos!!");
				}
			}
		});
		GridBagConstraints gbc_btnEntrar = new GridBagConstraints();
		gbc_btnEntrar.fill = GridBagConstraints.BOTH;
		gbc_btnEntrar.insets = new Insets(0, 0, 0, 5);
		gbc_btnEntrar.gridx = 1;
		gbc_btnEntrar.gridy = 3;
		contentPane.add(btnEntrar, gbc_btnEntrar);

		JButton btnsalir = new JButton("Salir");
		btnsalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		GridBagConstraints gbc_btnsalir = new GridBagConstraints();
		gbc_btnsalir.fill = GridBagConstraints.BOTH;
		gbc_btnsalir.gridx = 2;
		gbc_btnsalir.gridy = 3;
		contentPane.add(btnsalir, gbc_btnsalir);
	}
}
