package exercicio2.model.animais;

public class Aranha extends Animal{

    public Aranha(String nome) { super(nome, 8); }

    @Override
    public void caminhar() { System.out.println(nome + " anda com 8 pernas."); }

    @Override
    public void comer() { System.out.println(nome + " come insetos"); }
}
