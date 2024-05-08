package ar.edu.unju.fi.ejercicio5.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Categoria;
import ar.edu.unju.fi.ejercicio1.model.OrigenFabricacion;
import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio5.interfaces.Pago;
import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;

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
		prod= new Producto(5,"Heladera",6236,OrigenFabricacion.ARGENTINA,Categoria.ELECTROHOGAR,true);
		stock.add(prod);
		prod= new Producto(6,"Cocina",9491,OrigenFabricacion.CHINA,Categoria.ELECTROHOGAR,false);
		stock.add(prod);
		prod= new Producto(7,"Aire Acondicionado",5628,OrigenFabricacion.BRASIL,Categoria.ELECTROHOGAR,true);
		stock.add(prod);
		prod= new Producto(8,"Lavarropas",8561,OrigenFabricacion.URUGUAY,Categoria.ELECTROHOGAR,false);
		stock.add(prod);
		prod= new Producto(9,"Martillo",2471,OrigenFabricacion.ARGENTINA,Categoria.HERRAMIENTAS,true);
		stock.add(prod);
		prod= new Producto(10,"Tenaza",3019,OrigenFabricacion.CHINA,Categoria.HERRAMIENTAS,false);
		stock.add(prod);
		prod= new Producto(11,"Llave Inglesa",1655,OrigenFabricacion.BRASIL,Categoria.HERRAMIENTAS,true);
		stock.add(prod);
		prod= new Producto(12,"Claro",4160,OrigenFabricacion.URUGUAY,Categoria.TELEFONIA,false);
		stock.add(prod);
		prod= new Producto(13,"Personal",3848,OrigenFabricacion.ARGENTINA,Categoria.TELEFONIA,true);
		stock.add(prod);
		prod= new Producto(14,"Movistar",374,OrigenFabricacion.CHINA,Categoria.TELEFONIA,false);
		stock.add(prod);
		prod= new Producto(15,"Tuenti",6433,OrigenFabricacion.BRASIL,Categoria.TELEFONIA,true);
		stock.add(prod);
		Scanner sc = new Scanner(System.in);
		String op;
		do {
			System.out.println("MENU");
			System.out.println("1-Mostrar Productos");
			System.out.println("2-Realizar Compra");
			System.out.println("3-Salir");
			System.out.print("Ingrese opcion: ");
			op=sc.nextLine();
			switch(op) {
			case "1": 	mostrar(stock);
						System.out.println("Presione para continuar");
						sc.nextLine();
						break;
			case "2":	comprar(stock);
						break;
			default: System.out.println("Opcion Incorrecta");
			}
		}while(!op.equals("3"));
	}
	
	static void mostrar(List<Producto> stock)
	{
		for(Producto p: stock)
		{
			System.out.println();
			System.out.println("Descripcion: "+p.getDescripcion());
			System.out.println("Precio: "+p.getPrecioUnitario());
			if(p.isEstado())
				System.out.println("Está en stock");
			else
				System.out.println("No está en stock");
		}
	}
	
	static void comprar(List<Producto> stock)
	{
		boolean encontrado = false;
		List<Producto> carrito= new ArrayList<Producto>();
		Scanner sc = new Scanner(System.in);
		do {
		System.out.print("Ingrese producto a comprar:");
		String compra = sc.nextLine();
		for(Producto p: stock)
		{
			if(compra.equals(p.getDescripcion())) {
				if(p.isEstado()) {
					carrito.add(p);
					System.out.println(p.getDescripcion()+" ha sido añadido al carrito");
				}
				else
					System.out.println(p.getDescripcion()+" no está en stock");
				encontrado=true;
			}
		}
		if(!encontrado)
			System.out.println("Producto no existe");
		System.out.print("Escriba S o s para seguir comprando: ");
		}while(sc.nextLine().equalsIgnoreCase("S"));
		double total=0;
		for(Producto p: carrito)
			total+=p.getPrecioUnitario();
		
		
		String op;
		System.out.println("Metodo de pago");
		System.out.println("1- Pago efectivo");
		System.out.println("2- Pago con tarjeta");
		System.out.print("Ingrese opcion: ");
		op=sc.nextLine();
		switch(op) {
		case "1": 	Pago pago = new PagoEfectivo();
					pago.realizarPago(total);
					pago.imprimirRecibo();
					break;
		case "2":	Pago pagoT = new PagoTarjeta();
					pagoT.realizarPago(total);
					pagoT.imprimirRecibo();
					break;
		default: System.out.println("Opcion Incorrecta");
		}
	}

}
