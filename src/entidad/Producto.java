package entidad;

import java.math.BigDecimal;
import java.util.Objects;

public class Producto {

    private String codigo;
    private String nombre;
    private BigDecimal precio;
    private int stock;
    private int idCategoria;

    // Constructor completo
    public Producto(String codigo, String nombre, BigDecimal precio, int stock, int idCategoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.idCategoria = idCategoria;
    }

    // Constructor vacío
    public Producto() {}

    // Getters
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public BigDecimal getPrecio() { return precio; }
    public int getStock() { return stock; }
    public int getIdCategoria() { return idCategoria; }

    // Setters
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public void setNombre(String nombre) { 
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre; 
        } else {
            throw new RuntimeException("El nombre no puede estar vacío");
        }
    }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }
    public void setStock(int stock) { this.stock = stock; }
    public void setIdCategoria(int idCategoria) { this.idCategoria = idCategoria; }

    // equals y hashCode
    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, precio, stock, idCategoria);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Producto other = (Producto) obj;
        return stock == other.stock 
            && idCategoria == other.idCategoria
            && Objects.equals(codigo, other.codigo)
            && Objects.equals(nombre, other.nombre)
            && Objects.equals(precio, other.precio);
    }

    // toString
    @Override
    public String toString() {
        return "Producto [codigo=" + codigo 
            + ", nombre=" + nombre 
            + ", precio=" + precio 
            + ", stock=" + stock 
            + ", idCategoria=" + idCategoria + "]";
    }
}
