package conexao.consulta;

import java.sql.Connection;
import java.sql.Statement;

import recursos.Consulta;

public class CreateConsulta {
	public static void create(Connection con, Dentista dentista) throws Exception {
		Statement statement = con.createStatement();
		String query = "insert into dentista (Nome_Dent, CRM, Especialidade) "
				+ "values ('" + dentista.getNome_Dent() + "', '" + dentista.getCRM()
				+ "', '" + dentista.getEspecialidade() + "');";
		statement.executeUpdate(query);
	}
}
