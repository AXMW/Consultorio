package conexao.paciente;
import recursos.Paciente;
import java.sql.Connection;
import java.sql.Statement;

public class UpdatePaciente {
	public static void update(Connection con, Paciente paciente) throws Exception {
		Statement statement = con.createStatement();
		String query = "update paciente set Nome_Pac = '" + paciente.getNome_Pac() + "', Endereco_Pac = '"
				+ paciente.getEndereco_Pac() + "', Tipo_Sanguineo = '" + paciente.getTipo_Sanguineo() + 
				"', CPF_Pac = '" + paciente.getCPF_Pac() + "', Telefone = '" + paciente.getTelefone() + 
				"' where ID_Pac = " + paciente.getId_Pac() +";";
		statement.executeUpdate(query);
		
	}
}
