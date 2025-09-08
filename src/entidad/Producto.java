package entidad;

import java.math.BigDecimal;

public class Producto {
	
	private String codigo;
	private String nombre;
	private BigDecimal precio;
	private int stock;
	private int idCategoria;
	
	public Producto(String codigo, String nombre, BigDecimal precio, int stock, int idCategoria)
	{
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.idCategoria = idCategoria;
	}

	public String getCodigo() {return this.codigo;}
	public String getNombre() {return this.nombre;}
	public BigDecimal getPrecio() {return this.precio;}
	public int getStock() {return this.stock;}
	public int getIdCategoria( ) {return this.idCategoria;}
}