/*
 * JConexao.java
 *
 * Created on 22 de Junho de 2007, 08:42
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package takttime;
import java.sql.*;
/**
 *
 * @author bruno henrique
 */

public class JConexao {
    
    private String local = "192.168.0.100";
    private String user = "admin";
    private String senha = "123456";
    private Connection c;
    private Statement statment;
    private String str_conexao;
    private String driverjdbc;
    private String bd = "PostgreSql";
    private String porta = "5432";
    private String banco = "form";
    
    /** Creates a new instance of JConexao */
    public JConexao() {
        setStr_conexao("jdbc:postgresql://"+ local +":" + porta +"/"+ banco);
        setLocal(local);
        setSenha(senha);
        setUser(user);
        setDriverjdbc("org.postgresql.Driver");
    }
    
    public void configUser(String user, String senha) {
        setUser(user);
        setSenha(senha);
    }
    
    public void configLocal(String banco) {
        setLocal(banco);
    }
    
    //Conex�o com o Banco de Dados
    public void conect(){
        try {
            Class.forName(getDriverjdbc());
            setC(DriverManager.getConnection(getStr_conexao(), getUser(), getSenha()));
            setStatment(getC().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));
            
        }catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }
    
    public void disconect(){
        try {
            getC().close();
        }catch (SQLException ex) {
            System.err.println(ex);
            ex.printStackTrace();
        }
    }
    
    public ResultSet query(String query){
        try {
            return getStatment().executeQuery(query);
        }catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }    
    
    // GETs AND SETs
    public String getLocal() {
        return local;
    }    
    
    public void setLocal(String local) {
        this.local = local;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Connection getC() {
        return c;
    }

    public void setC(Connection c) {
        this.c = c;
    }

    public Statement getStatment() {
        return statment;
    }

    public void setStatment(Statement statment) {
        this.statment = statment;
    }

    public String getStr_conexao() {
        return str_conexao;
    }

    public void setStr_conexao(String str_conexao) {
        this.str_conexao = str_conexao;
    }

    public String getDriverjdbc() {
        return driverjdbc;
    }

    public void setDriverjdbc(String driverjdbc) {
        this.driverjdbc = driverjdbc;
    }    
}
