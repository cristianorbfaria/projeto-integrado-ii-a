package com.projeto_integrador_ii_a.database;

import java.sql.*;

public class Database {

    private static final String USUARIO = "root";
    private static final String SENHA = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/projeto_integrador_ii_a";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public Connection open() {
        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
            return conn;
        } catch (Exception error) {
            System.err.println("Erro ao conectar com banco de dados: " + error);
            return null;
        }
    }

    public ResultSet executeQuery(StringBuilder sql) {
        try {

            Connection conn = this.open();
            PreparedStatement command = conn.prepareStatement(sql.toString());
            ResultSet result = command.executeQuery();
            return result;
        } catch (Exception error) {
            System.err.println(error);
            return null;
        }
    }

    public void executeUpdate(String sql) {
        try {
            Connection conn = this.open();
            PreparedStatement pst = conn.prepareStatement(sql);
            int result = pst.executeUpdate(sql);

            System.out.println(result);
        } catch (Exception error) {
            System.err.println(error);
        }
    }

}