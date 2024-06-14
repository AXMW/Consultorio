package conexao.funcionario;

import java.sql.Connection;
import java.sql.Statement;

import recursos.Funcionario;

public class UpdateFuncionario {
	public static void update(Connection con, Funcionario funcionario) throws Exception {
		Statement statement = con.createStatement();
		int gerente = funcionario.isGerente() ? 1 : 0;
		String query = "update Funcionario set Nome_Func = '" + funcionario.getNome_Func() + "', Login = '"
				+ funcionario.getLogin() + "', Senha = '" + funcionario.getSenha() + 
				"', Gerente = '" + gerente + "' where ID_Func = " + funcionario.getId_Func() + ";";
		statement.executeUpdate(query);
		
	}
}
