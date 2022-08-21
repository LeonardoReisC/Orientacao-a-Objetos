import Conta from './Conta.js';

export default class ContaPoupanca extends Conta {
    #taxaRendimento;

    constructor(saldoInicial, taxaRendimento) {
        super(saldoInicial);
        this.#taxaRendimento = taxaRendimento;
    }
}