package conexao.dentista;

import java.sql.Connection;
import java.sql.Statement;

public class DeleteDentista {
	public static void delete(Connection con, int id) throws Exception {
		Statement statement = con.createStatement();
		String query = "delete from Consulta where ID_Dent = " + id + ";";
		statement.executeUpdate(query);
		query = "delete from Dentista where ID_Dent = " + id + ";";
		statement.executeUpdate(query);
	}
}
