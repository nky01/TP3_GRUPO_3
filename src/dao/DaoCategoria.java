package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidad.Categoria;

public class DaoCategoria {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bdInventario";
	
	
	public DaoCategoria() {}
	
	
	public int AgregarCategoria (Categoria categoria) {
		int filas = 0;
		String query = "INSERT INTO categorias (Nombre) VALUES (?)";
		try (Connection cn = DriverManager.getConnection(host+dbName, user, pass);
				PreparedStatement st = cn.prepareStatement(query)){
				
					st.setString(1,categoria.getNombre());
					filas = st.executeUpdate();
					
			System.out.println("Categoria agregada correctamente." + " Filas agregadas: " + filas);
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return filas;
	}
	public int EliminarCategoria (int id) {
		int filas = 0;
		String query = "DELETE FROM categorias WHERE idcategoria = ?";
		
		try (Connection cn = DriverManager.getConnection(host+dbName, user, pass);
				PreparedStatement st = cn.prepareStatement(query)){
					
					cn.setAutoCommit(false);				
					st.setInt(1,id);
					filas = st.executeUpdate();
					cn.commit();
			
				System.out.println("Categoria eliminada correctamente." + " Filas agregadas: " + filas);
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return filas;
	}
	
	public Categoria ModificarCategoria (Categoria categoria) {
		
		int filas = 0;
		String query = "UPDATE categorias SET Nombre = ? WHERE idcategoria = ?";
		try (Connection cn = DriverManager.getConnection(host+dbName, user, pass);
				PreparedStatement st = cn.prepareStatement(query)){
					
				
					st.setString(1, categoria.getNombre());
					st.setInt(1, categoria.getIdCategoria());
					filas = st.executeUpdate();
					
					System.out.println("Categoria modificada correctamente." + filas);
					
				}
				
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("No se pudo modificar la categoria.");
		}		
		
		return categoria;
	} 
	
	public ArrayList<Categoria> ListarCategorias() {
		ArrayList<Categoria> lCategoria = new ArrayList<Categoria>();
		String query = "SELECT * FROM categorias";
		
		try(Connection cn = DriverManager.getConnection(host+dbName, user, pass);
				PreparedStatement st = cn.prepareStatement(query)){
					
					ResultSet rs = st.executeQuery();
					while(rs.next()) {
						Categoria c = new Categoria();
						c.setNombre(rs.getString("Nombre"));
						c.setIdCategoria(rs.getInt("IdCategoria"));
						lCategoria.add(c);
					}	
			
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se pudo listar la categoria");
		}
		
		return lCategoria;
	}
	

}
