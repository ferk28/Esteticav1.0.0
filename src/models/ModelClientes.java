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
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author fernando
 */

public class ModelClientes {
    private final ModelMain model_main;        

    public ModelClientes(ModelMain model_main){
        this.model_main = model_main;
    }

    private int id_cliente;
    private String nombre;
    private String genero;
    private String telefono;
    private String telefono2;
    private TableModel tabla;
    private String buscar;
    
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
            setId_cliente(rs.getInt("id_cliente"));
            setNombre(rs.getString("nombre"));
            setGenero(rs.getString("genero"));            
            setTelefono(rs.getString("telefono"));
            setTelefono2(rs.getString("telefono2"));
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "error 102" + e);
        }
    }    

    public void llenarActualizarDatos(){ //seleccionarTodos
        try{
            sql="SELECT * FROM clientes;";
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
            sql= "INSERT INTO clientes(nombre, genero, telefono, telefono2) VALUES (?,?,?,?);";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, genero);
            ps.setString(3, telefono);
            ps.setString(4, telefono2);
            ps.executeUpdate();
            moverPrimero();
            llenarActualizarDatos();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 108" + e);
        }
    }
    public void borrar(){
        try{
            sql="DELETE FROM clientes WHERE id_cliente = ?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id_cliente);
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
            sql= "UPDATE clientes SET nombre=? , genero=? , telefono=? , telefono2=? WHERE id_cliente=?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(5, id_cliente);
            ps.setString(1, nombre);
            ps.setString(2, genero);
            ps.setString(3, telefono);
            ps.setString(4, telefono2);
            ps.executeUpdate();
            moverPrimero();
            llenarActualizarDatos();
            System.out.println(sql);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 110" + e);
        }
    }
    public void buscar(){
        //sql = ("SELECT * FROM clientes WHERE nombre LIKE ('%"+buscar+"%') OR genero LIKE ('%"+buscar+"%') OR telefono LIKE ('%"+buscar+"%') OR telefono2 LIKE ('%"+buscar+"%');");
        //sql = ("SELECT * FROM clientes WHERE nombre LIKE CONCAT('%', ?) OR genero LIKE CONCAT('%', ?) OR telefono LIKE CONCAT('%', ?) OR telefono2 LIKE CONCAT('%', ?);");
        //sql = "SELECT * FROM clientes WHERE nombre LIKE ('%?%') OR genero LIKE ('%?%') OR telefono LIKE ('%?%') OR telefono2 LIKE ('%?%');";               

        try {
            sql = ("SELECT * FROM clientes WHERE nombre LIKE CONCAT('%',? '%') OR genero LIKE CONCAT('%',? '%') OR telefono LIKE CONCAT('%',? '%') OR telefono2 LIKE CONCAT('%',? '%');");            
            ps = conexion.prepareStatement(sql);
            ps.setString(1, buscar);
            ps.setString(2, buscar);
            ps.setString(3, buscar);
            ps.setString(4, buscar);
            rs = ps.executeQuery();
            System.out.println(sql);
            tabla = DbUtils.resultSetToTableModel(rs);
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "error al buscar prro" + e);
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
    
    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public TableModel getTabla() {
        return tabla;
    }

    public void setTabla(TableModel tabla) {
        this.tabla = tabla;
    }

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }    
}
