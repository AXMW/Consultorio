package util;

public class Verificadores {

	//Metodo para validar o CPF de acordo com o padrão
	public static boolean verificarCPF (String cpfStr) {
		int valida = 0;
		
		//Verificar se a quantidade de numeros e a mesma de um CPF
		if (cpfStr.length() != 11) {
			return false;
		}
		//Verificador 1
		long cpf = Long.parseLong(cpfStr.substring(0, 9));
		
		System.out.println(cpf);
		
		for(int i = 9; cpf != 0; i--) {
			valida += (cpf % 10)*i;
			System.out.println((cpf % 10)*i);
			cpf /= 10;
		}
		System.out.println(valida);
		
		valida = valida % 11;
		if (valida == 10){
			valida = 0;
		}
		if (!(valida == (cpfStr.charAt(9) - '0'))){
			return false;
		}

		//Verificador 2
		valida = 0;
		cpf = Long.parseLong(cpfStr.substring(0, 10));
		for(int i = 9; cpf != 0; i--) {
			valida += (cpf % 10)*i;
			System.out.println((cpf % 10)*i);
			cpf /= 10;
		}
		System.out.println(valida);

		valida = valida % 11;
		if (valida == 10){
			valida = 0;
		}
		if (!(valida == (cpfStr.charAt(10) - '0'))){
			return false;
		}
		
		return true;
	}
	
	public static boolean verificarData(String data) {
		
		String[] vet = data.split(" ");
		
		data = vet[0];
		String horario = vet[1];
		
		vet = data.split("-");
		
		int ano = Integer.parseInt(vet[0]);
		int mes = Integer.parseInt(vet[1]);
		int dia = Integer.parseInt(vet[2]);
		
		if (ano < 1000 || ano > 3000 || mes < 1 || mes > 12 || dia < 1 || dia > 31) {
			return false;
		}
		if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && (dia > 30)) {
			return false;
		}
		if (mes == 2 && dia > 29) {
			return false;
		}
		
		vet = horario.split(":");
		int hora = Integer.parseInt(vet[0]);
		int minutos = Integer.parseInt(vet[1]);
		int segundos = Integer.parseInt(vet[2]);
		
		if (hora < 0 || hora > 23 || minutos < 0 || minutos > 59 || segundos < 0 || segundos > 59) {
			return false;
		}
		
		return true;
	}
}
