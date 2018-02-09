package modelo;

import java.sql.SQLException;
import java.util.Scanner;

import Vista.Libro_Vista;
import Vista.Prestamo_Vista;
import Vista.Usuario_Vista;

public class MainModeloUsuario {
	public static void main(String[] args) throws SQLException {
		
		Usuario_Vista usuariovista = new Usuario_Vista();
		usuariovista.menuDeUsuario();
		
		Libro_Vista librovista = new Libro_Vista();
		librovista.menuDeLibro();
		
		Prestamo_Vista prestamovista = new Prestamo_Vista();
		prestamovista.menuPrestamo();
			
		
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