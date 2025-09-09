package main;

import dao.DaoProducto;
import entidad.Producto;
import java.math.BigDecimal;

public class principal {

	public static void main(String[] args) {
		
		DaoProducto dp = new DaoProducto();
		Producto[] productos = new Producto[] {
	            new Producto("COD-001", "Producto1", BigDecimal.valueOf(125.002), 2, 3),
	            new Producto("COD-002", "Producto2", BigDecimal.valueOf(230.50), 15, 2),
	            new Producto("COD-003", "Producto3", BigDecimal.valueOf(75.99), 20, 3),
	            new Producto("COD-004", "Producto4", BigDecimal.valueOf(300.00), 5, 1),
	            new Producto("COD-005", "Producto5", BigDecimal.valueOf(150.75), 12, 2)
		};
		for (Producto p : productos) {
	            dp.ejecutarProcedimientoAlmacenado(p);
		}
		System.out.println("Los productos se cargaron correctamente!");	
	}
}