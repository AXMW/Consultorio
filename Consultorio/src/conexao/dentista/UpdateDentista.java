package conexao.dentista;

import java.sql.Connection;
import java.sql.Statement;
import recursos.Dentista;

public class UpdateDentista {
	public static void update(Connection con, Dentista dentista) throws Exception {
		Statement statement = con.createStatement();
		String query = "update dentista set Nome_Dent = '" + dentista.getNome_Dent() + "', CRM = '"
				+ dentista.getCRM() + "', Especialidade = '" + dentista.getCRM() + 
				 "' where ID_Dent = " + dentista.getId_Dent() +";";
		statement.executeUpdate(query);
		
	}
}
