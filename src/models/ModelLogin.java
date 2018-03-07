/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author fernando
 */
public class ModelLogin {
    private final ModelMain model_main;
    
    private String usuario;
    private char[] contraseña_usuario;
    private String contraseña_usuario_s;
    private String tipo_usuario;
    
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public char[] getContraseña_usuario() {
        return contraseña_usuario;
    }

    public void setContraseña_usuario(char[] contraseña_usuario) {
        try{
            this.contraseña_usuario = contraseña_usuario;
            contraseña_usuario_s = "";
            
            for (int x = 0; this.contraseña_usuario[x] != '\0'; x++) {
                contraseña_usuario_s += this.contraseña_usuario[x];
            }          
        }catch (ArrayIndexOutOfBoundsException e) {
            //
        }
    }

    public String getContraseña_usuario_s() {
        return contraseña_usuario_s;
    }

    public void setContraseña_usuario_s(String contraseña_usuario_s) {
        this.contraseña_usuario_s = contraseña_usuario_s;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }
    
    public ModelLogin(ModelMain model_main){
        this.model_main = model_main;
    }
    
    public void Verificar_Usuario(){
        try{
            contraseña_usuario_s = model_main.Cifrar(contraseña_usuario_s, "MD5");
            model_main.setSql("SELECT COUNT(Usuario)AS Verificado FROM Usuarios WHERE Usuario = ? AND Contrasena = ?;");
            model_main.Preparar_Statement();
            model_main.getPs().setString(1, usuario);
            model_main.getPs().setString(2, contraseña_usuario_s);
            model_main.Ejecutar_Consulta_PS();
            model_main.getRs().first();
            if(model_main.getRs().getString("Verificado").equals("1")){
                JOptionPane.showMessageDialog(null, "Bienvenido " + usuario);
            }
            else{
                throw new SQLException();
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
        }
    }
    
    public void Verificar_Tipo_Usuario(){
        try{
            model_main.setSql("SELECT Rol FROM Usuarios WHERE Usuario = ?;");
            model_main.Preparar_Statement();
            model_main.getPs().setString(1, usuario);
            model_main.Ejecutar_Consulta_PS();
            model_main.getRs().first();
            if (model_main.getRs().getString("Rol").equals("00")) {
                tipo_usuario = "Admin";
            } 
            else {
                tipo_usuario = "Vendedor";
            }
            System.out.println(tipo_usuario);
        }
        catch(SQLException e){
            //
        }
    }
}