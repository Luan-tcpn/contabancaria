package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import conta.controller.ContaController;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		ContaController contas = new ContaController();
		Scanner leia = new Scanner(System.in);
		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;
		
		System.out.println("\nCriar Contas\n");
		
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "Claudio Santos", 1000.00f, 200.50f);
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Geraldo Barros", 1000.00f, 200.50f);
		ContaCorrente cc3 = new ContaCorrente(contas.gerarNumero(), 125, 1, "Americo Ferreira", 1000.00f, 200.50f);
		
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 126, 2, "Felix Torres", 1000.00f, 1);
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 127, 2, "Rodrigo", 2000.00f, 8);
		ContaPoupanca cp3 = new ContaPoupanca(contas.gerarNumero(), 128, 2, "Ana Maria", 6000.00f, 10);

		contas.listarTodas();
		
		// Instanciamento = Converter classe -> em Objeto utilizavel
		/*
		 * Conta c1 = new Conta(123456, 0001, 1, "Maria das Neves", 500f);
		 * c1.setSaldo(5000.00f);
		 * 
		 * //teste c1.visualizar(); c1.sacar(600); c1.visualizar(); c1.depositar(200);
		 * c1.visualizar(); c1.sacar(600); c1.visualizar();
		 */

		// Instanciamento da classe contaCorrente
		/*
		 * ContaCorrente cc1 = new ContaCorrente(1, 34, 1, "Arlindo Cruz", 200f, 800);
		 * cc1.visualizar(); cc1.visualizar(); cc1.sacar(12000.0f); cc1.visualizar();
		 * cc1.depositar(5000.0f); cc1.visualizar();
		 * 
		 */
		/*
		 * System.out.println("Titular: " + c1.getTitular());
		 * System.out.println("Saldo: " + c1.getSaldo());
		 */

		// Teste da Classe Conta Corrente

		/*
		 * // Teste da Classe Conta Poupança ContaPoupanca cp1 = new ContaPoupanca(2,
		 * 123, 2, "Maria dos Santos", 100000.0f, 15); cp1.visualizar();
		 * cp1.sacar(1000.0f); cp1.visualizar(); cp1.depositar(5000.0f);
		 * cp1.visualizar();
		 */

		while (true) {

			System.out.println(Cores.TEXT_PURPLE + Cores.ANSI_BLACK_BACKGROUND 
			 + "*****************************************************");
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
			System.out.println("                                                      " + Cores.TEXT_RESET);
			opcao = leia.nextInt();

			// try catch
			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) { // excecao
				System.out.println("Digite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 9) {
				System.out.println("Banco Sem Cobrança - Onde ninguém te liga ");
				sobre();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Criar Conta");

				System.out.println("Digite o Numero da Agência: ");
				agencia = leia.nextInt();
				System.out.println("Digite o Nome do titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();

				do {
					System.out.println("Digite o Tipo da Conta (1-CC ou 2-CP): ");
					tipo = leia.nextInt();
				} while (tipo < 1 && tipo > 2);

				System.out.println("Digite o Saldo da conta (R$): ");
				saldo = leia.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o limite de Crédito (R$): ");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> { 
					System.out.println("Digite o dia de aniversário da conta: ");
					aniversario = leia.nextInt();
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}
				}
				
			

				keyPress();
				break;

			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as contas");
				contas.listarTodas();
				keyPress();
				break;

			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Consultar dados da Conta - por número");
				
				System.out.println("Digite o npumero da conta: ");
				numero = leia.nextInt();
				
				contas.procurarPorNumero(numero);
				
				keyPress();
				break;

			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar dados da Conta");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				var buscaConta = contas.buscarNaCollection(numero);

				if (buscaConta != null) {
					
					System.out.println("Digite o Numero da Agência: ");
					agencia = leia.nextInt();
					System.out.println("Digite o Nome do Titular: ");
					leia.skip("\\R?");
					titular = leia.nextLine();
						
					System.out.println("Digite o Saldo da Conta (R$): ");
					saldo = leia.nextFloat();
					
					tipo = buscaConta.getTipo();
					
					switch(tipo) {
						case 1 -> {
							System.out.println("Digite o Limite de Crédito (R$): ");
							limite = leia.nextFloat();
							contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
						}
						case 2 -> {
							System.out.println("Digite o dia do Aniversario da Conta: ");
							aniversario = leia.nextInt();
							contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
						}
						default ->{
							System.out.println("Tipo de conta inválido!");
						}
					}
					
				}else
					System.out.println("\nConta não encontrada!");
				
				keyPress();
				break;

			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar a conta");
				
				System.out.println("Digite o numero da conta: ");
				numero = leia.nextInt();
				
				contas.deletar(numero);
				
				keyPress();
				break;

			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Saque");
				
				System.out.println("Digite o Numero da conta: ");
				numero = leia.nextInt();

				do {
					System.out.println("Digite o Valor do Saque (R$): ");
					valor = leia.nextFloat();
				} while (valor <= 0);

				contas.sacar(numero, valor);

				
				keyPress();
				break;

			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Depósito");
				
				System.out.println("Digite o Numero da conta: ");
				numero = leia.nextInt();

				do {
					System.out.println("Digite o Valor do Depósito (R$): ");
					valor = leia.nextFloat();
				} while (valor <= 0);

				contas.depositar(numero, valor);
				
				keyPress();
				break;

			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Transferência entre contas");
				
				System.out.println("Digite o Numero da Conta de Origem: ");
				numero = leia.nextInt();
				System.out.println("Digite o Numero da Conta de Destino: ");
				numeroDestino = leia.nextInt();

				do {
					System.out.println("Digite o Valor da Transferência (R$): ");
					valor = leia.nextFloat();
				} while (valor <= 0);

				contas.transferir(numero, numeroDestino, valor);

				
				keyPress();
				break;

			default:
				System.out.println(Cores.TEXT_RED_BOLD + "Opção inválida");
				keyPress();
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

	public static void keyPress() {

		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}

}