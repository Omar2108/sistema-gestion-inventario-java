/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Conexion.Conectar;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class Cls_Usuarios {

    private PreparedStatement PS;
    private ResultSet RS;
    private Conectar CN;
    private DefaultTableModel DT;
    private final String SQL_INSERT_USUARIO = "INSERT INTO usuarios (user, pass,nombre_usuario, email, cargo) values (?,?,?,?,?)";
    private final String SQL_SELECT_USUARIO = "SELECT id,user,pass, nombre_usuario, email, cargo FROM usuarios";

    public Cls_Usuarios() {
        PS = null;
        CN = new Conectar();
    }

    private DefaultTableModel setTitulosUsuario() {
        DT = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        DT.addColumn("ID");
        DT.addColumn("Usuario");
        DT.addColumn("Clave");
        DT.addColumn("Nombre Usuario");
        DT.addColumn("Email");
        DT.addColumn("Cargo");
        return DT;
    }

    public DefaultTableModel getDatosUsuarios() {
        try {
            setTitulosUsuario();
            PS = CN.getConnection().prepareStatement(SQL_SELECT_USUARIO);
            RS = PS.executeQuery();
            Object[] fila = new Object[6];
            while (RS.next()) {
                fila[0] = RS.getString(1);
                fila[1] = RS.getString(2);
                fila[2] = RS.getString(3);
                fila[3] = RS.getString(4);
                fila[4] = RS.getString(5);
                fila[5] = RS.getString(6);
                DT.addRow(fila);

            }
        } catch (SQLException e) {
            System.err.println("Error al listar los datos." + e.getMessage());
        } finally {
            PS = null;
            RS = null;
            CN.desconectar();
        }
        return DT;
    }
    
    public ResultSet getUsuario(String user){
        
        ResultSet res = null;
        try {
            CallableStatement cst = CN.getConnection().prepareCall("{Call sp_buscar_usuario(?)}");
            cst.setString(1, user);
            res = cst.executeQuery();
            
            return res;            
            
        } catch (Exception e) {
            System.out.println("Error al consultar el usuario: " + e.getMessage());
        }
        return res;
    }

    public int registrarUsuario(String user, String pass, String nombre, String email, String cargo) {
        int res = 0;
        Util ut = new Util();
        try {
            PS = CN.getConnection().prepareStatement(SQL_INSERT_USUARIO);
            PS.setString(1, user);
            PS.setString(2, ut.Encriptar(pass));
            PS.setString(3, nombre);
            PS.setString(4, email);
            PS.setString(5, cargo);

            res = PS.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Usuario registrado con éxito.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el usuario.");
            System.err.println("Error al registrar el usuario." + e.getMessage());
        } finally {
            PS = null;
            CN.desconectar();
        }
        return res;
    }

    public int actualizarUsuario(String user,String pass, String email, String nombre, String cargo, int id) {
       // String SQL = "UPDATE usuarios SET email ='" + email + "', nombre_usuario = " + nombre + "', cargo = " + cargo + " ' WHERE user = '" + user + "'";
        int res = 0;
        Util ut = new Util();
        try {
            CallableStatement cst = CN.getConnection().prepareCall("{Call sp_actualizar_usuario(?,?,?,?,?,?)}");
            cst.setString(1, user);
            cst.setString(2, ut.Encriptar(pass));
            cst.setString(3, email);
            cst.setString(4, nombre);
            cst.setString(5, cargo);
            cst.setInt(6, id);
            res = cst.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Usuario actualizado con éxito");
            }
        } catch (SQLException e) {
            System.err.println("Error al modificar el usuario." + e.getMessage());
        } finally {
            PS = null;
            CN.desconectar();
        }
        return res;
    }

    public int eliminarUsuario(String user) {
        String SQL = "DELETE from usuarios WHERE user ='" + user + "'";
        int res = 0;
        try {
            PS = CN.getConnection().prepareStatement(SQL);
            res = PS.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Usuario eliminado con éxito");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No es posible eliminar el usuario.");
            System.err.println("Error al eliminar el usuario." + e.getMessage());
        } finally {
            PS = null;
            CN.desconectar();
        }
        return res;
    }

}
