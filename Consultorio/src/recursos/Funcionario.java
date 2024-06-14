package recursos;

public class Funcionario {
	private int id_Func;
	private String nome_Func;
	private String login;
	private String senha;
	private boolean gerente;
	
	public Funcionario(int id_Func, String nome_Func, String login, String senha, boolean gerente) {
		this.id_Func = id_Func;
		this.nome_Func = nome_Func;
		this.login = login;
		this.senha = senha;
		this.gerente = gerente;
	}
	public Funcionario(String nome_Func, String login, String senha, boolean gerente) {
		this.nome_Func = nome_Func;
		this.login = login;
		this.senha = senha;
		this.gerente = gerente;
	}
	public Funcionario(int id_Func) {
		this.id_Func = id_Func;
	}

	public int getId_Func() {
		return id_Func;
	}

	public void setId_Func(int id_Func) {
		this.id_Func = id_Func;
	}

	public String getNome_Func() {
		return nome_Func;
	}

	public void setNome_Func(String nome_Func) {
		this.nome_Func = nome_Func;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isGerente() {
		return gerente;
	}

	public void setGerente(boolean gerente) {
		this.gerente = gerente;
	}
	
	
}
