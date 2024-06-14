package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conector {
	
	private static String servidor = "jdbc:mysql://localhost:3306/consultorio?useTimezone=true&serverTimezone=UTC&useSSL=false";
	private static String usuario = "root";
	private static String senha = "f@tec123";
	private static Connection con;
	private static String driver = "com.mysql.jdbc.Driver";
	
	public static Connection getConecction() throws Exception {
		Class.forName(driver);
		con = DriverManager.getConnection(servidor, usuario, senha);
        return con;
	}
}
