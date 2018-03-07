/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author fernando
 */
public class ModelInventario {
    private final ModelMain model_main;     
    
    public ModelInventario(ModelMain model_main){
    this.model_main = model_main;
    }
    
    private String sql;

    private int id_articulo;
    private String nombre;
    private int cantidad;
    private String estado;
    private TableModel tabla_articulo;
    private String imagen;
    
    
public void AsignarDatos(){
        try{
            id_articulo = model_main.getRs().getInt("id_articulo");
            nombre = model_main.getRs().getString("nombre");
            cantidad = model_main.getRs().getInt("cantidad");
            estado = model_main.getRs().getString("estado");
            
        }catch(SQLException e){
      //      JOptionPane.showMessageDialog(null, "error 202" + e);
        }
    }    
   
    public void llenarActualizarDatos(){
        model_main.setSql("SELECT * FROM inventario;");
        model_main.Ejecutar_Consulta();
        tabla_articulo = DbUtils.resultSetToTableModel(model_main.getRs());
        model_main.Mover_Primero();
        AsignarDatos();

    }

    public void insertar(){
        try{
            
            model_main.setSql("INSERT INTO inventario(id_articulo, nombre, cantidad, estado) VALUES (?,?,?,?);");
            model_main.Preparar_Statement();
            model_main.getPs().setInt(1, id_articulo);
            model_main.getPs().setString(2, nombre);
            model_main.getPs().setInt(3, cantidad);
            model_main.getPs().setString(4, estado);
            model_main.Ejecutar_Actualizacion();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 208" + e);
        }
    }
    public void borrar(){
        try{
            model_main.setSql("DELETE FROM clientes WHERE id_articulo = ?;");
            model_main.Preparar_Statement();
            model_main.getPs().setInt(1, id_articulo);
            model_main.Ejecutar_Actualizacion();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 209" + e);
        }
    }
    public void modificar(){
        try{
            model_main.setSql("UPDATE inventario SET nombre=? , cantidad=? , estado=? WHERE id_articulo=?;");
            model_main.Preparar_Statement();
            model_main.getPs().setInt(5, id_articulo);
            model_main.getPs().setString(1, nombre);
            model_main.getPs().setInt(2, cantidad);
            model_main.getPs().setString(3, estado);
            model_main.Ejecutar_Actualizacion();

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 210" + e);
        }
    }
    
    
    
    
    
    
    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public int getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(int id_articulo) {
        this.id_articulo = id_articulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public TableModel getTabla_articulo() {
        return tabla_articulo;
    }

    public void setTabla_articulo(TableModel tabla_articulo) {
        this.tabla_articulo = tabla_articulo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }    
}
