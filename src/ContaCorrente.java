public class ContaCorrente extends ContaBancaria {
    private double taxaManutencao = 10.0; // Exemplo de taxa fixa

    public ContaCorrente(String numeroConta, double saldoInicial) {
        super(numeroConta, saldoInicial);
    }

    public void cobrarTaxa() {
        saldo -= taxaManutencao;
        System.out.println("Taxa de manutenção de R$ " + taxaManutencao + " cobrada.");
    }

    @Override
    public void mostrarInformacoes() {
        System.out.println("Conta Corrente - Número: " + numeroConta + ", Saldo: R$ " + saldo);
    }
}
