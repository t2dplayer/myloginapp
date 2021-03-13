/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.myloginapp.dao;

import br.com.myloginapp.model.User;
import br.com.myloginapp.mysql.Conexao;
import br.com.myloginapp.mysql.SQLMaker;
import br.com.myloginapp.utils.StringUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sergi
 */
public class UserDAO {
    private static Connection conn = Conexao.getConexao();
    public static List<User> select() {
        String sql = SQLMaker.select(SQLMaker.initMap(new String[][] {
            {"table", "user"},
            {"fields", "*"}
        }));
        List<User> result = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet r = stmt.executeQuery();
            while (r.next()) {
                User user = new User();
                user.setId(r.getInt("id"));
                user.setUsername(r.getString("username"));
                user.setEmail(r.getString("email"));
                user.setPassword(r.getString("password"));
                user.setCreateTime(r.getTimestamp("create_time"));
                result.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public static List<User> selectWhere(String where) {
        String sql = SQLMaker.selectWhere(SQLMaker.initMap(new String[][] {
            {"table", "user"},
            {"fields", "*"},
            {"conditions", where}
        }));
        System.out.println(sql);
        List<User> result = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet r = stmt.executeQuery();
            while (r.next()) {
                User user = new User();
                user.setId(r.getInt("id"));
                user.setUsername(r.getString("username"));
                user.setEmail(r.getString("email"));
                user.setPassword(r.getString("password"));
                user.setCreateTime(r.getTimestamp("create_time"));
                result.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static boolean insert(User user) {       
        String values = StringUtils.singleQuote(user.getUsername());
        values += ", " + StringUtils.singleQuote(user.getEmail());
        values += ", " + StringUtils.singleQuote(user.getPassword());
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
}
