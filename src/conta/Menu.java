package conta;

import java.util.Scanner;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		// Instanciamento = Converter classe -> em Objeto utilizavel
		/*
		 * Conta c1 = new Conta(123456, 0001, 1, "Maria das Neves", 500f);
		 * c1.setSaldo(5000.00f);
		 * 
		 * //teste c1.visualizar(); c1.sacar(600); c1.visualizar(); c1.depositar(200);
		 * c1.visualizar(); c1.sacar(600); c1.visualizar();
		 */

		// Instanciamento da classe contaCorrente
		ContaCorrente cc1 = new ContaCorrente(1, 34, 1, "Arlindo Cruz", 200f, 800);
		cc1.visualizar();
		cc1.visualizar();
		cc1.sacar(12000.0f);
		cc1.visualizar();
		cc1.depositar(5000.0f);
		cc1.visualizar();

		/*
		 * System.out.println("Titular: " + c1.getTitular());
		 * System.out.println("Saldo: " + c1.getSaldo());
		 */

		// Teste da Classe Conta Corrente
		
		// Teste da Classe Conta Poupança
		ContaPoupanca cp1 = new ContaPoupanca(2, 123, 2, "Maria dos Santos", 100000.0f, 15);
		cp1.visualizar();
		cp1.sacar(1000.0f);
		cp1.visualizar();
		cp1.depositar(5000.0f);
		cp1.visualizar();

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
			System.out.println(Cores.TEXT_RESET);
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