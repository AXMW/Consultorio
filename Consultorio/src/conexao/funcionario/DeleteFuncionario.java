package conexao.funcionario;

import java.sql.Connection;
import java.sql.Statement;

public class DeleteFuncionario {
	public static void delete(Connection con, int id) throws Exception {
		Statement statement = con.createStatement();
		String query = "delete from Funcionario where ID_Func = " + id + ";";
		statement.executeUpdate(query);
	}
}
