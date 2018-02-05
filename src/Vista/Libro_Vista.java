package Vista;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import modelo.Libro;
import modelo.Libro_Modelo;

/**
 * creamos la clase librovista para crear el menu que saldra en pantalla
 * 
 * @author ik012982i9
 *
 */
public class Libro_Vista {

	/**
	 * creamos el menu
	 */
	public void menuDeLibro() {
		Scanner scan = new Scanner(System.in);

		final int LISTAR_LIBRO = 1;
		final int INSERTAR_LIBRO = 2;
		final int SALIR = 0;

		int opcion;

		System.out.println("<------MENU------>");
		System.out.println("<----LISTAR LIBRO---->");
		System.out.println("<----INSERTAR LIBRO---->");
		System.out.println("<------SALIR------>");

		opcion = Integer.parseInt(scan.nextLine());

		switch (opcion) {
		/**
		 * creamos la opcion de listar el libro
		 */
		case LISTAR_LIBRO:
			Libro_Modelo LibroModelo = new Libro_Modelo();
			ArrayList<Libro> libros = LibroModelo.selectAll();
			this.mostrarLibros(libros);

			break;
		/**
		 * creamos la opcion de insertar libro
		 */
		case INSERTAR_LIBRO:
			Libro_Modelo LibroModelo1 = new Libro_Modelo();
			Libro libro = new Libro();
			insertarDatos(libro);
			LibroModelo1.insert(libro);
			break;
		/**
		 * creamos la opcion de salir del programa
		 */
		case SALIR:
			System.out.println("<------SALIENDO------>");
			break;
		default:
			System.out.println("La opcion elegida es incorrecta");
		}

	}

	/**
	 * recorremos el array de libro y lo mostramos
	 * 
	 * @param libros
	 */
	private void mostrarLibros(ArrayList<Libro> libros) {
		Iterator<Libro> i = libros.iterator();
		while (i.hasNext())
			;
		Libro libro = i.next();
		this.mostrarLibros(libros);

	}

	/**
	 * le introducimos los valores al aray del libro
	 * 
	 * @param libro
	 */
	private void mostrarLibros(Libro libro) {
		System.out.println(libro);
		libro.getAutor();
		libro.getTitulo();
		libro.getId();
	}

	/**
	 * Pedimos y le introducimos los valores a libro
	 * 
	 * @param libro
	 */

	private void insertarDatos(Libro libros) {
		Scanner scan = new Scanner(System.in);
		Libro libro = new Libro();
		System.out.println("Introduce la ID del libro: ");
		int id = Integer.parseInt(scan.nextLine());
		libro.setId(id);
		System.out.println("Introduce el titulo del libro: ");
		libro.setTitulo(scan.nextLine());
		System.out.println("Introduce el autor: ");
		libro.setAutor(scan.nextLine());

	}

}
