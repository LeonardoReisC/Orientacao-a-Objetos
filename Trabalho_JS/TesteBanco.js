import Banco from './banco/dominio/Banco.js'
import Cliente from './banco/dominio/Cliente.js'
import Conta from './banco/dominio/Conta.js';
import ContaCorrente from './banco/dominio/ContaCorrente.js'
import ContaPoupanca from './banco/dominio/ContaPoupanca.js'
import ExcecaoChequeEspecial from './banco/dominio/excecoes/ExcecaoChequeEspecial.js'

export default class TesteBanco {
    main() {
        let banco = new Banco();
        let conta = null;
        let cliente = null

        // Cria dois clientes e suas respectivas contas
        let brunoHenrique = new Cliente("Bruno", "Henrique");
        banco.adicionarCliente(brunoHenrique);
        brunoHenrique.adicionarConta(new ContaCorrente(220000, 40000))

        let gabrielBarbosa = new Cliente("Gabriel", "Barbosa");
        banco.adicionarCliente(gabrielBarbosa);
        gabrielBarbosa.adicionarConta(new ContaCorrente(30000, 0))

        let formatadorMonetario = new Intl.NumberFormat('pt-br', {
            style: 'currency',
            currency: 'BRL',
        });

        console.log("-------------------------- RELATÓRIO DE TRANSAÇÕES ---------------------------\n");

        // Testando uma conta poupança
        console.log("Recuperando o cliente Bruno Henrique");
        conta = brunoHenrique.getConta(0)
        // Executa algumas transações na conta
        try {
            console.log("Sacando R$ 1.200,00");
            conta.sacar(1200);
            console.log("Depositando R$ 8.525,00");
            conta.depositar(8525);
            console.log("Sacando R$ 300.000,00");
            conta.sacar(300000);
            console.log("Sacando R$ 50.000,00: ");
            conta.sacar(50000);
        } catch (e) {
            console.log("Exceção: " + e.message 
                    + "   Déficit: R$ " + e.getDeficit());
        } finally {
            console.log("Cliente [" + brunoHenrique.getNome()
                    + ", " + brunoHenrique.getSobrenome() + "]"
                    + " Tem um saldo em conta corrente de "
                    + formatadorMonetario.format(conta.getSaldo()));
        }

        console.log("\n")
        console.log("Recuperando o cliente Gabriel Barbosa");
        conta = gabrielBarbosa.getConta(0);

        try {
            console.log("Saque de R$ 15500,00");
            conta.sacar(15500);
            console.log("Depositando R$ 3000,00");
            conta.depositar(3000);
            console.log("Saque de R$ 18000,00");
            conta.sacar(18000);
        } catch (e) {
            console.log("Exceção: " + e.message
                    + "   Déficit: R$ " + e.getDeficit());
        } finally {
            console.log("Cliente [" + gabrielBarbosa.getNome()
                    + ", " + gabrielBarbosa.getSobrenome() + "]"
                    + " Tem um saldo em conta corrente de R$ "
                    + formatadorMonetario.format(conta.getSaldo()));
        }
        console.log();
    }
}