package model;

public class Consulta {
	
	private int id;
	private String name;
	private boolean marcado;
	
	public Consulta(int id, String name, boolean marcado){
		this.id = id;
		this.name = name;
		this.marcado = marcado;
	}
	
	

	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	@Override
	public String toString() {
		return "Consulta [id=" + id + ", name=" + name + ", marcado=" + marcado + "]";
	}
	
	

}
