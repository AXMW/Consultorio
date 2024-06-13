package recursos;
import java.util.ArrayList;

public class Paciente {
	private int id_Pac;
	private String nome_Pac;
	private String endereco_Pac;
	private String tipo_Sanguineo;
	private String CPF_Pac;
	private ArrayList<String> telefone;
	
	public Paciente(int id_Pac, String nome_Pac, String endereco_Pac, String tipo_Sanguineo, String CPF_Pac, ArrayList<String> telefone) {
		this.id_Pac = id_Pac;
		this.nome_Pac = nome_Pac;
		this.endereco_Pac = endereco_Pac;
		this.tipo_Sanguineo = tipo_Sanguineo;
		this.CPF_Pac = CPF_Pac;
		this.telefone = telefone;
	}

	public int getId_Pac() {
		return id_Pac;
	}

	public void setId_Pac(int id_Pac) {
		this.id_Pac = id_Pac;
	}

	public String getNome_Pac() {
		return nome_Pac;
	}

	public void setNome_Pac(String nome_Pac) {
		this.nome_Pac = nome_Pac;
	}

	public String getEndereco_Pac() {
		return endereco_Pac;
	}

	public void setEndereco_Pac(String endereco_Pac) {
		this.endereco_Pac = endereco_Pac;
	}

	public String getTipo_Sanguineo() {
		return tipo_Sanguineo;
	}

	public void setTipo_Sanguineo(String tipo_Sanguineo) {
		this.tipo_Sanguineo = tipo_Sanguineo;
	}

	public String getCPF_Pac() {
		return CPF_Pac;
	}

	public void setCPF_Pac(String cPF_Pac) {
		CPF_Pac = cPF_Pac;
	}

	public ArrayList<String> getTelefone() {
		return telefone;
	}

	public void setTelefone(ArrayList<String> telefone) {
		this.telefone = telefone;
	}
	
	public void adicionarTelefone(String numero) {
		this.telefone.add(numero);
	}
}
