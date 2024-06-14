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
}
