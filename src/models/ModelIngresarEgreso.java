/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author fernando
 */
public class ModelIngresarEgreso {
    private final ModelMain model_main;
    
    public ModelIngresarEgreso(ModelMain model_main){
        this.model_main = model_main;
    }

    private int id_egreso;
    private String tipo_egreso;
    private String buscar;
    private int aux_tipo_egreso;
    private TableModel table;

    private String sql;
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;   

    public void Conectar(){
    try{
        conexion = DriverManager.getConnection("jdbc:mysql://localhost/lucylu","root","fernando");
        st = conexion.createStatement();
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Error 101" + e);
        }    
    }    
   public void AsignarDatos(){ //llenarValores
        try{
            setId_egreso(rs.getInt("id_egtipo"));
            setTipo_egreso(rs.getString("tipo"));
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "error 102" + e);
        }
    }    
    public void llenarActualizarDatos(){ //seleccionarTodos
        try{
            sql="SELECT * FROM egtipo;";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            table = DbUtils.resultSetToTableModel(rs);
            moverPrimero();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 107" + e);
        }
    }   
    public void insertar(){
        try{
            sql= "INSERT INTO egtipo(tipo) VALUES (?);";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, tipo_egreso);
            ps.executeUpdate();
            moverPrimero();
            llenarActualizarDatos();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 108" + e);
        }
    }    
    
     public void borrar(){
        try{
            sql="DELETE FROM egtipo WHERE id_egtipo = ?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id_egreso);
            ps.executeUpdate();
            llenarActualizarDatos();
            moverPrimero();
            System.out.println(sql + ps);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 109" + e);
        }
    }
    public void buscar(){
        try {
            sql = ("SELECT * FROM egtipo WHERE id_egtipo LIKE CONCAT('%',? '%') OR tipo LIKE CONCAT('%',? '%');");            
            ps = conexion.prepareStatement(sql);
            ps.setString(1, buscar);
            ps.setString(2, buscar);
            rs = ps.executeQuery();
            System.out.println(sql);
            table = DbUtils.resultSetToTableModel(rs);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al buscar prro alv orale!" + e);
        }

    }
    public void modificar(){
        try {
            sql = "UPDATE egtipo SET tipo=? WHERE id_egtipo=?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(2, id_egreso);
            ps.setString(1, tipo_egreso);
            ps.executeUpdate();
            moverPrimero();
            llenarActualizarDatos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"error al modficar"  + e);
        }
        
    }
    public void moverPrimero(){
        
        try{
            rs.first();
            AsignarDatos();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 103" + e);
        }
    }     
    public int getId_egreso() {
        return id_egreso;
    }

    public void setId_egreso(int id_egreso) {
        this.id_egreso = id_egreso;
    }

    public String getTipo_egreso() {
        return tipo_egreso;
    }

    public void setTipo_egreso(String tipo_egreso) {
        this.tipo_egreso = tipo_egreso;
    }

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    public int getAux_tipo_egreso() {
        return aux_tipo_egreso;
    }

    public void setAux_tipo_egreso(int aux_tipo_egreso) {
        this.aux_tipo_egreso = aux_tipo_egreso;
    }

    public TableModel getTable() {
        return table;
    }

    public void setTable(TableModel table) {
        this.table = table;
    }    
}
