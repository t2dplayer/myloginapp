/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.myloginapp;

import br.com.myloginapp.mysql.Conexao;
import br.com.myloginapp.mysql.SQLMaker;
import br.com.myloginapp.view.Login;
import java.sql.Connection;
import java.util.Map;

/**
 *
 * @author sergi
 */
public class MyLoginApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    
}
