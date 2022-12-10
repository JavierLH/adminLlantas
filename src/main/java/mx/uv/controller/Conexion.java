package mx.uv.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static String url = "jdbc:mysql://127.0.0.1:3306/adminLlantas";
    private static String DriverName = "com.mysql.jdbc.Driver";
    private static String username = "root";
    private static String password = "coches3";
    private static Connection connection = null;

    public static Connection getConnection(){
        try {
            Class.forName(DriverName);
            connection = (Connection) DriverManager.getConnection(url, username, password);
            System.out.println("listo conectado");
        } catch (SQLException e){
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println("no encontro el driver");
        }
        return connection;
    }
    
}