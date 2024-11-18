package com.generation.gestorepersonefx.helpers;

import java.sql.*;

public class DbHelper {

    private static DbHelper instance;

    public static DbHelper getInstance()
    {
        if(instance == null)
            instance = new DbHelper();

        return instance;
    }

    Connection conn;


    private DbHelper() {
        String url = "jdbc:mysql://localhost:3306/gestorepersone";
        String username = "jaita";
        String password = "jaita";

        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connessione al database stabilita con successo!");
        } catch (SQLException e) {
            System.err.println("Errore durante la connessione al database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public ResultSet executeSelect(String query) {
        try{
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(query);
            return result;
        }catch(SQLException e){
            System.err.println("Query errata, messaggio errore: ");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void executeDML(String query) {
        try{
            Statement statement = conn.createStatement();
            statement.execute(query);

        }catch(SQLException e){
            System.err.println("Query errata, messaggio errore: ");
            System.out.println(e.getMessage());
        }
    }
}