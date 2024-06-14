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
					resultset.getString("Data_Consulta"), p, 
					f, d);
			consultas.add(c);
		}
		resultset.close();
		for(Consulta cons : consultas) {
			String queryP = "select * from Paciente where ID_Pac = " + cons.getPaciente().getId_Pac();
			ResultSet resultSet2 = statement.executeQuery(queryP);
			resultSet2.next();
			Paciente p = new Paciente(resultSet2.getInt("ID_Pac"), resultSet2.getString("Nome_Pac"), 
					resultSet2.getString("Endereco_Pac"), resultSet2.getString("Tipo_Sanguineo"),
					resultSet2.getString("CPF_Pac"), resultSet2.getString("Telefone"));
			cons.setPaciente(p);
			resultSet2.close();
			queryP = "select * from Funcionario where ID_Func = " + resultset.getInt("ID_Func");
			resultSet2 = statement.executeQuery(queryP);
			resultSet2.next();
			Funcionario f = new Funcionario(resultSet2.getInt("ID_Func"), resultSet2.getString("Nome_Func"),
					resultSet2.getString("Login"), resultSet2.getString("Senha"), resultSet2.getBoolean("Gerente"));
			cons.setFuncionario(f);
			resultSet2.close();
			queryP = "select * from Dentista where ID_Dent = " + resultset.getInt("ID_Dent");
			resultSet2 = statement.executeQuery(queryP);
			resultSet2.next();
			Dentista d = new Dentista(resultSet2.getInt("ID_Dent"), resultSet2.getString("Nome_Dent"), 
			resultSet2.getString("CRM"), resultSet2.getString("Especialidade"));
			resultSet2.close();
			cons.setDentista(d);
		}
		return consultas;
	}
}

