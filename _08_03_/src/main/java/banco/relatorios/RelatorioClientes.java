package banco.relatorios;

import banco.dominio.*;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Iterator;

public class RelatorioClientes {

    public void geraRelatorio() {

        /** Exercício: Recupere abaixo o objeto singleton Banco em vez de atribuir null à variável banco ***/
        Banco banco = Banco.getBanco();
        Cliente cliente;

        /**
         * Exercício: Defina o local do sistema como sendo Brasil e idioma Português do Brasil
         * (O valor 5 mil em inglês é escrito como 5,000.00. Em português do Brasil 5.000,00). Ao definirmos
         * o local, mudamos o esquema de escrita para valores monetários para usado no Brasil
         * Dica: use a classe Local da API do JRE
         * Uma vez definido o Local, é necessário criar um formatador monetário com a classe NumberFormat
         * antes de exibirmos nossos valores numéricos no console:
         * Dica: Use a classe NumberFormat e os métodos estáticos getCurrencyInstance e format **/

        NumberFormat formatadorMonetario = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));


        System.out.println("\n\t\t\tRELATÓRIO DE CLIENTES");
        System.out.println("\t\t\t========================");
        boolean isContaCorrente = false;
        Iterator<Cliente> itCliente = banco.getClientes();
        while (itCliente.hasNext()) {
            cliente = itCliente.next();
            System.out.println();
            System.out.println("Cliente: " + cliente.getNome() + ", " + cliente.getSobrenome());

            Iterator itConta = cliente.getContas();
            while(itConta.hasNext()) {
                Conta conta = (Conta) itConta.next();
                String tipoConta;

                // Determina o tipo de conta
                if (conta instanceof ContaPoupanca) {
                    tipoConta = "Conta Poupanca";
                    isContaCorrente = false;
                } else if (conta instanceof ContaCorrente) {
                    tipoConta = "Conta Corrente";
                    isContaCorrente = true;
                } else {
                    tipoConta = "Tipo desconhecido de conta";
                }

                // Exibe os saldos da conta
                /** Exercício: Complete as lacunas para formatar a saída para exibir o padrão monetário brasileiro (R$)
                 * sem explicitamente inclur R$ na instrução System.out.println() ***/

                System.out.println("    " + tipoConta + ": Saldo atual de " +
                                    formatadorMonetario.format(conta.getSaldo()) + ". ");
                if (isContaCorrente) {
                    ContaCorrente contaCorrente = (ContaCorrente) conta;
                    System.out.println("\tCheque especial de " +
                            (formatadorMonetario.format(contaCorrente.getChequeEspecial())));
                }
            }
        }
    }
}
