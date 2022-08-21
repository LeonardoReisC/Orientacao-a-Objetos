import ExcecaoChequeEspecial from "./excecoes/ExcecaoChequeEspecial.js";

export default class Conta {
    #numeroDaConta;
    _saldo;

    constructor(saldoInicial) {
        if (this.constructor instanceof Conta) {
            throw new Error("Object of Abstract class cannot be instantiated")
        }
        this._saldo = saldoInicial;
    }

    getNumeroDaConta() { return this.#numeroDaConta; }

    setNumeroDaConta(numeroDaConta) { this.#numeroDaConta = numeroDaConta; }

    getSaldo() { return this._saldo; }

    depositar(valor) {
        this._saldo += valor;
        return true; 
    }

    sacar(valor) {
        if ((this._saldo - valor) >= 0) {
            this._saldo -= valor;
         } else {
            let deficit = valor - this._saldo;
            throw new ExcecaoChequeEspecial(deficit, "Saldo insuficiente");
        }
    }
}