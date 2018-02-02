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
		System.out.println(LISTAR + "Listar");
		System.out.println(INSERTAR + "Insertar");
		System.out.println(SALIR + "Salir");

		opcion = Integer.parseInt(scan.nextLine());

		switch (opcion) {
		/**
		 * creamos la opcion de listar
		 */
		case LISTAR:
			UsuarioModelo usuarioModelo = new UsuarioModelo();
			ArrayList<Usuario> usuarios = usuarioModelo.selectAll();
			mostrarUsuarios(usuarios);

			break;
		/**
		 * creamos la opcion de insertar
		 */
		case INSERTAR:
			

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
	 * @param usuarios
	 */
	private void mostrarUsuarios(ArrayList<Usuario> usuarios) {
		Iterator<Usuario> i = usuarios.iterator();
		while (i.hasNext()) {
			Usuario usuario = i.next();
			this.mostrarUsuarios(usuario);
		}
	}


	private void mostrarUsuarios(Usuario usuario) {
	}
}