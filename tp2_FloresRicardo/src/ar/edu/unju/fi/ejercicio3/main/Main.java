package ar.edu.unju.fi.ejercicio3.main;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
		Provincia[] provincia;
		provincia=Provincia.values();
		for(int i=0; i<provincia.length;i++) {
			System.out.println(provincia[i]);
			System.out.println("Cantidad de poblacion: "+provincia[i].getCantidadPoblacion()+" habitantes");
			System.out.println("Superficie: "+provincia[i].getSuperficie()+" km2");
			System.out.println("Densidad poblacional: "+provincia[i].densidadPoblacional()+"/km2");
			System.out.println(" ");
		}
	}

}
