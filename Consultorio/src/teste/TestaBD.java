package teste;

import java.sql.Connection;
import recursos.Paciente;
import conexao.Conector;
import conexao.paciente.*;
import java.util.ArrayList;
import recursos.Funcionario;

public class TestaBD {

	public static void main(String[] args) throws Exception{
		Connection con = null;
		con = Conector.getConecction();
		
		Paciente p = new Paciente("Kaique", "Casa dele", "O-", "11111111111", "(11)91111-1111");
		CreatePaciente.create(con, p);
		DeletePaciente.delete(con, 1);
		p.setEndereco_Pac("Logo Ali");
		p.setId_Pac(1);
		UpdatePaciente.update(con, p);
		ArrayList<Paciente> pacientes = ReadPaciente.read(con);
		
		for(Paciente paciente : pacientes) {
			System.out.println(paciente.getId_Pac());
		}
		
		Funcionario f = new Funcionario("Kaique", "Login", "Senha", true);
	}

}
