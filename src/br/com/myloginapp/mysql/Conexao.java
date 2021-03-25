/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.myloginapp.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sergi
 */
public class Conexao {
    private static Connection con  = null;
    static {
        String url ="jdbc:mysql://localhost:3306/projeto_integrado?useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String pass = "admin123";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url, user, pass);            
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar se conectar ao servidor MySQL");
//            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("Erro ao tentar se conectar ao servidor MySQL");
        }
    }
    public static Connection getConexao() {
        return con;
    }
}
