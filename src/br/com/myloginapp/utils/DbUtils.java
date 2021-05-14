/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.myloginapp.utils;

import br.com.myloginapp.dao.ProjetoDAO;
import br.com.myloginapp.mysql.Conexao;
import br.com.myloginapp.mysql.SQLMaker;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sergi
 */
public class DbUtils {
    public static ResultSet selectAll(String tableName) {
        //public static Connection conn = Conexao.getConexao();
        String sql = SQLMaker.selectWhere(SQLMaker.initMap(new String[][] {
            {"table", tableName},
            {"fields", "*"},
            {"conditions", "1"}
        }));
        ResultSet rs = null;
        Statement st;
        try {
            st = Conexao.getConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }    
    public static DefaultTableModel buildTableModel(ResultSet rs)
            throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }
        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames);
    }
}
