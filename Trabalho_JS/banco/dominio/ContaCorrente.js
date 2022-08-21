import ExcecaoChequeEspecial from './excecoes/ExcecaoChequeEspecial.js';
import Conta from './Conta.js';

export default class ContaCorrente extends Conta {
    #chequeEspecial;

    constructor(saldoInicial, chequeEspecial) {
        super(saldoInicial);
        this.#chequeEspecial = chequeEspecial;
    }

    sacar(valor) {
        if (this._saldo + this.#chequeEspecial >= valor) {
            this._saldo -= valor;
         } else {
            let deficit = valor - this._saldo;
            if (this.#chequeEspecial == 0) {
                throw new ExcecaoChequeEspecial(deficit, "Não há cheque especial");
            } else {
                throw new ExcecaoChequeEspecial(deficit, "Saldo insuficiente no cheque especial");
            }
        }
    }

    getChequeEspecial() { return this.#chequeEspecial; }

    setChequeEspecial(chequeEspecial) { this.#chequeEspecial = chequeEspecial; }
}