package conexao.paciente;
import recursos.Paciente;
import java.sql.Connection;
import java.sql.Statement;

public class CreatePaciente {
	
	public static void create(Connection con, Paciente paciente) throws Exception {
		Statement statement = con.createStatement();
		String query = "insert into paciente (Nome_Pac, Endereco_Pac, Tipo_Sanguineo, CPF_Pac, Telefone) "
				+ "values ('" + paciente.getNome_Pac() + "', '" + paciente.getEndereco_Pac() + "', '"
				+ paciente.getTipo_Sanguineo() + "', '" + paciente.getCPF_Pac() + "', " + paciente.getTelefone() + ");";
		statement.executeUpdate(query);
	}
}
