package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Categoria;
import ar.edu.unju.fi.ejercicio1.model.OrigenFabricacion;
import ar.edu.unju.fi.ejercicio1.model.Producto;

public class Main {

	public static void main(String[] args) {
		List<Producto> almacen = new ArrayList<Producto>();
		Scanner sc = new Scanner(System.in);
		String op;
		do {
			System.out.println("MENU");
			System.out.println("1-Crear Producto");
			System.out.println("2-Mostrar Producto");
			System.out.println("3-Modificar Producto");
			System.out.println("4-Salir");
			System.out.print("Ingrese opcion: ");
			op=sc.nextLine();
			switch(op) {
			case "1":   Producto producto = new Producto();
						crear(producto);
						almacen.add(producto);
						break;
			case "2": 	mostrar(almacen);
						System.out.print("Presione ENTER para continuar...");
						sc.nextLine();
						break;
			case "3": 	modificar(almacen);
						break;
			case "4": System.out.println("Saliendo...");
						break;
			default: System.out.println("Opcion Incorrecta");
			}
		}while(!op.equals("4"));
	}
		
	public static void crear(Producto p)
	{
		Scanner sc = new Scanner(System.in);
		boolean band;
		System.out.print("Ingrese codigo del Producto: ");
		p.setCodigo(sc.nextInt());
		sc.nextLine();
		System.out.print("Ingrese una breve descripcion del Producto: ");
		p.setDescripcion(sc.nextLine());
		System.out.print("Ingrese precio del Producto: ");
		p.setPrecioUnitario(sc.nextDouble());
		sc.nextLine();
		submenu(p);
	}
	
	public static void submenu(Producto p)
	{
		Scanner sc = new Scanner(System.in);
		String op;
		boolean error;
		do {
			error=false;
		System.out.println("---- Origen de fabricación ------");
		System.out.println("1 - Argentina");
		System.out.println("2 - China");
		System.out.println("3 - Brasil");
		System.out.println("4 – Uruguay");
		System.out.println("Elija una opción: ");
		op=sc.nextLine();
		switch(op)
		{
		case "1":   p.setOrigenFabricacion(OrigenFabricacion.ARGENTINA);
					break;
		case "2":	p.setOrigenFabricacion(OrigenFabricacion.CHINA);
					break;
		case "3":	p.setOrigenFabricacion(OrigenFabricacion.BRASIL);
					break;
		case "4":	p.setOrigenFabricacion(OrigenFabricacion.URUGUAY);
					break;
		default: 	System.out.println("Opcion Incorrecta");
					error=true;
		}
		}while(error);
		do {
			error=false;
		System.out.println("------ Categoría ------");
		System.out.println("1 – Telefonía");
		System.out.println("2 – Informática");
		System.out.println("3 – Electro hogar");
		System.out.println("4 – Herramientas");
		System.out.println("Elija una opción: ");
		op=sc.nextLine();
		switch(op)
		{
		case "1":   p.setCategoria(Categoria.TELEFONIA);
					break;
		case "2":	p.setCategoria(Categoria.INFORMATICA);
					break;
		case "3":	p.setCategoria(Categoria.ELECTROHOGAR);
					break;
		case "4":	p.setCategoria(Categoria.HERRAMIENTAS);
					break;
		default: 	System.out.println("Opcion Incorrecta");
					error=true;
		}
		}while(error);
	}
	
	public static void mostrar(List<Producto> almacen)
	{
		System.out.println("Almacen");
		for(Producto producto: almacen)
		{
			System.out.println("");
			System.out.println("Codigo: "+producto.getCodigo());
			System.out.println("Descripcion: "+producto.getDescripcion());
			System.out.println("Precio: $"+producto.getPrecioUnitario());
			System.out.println("Origen de Fabricacion: "+producto.getOrigenFabricacion());
			System.out.println("Categoria: "+producto.getCategoria());
			System.out.println("");
		}
	}
	
	public static void modificar(List<Producto> almacen)
	{
		int codigo;
		boolean encontrado=false;
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese codigo del producto que quiera modificar: ");
		codigo=sc.nextInt();
		for(Producto producto: almacen)
			if(codigo==producto.getCodigo())
			{
				System.out.print("Ingrese una breve descripcion del Producto: ");
				producto.setDescripcion(sc.nextLine());
				System.out.print("Ingrese precio del Producto: ");
				producto.setPrecioUnitario(sc.nextDouble());
				sc.nextLine();
				submenu(producto);
				encontrado=true;
			}
		if(!encontrado)
			System.out.println("El codigo no pertence a un producto existente");
	}
}
