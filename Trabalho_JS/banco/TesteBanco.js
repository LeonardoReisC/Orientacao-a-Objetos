import Banco from './dominio/Banco.js';
import Cliente from './dominio/Cliente.js';
import Conta from './dominio/Conta.js';
import ContaCorrente from './dominio/ContaCorrente.js';
import ContaPoupanca from './dominio/ContaPoupanca.js';
import ExcecaoChequeEspecial from './dominio/excecoes/ExcecaoChequeEspecial.js';
import RelatorioClientes from './relatorios/RelatorioClientes.js';

export default class TesteBanco {
    main() {
        let banco = new Banco();
        let cliente;
        let relatorio = new RelatorioClientes();
        
        // Cria vários clientes e suas respectivas contas
        console.log("Criando uma conta corrente para o cliente Bruno Henrique.");
        let brunoHenrique = new Cliente("Bruno", "Henrique");
        banco.adicionarCliente(brunoHenrique);
        cliente = banco.getCliente(0);
        cliente.adicionarConta(new ContaPoupanca(50000, 0.03));
        cliente.adicionarConta(new ContaCorrente(220000, 40000));
        
        // Criação do cliente Everton Ribeiro e sua respectiva
        // conta corrente com saldo inicial e cheque especial
        console.log("Criando uma conta corrente para o cliente Everton Ribeiro");
        let evertonRibeiro = new Cliente("Everton", "Ribeiro");
        let contaER = new ContaCorrente(45000, 30000);
        evertonRibeiro.adicionarConta(contaER);
        banco.adicionarCliente(evertonRibeiro);
        
        // Criação do cliente Filipe Luis e sua respectiva
        // conta corrente com saldo inicial, sem cheque especial
        console.log("Criando uma conta corrente para o cliente Filipe Luis.");
        let filipeLuis = new Cliente("Filipe", "Luis");
        let contaFilipeLuis = new ContaCorrente(70000, 0);
        filipeLuis.adicionarConta(contaFilipeLuis);
        banco.adicionarCliente(filipeLuis);
        
        console.log("Criando uma conta corrente para o cliente Gabriel Barbosa.");
        let gabrielBarbosa = new Cliente("Gabriel", "Barbosa");
        banco.adicionarCliente(gabrielBarbosa);
        cliente = banco.getCliente(3);
        cliente.adicionarConta(new ContaPoupanca(220000, 0.03));
        
        // Criação do cliente Diego Alves e sua respectiva conta com saldo inicial
        console.log("Criando uma conta corrente para o cliente Diego Alves.");
        let diegoAlves = new Cliente("Diego", "Alves");
        let contaDA = new ContaCorrente(50000, 0);
        diegoAlves.adicionarConta(contaDA);
        banco.adicionarCliente(diegoAlves);
        
        // Criação da cliente Lorena Lara com conta conjunta com Diego Alves
        console.log("Diego Alves autorizou o cadastro de sua conta corrente como sendo conjunta com a cliente Lorena Lara.");
        let lorenaLara = new Cliente("Lorena", "Lara");
        lorenaLara.adicionarConta(contaDA);
        banco.adicionarCliente(lorenaLara);

        // gerar o relatorio
        relatorio.geraRelatorio();
    }
}
