package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoProducto {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bdInventario";
	
	public DaoProducto() {}
	
	public void ejecutarProcedimientoAlmacenado(Producto producto) {
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host+dbName, user, pass);
			CallableStatement cst = cn.prepareCall("CALL sp_AgregarProducto(?, ?, ?, ?, ?)");
			cst.setString(1, producto.getCodigo());
			cst.setString(2, producto.getNombre());
			cst.setBigDecimal(3, producto.getPrecio());
			cst.setInt(4, producto.getStock());
			cst.setInt(5, producto.getIdCategoria());
			cst.execute();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

