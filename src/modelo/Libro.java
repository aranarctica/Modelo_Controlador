package modelo;

/**
 * Creamos la clase libro y sus atributos
 * @author ik012982i9
 *
 */
public class Libro {
	
	private String titulo;
	private int id;
	private String autor;
	
	
	/**
	 *  generamos los getters y setters de la clase libro
	 * @return
	 */
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	

}
