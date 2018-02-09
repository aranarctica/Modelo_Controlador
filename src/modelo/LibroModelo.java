package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Creamos la clase Libro_modelo
 * 
 * @author ik012982i9
 *
 */
public class LibroModelo extends Conector {

	// select all
	public ArrayList<Libro> selectAll() {
		/**
		 * creamos el arraylist para meter los atributos del libro en el
		 */
		ArrayList<Libro> libros = new ArrayList<Libro>();
		/**
		 * creamos la conexion con el conector y ejecutamos el query lo
		 * recorremos y le añadimos al array los valores
		 */
		try {
			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from libros");
			while (rs.next()) {

				Libro libro = new Libro();

				libro.setId(rs.getInt("id"));
				libro.setAutor(rs.getString("autor"));
				libro.setTitulo(rs.getString("titulo"));
				libros.add(libro);
			}
			return libros;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return libros;

	}

	// select int id
	public ArrayList<Libro> selectId(int id) {
		/**
		 * creamos el arraylist para meter los atributos del libro en el
		 */
		ArrayList<Libro> libros = new ArrayList<Libro>();
		/**
		 * creamos la conexion con el conector y ejecutamos el query lo
		 * recorremos y le añadimos al array los valores
		 */
		try {
			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from libros where id = '" + id + "' '");
			while (rs.next())
				;

			Libro libro = new Libro();

			libro.setId(rs.getInt("id"));
			libro.setAutor(rs.getString("autor"));
			libro.setTitulo(rs.getString("titulo"));
			libros.add(libro);

			return libros;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return libros;

	}

	// select string titulo
	public Libro selectTitulo(String titulo) {
		/**
		 * creamos el arraylist para meter los atributos del libro en el
		 */
		ArrayList<Libro> libros = new ArrayList<Libro>();
		/**
		 * creamos la conexion con el conector y ejecutamos el query lo
		 * recorremos y le añadimos al array los valores
		 */
		Statement st;
		try {
			st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from libros where titulo = '" + titulo + "' '");
			while (rs.next())
				;
			if (rs.next())
				;
			Libro libro = new Libro();

			libro.setId(rs.getInt("id"));
			libro.setAutor(rs.getString("autor"));
			libro.setTitulo(rs.getString("titulo"));
			libros.add(libro);

			return libro;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	// update libro libro
	public void update(Libro libro) {
		/**
		 * creamos la conexion con el conector y le introducimos los valores para actualizar
		 */
		try {
			PreparedStatement pst = super.conexion.prepareStatement("update libros set autor= '?', titulo= '?', id='");
			pst.setString(1, libro.getAutor());
			pst.setString(2, libro.getTitulo());
			pst.setInt(3, libro.getId());
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// delete int id
	public void delete(int id) {
		/**
		 * creamos la conexion con el conector y le introducimos el id para
		 * borrar
		 */
		try {
			PreparedStatement pst = super.conexion.prepareStatement("delete from libros where id= " + id);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// insert (libro, libro)
	public void insert(Libro libro) {
		/**
		 * creamos la conexion co el conector y le introducimos los datos para
		 * añadir
		 */

		try {
			PreparedStatement pst = super.conexion.prepareStatement("insert into libros(autor, titulo) values(?,?)");
			pst.setString(1, libro.getAutor());
			pst.setString(2, libro.getTitulo());

			pst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}