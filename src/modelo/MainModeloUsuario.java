package modelo;

import java.util.Scanner;

import Vista.Libro_Vista;
import Vista.Usuario_Vista;

public class MainModeloUsuario {
	public static void main(String[] args) {
		
		Usuario_Vista usuariovista = new Usuario_Vista();
		usuariovista.menuDeUsuario();
		
		Libro_Vista librovista = new Libro_Vista();
		librovista.menuDeLibro();
		
			
		
		
		Scanner scan = new Scanner(System.in);

		System.out.println("Inserte un nombre");
		String nombre = scan.nextLine();

		String apellido = "Badiola";

		int edad = 33;

		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setEdad(edad);

		UsuarioModelo usuarioModelo = new UsuarioModelo();
		usuarioModelo.insert(usuario);

	}
	
		
}