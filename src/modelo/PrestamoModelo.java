package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * creamos la
 * 
 * @author ik012982i9
 *
 */
public class PrestamoModelo extends Conector {

	public void insertar(Prestamo prestamo) {
		try {
			PreparedStatement pst = super.conexion
					.prepareStatement("idLibro, idUsuario,fecha_prestamo, fecha_limite, entregado)values(?,?,?,?,?)");

			pst.setInt(1, prestamo.getIdLibro());
			pst.setInt(2, prestamo.getIdUsuario());
			pst.setDate(3, new java.sql.Date(prestamo.getFecha_prestamo().getTime()));
			pst.setDate(4, new java.sql.Date(prestamo.getFecha_limite().getTime()));
			pst.setBoolean(5, prestamo.isEntregado());
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Prestamo> selectAll() {
		Statement st;
		Prestamo prestamo;
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		try {

			st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from prestamo");
			while (rs.next()) {
				prestamo = new Prestamo();
				prestamo.setId(rs.getInt("id"));
				prestamo.setIdLibro(rs.getInt("id_libro"));
				prestamo.setIdUsuario(rs.getInt("id_usuario"));
				prestamo.setFecha_prestamo(rs.getDate("fecha_prestamo"));
				prestamo.setFecha_limite(rs.getDate("fecha_limite"));
				prestamo.setEntregado(rs.getBoolean("entregado"));
				prestamos.add(prestamo);
				return prestamos;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prestamos;
	}

	public Prestamo getPrestamoNoEntregado(int id_libro, int id_uduario) {
		
		return null;

	}

	public Prestamo getPrestamoEntregado(Libro libro, Usuario usuario) {
		
		return null;

	}

}