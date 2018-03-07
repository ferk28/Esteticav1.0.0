package controllers;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import models.ModelMain;
import models.ModelServicios;
import views.ViewServicios;
/**
 *
 * @author fernando
 */
public class ControllerServicios implements FocusListener{
    private final ModelServicios model_servicios;
    private final ViewServicios view_servicios;
    private final ModelMain model_main;
    
    public ControllerServicios(Object[] models, Object[] views, Object[] controllers){
        this.model_servicios = (ModelServicios) models[8];
        this.view_servicios = (ViewServicios) views[8];
        this.model_main = (ModelMain) models[0];
        
        initView();
        botones();
        //botones
        view_servicios.jbtn_agregar.addActionListener(e-> jbtn_agregar_click());
        view_servicios.jbtn_editar.addActionListener(e-> jbtn_editar_click());
        view_servicios.jbtn_eliminar.addActionListener(e-> jbtn_eliminar_click());
        view_servicios.jbtn_nuevo.addActionListener(e-> jbtn_nuevo_click());       
        
        view_servicios.jt_reservaciones.setVisible(false);
        view_servicios.ReservacionesDeHoy.setVisible(false);
        view_servicios.jtf_id_servicio.setEditable(false);
        view_servicios.jtf_total_ventas.setEditable(false);
        view_servicios.jtf_asdasd.setEditable(false);
    }
    public void initView(){
        view_servicios.addFocusListener(this);
        model_servicios.Conectar();
        model_servicios.JtfSumarDatos(view_servicios.jtf_total_ventas);        
    }
    public void getValores(){
        view_servicios.jt_servicios.setModel(model_servicios.getTabla_servicios());
        view_servicios.jcb_trabajo.setSelectedItem(model_servicios.getTrabajo());
        view_servicios.jcb_tipo_corte.setSelectedItem(model_servicios.getTipo_corte());
        view_servicios.jcb_cliente.setSelectedItem(model_servicios.getCliente());
        view_servicios.jcb_empleado.setSelectedItem(model_servicios.getEmpleado());
    }
    public void setValores(){
        model_servicios.setId_servicio(Integer.parseInt(view_servicios.jtf_id_servicio.getText()));
        model_servicios.setCosto(Integer.parseInt(view_servicios.jtf_costo.getText()));
        model_servicios.setJ_cliente("" + view_servicios.jcb_cliente.getSelectedItem());
        model_servicios.setJ_empleado("" + view_servicios.jcb_empleado.getSelectedItem());
        model_servicios.setJ_corte("" + view_servicios.jcb_tipo_corte.getSelectedItem());
        model_servicios.setJ_trabajo("" + view_servicios.jcb_trabajo.getSelectedItem());
        
    }
    public void ActualizarInterfaz(){
        model_servicios.llenarActualizarDatos();
        view_servicios.jtf_id_servicio.setEditable(false);
        model_servicios.JtfSumarDatos(view_servicios.jtf_total_ventas);                
        getValores();
    }

    @Override
    public void focusGained(FocusEvent e) {
        model_servicios.llenarActualizarDatos();
        model_servicios.moverPrimero();
        model_servicios.JComboboCliente(view_servicios.jcb_cliente);
        model_servicios.JComboboEmpleado(view_servicios.jcb_empleado);
        model_servicios.JtfFechaActual(view_servicios.jtf_asdasd);
        view_servicios.jt_servicios.addMouseListener(mouseIDListener);
        getValores();
    }
    @Override
    public void focusLost(FocusEvent e) {
    }

    public void jbtn_nuevo_click(){
        view_servicios.jtf_id_servicio.setText("0");
        view_servicios.jtf_costo.setText("");
    }
     public void jbtn_agregar_click(){
        
        if(view_servicios.jtf_costo.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Ingrese texto! >:(");
        }else{
        setValores();
        model_servicios.insertar();
        ActualizarInterfaz();
        }
    }
    public void jbtn_editar_click(){
        setValores();
        if (JOptionPane.showConfirmDialog(null, "Se modificará el registro ¿Desea continuar?",
        "Modificar registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        model_servicios.modificar();
        ActualizarInterfaz();
  
    }
    public void jbtn_eliminar_click(){
        setValores();
        if (JOptionPane.showConfirmDialog(null, "Se eliminará el registro, ¿Desea continuar?",
        "Eliminar Registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        model_servicios.borrar();
        ActualizarInterfaz();
  
    }
    public void jbtn_primero_click(){
        model_servicios.llenarActualizarDatos();
        model_servicios.moverPrimero();
        getValores();
    } 
    private MouseListener mouseIDListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int posicion_y = view_servicios.jt_servicios.getSelectedRow();
            
            String variable = "" + view_servicios.jt_servicios.getValueAt(posicion_y, 0);
            String mi_variable = "" + view_servicios.jt_servicios.getValueAt(posicion_y, 1);
            
            view_servicios.jtf_id_servicio.setText(variable);
            view_servicios.jtf_costo.setText(mi_variable);
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    };

    public void botones(){
        view_servicios.jbtn_agregar.setOpaque(false);
        view_servicios.jbtn_agregar.setContentAreaFilled(false);                  
        view_servicios.jbtn_agregar.setBorderPainted(false);
        
        view_servicios.jbtn_editar.setOpaque(false);
        view_servicios.jbtn_editar.setContentAreaFilled(false);                  
        view_servicios.jbtn_editar.setBorderPainted(false);
        
        view_servicios.jbtn_eliminar.setOpaque(false);
        view_servicios.jbtn_eliminar.setContentAreaFilled(false);                  
        view_servicios.jbtn_eliminar.setBorderPainted(false);
        
        view_servicios.jbtn_nuevo.setOpaque(false);
        view_servicios.jbtn_nuevo.setContentAreaFilled(false);                  
        view_servicios.jbtn_nuevo.setBorderPainted(false);
        
    }    
}
