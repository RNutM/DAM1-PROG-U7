package ejercicio3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class VentanaTextoCifrado extends JFrame {
	/**
	 * Programa para cifrar y desfricar texto
	 * 
	 * @author Robert G
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaTextoCifrado frame = new VentanaTextoCifrado();
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
	public VentanaTextoCifrado() {
		setTitle("Cifrado C\u00E9sar");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 555);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);

		JMenu menuArchivo = new JMenu("Archivo");
		menuBar.add(menuArchivo);

		JMenuItem menuAbrir = new JMenuItem("Abrir");
		menuAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser JFichero = new JFileChooser();
				int opcion = JFichero.showOpenDialog(contentPane);
				if (opcion == JFileChooser.APPROVE_OPTION) {
					File archivo = JFichero.getSelectedFile();
					String texto = "";
					try {
						FileReader entrada = new FileReader(archivo);
						BufferedReader buffer = new BufferedReader(entrada);
						String linea = "";

						while (linea != null) {
							linea = buffer.readLine();
							if (linea != null) {
								texto = texto + linea + "\n";
								System.out.println(linea);
							}
						}
						buffer.close();
						entrada.close();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Se ha producido un error inesperado.");
					}
					textArea.setText(texto);
				}
			}
		});
		menuArchivo.add(menuAbrir);

		JMenuItem menuGuardar = new JMenuItem("Guardar");
		menuGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser JFichero = new JFileChooser();
				int opcion = JFichero.showSaveDialog(contentPane);
				if (opcion == JFileChooser.APPROVE_OPTION) {
					File archivo = JFichero.getSelectedFile();
					try {
						FileWriter FWFichero = new FileWriter(archivo);
						BufferedWriter buffer = new BufferedWriter(FWFichero);
						buffer.write(textArea.getText());
						buffer.close();
						FWFichero.close();
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Se ha producido un error inesperado.");
					}
				}
			}
		});
		menuArchivo.add(menuGuardar);

		JMenuItem menuSalir = new JMenuItem("Salir");
		menuSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuArchivo.add(menuSalir);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textArea = new JTextArea();
		textArea.setForeground(Color.DARK_GRAY);
		textArea.setBackground(new Color(95, 158, 160));
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea.setBounds(12, 118, 958, 350);
		contentPane.add(textArea);

		JButton btnCifrar = new JButton("Cifrar");
		btnCifrar.setBackground(new Color(230, 230, 250));
		btnCifrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = textArea.getText();
				StringBuilder cifrado = new StringBuilder(texto.length());
				int valorASCII = 0;
				for (int i = 0; i < texto.length(); i++) {
					valorASCII = (int) (texto.charAt(i));
					valorASCII = (valorASCII + 3) % 255;
					cifrado.append((char) (valorASCII));
				}
				texto = cifrado.toString();
				textArea.setText(texto);
			}
		});
		btnCifrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCifrar.setBounds(202, 53, 177, 54);
		contentPane.add(btnCifrar);

		JButton btnDescifrar = new JButton("Descifrar");
		btnDescifrar.setBackground(new Color(230, 230, 250));
		btnDescifrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = textArea.getText();
				StringBuilder cifrado = new StringBuilder(texto.length());
				int valorASCII = 0;
				for (int i = 0; i < texto.length(); i++) {
					valorASCII = (int) (texto.charAt(i));
					valorASCII = (valorASCII - 3) % 255;
					cifrado.append((char) (valorASCII));
				}
				texto = cifrado.toString();
				textArea.setText(texto);
			}
		});
		btnDescifrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDescifrar.setBounds(602, 53, 177, 54);
		contentPane.add(btnDescifrar);

		JLabel lblNewLabel = new JLabel("CIFRADO C\u00C9SAR");
		lblNewLabel.setForeground(new Color(230, 230, 250));
		lblNewLabel.setFont(new Font("Tekton Pro", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(421, 11, 140, 30);
		contentPane.add(lblNewLabel);
	}
}
