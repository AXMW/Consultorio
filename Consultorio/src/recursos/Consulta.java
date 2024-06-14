package recursos;

public class Consulta {
	private int id_Cons;
	private String tipo_Consulta;
	private String data_Consulta;
	private Paciente paciente;
	private Funcionario funcionario;
	private Dentista dentista;
	
	public Consulta(int id_Cons, String tipo_Consulta, String data_Consulta, Paciente paciente, Funcionario funcionario, Dentista dentista) {
		this.id_Cons = id_Cons;
		this.tipo_Consulta = tipo_Consulta;
		this.data_Consulta = data_Consulta;
		this.paciente = paciente;
		this.funcionario = funcionario;
		this.dentista = dentista;
	}
	public Consulta(String tipo_Consulta, String data_Consulta, Paciente paciente, Funcionario funcionario, Dentista dentista) {
		this.tipo_Consulta = tipo_Consulta;
		this.data_Consulta = data_Consulta;
		this.paciente = paciente;
		this.funcionario = funcionario;
		this.dentista = dentista;
	}

	public int getId_Cons() {
		return id_Cons;
	}

	public void setId_Cons(int id_Cons) {
		this.id_Cons = id_Cons;
	}

	public String getTipo_Consulta() {
		return tipo_Consulta;
	}

	public void setTipo_Consulta(String tipo_Consulta) {
		this.tipo_Consulta = tipo_Consulta;
	}

	public String getData_Consulta() {
		return data_Consulta;
	}

	public void setData_Consulta(String data_Consulta) {
		this.data_Consulta = data_Consulta;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Dentista getDentista() {
		return dentista;
	}

	public void setDentista(Dentista dentista) {
		this.dentista = dentista;
	}
	
	
}
