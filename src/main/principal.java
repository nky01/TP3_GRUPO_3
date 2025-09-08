package main;

import dao.DaoProducto;
import entidad.Producto;
import java.math.BigDecimal;

public class principal {

	public static void main(String[] args) {
		
		DaoProducto dp = new DaoProducto();
		Producto pr = new Producto("COD-001", "Producto1", BigDecimal.valueOf(125.002), 2, 3);
		dp.ejecutarProcedimientoAlmacenado(pr);
		
	}

}
