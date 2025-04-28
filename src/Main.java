import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int opcao;
		Conta cc = null;
		Conta poupanca = null;

		do {
			System.out.println("\nBanco Digital:");
			System.out.println("1 - Criar conta");
			System.out.println("2 - Depositar em conta poupança");
			System.out.println("3 - Depositar em conta corrente");
			System.out.println("4 - Sacar");
			System.out.println("5 - Imprimir extrato");
			System.out.println("0 - Sair");
			System.out.print("\nEscolha uma opção: ");
			opcao = scanner.nextInt();

			switch (opcao) {
				case 1:
					System.out.println("Qual o seu primeiro nome?");
					String nomeCli = scanner.next();
					Cliente nomeCliente = new Cliente();
					nomeCliente.setNome(nomeCli);
					System.out.println("Digite 1 para criar Conta poupança e 2 para Conta Corrente: ");
					int tipoConta = scanner.nextInt();
					if (tipoConta == 1) {
						poupanca = new ContaPoupanca(nomeCliente);
						System.out.println(nomeCliente.getNome() + " , sua conta poupança foi criada.");
					} else if (tipoConta == 2) {
						cc = new ContaCorrente(nomeCliente);
						System.out.println(nomeCliente.getNome() + " , sua conta corrente foi criada.");
					}
					break;
				case 2:
					if (poupanca != null) {
						System.out.println("Qual valor deseja depositar na conta poupança?");
						Double valorDeposito = scanner.nextDouble();
						poupanca.depositar(valorDeposito);
						System.out.println(
								"Comprovante de depósito: Foi depositado R$ " + valorDeposito + " na conta poupança");
						System.out.println("O saldo atual é: " + poupanca.saldo);
					} else {
						System.out.println("Crie sua conta poupança primeiro!");
					}
					break;
				case 3:
					if (cc != null) {
						System.out.println("Qual valor deseja depositar na conta corrente?");
						Double valorDeposito = scanner.nextDouble();
						cc.depositar(valorDeposito);
						System.out.println(
								"Comprovante de depósito: Foi depositado R$ " + valorDeposito + " na conta corrente");
						System.out.println("O saldo atual é: " + cc.saldo);

					} else {
						System.out.println("Crie sua conta corrente primeiro!");
					}
					break;
				case 4:
					System.out.println("Deseja sacar de qual conta?");
					System.out.println("Digite 1 para Conta Poupança ou 2 para Conta Corrente");
					int tipoContaSaque = scanner.nextInt();

					Conta contaSelecionada = null;

					if (tipoContaSaque == 1) {
						if (poupanca != null) {
							contaSelecionada = poupanca;
						} else {
							System.out.println("Conta poupança ainda não criada.");
						}
					} else if (tipoContaSaque == 2) {
						if (cc != null) {
							contaSelecionada = cc;
						} else {
							System.out.println("Conta corrente ainda não criada.");
						}
					} else {
						System.out.println("Tipo inválido.");
					}

					if (contaSelecionada != null) {
						System.out.println("Saldo disponível: R$ " + contaSelecionada.getSaldo());
						System.out.print("Digite quanto deseja sacar: ");
						double valorSaque = scanner.nextDouble();
						contaSelecionada.sacar(valorSaque);
						System.out.println("Saque realizado com sucesso.");
						System.out.println("Saldo atualizado: R$ " + contaSelecionada.getSaldo());
					}
					break;

				case 5:

					contaSelecionada = null;
					System.out.println("Impressão do extrato \n Digite 1 para Conta Poupança ou 2 para Conta Corrente");
					int tipoContaExtrato = scanner.nextInt();
					if (tipoContaExtrato == 1) {
						if (poupanca != null) {
							contaSelecionada = poupanca;
							contaSelecionada.imprimirExtrato();
						} else {
							System.out.println("Conta poupança ainda não criada.");
						}
						break;
					} else if (tipoContaExtrato == 2) {
						if (cc != null) {
							contaSelecionada = cc;
							contaSelecionada.imprimirExtrato();
						} else {
							System.out.println("Conta corrente ainda não criada.");
						}
						break;
					} else {
						System.out.println("Tipo inválido.");
					}

					break;
				case 0:
					System.out.println("Encerrando programa...");
					break;
				default:
					System.out.println("Opção inválida, tente novamente.");
			}
		} while (opcao != 0);

		scanner.close();
	}
}
