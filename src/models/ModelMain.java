/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author fernando
 */
public class ModelMain {
    private Connection  conexion;
    private Statement   st;
    private PreparedStatement ps;
    private ResultSet   rs;
    private String      sql;

    private MessageDigest md5;
    private StringBuilder string_builder;
    

    public MessageDigest getMd5() {
        return md5;
    }

    public void setMd5(MessageDigest md5) {
        this.md5 = md5;
    }

    public StringBuilder getString_builder() {
        return string_builder;
    }

    public void setString_builder(StringBuilder string_builder) {
        this.string_builder = string_builder;
    }
    
    public Connection getConexion() {
        return conexion;
    }
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    public Statement getSt() {
        return st;
    }
    public void setSt(Statement st) {
        this.st = st;
    }
    public PreparedStatement getPs() {
        return ps;
    }
    public void setPs(PreparedStatement ps) {
        this.ps = ps;
    }
    public ResultSet getRs() {
        return rs;
    }
    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
    public String getSql() {
        return sql;
    }
    
    //SQL
    public void setSql(String sql) {
        this.sql = sql;
    }

    
    public void Conectar(){
    try{
        conexion = DriverManager.getConnection("jdbc:mysql://localhost/lucylu","root","fernando");
        st = conexion.createStatement();
       
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Error 101" + e);
        }    
    }    
    public void Ejecutar_Consulta(){
        try{
            Conectar();
            rs = st.executeQuery(sql);
            //conexion.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al ejecutar consulta: " +  e);
        }
    }
    
    public void Ejecutar_Consulta_PS() {
        try {
            rs = ps.executeQuery();
            //sql_connection.close();
        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar consulta: " + e);
        }
    }
    
    public void Ejecutar_Actualizacion(){
        try{
            ps.executeUpdate();
            //conexion.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al ejecutar actualización: " + e);
        }
    }
    
    public void Ejecutar_Sentencia(){
        try{
            Conectar();
            st.execute(sql);
            //conexion.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "nel carnal" + e);
        }
    }
    
    public void Preparar_Statement(){
        try{
            Conectar();
            ps = conexion.prepareStatement(sql);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al preparar statement: " + e);
        }
    }
    
    public void Mover_Primero(){
        try{
            if(rs.isFirst() == false){
                rs.first();
            }
            else{
                //
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al mover el cursor al primer registro:" + e);
        }
    }
    
    public void Mover_Anterior(){
        try{
            if(rs.isFirst() == false){
                rs.previous();
            }
            else{
                //
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al mover el cursor al registro anterior: " + e);
        }
    }
    
    public void Mover_Siguiente(){
        try{
            if(rs.isLast() == false){
                rs.next();
            }
            else{
                //
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al mover el cursor al registro siguiente: " + e);
        }
    }
    
    public void Mover_Ultimo(){
        try{
            if(rs.isLast() == false){
                rs.last();
            }
            else{
                //
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al mover el cursor al último registro: " + e);
        }
    }
    public String Cifrar(String texto, String tipo_cifrado){
        try{
            md5 = MessageDigest.getInstance(tipo_cifrado);
            byte[] auxiliar_cifrado = md5.digest(texto.getBytes());
            string_builder = new StringBuilder();
            for(int x = 0; x < auxiliar_cifrado.length; x ++){
                string_builder.append(Integer.toHexString((auxiliar_cifrado[x] & 0xFF) | 0x100).substring(1,3));
            }
            return string_builder.toString();
        }
        catch(NoSuchAlgorithmException e){
            JOptionPane.showMessageDialog(null, "Error al cifrar la información" + e);
        }
        return "";
    }
    
}
