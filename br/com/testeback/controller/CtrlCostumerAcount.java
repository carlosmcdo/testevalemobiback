//Importando pacotes
package br.com.testeback.controller;

//Importando bibliotecas necessárias
import br.com.testeback.model.CustomerAccount;
import br.com.testeback.util.ClassConex;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlos
 */

//Classe controle cliente, extendendo a classe ClassConex, responsável por realizar a conexão com o banco
public class CtrlCostumerAcount extends ClassConex{
    
    //Declarando os atributos necessários para realizar operações no banco de dados
    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;
    
    //Declarando atributos referentes ao objeto CustomerAccount/cliente
    private int id_customer;
    private int cpf_cnpj;
    private String nm_customer;
    private int is_active;
    private float vl_total;
    
    //Obtendo conexão com o banco e tratando os possíveis erros
    public CtrlCostumerAcount(){
        try {
            conn = this.ObterConexao();
            st = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlCostumerAcount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Função responsável por obter os atributos do objeto, executar a query e inserir as informações no banco de dados
    public boolean inserirRegistro(CustomerAccount ca){
           
        //Atributos recebendo informações do objeto (ca)
        id_customer = ca.getId_customer();
        cpf_cnpj = ca.getCpf_cnpj();
        nm_customer = ca.getNm_customer();
        is_active = ca.getIs_active();
        vl_total = ca.getVl_total();
         
        //Executando SQL e inserindo as informações do cliente no banco de dados e tratando os possiveis erros
        try {
            st.executeUpdate("INSERT INTO tb_customer_account(id_customer,cpf_cnpj,nm_customer,is_active,vl_total) VALUES "
                    + "('"+id_customer+"','"+cpf_cnpj+"','"+nm_customer+"','"+is_active+"','"+vl_total+"')");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CtrlCostumerAcount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /*
        Função responsável por realizar uma busca de todos os clientes no banco de dados
        e tratando possiveis erros.
    */
    public ArrayList<CustomerAccount> getCostumer(){
        //Declarando Array do tipo CustomerAccount que irá receber os clientes do banco
        ArrayList<CustomerAccount> customer = new ArrayList<>();
        
        try {
            //Execuntando a query que retornará todos os clientes do banco de dados
            rs = st.executeQuery("SELECT * FROM tb_customer_account");
            //Laço responsável por setar cada cliente ao Array
            while(rs.next()){
                CustomerAccount ctmAcc = new CustomerAccount();
                ctmAcc.setId_customer(rs.getInt(1));
                ctmAcc.setCpf_cnpj(rs.getInt(2));
                ctmAcc.setNm_customer(rs.getString(3));
                ctmAcc.setIs_active(rs.getInt(4));
                ctmAcc.setVl_total(rs.getFloat(5));
                customer.add(ctmAcc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CtrlCostumerAcount.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st == null){
                try {
                    this.FecharConexao();
                } catch (SQLException ex) {
                    Logger.getLogger(CtrlCostumerAcount.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //Retorna um Array com todos os clientes
        return customer;
    }
}
