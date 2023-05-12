package Clases;

import Conexion.Conectar;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Cls_Salida {
    private PreparedStatement PS;
    private ResultSet RS;
    private final Conectar CN;
    private DefaultTableModel DT;
    private final String SQL_INSERT_SALIDA = "INSERT INTO salida (sal_factura, sal_pro_codigo, sal_fecha, sal_cantidad, sal_precio, sal_total) values (?,?,?,?,?,?)";
    private final String SQL_SELECT_SALIDA = "SELECT sal_factura, sal_fecha, sal_pro_codigo, pro_descripcion, sal_cantidad, sal_precio, sal_total, entrada.ent_total FROM salida INNER JOIN producto ON sal_pro_codigo = pro_codigo INNER JOIN entrada ON sal_pro_codigo = ent_pro_codigo";
    private final String SQL_SELECT_FACTURA_SALIDA = "SELECT MAX(sal.sal_id),sal.sal_factura FROM salida sal";
    
    public Cls_Salida(){
        PS = null;
        CN = new Conectar();
    }
    
    private DefaultTableModel setTitulosSalida(){
        DT = new DefaultTableModel(){
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
        DT.addColumn("Ganancia Estimada");
        return DT;
    }
    
    public String getFacturaSalida() {
        try {
            setTitulosSalida();
            PS = CN.getConnection().prepareStatement(SQL_SELECT_FACTURA_SALIDA);
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
    
    public DefaultTableModel getDatosSalida(){
        try {
            setTitulosSalida();
            PS = CN.getConnection().prepareStatement(SQL_SELECT_SALIDA);
            RS = PS.executeQuery();
            Object[] fila = new Object[8];
            while(RS.next()){
                
                int ganancia = RS.getInt(7) - RS.getInt(8);
                fila[0] = RS.getString(1);
                fila[1] = RS.getDate(2);
                fila[2] = RS.getString(3);
                fila[3] = RS.getString(4);
                fila[4] = RS.getInt(5);
                fila[5] = RS.getInt(6);
                fila[6] = RS.getInt(7);
                fila[7] = ganancia;
                DT.addRow(fila);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar los datos."+e.getMessage());
        } finally{
            PS = null;
            RS = null;
            CN.desconectar();
        }
        return DT;
    }
    
    public int registrarSalida(String nfactura, String codigo, Date fecha, int cantidad, int precio, int total){
        int res=0;
        try {
            PS = CN.getConnection().prepareStatement(SQL_INSERT_SALIDA);
            PS.setString(1, nfactura);
            PS.setString(2, codigo);
            PS.setDate(3, fecha);
            PS.setInt(4, cantidad);
            PS.setInt(5, precio);
            PS.setInt(6, total);
            res = PS.executeUpdate();
            if(res > 0){
                JOptionPane.showMessageDialog(null, "Salida realizada con éxito.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar la salida.");
            System.err.println("Error al registrar la salida." +e.getMessage());
        } finally{
            PS = null;
            CN.desconectar();
        }
        return res;
    }
    
    public int verificarStock(String codigo){
        int res=0;
        try {
            PS = CN.getConnection().prepareStatement("SELECT inv_stock from inventario where inv_pro_codigo='"+codigo+"'");
            RS = PS.executeQuery();
            
            while(RS.next()){
                res = RS.getInt(1);
            }
            
        } catch (SQLException e) {
            System.err.println("Error al devolver cantidad de registros." +e.getMessage());
        } finally{
            PS = null;
            CN.desconectar();
        }
        return res;
    }
}
