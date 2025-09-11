package entidad;

import java.util.Objects;


public class Categoria 
{
	private int idCategoria;
	private String Nombre;
	
	
	public Categoria(int idcategoria, String nombre) 
	{
		this.idCategoria = idcategoria;
		this.Nombre = nombre;
		
	}
	public Categoria () {}
	
	public int getIdCategoria() { return idCategoria; }
	public String getNombre() { return Nombre; }
	
	public void setIdCategoria(int idCategoria) { this.idCategoria = idCategoria; }
	public void setNombre (String nombre) {  if (nombre != null) {Nombre = nombre;} else {throw new RuntimeException ("El nombre no puede estar vacío"); } }
	
	
	@Override
	public int hashCode() {
		return Objects.hash(Nombre, idCategoria);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(Nombre, other.Nombre) && idCategoria == other.idCategoria;
	}
	
	@Override
	public String toString() {
		return "Categoria [idCategoria=" + idCategoria + ", Nombre=" + Nombre + "]";
	}
	
}