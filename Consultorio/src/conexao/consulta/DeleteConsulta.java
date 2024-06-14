package conexao.consulta;

import java.sql.Connection;
import java.sql.Statement;

public class DeleteConsulta {
	public static void delete(Connection con, int id) throws Exception {
		Statement statement = con.createStatement();
		String query = "delete from Consulta where ID_Cons = " + id + ";";
		statement.executeUpdate(query);
	}
}
