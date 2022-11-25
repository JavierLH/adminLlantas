package mx.uv.controller;

public class Test {
    public static void main(String[] args) {
        try {
            Conexion c = new Conexion();
            c.getConnection();
            
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
    
}