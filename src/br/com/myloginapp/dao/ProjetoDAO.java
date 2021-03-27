/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.myloginapp.dao;

import br.com.myloginapp.model.Projeto;
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
public class ProjetoDAO {
    private static Connection conn = Conexao.getConexao();  
    
    public static List<Projeto> create(ResultSet r) {
        List<Projeto> result = null;
        try {
            while (r.next()) {
                Projeto projeto = new Projeto();
                projeto.setCodigo(r.getInt("codigo"));
                projeto.setNomeProjeto(r.getString("nome_projeto"));
                projeto.setNomeResposavel(r.getString("nome_responsavel"));
                projeto.setEmailResponsavel(r.getString("email_responsavel"));
                projeto.setDataInicio(r.getTimestamp("data_inicio"));
                projeto.setDataFim(r.getTimestamp("data_fim"));
                projeto.setSituacao(Projeto.stringToSituacao(r.getString("situacao")));
                result.add(projeto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public static List<Projeto> select() {
        String sql = SQLMaker.select(SQLMaker.initMap(new String[][] {
            {"table", "projeto"},
            {"fields", "*"}
        }));
        List<Projeto> result = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet r = stmt.executeQuery();
            result = create(r);
        } catch (SQLException ex) {
            Logger.getLogger(ProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public static List<Projeto> selectWhere(String where) {
        String sql = SQLMaker.selectWhere(SQLMaker.initMap(new String[][] {
            {"table", "projeto"},
            {"fields", "*"},
            {"conditions", where}
        }));
        List<Projeto> result = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet r = stmt.executeQuery();
            result = create(r);        
        } catch (SQLException ex) {
            Logger.getLogger(ProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static String createValues(Projeto projeto) {
        String values = StringUtils.singleQuote(projeto.getNomeProjeto());
        values += ", " + StringUtils.singleQuote(projeto.getNomeResposavel());
        values += ", " + StringUtils.singleQuote(projeto.getEmailResponsavel());
        values += ", " + StringUtils.singleQuote(projeto.getDataInicio().toString());
        values += ", " + StringUtils.singleQuote(projeto.getDataFim().toString());
        values += ", " + StringUtils.singleQuote(Projeto.situacaoToString(projeto.getSituacao()));
        return values;
    }
    
    public static boolean insert(Projeto projeto) {       
        String values = createValues(projeto);
        String sql = SQLMaker.insert(SQLMaker.initMap(new String[][] {
            {"table", "projeto"},
            {"fields", "nome_projeto, nome_responsavel, email_responsavel, data_inicio, data_fim, situacao"},
            {"values", values}
        }));
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
 
    public static boolean delete(int codigo) {
        boolean result = true;
        String sql = SQLMaker.delete(SQLMaker.initMap(new String[][] {
            {"table", "projeto"},
            {"conditions", "codigo = " + String.valueOf(codigo)}
        }));
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return result;
    }
    
    public static boolean update(Projeto projeto) {
        String values = createValues(projeto);
        String sql = SQLMaker.update(SQLMaker.initMap(new String[][] {
            {"table", "projeto"},
            {"fields", "nome_projeto, nome_responsavel, email_responsavel, data_inicio, data_fim, situacao"},
            {"values", values}
        }));
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }        
    }
    
}
