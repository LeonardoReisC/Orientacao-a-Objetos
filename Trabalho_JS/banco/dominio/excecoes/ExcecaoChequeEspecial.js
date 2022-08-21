export default class ExcecaoChequeEspecial extends Error {
    #deficit;

    constructor(deficit, mensagem) {
        super(mensagem);
        this.#deficit = deficit;
    }

    getDeficit() { return this.#deficit; }
}