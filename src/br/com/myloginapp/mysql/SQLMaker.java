package br.com.myloginapp.mysql;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SQLMaker {
    
    public static Map<String, String> initMap(String[][] keysValues) {
        Map<String, String> map = Stream.of(keysValues).collect(Collectors.toMap(data -> data[0], data -> data[1]));
        return map;
    }
    
    public static String replaceParams(Map<String, String> hashMap, String template) {
        return hashMap.entrySet().stream().reduce(template, (s, e) -> s.replace("{" + e.getKey() + "}", e.getValue()),
                (s, s2) -> s);
    }

    public static String select(Map<String, String> options) {
        final String SQL = "SELECT {fields} FROM {table};";
        return replaceParams(options, SQL);        
    }

    public static String selectWhere(Map<String, String> options) {
        final String SQL = "SELECT {fields} FROM {table} WHERE {conditions};";
        return replaceParams(options, SQL);        
    }

    
    // INSERT INTO livros (titulo) VALUES ('orgulho e preconceito');
    public static String insert(Map<String, String> options) {
        final String SQL = "INSERT INTO {table} ({fields}) VALUES ({values});";
        return replaceParams(options, SQL);
    };
    // DELETE from livros WHERE id=2;
    public static String delete(Map<String, String> options) {
        final String SQL = "DELETE FROM {table} WHERE {conditions};";
        return replaceParams(options, SQL);
    
    };
    //UPDATE livros SET disponivel=1 WHERE titulo='O Diário de Anne Frank';
    public static String update(Map<String, String> options) {
        final String SQL = "UPDATE {table} SET {fields} WHERE {conditions};";
        return replaceParams(options, SQL);

    };
}
