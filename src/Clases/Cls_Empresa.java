/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Conexion.Conectar;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class Cls_Empresa {

    private PreparedStatement PS;
    private ResultSet RS;
    private Conectar CN;
    private DefaultTableModel DT;
    private final String SQL_INSERT_EMPRESA = "INSERT INTO empresa (nit, fecha, email,direccion, nombre, telefono) values (?,?,?,?,?,?)";
    private final String SQL_SELECT_EMPRESA = "SELECT nit, fecha, email,direccion, nombre, telefono FROM empresa";

    public Cls_Empresa() {
        PS = null;
        CN = new Conectar();
    }

    private DefaultTableModel setTitulosEmpresa() {
        DT = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        DT.addColumn("NIT");
        DT.addColumn("Fecha de Registro");
        DT.addColumn("Email");
        DT.addColumn("Direccion");
        DT.addColumn("Nombre Empresa");
        DT.addColumn("Telefono");
        return DT;
    }

    public DefaultTableModel getDatosEmpresa() {
        try {
            setTitulosEmpresa();
            PS = CN.getConnection().prepareStatement(SQL_SELECT_EMPRESA);
            RS = PS.executeQuery();
            Object[] fila = new Object[6];
            while (RS.next()) {
                fila[0] = RS.getString(1);
                fila[1] = RS.getDate(2);
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
    
    public Object[] getEmpresa(){
        
        Object[] fila = new Object[6];
        try {
            setTitulosEmpresa();
            PS = CN.getConnection().prepareStatement(SQL_SELECT_EMPRESA);
            RS = PS.executeQuery();
            
            while (RS.next()) {
                fila[0] = RS.getString(1);
                fila[1] = RS.getDate(2);
                fila[2] = RS.getString(3);
                fila[3] = RS.getString(4);
                fila[4] = RS.getString(5);
                fila[5] = RS.getString(6);
               
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

    public int registrarEmpresa(String nit, Date fecha, String email, String direccion, String nombre, String telefono) {
        int res = 0;
        try {
            PS = CN.getConnection().prepareStatement(SQL_INSERT_EMPRESA);
            PS.setString(1, nit);
            PS.setDate(2, fecha);
            PS.setString(3, email);
            PS.setString(4, direccion);
            PS.setString(5, nombre);
            PS.setString(6, telefono);
            res = PS.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Empresa registrada con éxito.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar la empresa.");
            System.err.println("Error al registrar la empresa." + e.getMessage());
        } finally {
            PS = null;
            CN.desconectar();
        }
        return res;
    }

    public int actualizarEmpresa(String nit, String email, String direccion, String nombre, String telefono) {
        //String SQL = "UPDATE empresa SET nit ='"+ nit +"',fecha ='"+fecha+"',email ='"+email+"', direccion = "+direccion+"', nombre = "+nombre+"', telefono = "+telefono+" ' WHERE nit = '"+nit+"'";
        int res = 0;
        try {
            CallableStatement cst = CN.getConnection().prepareCall("{Call sp_actualizar_empresa(?,?,?,?,?)}");
            cst.setString(1, nit);
            cst.setString(2, email);
            cst.setString(3, direccion);
            cst.setString(4, nombre);
            cst.setString(5, telefono);
            res = cst.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Datos de la empresa actualizados con éxito");
            }
        } catch (SQLException e) {
            System.err.println("Error al modificar los datos de la empresa." + e.getMessage());
        } finally {
            PS = null;
            CN.desconectar();
        }
        return res;
    }

    public int eliminarEmpresa(String nit) {
        String SQL = "DELETE from empresa WHERE nit ='" + nit + "'";
        int res = 0;
        try {
            PS = CN.getConnection().prepareStatement(SQL);
            res = PS.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, " Datos de la empresa eliminados con éxito");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No es posible eliminar los datos de la empresa.");
            System.err.println("Error al eliminar la empresa." + e.getMessage());
        } finally {
            PS = null;
            CN.desconectar();
        }
        return res;
    }

}
