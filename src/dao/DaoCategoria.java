package dao;

import java.io.Console;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import entidad.Categoria;

public class DaoCategoria {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bdInventario";
	
	
	public DaoCategoria() {}
	
	
	public int AgregarCategoria (Categoria categoria) {
		int filas = 0;
		String query = "INSERT INTO categoria (Nombre) VALUES (?)";
		try (Connection cn = DriverManager.getConnection(host+dbName, user, pass);
				PreparedStatement st = cn.prepareStatement(query)){
				
					st.setString(1,categoria.GetNombre());
					filas = st.executeUpdate();
					
			System.out.println("Categoria agregada correctamente." +"Filas agregadas: " + filas);
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return filas;
	}
	
//	public Categoria ModificarCategoria (Categoria categoria) {
//		
//		String query = "UPDATE categoria (Nombre) VALUES (?)";
//		try (Connection cn = DriverManager.getConnection(host+dbName, user, pass);
//		
//		
//	} 
	

}
