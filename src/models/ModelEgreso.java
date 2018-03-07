/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author fernando
 */
public class ModelEgreso {
    private final ModelMain model_main;
    
    public ModelEgreso(ModelMain model_main){
        this.model_main = model_main;
    }
private int id_egreso;
    private int monto;
    private int cantidad;
    private Date fecha;
    private String tipo_egreso;
    private TableModel tabla;
    private JComboBox jcombo;
    
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql; 
    

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
            setId_egreso(rs.getInt("id_egreso"));
            setMonto(rs.getInt("monto"));
            setCantidad(rs.getInt("cantidad"));            
            setFecha(rs.getDate("fecha"));
            setTipo_egreso(rs.getString("tipo_egreso"));
                        
        }catch(SQLException e){
           // JOptionPane.showMessageDialog(null, "error 102" + e);
        }
    }    

    public void llenarActualizarDatos(){ //seleccionarTodos
        try{
            sql="SELECT * FROM egresos;";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            tabla = DbUtils.resultSetToTableModel(rs);
            moverPrimero();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 107" + e);
        }
    }
    
    public void insertar(){
        try{
            sql= "INSERT INTO egresos(monto, cantidad, fecha, tipo_egreso) VALUES (?,?,?,?);";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, monto);
            ps.setInt(2, cantidad);
            ps.setDate(3, fecha);
            ps.setString(4, tipo_egreso);
            ps.executeUpdate();
            moverPrimero();
            llenarActualizarDatos();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 108" + e);
        }
    }
    public void borrar(){
        try{
            sql="DELETE FROM egresos WHERE id_egreso = ?;";
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
    public void modificar(){
        try{
            sql= "UPDATE egresos SET monto=? , cantidad=? , fecha=?, tipo_egreso=? WHERE id_egreso=?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(5, id_egreso);
            ps.setInt(1, monto);
            ps.setInt(2, cantidad);
            ps.setDate(3, fecha);
            ps.setString(4, tipo_egreso);
            ps.executeUpdate();
            moverPrimero();
            llenarActualizarDatos();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 110" + e);
        }
    
    }
    public void JCombobox(javax.swing.JComboBox Combobox){
        try {

            sql = "SELECT tipo FROM egtipo";            
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            Combobox.removeAllItems();
            
            while(rs.next()){
               Combobox.addItem(rs.getString("tipo"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error combobox" + e);
        }
    }

/**********************************BOTONES NAVEGACION **********************************************/    

    public void moverPrimero(){
        
        try{
            rs.first();
            AsignarDatos();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 103" + e);
        }
    }
    public void moverUltimo(){
        try{
            rs.last();
            AsignarDatos();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 104" + e);
        }
    }
    public void moverSiguiente(){
        try{
            if(rs.isLast() == false)
            rs.next();
            AsignarDatos();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 105" + e);
        }
    }
    public void moverAnterior(){
        try{
            if(rs.isFirst() == false)
            rs.previous();
            AsignarDatos();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 106" + e);
        }
    }    
    
/*********************************SETTER Y GETTERS**************************************************/    
    
    public int getId_egreso() {
        return id_egreso;
    }

    public void setId_egreso(int id_egreso) {
        this.id_egreso = id_egreso;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo_egreso() {
        return tipo_egreso;
    }

    public void setTipo_egreso(String tipo_egreso) {
        this.tipo_egreso = tipo_egreso;
    }
    
    public TableModel getTabla() {
        return tabla;
    }

    public void setTabla(TableModel tabla) {
        this.tabla = tabla;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
