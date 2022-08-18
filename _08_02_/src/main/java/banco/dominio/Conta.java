package banco.dominio;

import banco.dominio.excecoes.ExcecaoChequeEspecial;

public class Conta {

    protected double saldo;

    public Conta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean depositar(double valor) {
        saldo = saldo + valor;
        return true;
    }

    public void sacar(double valor) throws ExcecaoChequeEspecial {
        try {
            double deficit = this.saldo - valor;
            if (deficit < 0) {
                throw new ExcecaoChequeEspecial(deficit, "Saldo insuficiente");
            }
            this.saldo = deficit;
        } catch (ExcecaoChequeEspecial e) {
            throw e;
        }
    }


}
