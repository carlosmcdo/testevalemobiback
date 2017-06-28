//Importando pacote
package br.com.testeback.util;

//Importando bibliotecas necessárias
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author carlos
 */
public class ClassConex {
    
    //Variáveias necessárias para guardar as informações para a conexão com o banco de dados
    public String driver, urlbd, usrbd, passbd;
    
    //Conexão
    public Connection conexao;
    
    //Classe que retorna a conexão com o banco
    public ClassConex() {
        
        /*
            Atributos recebendo informações necessárias para a conexão.
            JDBC, Usuário, Senha e Banco
        */
        
        driver = "com.mysql.jdbc.Driver";
        usrbd = "root";
        urlbd = "jdbc:mysql://localhost/TesteBack";
        passbd = "291215";
        
        /*
            Tratando possiveis erros ao criar numa nova instância com o JDBC e utilizando as informações para
            a conexão
        */
        try {
            Class.forName(driver).newInstance();
            conexao = DriverManager.getConnection(urlbd, usrbd, passbd);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            System.out.println("Conexão com a base de dados: falha - " + e.getLocalizedMessage());
        }
    }

    //Função responsável por retornar a conexão 
    public Connection ObterConexao() {
        return conexao;
    }

    //Função responsável por fechar a conexão
    public Connection FecharConexao() throws SQLException {
        conexao.close();
        conexao = null;
        return conexao;
    }
}
