package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuarioModelo extends Conector {

	public ArrayList<Usuario> selectAll() {

		// crear arraylist
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from usuarios");
			while (rs.next());
			Usuario usuario = new Usuario();
			usuario.setId(rs.getInt("id"));
			usuario.setNombre(rs.getString("nombre"));
			usuario.setApellido(rs.getString("apellido"));
			usuario.setEdad(rs.getInt("edad"));
			usuarios.add(usuario);
			
			
			return usuarios;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return usuarios;
	}

	public void delete(int id) {
		// delete from usuarios where id = ?
		try {
			PreparedStatement pst = super.conexion.prepareStatement("DELETE FROM usuarios WHERE id= " + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Usuario usuario) {
		// update usuarios set nombre='adas', apellido= 'adsaad', edad = ??
		// where id = ?

		try {
			PreparedStatement pst = super.conexion.prepareStatement("UPDATE usuarios SET nombre= '?', apellido ='?', edad=? WHERE id=");
			pst.setString(1, usuario.getNombre());
			pst.setString(2, usuario.getApellido());
			pst.setInt(3, usuario.getEdad());
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert(Usuario usuario) {

		try {
			PreparedStatement pst = super.conexion.prepareStatement("INSERT INTO usuarios(nombre, apellido, edad) values(?,?,?)");
			pst.setString(1, usuario.getNombre());
			pst.setString(2, usuario.getApellido());
			pst.setInt(3, usuario.getEdad());
			pst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Usuario> selectPorNombre(String nombre) {
		// crear arraylist
				ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

				try {
					Statement st = super.conexion.createStatement();
					ResultSet rs = st.executeQuery("select * from usuarios where nombre = '" + nombre + "' '");
					while (rs.next())
						;
					Usuario usuario = new Usuario();
					usuario.setId(rs.getInt("id"));
					usuario.setNombre(rs.getString("nombre"));
					usuario.setApellido(rs.getString("apellido"));
					usuario.setEdad(rs.getInt("edad"));
					usuarios.add(usuario);
					return usuarios;
				} catch (SQLException e) {

					e.printStackTrace();
				}

				return usuarios;

	}

	public ArrayList<Usuario> selectMenorDeEdad() {
		// crear arraylist
				ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

				try {
					Statement st = super.conexion.createStatement();
					ResultSet rs = st.executeQuery("select * from usuarios where menos de edad < 18");
					while (rs.next())
						;
					Usuario usuario = new Usuario();
					usuario.setId(rs.getInt("id"));
					usuario.setNombre(rs.getString("nombre"));
					usuario.setApellido(rs.getString("apellido"));
					usuario.setEdad(rs.getInt("edad"));
					usuarios.add(usuario);
					return usuarios;
				} catch (SQLException e) {

					e.printStackTrace();
				}

				return usuarios;

	}

	public ArrayList<Usuario> selectConttieneapellido(String cadena) {
		//select * from usuarios where apellido like '%za%'
		// crear arraylist
				ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

				try {
					Statement st = super.conexion.createStatement();
					ResultSet rs = st.executeQuery("select * from usuarios where apellido like  '%' "+ cadena + " '%'");
					while (rs.next())
						;
					Usuario usuario = new Usuario();
					usuario.setId(rs.getInt("id"));
					usuario.setNombre(rs.getString("nombre"));
					usuario.setApellido(rs.getString("apellido"));
					usuario.setEdad(rs.getInt("edad"));
					usuarios.add(usuario);
					return usuarios;
				} catch (SQLException e) {

					e.printStackTrace();
				}

				return usuarios;
		

	}
}
