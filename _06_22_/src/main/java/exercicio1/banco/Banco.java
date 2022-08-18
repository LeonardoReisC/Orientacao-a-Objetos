package exercicio1.banco;

import java.util.ArrayList;

public class Banco {
    private ArrayList<Cliente> clientes;

    public Banco() {
        // this.clientes = new Cliente[5]; - Codigo na versão com arrays
        clientes = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public Cliente getCliente(int indice) {
        return this.clientes.get(indice);
    }

    public ArrayList<Cliente> getCliente(String nome, String sobrenome) {
        ArrayList<Cliente> result = new ArrayList<>();
        for (Cliente cliente: clientes) {
            if (cliente.getNome().equals(nome) && cliente.getSobrenome().equals(sobrenome)) {
                result.add(cliente);
            }
        }
        return result;
    }

    public int getNumeroDeClientes() {
        return clientes.size();
    }
}
