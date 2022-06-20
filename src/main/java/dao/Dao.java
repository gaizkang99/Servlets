package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Consulta;
import utils.Constantes;

public class Dao {
	
	private Connection conexion;
	
	public void conectar() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = Constantes.Connection;
			String usuario = Constantes.Name;
			String contrasena = Constantes.Password;
			//Conexion
			conexion = DriverManager.getConnection(url, usuario, contrasena);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void desconectar() throws SQLException {
		if(conexion != null) {
				conexion.close();
		}
	}
	
	public void insertarConsulta(String name) throws SQLException{
		try(PreparedStatement ps = conexion.prepareStatement(Constantes.Insertar_Consulta)){
			ps.setString(1, name);
			ps.setBoolean(2, false);
			ps.executeUpdate();
		}
	}
	
	
	public String compruebaNombre(String name) throws SQLException{
		String nombreConsulta = null;
		try (PreparedStatement ps = conexion.prepareStatement(Constantes.Consultar_Nombre)) {
			ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
            	if(rs.next()) {
            		nombreConsulta = rs.getString("nombre");
				}		
            }
        }
		return nombreConsulta;
	}
	
	public void actualizarEstado(String name) throws SQLException{
		try(PreparedStatement ps = conexion.prepareStatement(Constantes.Actualizar_Estado)){
			ps.setString(1, name);
			ps.executeUpdate();
		}
	}
	
	public ArrayList<Consulta> usuariosMarcados() throws SQLException{
		ArrayList<Consulta> consultados = new ArrayList<Consulta>();
		try(Statement st = conexion.createStatement()){
			try(ResultSet rs = st.executeQuery(Constantes.Listar_Marcados)){
				while(rs.next()) {
					Consulta consulta = new Consulta(rs.getInt(1), rs.getString(2), rs.getBoolean(3));
            		consultados.add(consulta);
				}
			}
		}
		return consultados;
	}
	
	public void actualizarMarcado(String name) throws SQLException{
		try(PreparedStatement ps = conexion.prepareStatement(Constantes.Actualizar_Marcado_ID)){
			ps.setString(1, name);
			ps.executeUpdate();
		}
	}
	
	public void borrarDeLista(String name) throws SQLException{
		try(PreparedStatement ps = conexion.prepareStatement(Constantes.Borrar_De_Cola)){
			ps.setString(1, name);
			ps.executeUpdate();
		}
	}

}
