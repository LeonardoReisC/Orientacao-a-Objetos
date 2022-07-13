package exercicio2.model.animais;

public class Peixe extends Animal implements AnimalDeEstimacao{
    public Peixe(String nome) { super(nome, 0); }

    @Override
    public void brincar() { System.out.println(nome + " brinca com anzol."); }

    @Override
    public void caminhar() { System.out.println(nome + " nao anda, nada."); }

    @Override
    public void comer() { System.out.println(nome + " come minhoca."); }
}
