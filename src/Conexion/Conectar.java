package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conectar {
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String USER = "root"; 
    private static String PASSWORD = "";
    private static String DB = "dbinventario";
    private static String URL = "jdbc:mysql://localhost:3306/"+DB+"?autoReconnect=true&useSSL=false";
    
    private Connection conn;
    
    public Conectar(){
        conn = null;
    }

    public static String getDB() {
        return DB;
    }

    public static void setDB(String DB) {
        Conectar.DB = DB;
    }

    public static String getDRIVER() {
        return DRIVER;
    }

    public static void setDRIVER(String DRIVER) {
        Conectar.DRIVER = DRIVER;
    }

    public static String getUSER() {
        return USER;
    }

    public static void setUSER(String USER) {
        Conectar.USER = USER;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static void setPASSWORD(String PASSWORD) {
        Conectar.PASSWORD = PASSWORD;
    }

    public static String getURL() {
        return URL;
    }

    public static void setURL(String URL) {
        Conectar.URL = URL;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
    public Connection getConnection(){
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error al conectar con la base de datos", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return conn;
    }
    
    public void desconectar(){
        try {
            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error al cerrar la conexion con la base de datos", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
