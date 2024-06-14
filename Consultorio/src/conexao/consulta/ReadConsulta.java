package conexao.consulta;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import recursos.*;

public class ReadConsulta {
	public static ArrayList<Consulta> read(Connection con) throws Exception {
		ArrayList<Consulta> consultas = new ArrayList<Consulta>();
		Statement statement = con.createStatement();
		String query = "select * from Consulta";
		ResultSet resultset = statement.executeQuery(query);
		while(resultset.next()) {
			Paciente p = new Paciente(resultset.getInt("ID_Pac"));
			Funcionario f = new Funcionario(resultset.getInt("ID_Func"));
			Dentista d = new Dentista(resultset.getInt("ID_Dent"));
			Consulta c = new Consulta(resultset.getInt("ID_Consulta"), resultset.getString("Tipo_Consulta"), 
					resultset.getString("Data_Consulta"), p, f, d);
			consultas.add(c);
		}
		for(Consulta cons : consultas) {
			String queryP = "select * from Paciente where ID_Pac = " + cons.getPaciente().getId_Pac();
			ResultSet resultSet2 = statement.executeQuery(queryP);
			resultSet2.next();
			Paciente p = new Paciente(resultSet2.getInt("ID_Pac"), resultSet2.getString("Nome_Pac"), 
					resultSet2.getString("Endereco_Pac"), resultSet2.getString("Tipo_Sanguineo"),
					resultSet2.getString("CPF_Pac"), resultSet2.getString("Telefone"));
			cons.setPaciente(p);
			String queryF = "select * from Funcionario where ID_Func = " + resultset.getInt("ID_Func");
			ResultSet resultSet3 = statement.executeQuery(queryF);
			resultSet3.next();
			Funcionario f = new Funcionario(resultSet3.getInt("ID_Func"), resultSet3.getString("Nome_Func"),
					resultSet3.getString("Login"), resultSet3.getString("Senha"), resultSet3.getBoolean("Gerente"));
			cons.setFuncionario(f);
			String queryD = "select * from Dentista where ID_Dent = " + resultset.getInt("ID_Dent");
			ResultSet resultSet4 = statement.executeQuery(queryD);
			resultSet4.next();
			Dentista d = new Dentista(resultSet4.getInt("ID_Dent"), resultSet4.getString("Nome_Dent"), 
			resultSet4.getString("CRM"), resultSet4.getString("Especialidade"));
			cons.setDentista(d);
		}
		return consultas;
	}
}

