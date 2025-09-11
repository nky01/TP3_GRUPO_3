package main;

import dao.DaoProducto;
import dao.DaoCategoria;
import entidad.Categoria;
import entidad.Producto;
import java.math.BigDecimal;
import java.util.ArrayList;

public class principal {

	public static void main(String[] args) {
		DaoCategoria dc = new DaoCategoria();
		DaoProducto dp = new DaoProducto();
		
		Categoria [] categorias = new Categoria[] {
				new Categoria("Alimentos"),
				new Categoria("Electrodomesticos"),
				new Categoria("Limpieza"),
				new Categoria("Tecnologia")
		};
		
		
		
//		Producto[] productos = new Producto[] {
//	            new Producto("COD-001", "Producto1", BigDecimal.valueOf(125.002), 2, 3),
//	            new Producto("COD-002", "Producto2", BigDecimal.valueOf(230.50), 15, 2),
//	            new Producto("COD-003", "Producto3", BigDecimal.valueOf(75.99), 20, 3),
//	            new Producto("COD-004", "Producto4", BigDecimal.valueOf(300.00), 5, 1),    
//	            new Producto("COD-005", "Producto5", BigDecimal.valueOf(150.75), 12, 2),
//	            new Producto("COD-006", "Producto6", BigDecimal.valueOf(25.102), 3, 1),
//	            new Producto("COD-007", "Producto7", BigDecimal.valueOf(481.027), 8, 1),
//	            new Producto("COD-008", "Producto8", BigDecimal.valueOf(33.66), 7, 2),
//	            new Producto("COD-009", "Producto9", BigDecimal.valueOf(815.24), 13, 3),
//	            new Producto("COD-010", "Producto10", BigDecimal.valueOf(615.1), 69, 1)
//		};
		
			
//		dp.eliminarProducto("COD-002"); // Eliminar Producto
		
//		Producto pnuevo = new Producto("COD-001","Nuevo P1",BigDecimal.valueOf(220.01), 2, 3); // Modificar producto
//		dp.modificarProducto(pnuevo);
		
//		ArrayList<Producto> lProductos = dp.ListarProductos(); // Listar Productos
//		for(Producto p : lProductos) {
//			System.out.println(p.toString());
//		}
//	
		
		
		
//		for (Categoria c : categorias) {
//			dc.AgregarCategoria(c);
//		}
//		
//		
//		
//		for (Producto p : productos) {
//	            dp.ejecutarProcedimientoAlmacenado(p);
//		}
//		System.out.println("Los productos se cargaron correctamente!");	    // Agregar Productos
		
		ArrayList<Categoria> lcategorias = dc.ListarCategorias();
		for(Categoria c : lcategorias) {
			System.out.println(c.toString());
		}
	}
	
	
}