package banco.dominio.excecoes;

public class ExcecaoChequeEspecial extends Exception {
    private double deficit;

    public ExcecaoChequeEspecial(double deficit, String mensagem) {
        super(mensagem);
        this.deficit = deficit;
    }

    public double getDeficit() { return deficit; }
}
