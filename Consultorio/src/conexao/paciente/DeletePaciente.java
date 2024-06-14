package conexao.paciente;
import java.sql.Connection;
import java.sql.Statement;


public class DeletePaciente {
	public static void delete(Connection con, int id) throws Exception {
		Statement statement = con.createStatement();
		String query = "delete from Consulta where ID_Pac = " + id + ";";
		statement.executeUpdate(query);
		query = "delete from Paciente where ID_Pac = " + id + ";";
		statement.executeUpdate(query);
	}
}
