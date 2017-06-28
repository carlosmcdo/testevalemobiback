//Importando pacote necessário
package br.com.testeback.view;

//Importando bibliotecas necessárias
import br.com.testeback.controller.IsrtCostumerAcount;
import br.com.testeback.model.CustomerAccount;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author carlos
 */
public class TesteBack{

    //Função principal que inicia todos os processos     
    public static void main(String[] args) throws SQLException{
        
        //Objeto para chamar as funções para inserir e consultar os clientes
        IsrtCostumerAcount start = new IsrtCostumerAcount();
        
        /*  
            Array para receber todos os clientes que estão de acordo com todos os 
            requisitos para cálculo e exibição da média
        */
        ArrayList<CustomerAccount> customersApproved = new ArrayList<>();
        
        //Chamando a função insertCmrAct(), responsável por inserir os clientes no banco de dados
        start.insertCmrAct();
        //Array recebendo clientes aprovados para o cálculo da média
        customersApproved = start.customersApproved();
        
        //Laço para exibir todas as informações dos clientes aprovados para cálculo
        for(CustomerAccount c : customersApproved){
            System.out.println("CPF/CNPJ: "+c.getCpf_cnpj() + " - Nome: "+ c.getNm_customer() + " - Ativo: " + c.getIs_active() + " - Saldo: " + c.getVl_total());
        }     
    }
}
