package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio1.model.Categoria;
import ar.edu.unju.fi.ejercicio1.model.OrigenFabricacion;
import ar.edu.unju.fi.ejercicio1.model.Producto;

public class Main {

	public static void main(String[] args) {
		List<Producto> stock= new ArrayList<Producto>();
		Producto prod= new Producto(1,"Monitor",4256,OrigenFabricacion.ARGENTINA,Categoria.INFORMATICA,true);
		stock.add(prod);
		prod= new Producto(2,"Gabinete",7529,OrigenFabricacion.CHINA,Categoria.INFORMATICA,false);
		stock.add(prod);
		prod= new Producto(3,"Motherboard",2405,OrigenFabricacion.BRASIL,Categoria.INFORMATICA,true);
		stock.add(prod);
		prod= new Producto(4,"Mouse",8154,OrigenFabricacion.URUGUAY,Categoria.INFORMATICA,false);
		stock.add(prod);
		prod= new Producto(5,"HELADERA",6236,OrigenFabricacion.ARGENTINA,Categoria.ELECTROHOGAR,true);
		stock.add(prod);
		prod= new Producto(6,"Cocina",9491,OrigenFabricacion.CHINA,Categoria.ELECTROHOGAR,false);
		stock.add(prod);
		prod= new Producto(7,"Aire Acondicionado",5628,OrigenFabricacion.BRASIL,Categoria.ELECTROHOGAR,true);
		stock.add(prod);
		prod= new Producto(8,"Lavarropas",8561,OrigenFabricacion.URUGUAY,Categoria.ELECTROHOGAR,false);
		stock.add(prod);
		prod= new Producto(9,"MARTILLO",2471,OrigenFabricacion.ARGENTINA,Categoria.HERRAMIENTAS,true);
		stock.add(prod);
		prod= new Producto(10,"Tenaza",3019,OrigenFabricacion.CHINA,Categoria.HERRAMIENTAS,false);
		stock.add(prod);
		prod= new Producto(11,"Llave Inglesa",1655,OrigenFabricacion.BRASIL,Categoria.HERRAMIENTAS,true);
		stock.add(prod);
		prod= new Producto(12,"Claro",4160,OrigenFabricacion.URUGUAY,Categoria.TELEFONIA,false);
		stock.add(prod);
		prod= new Producto(13,"PERSONAL",3848,OrigenFabricacion.ARGENTINA,Categoria.TELEFONIA,true);
		stock.add(prod);
		prod= new Producto(14,"Movistar",374,OrigenFabricacion.CHINA,Categoria.TELEFONIA,false);
		stock.add(prod);
		prod= new Producto(15,"Tuenti",6433,OrigenFabricacion.BRASIL,Categoria.TELEFONIA,true);
		stock.add(prod);
		Scanner sc = new Scanner(System.in);
		String op;
		while(true) {
				System.out.println("MENU");
				System.out.println("1 – Mostrar productos (solo se muestran los productos con estado true)");
				System.out.println("2 – Mostrar los productos faltantes (muestra productos con estado false)");
				System.out.println("3 – Incrementar los precios de los productos en un 20%");
				System.out.println("4 – Mostrar los productos que corresponden a la categoría Electrohogar y "
						+ "estén disponibles para la venta");
				System.out.println("5 – Ordenar los productos por precio de forma descendente");
				System.out.println("6 - Mostrar los productos con los nombres en mayúsculas");
				System.out.print("Ingrese opcion: ");
				op=sc.nextLine();
				switch(op) {
				case "1":	mostrarstock(stock);
							break;
				case "2":	mostrarNOstock(stock);
							break;
				case "3":	incrementar(stock);
							break;
				case "4":	mostrarEHdisponible(stock);
							break;
				case "5":	stock.sort(Comparator.comparing(Producto::getPrecioUnitario).reversed());
							break;
				case "6":	mostrarMayus(stock);
							break;
				default: System.out.println("Opcion Incorrecta");
				}
		}
	}
	
	static void mostrarstock(List<Producto>stock)
	{
		Consumer<Producto> mostrar = p ->{
			if(p.isEstado())
				System.out.println(p);
		};
		stock.forEach(mostrar);
	}
	
	static void mostrarNOstock(List<Producto>stock)
	{
		Predicate<Producto> filtro = p -> !p.isEstado();
		stock.stream().filter(filtro).forEach(System.out::println);
	}
	
	static void incrementar(List<Producto>stock)
	{
		Function<Producto,Producto> incremento = (p)->{
												p.setPrecioUnitario(p.getPrecioUnitario()*1.2);
												return p;
												};
		List<Producto> productosIncrementados= new ArrayList<Producto>();
		productosIncrementados=stock.stream().map(incremento).collect(Collectors.toList());
		productosIncrementados.forEach(System.out::println);
	}
	
	static void mostrarEHdisponible(List<Producto>stock)
	{
		Predicate<Producto> filtro = p -> p.getCategoria()==Categoria.ELECTROHOGAR&&p.isEstado();
		stock.stream().filter(filtro).forEach(System.out::println);
	}
	
	static void mostrarMayus(List<Producto>stock)
	{
		Function<Producto,Producto> incremento = (p)->{
			p.setDescripcion(p.getDescripcion().toUpperCase());;
			return p;
			};
			stock.stream().map(incremento).collect(Collectors.toList());
			stock.forEach(System.out::println);
	}
}
