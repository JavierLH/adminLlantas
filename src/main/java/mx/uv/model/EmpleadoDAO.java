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


    public static String actualizaUsuario(Empleado u) {
        PreparedStatement stm = null;
        //UPDATE `ejemplo80640`.`usuario` SET `id` = '4', `username` = 'alexis', `password` = '123456' WHERE (`id` = '3');
        Connection cc = null;
        String msj = "";

        cc = c.getConnection();
        try {
            String sql = "UPDATE empleado SET idEmpleado = ?, nombre = ?, apellidoPaterno = ?,apellidoMaterno = ?,correoElectronico = ?, direccion = ?, telefono = ?, password = ?,estatus = ?,idRol = ? WHERE (idEmpleado = ?)";
            stm = (PreparedStatement) cc.prepareStatement(sql);
            stm.setInt(1, u.getIdEmpleado());
            stm.setString(2, u.getNombre());
            stm.setString(3, u.getApellidoPaterno());
            stm.setString(4, u.getApellidoMaterno());
            stm.setString(5, u.getCorreoElectronico());
            stm.setString(6, u.getDireccion());
            stm.setString(7, u.getTelefono());
            stm.setString(8, u.getPassword());
            stm.setInt(9, u.getEstatus());
            stm.setInt(10, u.getIdRol());

            if (stm.executeUpdate() > 0)
                msj = "Empleado agregado correctamente";
            else
                msj = "Algo salio mal. El empleado no se pudo agregar";
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            // vamos a liberar en este bloque todos los recursos empleando
            // se hace en orden inverso a su creación
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
                System.out.println("Closed  connection!");
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
        }

        return msj;
    }

    
}
