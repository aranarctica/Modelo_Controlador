package Vista;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import modelo.Usuario;
import modelo.UsuarioModelo;

/**
 * creamos la clase usuario vista para ver el menu que saldra en la pantalla
 * 
 * @author ik012982i9
 *
 */
public class Usuario_Vista {

	/**
	 * creamos el menu
	 */
	public void menuDeUsuario() {

		final int LISTAR = 1;
		final int INSERTAR = 2;

		final int SALIR = 0;

		Scanner scan = new Scanner(System.in);

		int opcion;

		System.out.println("------MENU------");
		System.out.println(LISTAR + " Listar");
		System.out.println(INSERTAR + " Insertar");
		System.out.println(SALIR + " Salir");

		opcion = Integer.parseInt(scan.nextLine());

		switch (opcion) {
		/**
		 * creamos la opcion de listar
		 */
		case LISTAR:
			UsuarioModelo usuarioModelo = new UsuarioModelo();
			ArrayList<Usuario> usuarios = usuarioModelo.selectAll();
			this.mostrarUsuarios(usuarios);

			break;
		/**
		 * creamos la opcion de insertar
		 */
		case INSERTAR:
			UsuarioModelo usuarioModelo1 = new UsuarioModelo();
			Usuario usuario = new Usuario();
			insertarDatos(usuario);
			usuarioModelo1.insert(usuario);
			break;

		/**
		 * creamos la opcion de salir
		 */
		case SALIR:
			System.out.println("------SALIENDO------");
			break;
		default:
			System.out.println("La opcion elegida es incorrecta");

		}
	}

	/**
	 * recorremos el array y mostrar los usuarios
	 * 
	 * @param usuarios
	 */
	private void mostrarUsuarios(ArrayList<Usuario> usuarios) {
		Iterator<Usuario> i = usuarios.iterator();
		while (i.hasNext()) {
			Usuario usuario = i.next();
			this.mostrarUsuarios(usuario);
		}
	}

	/**
	 * Le introducimos los valores a usuario
	 * 
	 * @param usuario
	 */

	private void mostrarUsuarios(Usuario usuario) {
		System.out.println(usuario);
		usuario.getApellido();
		usuario.getNombre();
		usuario.getEdad();
		usuario.getId();

	}

	/**
	 * Pedimos e introducimos los valores al usuario
	 * 
	 * @param usuarios
	 */
	private void insertarDatos(Usuario usuarios) {

		Scanner scan = new Scanner(System.in);
		Usuario usuario = new Usuario();
		System.out.println("Introduce el id:");
		int id = Integer.parseInt(scan.nextLine());
		usuario.setId(id);
		System.out.println("Introduce el nombre:");

		usuario.setNombre(scan.nextLine());
		System.out.println("Introduce el apellido:");
		usuario.setApellido(scan.nextLine());
		System.out.println("Introduce la edad");
		int edad = Integer.parseInt(scan.nextLine());
		usuario.getEdad();
		System.out.println("Introduce el dni");
		usuario.setDni(scan.nextLine());
		System.out.println("Introduce la fecha de nacimiento");
		scan.nextLine();
		usuario.getFecha_nacimiento();

	}

}