package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Repository {
    private final String URL = "jdbc:postgresql://localhost:5433/dishbd";
    private final String USER = "postgres";
    private final String PASSWORD = "admin";

    Connection createdConnection;

    public Repository() {
        try {
            createdConnection = DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
