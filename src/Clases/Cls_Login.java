/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Conexion.Conectar;
import Formularios.Frm_Principal;
import static Formularios.Frm_Principal.usuario;
import static Formularios.Frm_Principal.cargo;
import static Formularios.Frm_Principal.btn_usuarios;
import java.awt.HeadlessException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static Formularios.Frm_Principal.btn_empresa;

/**
 *
 * @author LENOVO
 */
public class Cls_Login {

    private PreparedStatement PS;
    private ResultSet RS;
    private final Conectar CN;

    public Cls_Login() {
        PS = null;
        CN = new Conectar();
    }

    public Object[] getUsuario(String user, String pass) {

        Object[] fila = new Object[6];
        try {
            String SQL = "SELECT id,user, pass, nombre_usuario, email, cargo FROM usuarios WHERE user = '" + user + " AND pass = '" + pass + "'";

            PS = CN.getConnection().prepareStatement(SQL);
            RS = PS.executeQuery();
            RS.next();

            fila[0] = RS.getString(1);
            fila[1] = RS.getString(2);
            fila[2] = RS.getString(3);
            fila[3] = RS.getString(4);
            fila[4] = RS.getString(5);
            fila[5] = RS.getString(6);

            System.out.println(RS.getString(4));

            return fila;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            PS = null;
            RS = null;
            CN.desconectar();
        }
        return fila;

    }

    public void consultarUsuario(String user, String pass) {

        // Se inicializa a null
        String usuarioCorrecto = null;
        String passCorrecto = null;
        try {
            //String SQL = "SELECT user, pass,nombre_usuario, cargo FROM usuarios ";
            CallableStatement cst = CN.getConnection().prepareCall("{Call sp_validar_usuario(?,?)}");
            cst.setString(1, user);
            cst.setString(2, pass);
            RS = cst.executeQuery();

            if (RS.next()) {
                usuarioCorrecto = RS.getString(1);
                passCorrecto = RS.getString(2);
                System.out.println(usuarioCorrecto + " " + passCorrecto);
            }

            if (user.equals(usuarioCorrecto) && pass.equals(passCorrecto)) {
                JOptionPane.showMessageDialog(null, "Login correcto Bienvenido " + RS.getString(3));
         
                Frm_Principal ing = new Frm_Principal();
                ing.setVisible(true);
                ing.show();
                 if (!usuarioCorrecto.equals("admin")) {
                    btn_empresa.setEnabled(false);
                    btn_usuarios.setEnabled(false);
                    
                }
                usuario.setText((String) RS.getString(3));
                cargo.setText((String) RS.getString(4));
            } else if (!user.equals(usuarioCorrecto) || pass.equals(passCorrecto)) {

                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
    }

}
