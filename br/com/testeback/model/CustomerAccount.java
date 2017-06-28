//Importando pacote
package br.com.testeback.model;

/**
 *
 * @author carlos
 */
//Classe modelo do consumidor
public class CustomerAccount {
    
    /*
        Atributos:
        id, cpf/cnpf, nome, ativo, saldo
    */
    private int id_customer;
    private int cpf_cnpj;
    private String nm_customer;
    private int is_active;
    private float vl_total;

    //Construtor sem parâmetros    
    public CustomerAccount() {
    }

    //Construtor com todos os parâmetros
    public CustomerAccount(int id_customer, int cpf_cnpj, String nm_customer, int is_active, float vl_total) {
        this.id_customer = id_customer;
        this.cpf_cnpj = cpf_cnpj;
        this.nm_customer = nm_customer;
        this.is_active = is_active;
        this.vl_total = vl_total;
    }

    //Getters e Setters necessários para as manupilações das informações 
    public int getId_customer() {
        return id_customer;
    }
    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public int getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(int cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getNm_customer() {
        return nm_customer;
    }

    public void setNm_customer(String nm_customer) {
        this.nm_customer = nm_customer;
    }

    public int getIs_active() {
        return is_active;
    }

    public void setIs_active(int is_active) {
        this.is_active = is_active;
    }

    public float getVl_total() {
        return vl_total;
    }

    public void setVl_total(float vl_total) {
        this.vl_total = vl_total;
    }
}
