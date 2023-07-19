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
public class Cls_Clientes {
    
    private PreparedStatement PS;
    private ResultSet RS;
    private Conectar CN;
    private DefaultTableModel DT;
    private final String SQL_INSERT_CLIENTE = "INSERT INTO clientes (cli_cedula_nit, cli_nombre, cli_direccion, cli_telefono, cli_email) values (?,?,?,?,?)";
    private final String SQL_SELECT_CLIENTE = "SELECT cli_cedula_nit, cli_nombre, cli_direccion, cli_telefono, cli_email FROM clientes";

    public Cls_Clientes() {
        PS = null;
        CN = new Conectar();
    }

    private DefaultTableModel setTitulosClientes() {
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

    public DefaultTableModel getDatosClientes() {
        try {
            setTitulosClientes();
            PS = CN.getConnection().prepareStatement(SQL_SELECT_CLIENTE);
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
    
    public ResultSet getCliente(int doc){
        
        ResultSet res = null;
        try {
            CallableStatement cst = CN.getConnection().prepareCall("{Call sp_buscar_cliente(?)}");
            cst.setInt(1, doc);
            res = cst.executeQuery();
            
            return res;            
            
        } catch (Exception e) {
            System.out.println("Error al consultar el usuario: " + e.getMessage());
        }
        return res;
    }
    
     public Object[] getClienteByDoc(int identify){
         Object[] fila = new Object[5];
        try {
            setTitulosClientes();
            PS = CN.getConnection().prepareStatement("SELECT cli_cedula_nit, cli_nombre,cli_direccion,cli_telefono,cli_email from clientes WHERE cli_cedula_nit = '" + identify + "'");
            RS = PS.executeQuery();
            
            while (RS.next()) {
                fila[0] = RS.getInt(1);
                fila[1] = RS.getString(2);
                fila[2] = RS.getString(3);
                fila[3] = RS.getString(4);
                fila[4] = RS.getString(5);
               
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar los datos." + e.getMessage());
        } finally {
            PS = null;
            RS = null;
            CN.desconectar();
        }
        return fila;
        
    }

    public int registrarCliente(Integer doc,String nombre, String direccion,String telefono, String email) {
        int res = 0;
        Util ut = new Util();
        try {
            PS = CN.getConnection().prepareStatement(SQL_INSERT_CLIENTE);
            PS.setInt(1, doc);
            PS.setString(2, nombre);
            PS.setString(3, direccion);
            PS.setString(4, telefono);
            PS.setString(5, email);

            res = PS.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Cliente registrado con éxito.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el cliente.");
            System.err.println("Error al registrar el cliente." + e.getMessage());
        } finally {
            PS = null;
            CN.desconectar();
        }
        return res;
    }

    public int actualizarCliente(Integer doc,String nombre, String direccion,String telefono, String email) {
       // String SQL = "UPDATE usuarios SET email ='" + email + "', nombre_usuario = " + nombre + "', cargo = " + cargo + " ' WHERE user = '" + user + "'";
        int res = 0;
        Util ut = new Util();
        try {
            CallableStatement cst = CN.getConnection().prepareCall("{Call sp_actualizar_cliente(?,?,?,?,?)}");
            cst.setInt(1, doc);
            cst.setString(2, nombre);
            cst.setString(3, direccion);
            cst.setString(4, telefono);
            cst.setString(5, email);
            res = cst.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Cliente actualizado con éxito");
            }
        } catch (SQLException e) {
            System.err.println("Error al modificar el cliente." + e.getMessage());
        } finally {
            PS = null;
            CN.desconectar();
        }
        return res;
    }

    public int eliminarCliente(String doc) {
        
        int input = Integer.parseInt(doc);
        String SQL = "DELETE from clientes WHERE cli_cedula_nit ='" + input + "'";
        int res = 0;
        try {
            PS = CN.getConnection().prepareStatement(SQL);
            res = PS.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Cliente eliminado con éxito");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No es posible eliminar el cliente.");
            System.err.println("Error al eliminar el cliente." + e.getMessage());
        } finally {
            PS = null;
            CN.desconectar();
        }
        return res;
    }
    
}
