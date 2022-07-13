package exercicio2.banco;

public class Cliente {
    private String nome;
    private String sobrenome;
    private ContaPoupanca contaPoupanca;
    private ContaCorrente contaCorrente;

    public Cliente(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
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

    public ContaCorrente getContaCorrente() { return contaCorrente; }

    public ContaPoupanca getContaPoupanca() { return contaPoupanca; }

    public void setContaCorrente(ContaCorrente contaCorrente) { this.contaCorrente = contaCorrente; }

    public void setContaPoupanca(ContaPoupanca contaPoupanca) { this.contaPoupanca = contaPoupanca; }

}
