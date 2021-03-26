/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.myloginapp.dao;

import br.com.myloginapp.model.Artigo;
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
public class ArtigoDAO {
    private static Connection conn = Conexao.getConexao();  
    
    public static List<Artigo> create(ResultSet r) {
        List<Artigo> result = null;
        try {
            while (r.next()) {
                Artigo artigo = new Artigo();
                artigo.setCodigo(r.getInt("codigo"));
                artigo.setTitulo(r.getString("titulo"));
                artigo.setAutor(r.getString("autor"));
                artigo.setEmail(r.getString("email"));
                String strNatureza = r.getString("natureza");
                artigo.setNatureza(Artigo.stringToNatureza(strNatureza));
                artigo.setCodigoProjeto(r.getInt("fk_projeto_codigo"));
                result.add(artigo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArtigoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public static List<Artigo> select() {
        String sql = SQLMaker.select(SQLMaker.initMap(new String[][] {
            {"table", "artigo"},
            {"fields", "*"}
        }));
        List<Artigo> result = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet r = stmt.executeQuery();
            result = create(r);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public static List<Artigo> selectWhere(String where) {
        String sql = SQLMaker.selectWhere(SQLMaker.initMap(new String[][] {
            {"table", "artigo"},
            {"fields", "*"},
            {"conditions", where}
        }));
        List<Artigo> result = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet r = stmt.executeQuery();
            result = create(r);        
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static String createValues(Artigo artigo) {
        String values = StringUtils.singleQuote(artigo.getTitulo());
        values += ", " + StringUtils.singleQuote(artigo.getAutor());
        values += ", " + StringUtils.singleQuote(artigo.getEmail());
        String strNatureza = Artigo.naturezaToString(artigo.getNatureza());
        values += ", " + StringUtils.singleQuote(strNatureza);
        String codProjeto = String.valueOf(artigo.getCodigoProjeto());
        values += ", " + StringUtils.singleQuote(codProjeto);
        return values;
    }
    
    public static boolean insert(Artigo artigo) {       
        String values = createValues(artigo);
        String sql = SQLMaker.insert(SQLMaker.initMap(new String[][] {
            {"table", "artigo"},
            {"fields", "titulo, autor, email, natureza, fk_projeto_codigo"},
            {"values", values}
        }));
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
 
    public static boolean delete(int codigo) {
        boolean result = true;
        String sql = SQLMaker.delete(SQLMaker.initMap(new String[][] {
            {"table", "artigo"},
            {"conditions", "codigo = " + String.valueOf(codigo)}
        }));
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return result;
    }
    
    public static boolean update(Artigo artigo) {
        String values = createValues(artigo);
        String sql = SQLMaker.update(SQLMaker.initMap(new String[][] {
            {"table", "artigo"},
            {"fields", "titulo, autor, email, natureza, fk_projeto_codigo"},
            {"values", values}
        }));
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }        
    }
    
}
