package conexao.funcionario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import recursos.Funcionario;

public class ReadFuncionario {
	public static ArrayList<Funcionario> read(Connection con) throws Exception {
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		Statement statement = con.createStatement();
		String query = "select * from Funcionario";
		ResultSet resultset = statement.executeQuery(query);
		while(resultset.next()) {
			Funcionario f = new Funcionario(resultset.getInt("ID_Func"), resultset.getString("Nome_Func"), 
					resultset.getString("Login"), resultset.getString("Senha"), 
					resultset.getBoolean("Gerente"));
			funcionarios.add(f);
		}
		resultset.close();
		return funcionarios;
	}
}
