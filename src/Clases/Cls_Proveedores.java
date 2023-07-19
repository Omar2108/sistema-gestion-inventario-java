/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class Cls_Proveedores {

    private PreparedStatement PS;
    private ResultSet RS;
    private Conectar CN;
    private DefaultTableModel DT;
    private final String SQL_INSERT_PROVEEDOR = "INSERT INTO proveedores (pro_cedula_nit, razon_social, direccion, telefono, email) values (?,?,?,?,?)";
    private final String SQL_SELECT_PROVEEDORES = "SELECT pro_cedula_nit, razon_social, direccion, telefono, email FROM proveedores";

    public Cls_Proveedores() {
        PS = null;
        CN = new Conectar();
    }

    private DefaultTableModel setTitulosProveedores() {
        DT = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        DT.addColumn("Nº Documento");
        DT.addColumn("Nombre");
        DT.addColumn("Direccion");
        DT.addColumn("Telefono");
        DT.addColumn("Email");
        return DT;
    }

    public DefaultTableModel getDatosProveedores() {
        try {
            setTitulosProveedores();
            PS = CN.getConnection().prepareStatement(SQL_SELECT_PROVEEDORES);
            RS = PS.executeQuery();
            Object[] fila = new Object[5];
            while (RS.next()) {
                fila[0] = RS.getString(1);
                fila[1] = RS.getString(2);
                fila[2] = RS.getString(3);
                fila[3] = RS.getString(4);
                fila[4] = RS.getString(5);
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
    
    public ResultSet getProveedor(int doc){
        
        ResultSet res = null;
        try {
            CallableStatement cst = CN.getConnection().prepareCall("{Call sp_buscar_proveedor(?)}");
            cst.setInt(1, doc);
            res = cst.executeQuery();
            
            return res;            
            
        } catch (Exception e) {
            System.out.println("Error al consultar el usuario: " + e.getMessage());
        }
        return res;
    }

    public Object[] getProveedorByDoc(int identify) {
        Object[] fila = new Object[5];
        try {
            setTitulosProveedores();
            PS = CN.getConnection().prepareStatement("SELECT pro_cedula_nit, razon_social,direccion,telefono,email from proveedores WHERE pro_cedula_nit = '" + identify + "'");
            RS = PS.executeQuery();

            while (RS.next()) {
                fila[0] = RS.getInt(1);
                fila[1] = RS.getString(2);
                fila[2] = RS.getString(3);
                fila[3] = RS.getString(4);
                fila[4] = RS.getString(5);

            }
        } catch (SQLException e) {
            System.err.println("Error al listar los datos." + e.getMessage());
        } finally {
            PS = null;
            RS = null;
            CN.desconectar();
        }
        return fila;

    }

    public int registrarProveedor(Integer doc, String nombre, String direccion, String telefono, String email) {
        int res = 0;
        Util ut = new Util();
        try {
            PS = CN.getConnection().prepareStatement(SQL_INSERT_PROVEEDOR);
            PS.setInt(1, doc);
            PS.setString(2, nombre);
            PS.setString(3, direccion);
            PS.setString(4, telefono);
            PS.setString(5, email);

            res = PS.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Proveedor registrado con éxito.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el proveedor.");
            System.err.println("Error al registrar el proveedor." + e.getMessage());
        } finally {
            PS = null;
            CN.desconectar();
        }
        return res;
    }

    public int actualizarProveedor(Integer doc, String nombre, String direccion, String telefono, String email) {
        // String SQL = "UPDATE usuarios SET email ='" + email + "', nombre_usuario = " + nombre + "', cargo = " + cargo + " ' WHERE user = '" + user + "'";
        int res = 0;
        Util ut = new Util();
        try {
            CallableStatement cst = CN.getConnection().prepareCall("{Call sp_actualizar_proveedor(?,?,?,?,?)}");
            cst.setInt(1, doc);
            cst.setString(2, nombre);
            cst.setString(3, direccion);
            cst.setString(4, telefono);
            cst.setString(5, email);
            res = cst.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Proveedor actualizado con éxito");
            }
        } catch (SQLException e) {
            System.err.println("Error al modificar el proveedor." + e.getMessage());
        } finally {
            PS = null;
            CN.desconectar();
        }
        return res;
    }

    public int eliminarProveedor(String doc) {

        int input = Integer.parseInt(doc);
        String SQL = "DELETE from proveedores WHERE pro_cedula_nit ='" + input + "'";
        int res = 0;
        try {
            PS = CN.getConnection().prepareStatement(SQL);
            res = PS.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Proveedor eliminado con éxito");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No es posible eliminar el proveedor.");
            System.err.println("Error al eliminar el proveedor." + e.getMessage());
        } finally {
            PS = null;
            CN.desconectar();
        }
        return res;
    }

}
