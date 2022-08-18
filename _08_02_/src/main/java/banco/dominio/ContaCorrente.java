package banco.dominio;

import banco.dominio.excecoes.ExcecaoChequeEspecial;

public class ContaCorrente extends Conta{
    private double chequeEspecial;

    public ContaCorrente(double saldoInicial) { this(saldoInicial,0); }

    public ContaCorrente(double saldoInicial, double chequeEspecial) {
        super(saldoInicial);
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public void sacar(double valor) throws ExcecaoChequeEspecial {
        // Saldo + valor cheque especial suficientes para cobrir o saque
        try {
            double deficit = this.saldo - valor;
            if (deficit < 0) {
                if (this.chequeEspecial == 0D) {
                    throw new ExcecaoChequeEspecial(-deficit, "Nao ha cheque especial");
                } else if (this.chequeEspecial < -deficit) {
                    throw new ExcecaoChequeEspecial(-deficit, "Saldo insuficiente no cheque especial");
                }
            }

            this.saldo = deficit;
        } catch (ExcecaoChequeEspecial e) {
            throw e;
        }
    }

    public double getChequeEspecial() { return chequeEspecial; }

    public void setChequeEspecial(double chequeEspecial) { this.chequeEspecial = chequeEspecial; }
}
