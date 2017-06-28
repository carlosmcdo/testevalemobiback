//Importanto pacote necessário
package br.com.testeback.controller;

//Importando bibliotecas necessárias
import br.com.testeback.model.CustomerAccount;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author carlos
 */
public class IsrtCostumerAcount {
    
    //Array que irá conter todos os clientes e suas informações para o cadastro
    ArrayList<CustomerAccount> arrCtrmAcc = new ArrayList<>();

    //Função para coletar todas as informações dos clientes e inserir em um Array
    public String insertCmrAct(){
        
        //Objetos dos clientes e suas informações
        CustomerAccount ctmAcc1 = new CustomerAccount(1500,12345, "Carlos Machado",1, 2500);
        CustomerAccount ctmAcc2 = new CustomerAccount(1501,12346, "Bruno Arantes", 1, 3000);
        CustomerAccount ctmAcc3 = new CustomerAccount(1502,12347, "Ótavio Krauss", 1, 2500);
        CustomerAccount ctmAcc4 = new CustomerAccount(1503,12348, "Gabriel Teles", 0, 1000);
        CustomerAccount ctmAcc5 = new CustomerAccount(1504,12349, "Natalia Diniz", 1, 2800);
        CustomerAccount ctmAcc6 = new CustomerAccount(1505,12350, "Leonardo Batista", 1, 3500);
        CustomerAccount ctmAcc7 = new CustomerAccount(1506,12351, "Alexia de Deus", 1, 800);
        CustomerAccount ctmAcc8 = new CustomerAccount(1507,12352, "Rodrigo Araújo", 1, 5000);
        CustomerAccount ctmAcc9 = new CustomerAccount(1508,12353, "Fabrício Corrêa", 0, 4200);
        CustomerAccount ctmAcc10 = new CustomerAccount(1509,12354, "Alessandra Lourdes", 1, 3100);
        
        //Inserindo objetos no Array
        arrCtrmAcc.add(ctmAcc1);
        arrCtrmAcc.add(ctmAcc2);
        arrCtrmAcc.add(ctmAcc3);
        arrCtrmAcc.add(ctmAcc4);
        arrCtrmAcc.add(ctmAcc5);
        arrCtrmAcc.add(ctmAcc6);
        arrCtrmAcc.add(ctmAcc7);
        arrCtrmAcc.add(ctmAcc8);
        arrCtrmAcc.add(ctmAcc9);
        arrCtrmAcc.add(ctmAcc10);
        
        /*
            Laço percorrendo todos os clientes do Array e chamando a função inserirRegistro('objeto'), 
            da classe controle, CtrlCustomerAccount responsável por inserir na base de dados todos os clientes do Array 
            acima descrito.
        */
        for(CustomerAccount c : arrCtrmAcc){
            CtrlCostumerAcount ctlCtmAcc = new CtrlCostumerAcount();
            ctlCtmAcc.inserirRegistro(c);
        }
        //Retornando mensagem
        return "Todos os registros foram inseridos com sucesso!";
    }
    
    //Função responsável por aplicar os critérios necessários para a média do saldo dos clientes
    public ArrayList<CustomerAccount> customersApproved(){
        /*
            Declarando uma variável média que irá receber o valor final do cálculo, além de dois Arrays para a
            manipulação das informações.
        */
        double media = 0;
        CtrlCostumerAcount ctrlCtmAcc = new CtrlCostumerAcount();
        ArrayList<CustomerAccount> customer = new ArrayList<>();
        ArrayList<CustomerAccount> ctmAppd = new ArrayList<>();
        
        //Array recebendo da função getCostumer, todos os clientes do banco de dados
        customer = ctrlCtmAcc.getCostumer();
        
        /*
            Laço responsável por verificar se todos os clientes estão de acordo com os críterios,
            e aqueles aprovados, se calcula a média do saldo
        */
        for(CustomerAccount c : customer){
            if((c.getId_customer() > 1499 && c.getId_customer() < 2701) && c.getVl_total() > 500){
                ctmAppd.add(c);
                media += c.getVl_total();
            }
        }
        
        //Imprime a média formatada dos clientes aprovados.        
        System.out.println(String.format("Média: R$%.2f",(media/ctmAppd.size())));
        
        /*
            Realiza uma comparação de cada cliente pelo seu saldo, assim torna a 
            ordenar os clientes de acordo com o seu saldo
        */
        
        Collections.sort(ctmAppd, new ComparatorCustomers());
        //Retorna array ordenado
        return ctmAppd;
    }
}
