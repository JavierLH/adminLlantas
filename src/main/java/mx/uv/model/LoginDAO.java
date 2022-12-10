package mx.uv.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

//import com.mysql.cj.xdevapi.Statement;

import mx.uv.controller.Conexion;

public class LoginDAO {
    public static Conexion c = new Conexion();
    
    public static List<Empleado> dameUsuarios() {
        Statement stm = null;
        ResultSet rs = null;
        List<Empleado> resultado = new ArrayList<>();
        Connection cc = null;
        // falto conectarme
        cc = c.getConnection();
        try {
            String sql = "SELECT nombre, password FROM usuario WHERE idRol =? AND estatus =1 AND ID =?";
            stm = (Statement) cc.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Empleado e = new Empleado(rs.getInt("ID"),
                        rs.getString("nombre"),
                        rs.getString("password"),
                        rs.getString("idRol"));
                resultado.add(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                    sqlEx.printStackTrace();
                }
                rs = null;
            }
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException sqlEx) {
                    sqlEx.printStackTrace();
                }
                stm = null;
            }
            try {
                cc.close();
                System.out.println("Conexion terminada :D");
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
        }
        return resultado;
    }
    
}
