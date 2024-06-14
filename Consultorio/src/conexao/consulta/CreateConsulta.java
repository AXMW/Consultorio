package conexao.consulta;

import java.sql.Connection;
import java.sql.Statement;

import recursos.Consulta;

public class CreateConsulta {
	public static void create(Connection con, Consulta consulta) throws Exception {
		Statement statement = con.createStatement();
		String query = "insert into consulta (Nome_Dent, CRM, Especialidade) "
				+ "values ('"  + "', '" 
				+ "', '"  + "');";
		statement.executeUpdate(query);
	}
}
