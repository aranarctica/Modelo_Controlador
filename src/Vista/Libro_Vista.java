package Vista;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import modelo.Libro;
import modelo.LibroModelo;

/**
 * creamos la clase librovista para crear el menu que saldra en pantalla
 * 
 * @author ik012982i9
 *
 */

public class Libro_Vista {
	static final int LISTAR_LIBRO = 1;
	static final int INSERTAR_LIBRO = 2;
	final int UPDATE_LIBRO = 3;
	final int DELETE_LIBRO = 4;
	final int SALIR = 0;

	/**
	 * creamos el menu
	 */
	public void menuDeLibro() {
		Scanner scan = new Scanner(System.in);

		int opcion;
		do {
			System.out.println("<------MENU LIBRO------>");
			System.out.println(LISTAR_LIBRO + "<----LISTAR LIBRO---->");
			System.out.println(INSERTAR_LIBRO + "<----INSERTAR LIBRO---->");
			System.out.println(UPDATE_LIBRO + "<------ACTUALIZAR LIBRO------>");
			System.out.println(DELETE_LIBRO + "<------BORRAR LIBRO------>");
			System.out.println(SALIR + "<------SALIR------>");

			opcion = Integer.parseInt(scan.nextLine());

			switch (opcion) {
			/**
			 * creamos la opcion de listar el libro
			 */
			case LISTAR_LIBRO:
				LibroModelo LibroModelo = new LibroModelo();
				ArrayList<Libro> libros = LibroModelo.selectAll();
				this.mostrarLibros(libros);

				break;
			/**
			 * creamos la opcion de insertar libro
			 */
			case INSERTAR_LIBRO:
				LibroModelo LibroModelo1 = new LibroModelo();
				Libro libro = new Libro();
				insertarDatos(libro);
				LibroModelo1.insert(libro);
				break;
			/**
			 * creamos la opcion de actualizar los datos del libro
			 */
			/*
			 * case UPDATE_LIBRO: Libro_Modelo LibroModelo2 = new
			 * Libro_Modelo(); actualizarDatos(libro);
			 * LibroModelo2.update(libro);
			 * 
			 * break; /** creamos la opcion de borrar un registro
			 * 
			 * case DELETE_LIBRO:
			 * 
			 * 
			 * break;
			 */

			default:
				break;
			}
		} while (opcion != SALIR);
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
		System.out.println("Introduce el titulo del libro: ");
		libro.setTitulo(scan.nextLine());
		System.out.println("Introduce el autor: ");
		libro.setAutor(scan.nextLine());

	}

	/**
	 * Pedimos la ID del libro que se quiere actualizar y se piden los datos
	 * nuevos
	 * 
	 * @param libro
	 * 
	 *            /* private void actualizarDatos(Libro libro1) { Scanner scan =
	 *            new Scanner(System.in); System.out.println("Introduce el ID
	 *            del libro que se quiere actualizar: "); int id =
	 *            Integer.parseInt(scan.nextLine());
	 *            System.out.println("Introcude la ID del libro: ");
	 *            libro.setId(scan.nextInt()); System.out.println("Introduce el
	 *            titulo del libro:"); libro.setTitulo(scan.nextLine());
	 *            System.out.println("Introduce el autor del libro");
	 *            libro.setAutor(scan.nextLine());
	 * 
	 *            }
	 */
}
