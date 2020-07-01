/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author HITMAN
 */
public class ConnectionDataBase {

    private static String banco = "jdbc:mysql://localhost/dbvendasbl?allowPublicKeyRetrieval=true&useSSL=false&useTimezone=true&serverTimezone=UTC";
    private static String password = "testeabc";
    private static String user = "root";
    private static Connection connection = null;
    
    static {
    conectar();
    }

    public ConnectionDataBase() {
    conectar();
    }
    
    private static void conectar(){
    
        try {
            //Driver do PostgreSQL
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            
            setConnection((Connection) DriverManager.getConnection(banco,user,password));
           
        } catch (Exception e) {
            throw  new RuntimeException("Erro ao Conectar com o Banco de Dados");
        }
    }

    /**
     * @return the connection
     */
    public static Connection getConnection() {
        return connection;
    }

    /**
     * @param aConnection the connection to set
     */
    public static void setConnection(Connection aConnection) {
        connection = aConnection;
    }
   
    
}
