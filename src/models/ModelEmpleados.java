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
public class ModelEmpleados {
    private final ModelMain model_main;
    
    public ModelEmpleados(ModelMain model_main){
        this.model_main = model_main;
    }
    private int id_empleado;
    private String nombre;
    private int edad;
    private String genero;
    private String clave_elector;
    private String telefono;
    private String telefono2;
    private String identificaciones;
    private TableModel tabla_empleados;

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
            setId_empleado(rs.getInt("id_empleado"));
            setNombre(rs.getString("nombre"));
            setEdad(rs.getInt("edad"));
            setGenero(rs.getString("genero")); 
            setClave_elector(rs.getString("clavelector"));
            setTelefono(rs.getString("telefono"));
            setTelefono2(rs.getString("telefono2"));
            setIdentificaciones(rs.getString("identificacion"));
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "error 102" + e);
        }
    }    

    public void llenarActualizarDatos(){ //seleccionarTodos
        try{
            sql="SELECT * FROM empleados;";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            tabla_empleados = DbUtils.resultSetToTableModel(rs);
            moverPrimero();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 107" + e);
        }
    }
    
    public void insertar(){
        try{
            sql= "INSERT INTO empleados(nombre, edad, genero, clavelector, telefono, telefono2, identificacion) VALUES (?,?,?,?,?,?,?);";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setInt(2, edad);
            ps.setString(3, genero);
            ps.setString(4, clave_elector);
            ps.setString(5, telefono);
            ps.setString(6, telefono2);
            ps.setString(7, identificaciones);
            ps.executeUpdate();
            moverPrimero();
            llenarActualizarDatos();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 108" + e);
        }
    }
    public void borrar(){
        try{
            sql="DELETE FROM empleados WHERE id_empleado = ?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id_empleado);
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
            sql= "UPDATE empleados SET nombre=? , edad = ? , genero=? , clavelector=? , telefono=? , telefono2=? , identificacion=? WHERE id_empleado=?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(8, id_empleado);
            ps.setString(1, nombre);
            ps.setInt(2, edad);
            ps.setString(3, genero);
            ps.setString(4, clave_elector);
            ps.setString(5, telefono);
            ps.setString(6, telefono2);
            ps.setString(7, identificaciones);
            ps.executeUpdate();
            moverPrimero();
            llenarActualizarDatos();
            System.out.println(sql);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 110" + e);
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
    
    
    public TableModel getTabla_empleados() {
        return tabla_empleados;
    }

    public void setTabla_empleados(TableModel tabla_empleados) {
        this.tabla_empleados = tabla_empleados;
    }
    
    
    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getClave_elector() {
        return clave_elector;
    }

    public void setClave_elector(String clave_elector) {
        this.clave_elector = clave_elector;
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

    public String getIdentificaciones() {
        return identificaciones;
    }

    public void setIdentificaciones(String identificaciones) {
        this.identificaciones = identificaciones;
    }

}
