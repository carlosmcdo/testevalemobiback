//Importando pacotes
package br.com.testeback.controller;

//Importando bibliotecas necessárias
import br.com.testeback.model.CustomerAccount;
import java.util.Comparator;

/**
 *
 * @author carlos
 */

//Classe que realiza uma comparação entre os clientes de um array
public class ComparatorCustomers implements Comparator<CustomerAccount>{
    @Override
    public int compare(CustomerAccount o1, CustomerAccount o2) { 
        //Se o saldo do cliente1 for maior que o saldo do cliente 2, retorne -1
        if(o1.getVl_total() > o2.getVl_total()){
            return -1;
        //Se o contrário, retorne +1
        }else if(o1.getVl_total() < o2.getVl_total()){
            return +1;
        //Senão
        }else{
            return 0;
        }
    }   
}