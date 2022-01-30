package ejercicio3;

import java.util.Scanner;

public class CifrarDescifrar {
	/**
	 * Programa para cifrar y desfricar texto
	 * 
	 * @author Robert G
	 * 
	 */
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		cifrar();
		descifrar();
	}

	private static void cifrar() {
		System.out.println("Introduce un texto a cifrar:");
		String texto = sc.nextLine();
		StringBuilder cifrado = new StringBuilder(texto.length());
		int valorASCII = 0;
		for (int i = 0; i < texto.length(); i++) {
			valorASCII = (int) (texto.charAt(i));
			valorASCII = (valorASCII + 3) % 255;
			cifrado.append((char) (valorASCII));
		}
		String textocodificado = cifrado.toString();
		System.out.println("El mensaje codificado es: " + textocodificado);
	}

	private static void descifrar() {
		System.out.println("Introduce un texto a descifrar:");
		String texto = sc.nextLine();
		StringBuilder cifrado = new StringBuilder(texto.length());
		int valorASCII = 0;
		for (int i = 0; i < texto.length(); i++) {
			valorASCII = (int) (texto.charAt(i));
			valorASCII = (valorASCII - 3) % 255;
			cifrado.append((char) (valorASCII));
		}
		String textocodificado = cifrado.toString();
		System.out.println("El mensaje decodificado es: " + textocodificado);
	}
}
