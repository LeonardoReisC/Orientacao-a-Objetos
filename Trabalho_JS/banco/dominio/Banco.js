export default class Banco {
    #clientes = new Array();
    
    constructor() {
        if (Banco.instance instanceof Banco) {
            return Banco.instance;
        }

        Object.freeze(this);
        Banco.instance = this;
    }

    getCliente(index) { return this.#clientes[index]; }

    filterCliente(nome, sobrenome) { 
        let result = new Array();
        for (let cliente of this.#clientes) {
            if (cliente.getNome().equals(nome) && cliente.getSobrenome().equals(sobrenome)) {
                result.push(cliente);
            }
        }
        return result;
    }

    getClientes() { return this.#clientes; }

    getNumeroClientes() { return this.#clientes.length; }

    adicionarCliente(cliente) { this.#clientes.push(cliente); }
}