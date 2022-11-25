package mx.uv.model;

import java.util.List;

import mx.uv.controller.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class EmpleadoDAO {
    public static Conexion c = new Conexion();

    public static List<Empleado> dameEmpleados() {
        Statement stm = null;
        ResultSet rs = null;
        List<Empleado> resultado = new ArrayList<>();
        Connection cc = null;

        // falto conectarme
        cc = c.getConnection();
        try {
            String sql = "SELECT * FROM empleado";
            stm = (Statement) cc.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Empleado e = new Empleado(rs.getInt("idEmpleado"),
                        rs.getString("nombre"), rs.getString("apellidoPaterno"),
                        rs.getString("apellidoMaterno"),rs.getString("correoElectronico"),
                        rs.getString("direccion"), rs.getString("telefono"),
                        rs.getString("password"), rs.getInt("estatus"),
                        rs.getInt("idRol"));
                resultado.add(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            // vamos a liberar en este bloque todos los recursos empleando
            // se hace en orden inverso a su creación
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
