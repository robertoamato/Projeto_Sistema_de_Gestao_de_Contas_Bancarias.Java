import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);
        String numeroConta;
        double valor;

        while (true) {
            System.out.println("\n--- Menu Banco ---");
            System.out.println("1. Criar Conta Corrente");
            System.out.println("2. Criar Conta Poupança");
            System.out.println("3. Depósito");
            System.out.println("4. Saque");
            System.out.println("5. Transferência");
            System.out.println("6. Exibir Saldo");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o número da conta: ");
                    numeroConta = scanner.next();
                    System.out.print("Digite o saldo inicial: ");
                    valor = scanner.nextDouble();
                    ContaCorrente contaCorrente = new ContaCorrente(numeroConta, valor);
                    banco.adicionarConta(contaCorrente);
                    break;
                case 2:
                    System.out.print("Digite o número da conta: ");
                    numeroConta = scanner.next();
                    System.out.print("Digite o saldo inicial: ");
                    valor = scanner.nextDouble();
                    ContaPoupanca contaPoupanca = new ContaPoupanca(numeroConta, valor);
                    banco.adicionarConta(contaPoupanca);
                    break;
                case 3:
                    System.out.print("Digite o número da conta: ");
                    numeroConta = scanner.next();
                    System.out.print("Digite o valor do depósito: ");
                    valor = scanner.nextDouble();
                    ContaBancaria contaDeposito = banco.buscarConta(numeroConta);
                    if (contaDeposito != null) {
                        contaDeposito.depositar(valor);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o número da conta: ");
                    numeroConta = scanner.next();
                    System.out.print("Digite o valor do saque: ");
                    valor = scanner.nextDouble();
                    ContaBancaria contaSaque = banco.buscarConta(numeroConta);
                    if (contaSaque != null) {
                        contaSaque.sacar(valor);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 5:
                    System.out.print("Digite o número da conta de origem: ");
                    String contaOrigem = scanner.next();
                    System.out.print("Digite o número da conta de destino: ");
                    String contaDestino = scanner.next();
                    System.out.print("Digite o valor da transferência: ");
                    valor = scanner.nextDouble();
                    banco.transferir(contaOrigem, contaDestino, valor);
                    break;
                case 6:
                    System.out.print("Digite o número da conta: ");
                    numeroConta = scanner.next();
                    banco.exibirSaldo(numeroConta);
                    break;
                case 7:
                    System.out.println("Encerrando o sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
