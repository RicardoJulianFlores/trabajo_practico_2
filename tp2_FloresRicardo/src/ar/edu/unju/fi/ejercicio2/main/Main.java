package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {

	public static void main(String[] args) {
		List<Efemeride> lista = new ArrayList();
		Scanner sc = new Scanner(System.in);
		String op;
		do 
		{
			System.out.println("--MENU--");
			System.out.println("1 - Crear efemeride");
			System.out.println("2 - Mostrar efemerides");
			System.out.println("3 - Eliminar efemeride");
			System.out.println("4 - Modicar efemeride");
			System.out.println("5 - Salir");
			System.out.print("Ingrese opcion: ");
			op = sc.nextLine();
			switch(op)
			{
				case "1": 	Efemeride efemeride = new Efemeride();
							crearefem(efemeride);
							lista.add(efemeride);
							break;
				case "2": 	mostrarefem(lista);
							System.out.print("Presione ENTER para continuar...");
							sc.nextLine();
							break;
				case "3": 	eliminarefem(lista);
							break;
				case "4":	modefem(lista);
							break;
				case "5": 	System.out.println("Saliendo...");
							break;
				default:	System.out.println("Opcion Incorrecto");
				
			}
		}while(!op.equals("5"));

	}
	
	public static void crearefem(Efemeride e) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingrese codigo: ");
		e.setCodigo(sc.nextInt());
		sc.nextLine();
		System.out.print("Ingrese el numero del mes en numero: ");
		e.setMes(Mes.values()[sc.nextInt()-1]);
		System.out.print("Ingrese dia: ");
		e.setDia(sc.nextInt());
		sc.nextLine();
		System.out.print("Ingrese detalles: ");
		e.setDetalle(sc.nextLine());
	}

	public static void mostrarefem(List<Efemeride> lista) 
	{
		for(Efemeride efem: lista)
		{
			System.out.println("Codigo: "+efem.getCodigo());
			System.out.println("Mes: "+efem.getMes());
			System.out.println("Dia: "+efem.getDia());
			System.out.println("Detalle: "+efem.getDetalle());
		}
	}
	public static void eliminarefem(List<Efemeride> lista)
	{
		Scanner sc = new Scanner(System.in);
		int codigo;
		boolean band = false;
		
		System.out.println("Ingrese codigo de Efemeride a eliminar: ");
		codigo = sc.nextInt();
		
		for(Efemeride efem: lista)
			if(codigo == efem.getCodigo())
			{
				band = lista.remove(efem);
				System.out.println("Se elimino correctamente");
			}
		if(!band)
			System.out.println("Codigo no existente");
		
	}
	public static void modefem(List<Efemeride> lista)
	{
		Scanner sc = new Scanner(System.in);
		boolean band = false;
		System.out.print("Ingrese codigo de Efemeride a modificar: ");
		int codigo = sc.nextInt();
		
		for(Efemeride efem: lista)
			if(codigo == efem.getCodigo())
			{
				band = true;
				System.out.println("Ingrese codigo: ");
				efem.setCodigo(sc.nextInt());
				sc.nextLine();
				System.out.println("Ingrese el numero del mes en numero: ");
				efem.setMes(Mes.values()[sc.nextInt()-1]);
				System.out.println("Ingrese dia: ");
				efem.setDia(sc.nextInt());
				sc.nextLine();
				System.out.println("Ingrese detalles: ");
				efem.setDetalle(sc.nextLine());
			}
		if(!band)
			System.out.println("El codigo no pertence a un dia existente");
		}

}