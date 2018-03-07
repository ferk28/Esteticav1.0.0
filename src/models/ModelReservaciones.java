package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author fernando
 */
public class ModelReservaciones {
    ModelMain model_main;
    public ModelReservaciones(ModelMain model_main){
        this.model_main = model_main;
    }

    private int id_reservacion;
    private java.sql.Time hora;
    private java.sql.Date fecha;
    private JComboBox combobox;
    private String jtf_hora;
    private String jtf_fecha;
    private TableModel tabla;
    private String cliente;

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
    public void AsignarDatos(){
            try {
                setId_reservacion(rs.getInt("id_reservacion"));
                setHora(rs.getTime("hora"));
                setFecha(rs.getDate("fecha"));
                setCliente(rs.getString("cliente"));
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"error al asignar datos reservaciones" + ex);
            }
        }
    
    public void llenarActualizarDatos(){
        try{
            sql = "SELECT id_reservacion, hora, fecha, cliente FROM reservaciones;";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            tabla = DbUtils.resultSetToTableModel(rs);
            moverPrimero();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error al actualizar reservaciones" + e);
        }
    }
    
    public void diaReservacionHora(javax.swing.JTextField Ultima_reservacionHora){
    try{
        String consulta_completa = "";  
        
        sql = "SELECT hora FROM reservaciones ORDER BY fecha DESC LIMIT 1;";
        ps = conexion.prepareStatement(sql);
        rs = ps.executeQuery();
        rs.first();
        consulta_completa += rs.getString("hora");
        
        sql = "SELECT fecha_now FROM reservaciones ORDER BY fecha_now DESC LIMIT 1;";
        ps = conexion.prepareStatement(sql);
        rs = ps.executeQuery();
        rs.first();
        consulta_completa += rs.getString("fecha_now");
        
        Ultima_reservacionHora.setText(consulta_completa);
        
        System.out.println(rs);
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"error al llenar el dia de reservacion" + ex);
    }    
    }
    
    public void diaReservacionFecha(javax.swing.JTextField Ultima_reservacionFecha){
    try{
        String consulta_completa = "";  
        
        sql = "SELECT fecha FROM reservaciones ORDER BY fecha DESC LIMIT 1;";
        ps = conexion.prepareStatement(sql);
        rs = ps.executeQuery();
        rs.first();
        consulta_completa += rs.getString("fecha");
        
        Ultima_reservacionFecha.setText(consulta_completa);
        
        System.out.println(rs);
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"error al llenar el dia de reservacion" + ex);
    }    
    }
    public void insertar(){
        try{
          sql = "INSERT INTO reservaciones(hora, fecha, cliente) VALUES (?,?,?);";
          ps = conexion.prepareStatement(sql);
          ps.setTime(1, hora);
          ps.setDate(2, fecha);
          ps.setString(3, cliente);
          ps.executeUpdate();
          llenarActualizarDatos();
          moverPrimero();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error al insertar" + ex);
        }
    }
    public void borrar(){
        try{
            sql = "DELETE FROM reservaciones WHERE id_reservacion=?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id_reservacion);
            ps.executeUpdate();
            llenarActualizarDatos();
            moverPrimero();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "error al querer borrar reservaciones" +ex);
        }
    }
    public void modificar(){
        try {
            sql = "UPDATE reservaciones SET hora=? , fecha=?, cliente=? WHERE id_reservacion=?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(4, id_reservacion);
            ps.setTime(1, hora);
            ps.setDate(2, fecha);
            ps.setString(3, cliente);
            ps.executeUpdate();
            moverPrimero();
            llenarActualizarDatos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"error al modficar"  + e);
        }        
    }
    public void JComboboxR(javax.swing.JComboBox Combobox){
        try{
            sql = "SELECT nombre FROM clientes;";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            Combobox.removeAllItems();
            while(rs.next()){
                Combobox.addItem(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelReservaciones.class.getName()).log(Level.SEVERE, null, ex);
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
    

    public int getId_reservacion() {
        return id_reservacion;
    }

    public void setId_reservacion(int id_reservacion) {
        this.id_reservacion = id_reservacion;
    }

    public java.sql.Time getHora() {
        return hora;
    }

    public void setHora(java.sql.Time hora) {
        this.hora = hora;
    }

    public java.sql.Date getFecha() {
        return fecha;
    }

    public void setFecha(java.sql.Date fecha) {
        this.fecha = fecha;
    }

    public JComboBox getCombobox() {
        return combobox;
    }

    public void setCombobox(JComboBox combobox) {
        this.combobox = combobox;
    }

    public String getJtf_hora() {
        return jtf_hora;
    }

    public void setJtf_hora(String jtf_hora) {
        this.jtf_hora = jtf_hora;
    }

    public String getJtf_fecha() {
        return jtf_fecha;
    }

    public void setJtf_fecha(String jtf_fecha) {
        this.jtf_fecha = jtf_fecha;
    }

    public TableModel getTabla() {
        return tabla;
    }

    public void setTabla(TableModel tabla) {
        this.tabla = tabla;
    }    

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
        
}
