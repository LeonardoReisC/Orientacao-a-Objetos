package exercicio2.model.animais;

public class TesteAnimais {
    public static void main(String[] args) {
        Peixe p = new Peixe("Nemo");
        System.out.println("O peixe " + p.getNome() + " possui " + p.getNumeroDePernas() + " pernas.");
        p.caminhar();
        p.brincar();
        p.comer();
        System.out.println();

        Gato g = new Gato("Tom");
        System.out.println("O gato " + g.getNome() + " possui " + g.getNumeroDePernas() + " pernas.");
        g.caminhar();
        g.brincar();
        g.comer();
        System.out.println();

        Animal f = new Peixe("Peixoto");
        System.out.println("O animal " + f.getNome() + " possui " + f.getNumeroDePernas() + " pernas.");
        f.caminhar();
        if (f instanceof Peixe) {
            Peixe peixe = (Peixe) f;
            peixe.brincar();
        }
        f.comer();
        System.out.println();

        Animal s = new Aranha("Aracnilda");
        System.out.println("O animal " + s.getNome() + " possui " + s.getNumeroDePernas() + " pernas.");
        s.caminhar();
        s.comer();
        System.out.println();

        AnimalDeEstimacao ae = new Gato("Pudim");
        if (ae instanceof Gato) {
            Gato gato = (Gato) ae;
            System.out.println("O animal de estimacao " + gato.getNome() + " possui "
                                + gato.getNumeroDePernas() + " pernas.");
            gato.caminhar();
            gato.brincar();
            gato.comer();
        }
    }
}
