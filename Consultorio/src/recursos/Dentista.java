package recursos;


public class Dentista {
	private int id_Dent;
	private String nome_Dent;
	private String CRM;
	private String especialidade;
	
	public Dentista(int id_Dent, String nome_Dent, String CRM, String especialidade) {
		this.id_Dent = id_Dent;
		this.nome_Dent = nome_Dent;
		this.CRM = CRM;
		this.especialidade = especialidade;
	}

	public int getId_Dent() {
		return id_Dent;
	}

	public void setId_Dent(int id_Dent) {
		this.id_Dent = id_Dent;
	}

	public String getNome_Dent() {
		return nome_Dent;
	}

	public void setNome_Dent(String nome_Dent) {
		this.nome_Dent = nome_Dent;
	}

	public String getCRM() {
		return CRM;
	}

	public void setCRM(String cRM) {
		CRM = cRM;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
}
