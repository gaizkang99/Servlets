package utils;

public class Constantes {
	
	//Constantes para la conexion
	public static final String Schema_name = "dam2tm06uf4p1";
	public static final String Connection = "jdbc:mysql://localhost:3306/" + Schema_name
			+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
	public static final String Name = "root";
	public static final String Password = "DAM1T_M03";
	
	//Queries SQL
	public static final String Insertar_Consulta = "insert into consultas (nombre, marcado) values(?, ?)";
	public static final String Consultar_Nombre = "select nombre from consultas where nombre = ? ";
	public static final String Actualizar_Estado = "update consultas set marcado = true where nombre = ?";
	public static final String Listar_Marcados = "select * from consultas where marcado=false order by id asc";
	public static final String Actualizar_Marcado_ID = "update consultas set marcado = true where nombre = ?";
	public static final String Borrar_De_Cola = "delete from consultas where nombre = ?";
}
