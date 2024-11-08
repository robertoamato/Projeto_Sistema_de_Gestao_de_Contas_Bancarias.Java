public class ContaPoupanca extends ContaBancaria {
    private double taxaRendimento = 0.02; // 2% de rendimento mensal

    public ContaPoupanca(String numeroConta, double saldoInicial) {
        super(numeroConta, saldoInicial);
    }

    public void aplicarRendimento() {
        saldo += saldo * taxaRendimento;
        System.out.println("Rendimento de 2% aplicado. Saldo atual: R$ " + saldo);
    }

    @Override
    public void mostrarInformacoes() {
        System.out.println("Conta Poupança - Número: " + numeroConta + ", Saldo: R$ " + saldo);
    }
}
