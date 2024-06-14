package conexao.paciente;
import recursos.Paciente;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ReadPaciente {
	
	public static ArrayList<Paciente> read(Connection con) throws Exception {
		ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
		Statement statement = con.createStatement();
		String query = "select * from Paciente";
		ResultSet resultset = statement.executeQuery(query);
		while(resultset.next()) {
			Paciente p = new Paciente(resultset.getInt("ID_Pac"), resultset.getString("Nome_Pac"), 
					resultset.getString("Endereco_Pac"), resultset.getString("Tipo_Sanguineo"), 
					resultset.getString("CPF_Pac"), resultset.getString("Telefone"));
			pacientes.add(p);
		}
		resultset.close();
		return pacientes;
	}
	
	public static Paciente read(Connection con, String CPF) throws Exception{
		Paciente p = null;
		Statement statement = con.createStatement();
		String query = "select * from Paciente where CPF_Pac = " + CPF;
		ResultSet resultset = statement.executeQuery(query);
		while(resultset.next()) {
			p = new Paciente(resultset.getInt("ID_Pac"), resultset.getString("Nome_Pac"), 
					resultset.getString("Endereco_Pac"), resultset.getString("Tipo_Sanguineo"), 
					resultset.getString("CPF_Pac"), resultset.getString("Telefone"));
			
		}
		resultset.close();
		return p;
	}
}
