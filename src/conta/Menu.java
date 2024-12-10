package conta;

import java.util.Scanner;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);
		int opcao;

		while (true) {

			System.out.println(Cores.TEXT_PURPLE + Cores.ANSI_BLACK_BACKGROUND);
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("               BANCO SEM COBRANÇA                      ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");
			System.out.println( Cores.TEXT_RESET);
			opcao = leia.nextInt();

		
		if (opcao == 9) {
			System.out.println("Banco Sem Cobrança - Onde ninguém te liga ");
			sobre();
			System.exit(0);
		}
		

		switch (opcao) {
		case 1:
			System.out.println(Cores.TEXT_WHITE_BOLD + "Criar Conta");
			break;

		case 2:
			System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as contas");
			break;

		case 3:
			System.out.println(Cores.TEXT_WHITE_BOLD + "Consultar dados da Conta - por número");
			break;
		
		case 4:
			System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar dados da Conta");
			break;
		
		case 5:
			System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar a conta");
			break;
		
		case 6:
			System.out.println(Cores.TEXT_WHITE_BOLD + "Saque");
			break;
		
		case 7:
			System.out.println(Cores.TEXT_WHITE_BOLD + "Depósito");
			break;
		
		case 8:
			System.out.println(Cores.TEXT_WHITE_BOLD + "Transferência entre contas");
			break;
		
		default:
			System.out.println(Cores.TEXT_RED_BOLD + "Opção inválida");
			break;
		}
		}
	}
	
	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Luan Oliveira - luana@genstudents.org");
		System.out.println("https://github.com/Luan-tcpn");
		System.out.println("*********************************************************");
		
}

}