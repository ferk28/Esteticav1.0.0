package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import sun.util.calendar.CalendarDate;

/**
 *
 * @author fernando
 */
public class ModelServicios {
    ModelMain model_main;
    
    public ModelServicios(ModelMain model_main){
        this.model_main = model_main;
    }

    private int id_servicio;
    private int costo;
    private String j_corte;
    private String j_empleado;
    private String j_trabajo;
    private String j_cliente;
    private JComboBox tipo_corte;
    private JComboBox empleado;
    private JComboBox cliente;
    private JComboBox trabajo;
    private TableModel tabla_servicios;
    private TableModel tabla_reservaciones;
    private String fecha;

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
                setId_servicio(rs.getInt("id_servicio"));
                setCosto(rs.getInt("costo"));
                setJ_corte(rs.getString("tipcorte"));
                setJ_trabajo(rs.getString("trabajo"));
                setJ_cliente(rs.getString("cliente"));
                setJ_empleado(rs.getString("empleado"));
                
            } catch (SQLException ex) {
                //JOptionPane.showMessageDialog(null,"error al asignar datos 901" + ex);
            }
        }
    
    public void llenarActualizarDatos(){
        try{
            sql = "SELECT * FROM servicios WHERE LEFT(fecha,10)=CURDATE() ORDER BY 1;";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            tabla_servicios = DbUtils.resultSetToTableModel(rs);
            moverPrimero();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error al actualizar 902" + e);
        }
    }

    public void insertar(){
        try{
          sql = "INSERT INTO servicios(costo, tipcorte, trabajo, cliente, empleado) VALUES (?,?,?,?,?);";
          ps = conexion.prepareStatement(sql);
          ps.setInt(1, costo);
          ps.setString(2, j_corte);
          ps.setString(3, j_trabajo);
          ps.setString(4, j_cliente);
          ps.setString(5, j_empleado);
          ps.executeUpdate();
          llenarActualizarDatos();
          moverPrimero();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error al insertar 903" + ex);
        }
    }
    public void borrar(){
        try{
            sql = "DELETE FROM servicios WHERE id_servicio=?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id_servicio);
            ps.executeUpdate();
            llenarActualizarDatos();
            moverPrimero();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "error al querer borrar 904" +ex);
        }
    }
    public void modificar(){
        try {
            sql = "UPDATE servicios SET costo=? , tipcorte=? , trabajo=? , cliente=? , empleado=? WHERE id_servicio=?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(6, id_servicio);
            ps.setInt(1, costo);
            ps.setString(2, j_corte);
            ps.setString(3, j_trabajo);
            ps.setString(4, j_cliente);
            ps.setString(5, j_empleado);
            ps.executeUpdate();
            moverPrimero();
            llenarActualizarDatos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"error al modficar 905"  + e);
        }        
    }
        public void JComboboEmpleado(javax.swing.JComboBox Combobox){
        try{
            sql = "SELECT nombre FROM empleados;";
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
        public void JComboboCliente(javax.swing.JComboBox Combobox){
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
        
    public void JtfFechaActual(javax.swing.JTextField jtf_FechaActual){
        Calendar Cal = Calendar.getInstance();
        String fecha = "   FECHA "+ Cal.get(Cal.DATE)+"-"+(Cal.get(Cal.MONTH)+1)+
        "-"+Cal.get(Cal.YEAR)+"               HORA "+Cal.get(Cal.HOUR_OF_DAY)+":"+Cal.get(Cal.MINUTE)+":"+Cal.get(Cal.SECOND);
        jtf_FechaActual.setText(fecha);
        System.out.println(fecha);
    }
    
    public void JtfSumarDatos (javax.swing.JTextField jtf_SumarDatos){
        try {
            String consulta_completa = "";
            sql = "SELECT SUM(costo) FROM servicios WHERE LEFT(fecha,10) = CURDATE() ORDER BY 1;";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.first();
            consulta_completa += rs.getString("SUM(costo)");
            jtf_SumarDatos.setText(consulta_completa);
            System.out.println(consulta_completa);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error al sumar datos error 1000001" +  ex);
        }
        
    }
    
//    public void llenaDatosTablaReservaciones(){
//        try{
//            sql = "SELECT * FROM reservaciones WHERE LEFT(fecha,10)=CURDATE() ORDER BY 1;";
//            ps = conexion.prepareStatement(sql);
//            rs = ps.executeQuery();
//            tabla_reservaciones = DbUtils.resultSetToTableModel(rs);
//            moverPrimero();
//        }catch(SQLException e){
//            JOptionPane.showMessageDialog(null,"error al actualizar 902" + e);
//        }
//    }
//    
    public void moverPrimero(){
        
        try{
            rs.first();
            AsignarDatos();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 103" + e);
        }
    }
    
    

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public JComboBox getTipo_corte() {
        return tipo_corte;
    }

    public void setTipo_corte(JComboBox tipo_corte) {
        this.tipo_corte = tipo_corte;
    }

    public JComboBox getEmpleado() {
        return empleado;
    }

    public void setEmpleado(JComboBox empleado) {
        this.empleado = empleado;
    }

    public JComboBox getCliente() {
        return cliente;
    }

    public void setCliente(JComboBox cliente) {
        this.cliente = cliente;
    }

    public TableModel getTabla_servicios() {
        return tabla_servicios;
    }

    public void setTabla_servicios(TableModel tabla_servicios) {
        this.tabla_servicios = tabla_servicios;
    }

    public TableModel getTabla_reservaciones() {
        return tabla_reservaciones;
    }

    public void setTabla_reservaciones(TableModel tabla_reservaciones) {
        this.tabla_reservaciones = tabla_reservaciones;
    }

    public String getJ_corte() {
        return j_corte;
    }

    public void setJ_corte(String j_corte) {
        this.j_corte = j_corte;
    }

    public String getJ_empleado() {
        return j_empleado;
    }

    public void setJ_empleado(String j_empleado) {
        this.j_empleado = j_empleado;
    }

    public String getJ_trabajo() {
        return j_trabajo;
    }

    public void setJ_trabajo(String j_trabajo) {
        this.j_trabajo = j_trabajo;
    }

    public String getJ_cliente() {
        return j_cliente;
    }

    public void setJ_cliente(String j_cliente) {
        this.j_cliente = j_cliente;
    }

    public JComboBox getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(JComboBox trabajo) {
        this.trabajo = trabajo;
    } 
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }    
}
