package br.com.myloginapp.dao;

import br.com.myloginapp.model.TCC;
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

public class TCCDAO {
    private static Connection conn = Conexao.getConexao();  
    
    public static List<TCC> create(ResultSet r) {
        List<TCC> result = null;
        try {
            while (r.next()) {
                TCC tcc = new TCC();
                tcc.setCodigo(r.getInt("codigo"));
                tcc.setTitulo(r.getString("titulo"));
                tcc.setAutor(r.getString("autor"));
                String strSituacao = r.getString("situacao");
                tcc.setSituacao(TCC.stringToSituacao(strSituacao));
                tcc.setCodigoProjeto(r.getInt("fk_projeto_codigo"));
                result.add(tcc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TCCDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public static List<TCC> select() {
        String sql = SQLMaker.select(SQLMaker.initMap(new String[][] {
            {"table", "user"},
            {"fields", "*"}
        }));
        List<TCC> result = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet r = stmt.executeQuery();
            result = create(r);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public static List<TCC> selectWhere(String where) {
        String sql = SQLMaker.selectWhere(SQLMaker.initMap(new String[][] {
            {"table", "tcc"},
            {"fields", "*"},
            {"conditions", where}
        }));
        List<TCC> result = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet r = stmt.executeQuery();
            result = create(r);        
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static String createValues(TCC tcc) {
        String values = StringUtils.singleQuote(tcc.getTitulo());
        values += ", " + StringUtils.singleQuote(tcc.getAutor());
        String strSitucao = TCC.situacaoToString(tcc.getSituacao());
        values += ", " + StringUtils.singleQuote(strSitucao);
        String codProjeto = String.valueOf(tcc.getCodigoProjeto());
        values += ", " + StringUtils.singleQuote(codProjeto);
        return values;
    }
    
    public static boolean insert(TCC tcc) {       
        String values = createValues(tcc);
        String sql = SQLMaker.insert(SQLMaker.initMap(new String[][] {
            {"table", "user"},
            {"fields", "username, email, password"},
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
            {"table", "tcc"},
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
    
    public static boolean update(TCC tcc) {
        String values = createValues(tcc);
        String sql = SQLMaker.update(SQLMaker.initMap(new String[][] {
            {"table", "tcc"},
            {"fields", "titulo, autor, situacao, fk_projeto_codigo"},
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
