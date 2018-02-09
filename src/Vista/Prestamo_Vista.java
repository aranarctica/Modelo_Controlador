package Vista;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Scanner;

import modelo.Libro;
import modelo.LibroModelo;
import modelo.Prestamo;
import modelo.PrestamoModelo;
import modelo.Usuario;
import modelo.UsuarioModelo;

public class Prestamo_Vista {

	static final int TOMAR_PRESTAMO = 1;
	static final int ENTREGAR = 2;
	static final int SALIR = 0;

	public void menuPrestamo() throws SQLException {
		int opcion;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("<------PRESTAMO------>");
			System.out.println(TOMAR_PRESTAMO + "TOMAR PRESTAMO");
			System.out.println(ENTREGAR + "ENTREGAR");
			System.out.println(SALIR + "S");
			opcion = Integer.parseInt(scan.nextLine());

			switch (opcion) {
			case TOMAR_PRESTAMO:
				realizarPrestamo(scan);
				break;
			case ENTREGAR:
				realizarEntrega(scan);

				break;
			default:
				break;
			}
		} while (opcion != SALIR);

	}

	private void realizarPrestamo(Scanner scan) throws SQLException {
		// Liburuaren izena eskatu
		System.out.println("Introduce un Titulo de Libro");
		String titulo = scan.nextLine();
		LibroModelo libroModelo = new LibroModelo();
		Libro libro = libroModelo.selectTitulo(titulo);

		if (libro != null) {// si el libro existe
			// Erabiltzailearen dni eskatu
			System.out.println("Introduce el DNI");
			String dni = scan.nextLine();
			UsuarioModelo usuarioModelo = new UsuarioModelo();
			Usuario usuario = usuarioModelo.selectPorDni(dni);

			// crear el objeto prestamo y rellernarlo
			Prestamo prestamo = new Prestamo();
			int id = Integer.parseInt(scan.nextLine());
			prestamo.setId(id);
			int idLibro = Integer.parseInt(scan.nextLine());
			prestamo.setIdLibro(idLibro);
			int idUsuario = Integer.parseInt(scan.nextLine());
			prestamo.setIdUsuario(idUsuario);
			java.sql.Date dataFecha = new java.sql.Date(prestamo.getFecha_prestamo().getTime());
			java.sql.Date dataLimite = new java.sql.Date(prestamo.getFecha_limite().getTime());

			Date fechaPrestamo = new Date(idUsuario);
			Date fechaLimite = new Date(fechaPrestamo.getTime() + 21 * 24 * 60 * 60 * 1000);
			prestamo.setFecha_prestamo(fechaPrestamo);
			prestamo.setFecha_limite(fechaLimite);

			prestamo.setEntregado(false);

			// crear el objeto modeloprestamo
			PrestamoModelo prestamoModelo = new PrestamoModelo();

			// insertar prestamo utilizando modeloPrestamo
			prestamoModelo.insertar(prestamo);
			System.out.println("Prestamo realizado");

		} else {// si no existe

		}
	}

	private boolean realizarEntrega(Scanner scan) {
		Prestamo prestamo = new Prestamo();
		// pedir dni
		System.out.println("Inserta el DNI");
		String dni = scan.nextLine();
		UsuarioModelo usuarioModelo = new UsuarioModelo();
		try {
			Usuario usuario = usuarioModelo.selectPorDni(dni);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		// pedir el titulo
		System.out.println("Inserta el titulo del libro");
		scan.nextLine();

		// crear el prestamo
		Prestamo prestamorealizado = new Prestamo();
		prestamorealizado.getFecha_prestamo();

		// update
		Prestamo prestamoentrega = new Prestamo();
		prestamoentrega.isEntregado();
		return true;
		
	}

}
