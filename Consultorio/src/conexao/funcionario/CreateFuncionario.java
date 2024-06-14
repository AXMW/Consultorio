package conexao.funcionario;

import java.sql.Connection;
import java.sql.Statement;

import recursos.Funcionario;

public class CreateFuncionario {
	public static void create(Connection con, Funcionario funcionario) throws Exception {
		Statement statement = con.createStatement();
		int i = funcionario.isGerente() ? 1 : 0;
		String query = "insert into Funcionario (Nome_Func, Login, Senha, Gerente) "
				+ "values ('" + funcionario.getNome_Func() + "', '" + funcionario.getLogin() + "', '"
				+ funcionario.getSenha() + "', '" + i + "');";
		statement.executeUpdate(query);
	}
}
