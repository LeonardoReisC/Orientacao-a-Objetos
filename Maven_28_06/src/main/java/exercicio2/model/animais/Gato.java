package exercicio2.model.animais;

public class Gato extends Animal implements AnimalDeEstimacao{
    public Gato() { this(""); }

    public Gato(String nome) { super(nome, 4); }
    @Override
    public void brincar() {
        System.out.println(nome + " brinca com bola de meia.");
    }

    @Override
    public void caminhar() {
        System.out.println(nome + " anda com 4 pernas.");
    }
    @Override
    public void comer() { System.out.println(nome + " come racao."); }
}
