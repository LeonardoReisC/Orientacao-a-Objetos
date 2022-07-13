package exercicio2.banco;

public class ContaCorrente extends Conta {
    private Conta contaPoupanca;

    public ContaCorrente(double saldoInicial, ContaPoupanca protecao) {
        super(saldoInicial);
        this.contaPoupanca = protecao;
    }

    public ContaCorrente(double saldoInicial) {
        super(saldoInicial);
    }

    @Override
    public boolean sacar(double valor) {
        //  Saldo em conta corrente SUFICIENTE para o saque
        if (valor <= this.saldo) {
            this.saldo -= valor;
            return true;
        }

        //  Saldo em conta corrente + saldo em conta poupança SUFICIENTES para o saque
        if ((contaPoupanca != null) && (this.saldo + this.contaPoupanca.getSaldo() >= valor)) {
            contaPoupanca.sacar(valor - this.saldo);
            this.saldo = 0;
            return true;
        } else return false; //  Saldo em conta corrente + saldo em conta poupança INSUFICIENTES para o saque
    }

    public Conta getContaPoupanca() { return contaPoupanca; }

    public void setContaPoupanca(ContaPoupanca contaPoupanca) { this.contaPoupanca = contaPoupanca; }
}
