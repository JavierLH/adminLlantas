import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// su objetivo es independizar la lógica de negocio 
// de la comunicación con la BD
public class DAO {
    public static Conexion c = new Conexion();

    public static List<Usuario> dameUsuarios() {
        Statement stm = null;
        ResultSet rs = null;
        List<Usuario> resultado = new ArrayList<>();
        Connection cc = null;

        // falto conectarme
        cc = c.getConnection();
        try {
            String sql = "select * from usuario";
            stm = (Statement) cc.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Usuario u = new Usuario(rs.getString("id"),
                        rs.getString("username"), rs.getString("password"));
                resultado.add(u);
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
                System.out.println("Closed  connection!");
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
        }

        return resultado;
    }

    public static String crearUsuario(Usuario u) {
        PreparedStatement stm = null;
        Connection cc = null;
        String msj = "";

        cc = c.getConnection();
        try {
            String sql = "INSERT INTO usuario (id, username, password) VALUES (?,?,?)";
            stm = (PreparedStatement) cc.prepareStatement(sql);
            stm.setString(1, u.getId());
            stm.setString(2, u.getNombre());
            stm.setString(3, u.getPassword());

            if (stm.executeUpdate() > 0)
                msj = "el usuario se agrego";
            else
                msj = "el usuario no se agrego";
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

    public static String actualizaUsuario(Usuario u) {
        PreparedStatement stm = null;
        //UPDATE `ejemplo80640`.`usuario` SET `id` = '4', `username` = 'alexis', `password` = '123456' WHERE (`id` = '3');
        Connection cc = null;
        String msj = "";

        cc = c.getConnection();
        try {
            String sql = "UPDATE usuario SET id = ?, username = ?, password = ? WHERE (id = ?)";
            stm = (PreparedStatement) cc.prepareStatement(sql);
            stm.setString(1, u.getId());
            stm.setString(2, u.getNombre());
            stm.setString(3, u.getPassword());

            if (stm.executeUpdate() > 0)
                msj = "el usuario se agrego";
            else
                msj = "el usuario no se agrego";
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
