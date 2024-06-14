package conexao.consulta;

import java.sql.Connection;
import java.sql.Statement;

import recursos.Consulta;

public class CreateConsulta {
	public static void create(Connection con, Consulta consulta) throws Exception {
		Statement statement = con.createStatement();
		String query = "insert into consulta (Tipo_Consulta, Data_Consulta, ID_Pac, ID_Func, ID_Dent) "
				+ "values ('"  + consulta.getTipo_Consulta() + "', '" + consulta.getData_Consulta()
				+ "', '"  + consulta.getPaciente().getId_Pac() + "', '" +
				consulta.getFuncionario().getId_Func() + "', '" + consulta.getDentista().getId_Dent() + "');";
		statement.executeUpdate(query);
	}
}
