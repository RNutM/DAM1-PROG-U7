package ejercicio2;

import javax.swing.JOptionPane;

public class Cuenta {
	/**
	 * Practicando con Ventanas ejercicio2
	 * 
	 * @author Robert G
	 */
	// Atributos
	String titular = "";
	double saldoCuenta = 0.0;
	double saldoTarjeta = 0.0;

	// Métodos getters

	String getTitular() {
		return this.titular;
	}

	double getSaldoCuenta() {
		return this.saldoCuenta;
	}

	double getSaldoTarjeta() {
		return this.saldoTarjeta;
	}

	// Métodos Setters

	void setTitular(String titular) {
		this.titular = titular;
	}

	void setSaldoCuenta(double saldoCuenta) {
		this.saldoCuenta = saldoCuenta;
	}

	void setSaldoTarjeta(double saldoTarjeta) {
		this.saldoTarjeta = saldoTarjeta;
	}

	// Otros métodos

	void ingresarSaldoCuenta(double cantidad) {
		if (cantidad <= 0) {
			JOptionPane.showMessageDialog(null, "Ingrese un número positivo.");
		} else {
			this.saldoCuenta = Math.round((saldoCuenta + cantidad) * 100.0) / 100.0;
		}
	}

	void ingresarSaldoTarjeta(double cantidad) {
		if (cantidad <= 0) {
			JOptionPane.showMessageDialog(null, "Ingrese un número positivo.");
		} else {
			this.saldoTarjeta = Math.round((saldoTarjeta + cantidad) * 100.0) / 100.0;
		}
	}

	void sacarSaldoCuenta(double cantidad) {
		if (cantidad <= 0) {
			JOptionPane.showMessageDialog(null, "Ingrese un número positivo.");
		} else {
			if (saldoCuenta < cantidad) {
				JOptionPane.showMessageDialog(null,
						"La cantidad a extraer es mayor a su saldo actual. Ingrese una cantidad adecuada.");
			} else {
				this.saldoCuenta = Math.round((saldoCuenta - cantidad) * 100.0) / 100.0;
			}
		}
	}

	void sacarSaldoTarjeta(double cantidad) {
		if (cantidad <= 0) {
			JOptionPane.showMessageDialog(null, "Ingrese un número positivo.");
		} else {
			if (saldoTarjeta < cantidad) {
				JOptionPane.showMessageDialog(null,
						"La cantidad a extraer es mayor al saldo actual de su tarjeta. Ingrese una cantidad adecuada.");
			} else {
				this.saldoTarjeta = Math.round((saldoTarjeta - cantidad) * 100.0) / 100.0;
			}
		}
	}

	void transferirSaldoATarjeta(double cantidad) {
		if (cantidad <= 0) {
			JOptionPane.showMessageDialog(null, "Ingrese un número positivo.");
		} else {
			if (saldoCuenta < cantidad) {
				JOptionPane.showMessageDialog(null,
						"La cantidad a ingresar es mayor a su saldo actual. Ingrese una cantidad adecuada.");
			} else {
				this.saldoCuenta = Math.round((saldoCuenta - cantidad) * 100.0) / 100.0;
				this.saldoTarjeta = Math.round((saldoTarjeta + cantidad) * 100.0) / 100.0;
			}
		}
	}

	void mostrardatosCuenta() {
		System.out.println("Su saldo actual es de: " + this.saldoCuenta + " euros.\n" + "El saldo en su tarjeta es de: "
				+ this.saldoTarjeta + " euros.\n");
	}
}