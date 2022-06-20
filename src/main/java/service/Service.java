package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.Dao;
import model.Consulta;

public class Service {
	
	private Dao dao;
	private ArrayList<Consulta> consultas;
	
	public Service() {
		this.dao = new Dao();
	}
	
	public void insertarConsulta(String name, String marcado) throws SQLException {
		dao.conectar();
		String nombre = dao.compruebaNombre(name);
		boolean marca = marcado ==null ? false : true;
		if(nombre==null) {
			dao.insertarConsulta(name.toUpperCase());
		}else if (marca == true){
			dao.borrarDeLista(nombre);
		}
		
		dao.desconectar();
	}
	
	public ArrayList<Consulta> consultarMarcados() throws SQLException {
		dao.conectar();
		consultas = dao.usuariosMarcados();
		dao.desconectar();
		return consultas;
	}
	
	public void actualizarListaConsulta(String name) throws SQLException {
		dao.conectar();
		dao.actualizarMarcado(name);
		dao.borrarDeLista(name);
		dao.desconectar();
	}
	
}
