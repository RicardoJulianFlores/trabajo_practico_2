package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

public class Main {

	public static void main(String[] args) {
		FelinoDomestico gato = new FelinoDomestico("Tanner", (byte)20,186f);
		//gato=null;
		//definición de expresión lambda que define el convertidor de FelinoDomestico a
		//FelinoSalvaje.
			Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(),
			x.getEdad(), x.getPeso());
		if(Converter.isNotNull(gato)) {
			//se realiza la conversion
			FelinoSalvaje felino1 = converter.convert(gato);
			//mostramos los datos del objeto felino salvaje felino1
			converter.mostrarObjeto(felino1);
		}
		else
		System.out.println("No hay gato");

	}

}
