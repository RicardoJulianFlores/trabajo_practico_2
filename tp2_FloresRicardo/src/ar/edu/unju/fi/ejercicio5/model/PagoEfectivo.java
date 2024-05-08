package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoEfectivo implements Pago{
	private double MontoPagado;
	private LocalDate FechaPago;

	@Override
	public void realizarPago(double monto) {
		MontoPagado= monto*0.9;
		FechaPago=LocalDate.now();
	}

	@Override
	public void imprimirRecibo() {
		System.out.println("Fecha de pago: "+DateTimeFormatter.ofPattern("dd/MM/yy").format(FechaPago));
		System.out.println("Monto pagado: "+MontoPagado);
	}

}
