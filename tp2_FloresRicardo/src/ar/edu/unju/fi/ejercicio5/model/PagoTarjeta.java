package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoTarjeta implements Pago{
	private String NumTarjeta;
	private LocalDate FechaPago;
	private double MontoPagado;

	@Override
	public void realizarPago(double monto) {
		this.MontoPagado= monto*1.15;
		FechaPago=LocalDate.now();
		System.out.print("Ingrese numero de tarjeta: ");
		Scanner sc = new Scanner(System.in);
		NumTarjeta=sc.nextLine();
	}

	@Override
	public void imprimirRecibo() {
		System.out.println("Número de tarjeta: "+NumTarjeta);
		System.out.println("Fecha de pago: "+DateTimeFormatter.ofPattern("dd/MM/yy").format(FechaPago));
		System.out.println("Monto pagado: "+MontoPagado);
	}

}
