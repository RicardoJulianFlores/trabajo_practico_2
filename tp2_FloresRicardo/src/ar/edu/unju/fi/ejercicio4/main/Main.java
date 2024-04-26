package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Jugador>plantel = new ArrayList<Jugador>();
		Scanner sc = new Scanner(System.in);
		String op;
		do {
		System.out.println("MENU");
		System.out.println("1- Alta de Jugador");
		System.out.println("2- Mostrar todos los jugadores"); 
		System.out.println("3- Modificar la posicion de un jugador");
		System.out.println("4- Eliminar un jugador ");
		System.out.println("5- Salir");
		System.out.print("Ingrese Opcion: "); 
		op= sc.next();
		switch(op)
		{
			case "1": Jugador jg = new Jugador();
					  altaJugador(jg);
					  plantel.add(jg);
					  break;
			case "2": mostrarTodo(plantel);
					  break;
			case "3": modJugador(plantel);
					  break;
			case "4": eliminar(plantel);
					  break;
			case "5": System.out.println("Saliendo...");
			default:  System.out.println("Opcion ingresada inexistente");
					  break;
		 }
		sc.nextLine();
		System.out.print("Presione ENTER para continuar...");
		sc.nextLine();
		}while(!op.equals("5"));
		
	}
	
	public static void altaJugador(Jugador jg) {
		Scanner sc = new Scanner(System.in);
		boolean error;
		System.out.print("Ingrese su nombre: ");
		jg.setNombre(sc.nextLine());;
		System.out.print("Ingrese su apellido: ");
		jg.setApellido(sc.nextLine());
		do {
		try {
			error=false;
			System.out.println("Ingrese su Fecha de Nacimiento (dd/mm/yyyy): ");
			jg.setFechaNacimiento(LocalDate.parse(sc.next(),DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			sc.nextLine();
		} catch ( DateTimeParseException e) {
			System.out.println("Fecha mal ingresada");
			error=true;
		}
		}while(error);
		System.out.println("Ingrese su Nacionalidad: ");
		jg.setNacionalidad(sc.nextLine());
		System.out.print("Ingrese su Estatura: ");
		jg.setEstatura(sc.nextDouble());
		System.out.print("Ingrese su Peso: ");
		jg.setPeso(sc.nextDouble());
		sc.nextLine();
		menuposicion(jg);
		
	}

	public static void menuposicion(Jugador jg)
	{
		boolean error;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				error=false;
		System.out.println("Posicion");
		System.out.println("1-Delantero");
		System.out.println("2-Medio");
		System.out.println("3-Defensa");
		System.out.println("4-Arquero");
		System.out.println("Elija opcion: ");
		jg.setPosicion(Posicion.values()[sc.nextInt()-1]);
			} catch ( Exception e) {
				System.out.println("Opcion Incorrecta");
				error=true;
			}
		}while(error);
	}
	
	
	public static void mostrarTodo(List<Jugador> plantel) {
		for(Jugador j: plantel) {
			System.out.println("Nombre: "+j.getNombre());
			System.out.println("Apellido: "+j.getApellido());
			System.out.println("Fecha Nacimiento: "+j.getFechaNacimiento().getDayOfMonth()+"/"
			+j.getFechaNacimiento().getMonthValue()+"/"+j.getFechaNacimiento().getYear());
			System.out.println("Nacionalidad: "+j.getNacionalidad());
			System.out.println("Estatura: "+j.getEstatura());
			System.out.println("Peso: "+j.getPeso());
			System.out.println("Posicion: "+j.getPosicion());
		}
	}
	
	public static void modJugador(List<Jugador> plantel) {
		Scanner sc = new Scanner(System.in);
		String nombre;
		String apellido;
		System.out.print("Ingrese el nombre de jugador: ");
		nombre=sc.nextLine();
		System.out.print("Ingrese su apellido: ");
		apellido=sc.nextLine();
		for(Jugador j: plantel)
			if(j.getNombre().equals(nombre) && j.getApellido().equals(apellido))
				menuposicion(j);
	}
	
	public static void eliminar(List<Jugador> plantel) {
		Scanner sc = new Scanner(System.in);
		String nombre;
		String apellido;
		Boolean borrado=false;
		System.out.print("Ingrese el nombre de jugador: ");
		nombre=sc.nextLine();
		System.out.print("Ingrese su apellido: ");
		apellido=sc.nextLine();
		for(int i=0;i<plantel.size();i++)
			if(plantel.get(i).getNombre().equals(nombre) && plantel.get(i).getApellido().equals(apellido)) {
				plantel.remove(i);
				borrado=true;
				}
		if (borrado)
			System.out.println("Jugador eliminado");
		else 
			System.out.println("Jugador no encontrado");
	}
}
