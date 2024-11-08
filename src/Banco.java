import java.util.ArrayList;

public class Banco {
    private ArrayList<ContaBancaria> contas = new ArrayList<>();

    public void adicionarConta(ContaBancaria conta) {
        contas.add(conta);
        System.out.println("Conta adicionada com sucesso.");
    }

    public ContaBancaria buscarConta(String numeroConta) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta().equals(numeroConta)) {
                return conta;
            }
        }
        return null;
    }

    public void transferir(String numeroContaOrigem, String numeroContaDestino, double valor) {
        ContaBancaria origem = buscarConta(numeroContaOrigem);
        ContaBancaria destino = buscarConta(numeroContaDestino);

        if (origem != null && destino != null) {
            if (origem.getSaldo() >= valor) {
                origem.sacar(valor);
                destino.depositar(valor);
                System.out.println("Transferência de R$ " + valor + " realizada com sucesso.");
            } else {
                System.out.println("Saldo insuficiente para transferência.");
            }
        } else {
            System.out.println("Conta(s) não encontrada(s).");
        }
    }

    public void exibirSaldo(String numeroConta) {
        ContaBancaria conta = buscarConta(numeroConta);
        if (conta != null) {
            conta.mostrarInformacoes();
        } else {
            System.out.println("Conta não encontrada.");
        }
    }
}
