package Clases;

import Conexion.Conectar;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Cls_Entrada {

    private PreparedStatement PS;
    private ResultSet RS;
    private final Conectar CN;
    private DefaultTableModel DT;
    private final String SQL_INSERT_ENTRADA = "INSERT INTO entrada (ent_factura, ent_pro_codigo, ent_fecha, ent_cantidad, ent_precio, ent_total, pro_cedula_nit) values (?,?,?,?,?,?,?)";
    private final String SQL_SELECT_ENTRADA = "SELECT e.ent_factura, e.ent_fecha, e.ent_pro_codigo, pro.pro_descripcion, e.ent_cantidad, ent_precio, e.ent_total, p.razon_social FROM entrada e INNER JOIN producto pro ON pro.pro_codigo = e.ent_pro_codigo INNER JOIN proveedores p ON p.pro_cedula_nit = e.pro_cedula_nit";
    private final String SQL_SELECT_FACTURA_ENTRADA = "SELECT MAX(en.ent_id) as consec FROM entrada en";
    
    public Cls_Entrada() {
        PS = null;
        CN = new Conectar();
    }

    private DefaultTableModel setTitulosEntrada() {
        DT = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        DT.addColumn("N° de Factura");
        DT.addColumn("Fecha");
        DT.addColumn("Código de Producto");
        DT.addColumn("Descripción");
        DT.addColumn("Cantidad");
        DT.addColumn("Precio Unitario");
        DT.addColumn("Nombre Proveedor");
        DT.addColumn("Total");
        return DT;
    }

    public String getFactura() {
        try {
            setTitulosEntrada();
            PS = CN.getConnection().prepareStatement(SQL_SELECT_FACTURA_ENTRADA);
            RS = PS.executeQuery();
            boolean next = RS.next();
            if (next) {
                String result = RS.getString(1);

                return result;

            }

        } catch (Exception e) {

            System.err.println("Error al consulta la factura." + e.getMessage());
        }
        return "No se encontraron registros";
    }

    public DefaultTableModel getDatosEntradas() {
        try {
            setTitulosEntrada();
            PS = CN.getConnection().prepareStatement(SQL_SELECT_ENTRADA);
            RS = PS.executeQuery();
            Object[] fila = new Object[8];
            while (RS.next()) {
                fila[0] = RS.getString(1);
                fila[1] = RS.getDate(2);
                fila[2] = RS.getString(3);
                fila[3] = RS.getString(4);
                fila[4] = RS.getInt(5);
                fila[5] = RS.getInt(6);
                fila[6] = RS.getString(8);
                fila[7] = RS.getInt(7);
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
    
    public Object[] getProveedor(int identify){
         Object[] fila = new Object[5];
        try {
            setTitulosEntrada();
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

    public int registrarEntrada(String nfactura, String codigo, Date fecha, int cantidad, int precio, int total, int identify) {
        int res = 0;
        try {
            PS = CN.getConnection().prepareStatement(SQL_INSERT_ENTRADA);
            PS.setString(1, nfactura);
            PS.setString(2, codigo);
            PS.setDate(3, fecha);
            PS.setInt(4, cantidad);
            PS.setInt(5, precio);
            PS.setInt(6, total);
            PS.setInt(7, identify);
            res = PS.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Entrada realizada con éxito.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar la entrada.");
            System.err.println("Error al registrar la entrada." + e.getMessage());
        } finally {
            PS = null;
            CN.desconectar();
        }
        return res;
    }
}
