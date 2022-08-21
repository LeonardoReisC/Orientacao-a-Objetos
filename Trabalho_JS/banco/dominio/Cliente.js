export default class Cliente {
    #cpf;
    #nome;
    #sobrenome;
    #contas;

    constructor(nome, sobrenome) {
        this.#nome = nome;
        this.#sobrenome = sobrenome;
        this.#contas = new Array();
    }

    getCpf() { return this.#cpf; }

    setCpf(cpf) { this.#cpf = cpf; }

    getNome() { return this.#nome; }

    setNome(nome) { this.#nome = nome; }

    getSobrenome() { return this.#sobrenome; }

    setSobrenome(sobrenome) { this.#sobrenome = sobrenome; }

    adicionarConta(conta) { this.#contas.push(conta); }

    getConta(index) { return this.#contas[index]; }

    getContas() { return this.#contas; }

    getNumeroContas() { return this.#contas.length; }
}