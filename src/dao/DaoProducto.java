package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import entidad.Producto;

public class DaoProducto {

    private String host = "jdbc:mysql://localhost:3306/";
    private String user = "root";
    private String pass = "root";
    private String dbName = "bdInventario";

    public DaoProducto() {}

    // AGREGAR (Procedimiento Almacenado)
    public void ejecutarProcedimientoAlmacenado(Producto producto) {
        String sql = "{CALL sp_AgregarProducto(?, ?, ?, ?, ?)}";
        try (Connection cn = DriverManager.getConnection(host + dbName, user, pass);
             CallableStatement cst = cn.prepareCall(sql)) {

            cst.setString(1, producto.getCodigo());
            cst.setString(2, producto.getNombre());
            cst.setBigDecimal(3, producto.getPrecio());
            cst.setInt(4, producto.getStock());
            cst.setInt(5, producto.getIdCategoria());
            cst.execute();

        } catch (SQLException e) {
            System.out.println("Error al agregar producto: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // BAJA
    public boolean eliminarProducto(String codigo) {
        String sql = "DELETE FROM Productos WHERE Codigo = ?";
        try (Connection cn = DriverManager.getConnection(host + dbName, user, pass);
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, codigo);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar producto: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // MODIFICACIÓN
    public boolean modificarProducto(Producto producto) {
        String sql = "UPDATE Productos SET Nombre = ?, Precio = ?, Stock = ?, IdCategoria = ? WHERE Codigo = ?";
        try (Connection cn = DriverManager.getConnection(host + dbName, user, pass);
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, producto.getNombre());
            ps.setBigDecimal(2, producto.getPrecio());
            ps.setInt(3, producto.getStock());
            ps.setInt(4, producto.getIdCategoria());
            ps.setString(5, producto.getCodigo());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al modificar producto: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
