package conexao.dentista;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import recursos.Dentista;

public class ReadDentista {
	public static ArrayList<Dentista> read(Connection con) throws Exception {
		ArrayList<Dentista> dentistas = new ArrayList<Dentista>();
		Statement statement = con.createStatement();
		String query = "select * from Dentista";
		ResultSet resultset = statement.executeQuery(query);
		while(resultset.next()) {
			Dentista d = new Dentista(resultset.getInt("ID_Dent"), resultset.getString("Nome_Dent"), 
					resultset.getString("CRM"), resultset.getString("Especialidade"));
			dentistas.add(d);
		}
		resultset.close();
		return dentistas;
	}
}
