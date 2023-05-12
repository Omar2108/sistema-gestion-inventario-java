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
    private final String SQL_INSERT_ENTRADA = "INSERT INTO entrada (ent_factura, ent_pro_codigo, ent_fecha, ent_cantidad, ent_precio, ent_total) values (?,?,?,?,?,?)";
    private final String SQL_SELECT_ENTRADA = "SELECT ent_factura, ent_fecha, ent_pro_codigo, pro_descripcion, ent_cantidad, ent_precio, ent_total FROM entrada INNER JOIN producto ON ent_pro_codigo = pro_codigo";
    private final String SQL_SELECT_FACTURA_ENTRADA = "SELECT MAX(en.ent_id),en.ent_factura FROM entrada en";

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
                String result = RS.getString(2);

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
            Object[] fila = new Object[7];
            while (RS.next()) {
                fila[0] = RS.getString(1);
                fila[1] = RS.getDate(2);
                fila[2] = RS.getString(3);
                fila[3] = RS.getString(4);
                fila[4] = RS.getInt(5);
                fila[5] = RS.getInt(6);
                fila[6] = RS.getInt(7);
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

    public int registrarEntrada(String nfactura, String codigo, Date fecha, int cantidad, int precio, int total) {
        int res = 0;
        try {
            PS = CN.getConnection().prepareStatement(SQL_INSERT_ENTRADA);
            PS.setString(1, nfactura);
            PS.setString(2, codigo);
            PS.setDate(3, fecha);
            PS.setInt(4, cantidad);
            PS.setInt(5, precio);
            PS.setInt(6, total);
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
