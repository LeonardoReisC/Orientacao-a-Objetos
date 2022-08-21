import Banco from '../dominio/Banco.js';
import Cliente from '../dominio/Cliente.js';
import Conta from '../dominio/Conta.js';
import ContaCorrente from '../dominio/ContaCorrente.js';
import ContaPoupanca from '../dominio/ContaPoupanca.js';
import ExcecaoChequeEspecial from '../dominio/excecoes/ExcecaoChequeEspecial.js';

export default class RelatorioClientes {
    geraRelatorio() {
        let banco = new Banco();

        let formatadorMonetario = new Intl.NumberFormat('pt-br', {
            style: 'currency',
            currency: 'BRL',
        });

        console.log("\n\t\t\tRELATÓRIO DE CLIENTES");
        console.log("=================================================================================");

        let isContaCorrente = false;
        for (let itCliente of banco.getClientes()) {
            console.log("Cliente: " + itCliente.getNome() + ", " + itCliente.getSobrenome());
            
            for (let itConta of itCliente.getContas()) {
                let tipoConta;
    
                if (itConta instanceof ContaPoupanca) {
                    tipoConta = "Conta Poupança";
                    isContaCorrente = false;
                } else if (itConta instanceof ContaCorrente) {
                    tipoConta = "Conta Corrente";
                    isContaCorrente = true;
                } else {
                    tipoConta = "Tipo desconhecido de conta";
                }
    
                console.log("\t" + tipoConta + ": Saldo atual de " +
                    formatadorMonetario.format(itConta.getSaldo())  + ".");
            
                if (isContaCorrente) {
                    let contaCorrente = itConta;
                    console.log("\tCheque especial de " 
                    + formatadorMonetario.format(contaCorrente.getChequeEspecial()));
                }
            }
            console.log();
        }
        
    }
}