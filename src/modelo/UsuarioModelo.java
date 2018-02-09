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
			usuario.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
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
			PreparedStatement pst = super.conexion.prepareStatement("delete from usuarios where id= " + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Usuario usuario) {
		// update usuarios set nombre='adas', apellido= 'adsaad', edad = ??
		// where id = ?

		try {
			PreparedStatement pst = super.conexion
					.prepareStatement("update usuarios set nombre= '?', apellido ='?', edad=? where id=");
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
			PreparedStatement pst = super.conexion
					.prepareStatement("insert into usuarios(nombre, apellido, edad) values(?,?,?)");
			pst.setString(1, usuario.getNombre());
			pst.setString(2, usuario.getApellido());
			pst.setInt(3, usuario.getEdad());
			pst.setString(4, usuario.getDni());
			pst.setDate(5, usuario.getFecha_nacimiento());
			java.sql.Date sqlData = new java.sql.Date(usuario.getFecha_nacimiento().getTime());

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

	public ArrayList<Usuario> selectContieneapellido(String cadena) {
		// select * from usuarios where apellido like '%za%'
		// crear arraylist
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from usuarios where apellido like  '%' " + cadena + " '%'");
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

	public Usuario selectPorDni(String dni) throws SQLException {
		PreparedStatement pst = super.conexion.prepareStatement("select * from usuarios where dni = ?");
		pst.setString(1, dni);
		ResultSet rs = pst.executeQuery();

		if (rs.next()) {
			Usuario usuario = new Usuario();
			usuario.setId(rs.getInt("id"));
			usuario.setNombre(rs.getString("nombre"));
			usuario.setApellido(rs.getString("apellido"));
			usuario.setEdad(rs.getInt("edad"));
			usuario.setDni(rs.getString("dni"));
			usuario.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
		}
		return null;

	}
}
