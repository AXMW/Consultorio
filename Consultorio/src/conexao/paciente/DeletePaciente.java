package conexao.paciente;
import java.sql.Connection;
import java.sql.Statement;


public class DeletePaciente {
	public static void update(Connection con, int id) throws Exception {
		Statement statement = con.createStatement();
		String query = "delete from Paciente where ID_Pac = " + id + ";";
		statement.executeUpdate(query);
	}
}
