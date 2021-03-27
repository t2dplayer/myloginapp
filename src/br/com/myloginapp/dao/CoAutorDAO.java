/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.myloginapp.dao;

import br.com.myloginapp.model.CoAutor;
import br.com.myloginapp.mysql.Conexao;
import br.com.myloginapp.mysql.SQLMaker;
import br.com.myloginapp.utils.StringUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sergi
 */
public class CoAutorDAO {
    private static Connection conn = Conexao.getConexao();  
    
    public static List<CoAutor> create(ResultSet r) {
        List<CoAutor> result = null;
        try {
            while (r.next()) {
                CoAutor coautor = new CoAutor();
                coautor.setCodigo(r.getInt("codigo"));
                coautor.setNome(r.getString("nome"));
                coautor.setEmail(r.getString("email"));
                coautor.setCodigoArtigo(r.getInt("fk_artigo_codigo"));
                result.add(coautor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoAutorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public static List<CoAutor> select() {
        String sql = SQLMaker.select(SQLMaker.initMap(new String[][] {
            {"table", "coautor"},
            {"fields", "*"}
        }));
        List<CoAutor> result = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet r = stmt.executeQuery();
            result = create(r);
        } catch (SQLException ex) {
            Logger.getLogger(CoAutorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public static List<CoAutor> selectWhere(String where) {
        String sql = SQLMaker.selectWhere(SQLMaker.initMap(new String[][] {
            {"table", "coautor"},
            {"fields", "*"},
            {"conditions", where}
        }));
        List<CoAutor> result = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet r = stmt.executeQuery();
            result = create(r);        
        } catch (SQLException ex) {
            Logger.getLogger(CoAutorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static String createValues(CoAutor coautor) {
        String values = StringUtils.singleQuote(coautor.getNome());
        values += ", " + StringUtils.singleQuote(coautor.getEmail());
        String codProjeto = String.valueOf(coautor.getCodigoArtigo());
        values += ", " + StringUtils.singleQuote(codProjeto);
        return values;
    }
    
    public static boolean insert(CoAutor coautor) {       
        String values = createValues(coautor);
        String sql = SQLMaker.insert(SQLMaker.initMap(new String[][] {
            {"table", "coautor"},
            {"fields", "nome, email, fk_artigo_codigo"},
            {"values", values}
        }));
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CoAutorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
 
    public static boolean delete(int codigo) {
        boolean result = true;
        String sql = SQLMaker.delete(SQLMaker.initMap(new String[][] {
            {"table", "coautor"},
            {"conditions", "codigo = " + String.valueOf(codigo)}
        }));
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CoAutorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return result;
    }
    
    public static boolean update(CoAutor coautor) {
        String values = createValues(coautor);
        String sql = SQLMaker.update(SQLMaker.initMap(new String[][] {
            {"table", "coautor"},
            {"fields", "nome, email, fk_artigo_codigo"},
            {"values", values}
        }));
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CoAutorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }        
    }
    
}
