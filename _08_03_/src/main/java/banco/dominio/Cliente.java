package banco.dominio;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Cliente {
    private String cpf;
    private String nome;
    private String sobrenome;
    private List<Conta> contas;

    public Cliente(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.contas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public Conta getConta(int index) {
        return this.contas.get(index);
    }

    public Iterator getContas() { return contas.listIterator(); }

    public int getNumeroDeContas() {
        return this.contas.size();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
