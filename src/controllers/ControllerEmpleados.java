package controllers;

/**
 *
 * @author fernando
 */

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import models.ModelMain;
import models.ModelEmpleados;
import views.ViewEmpleados;

/**
 *
 * @author fernando
 */
public class ControllerEmpleados implements FocusListener {
    private final ModelEmpleados model_empleados;
    private final ViewEmpleados view_empleados;
    private final ModelMain model_main;
    
    public ControllerEmpleados(Object[] models, Object[] views, Object[] controllers){
        this.model_empleados = (ModelEmpleados) models[4];
        this.view_empleados = (ViewEmpleados) views[4];
        this.model_main = (ModelMain) models[0];
        
        view_empleados.jbtn_primero.addActionListener(e-> jbtn_primero_click());
        view_empleados.jbtn_ultimo.addActionListener(e-> jbtn_ultimo_click());
        view_empleados.jbtn_agregar.addActionListener(e-> jbtn_agregar_click());
        view_empleados.jbtn_editar.addActionListener(e-> jbtn_editar_click());
        view_empleados.jbtn_eliminar.addActionListener(e-> jbtn_eliminar_click());
        view_empleados.jbtn_nuevo.addActionListener(e-> jbtn_nuevo_click());         
        view_empleados.jbtn_siguiente.addActionListener(e-> jbtn_siguiente_click());
        view_empleados.jbtn_anterior.addActionListener(e-> jbtn_anterior_click());
        view_empleados.jbtn_agregar.setEnabled(false);
        view_empleados.jtf_id_empleado.setEditable(false); 
        
        initView();
    }
    
    public void initView(){
        view_empleados.addFocusListener(this);
        model_empleados.Conectar();
        botones();
    }
    
    public void getValores(){
        view_empleados.jtf_id_empleado.setText("" + model_empleados.getId_empleado());
        view_empleados.jtf_nombre.setText(model_empleados.getNombre());
        view_empleados.jtf_edad.setText("" + model_empleados.getEdad());
        view_empleados.jcb_genero.setSelectedItem(model_empleados.getGenero());
        view_empleados.jtf_clave_elector.setText(model_empleados.getClave_elector());
        view_empleados.jtf_telefono.setText(model_empleados.getTelefono());
        view_empleados.jtf_telefono2.setText(model_empleados.getTelefono2());
        view_empleados.jcb_identificaciones.setSelectedItem(model_empleados.getIdentificaciones());
        view_empleados.jt_empleados.setModel(model_empleados.getTabla_empleados());
    }
    public void setValores(){
        model_empleados.setId_empleado(Integer.parseInt(view_empleados.jtf_id_empleado.getText()));
        model_empleados.setNombre(view_empleados.jtf_nombre.getText());
        model_empleados.setEdad(Integer.parseInt(view_empleados.jtf_edad.getText()));
        model_empleados.setClave_elector(view_empleados.jtf_clave_elector.getText());
        model_empleados.setTelefono(view_empleados.jtf_telefono.getText());
        model_empleados.setTelefono2(view_empleados.jtf_telefono2.getText());        

        model_empleados.setGenero((String) view_empleados.jcb_genero.getSelectedItem());
        model_empleados.setIdentificaciones((String) view_empleados.jcb_identificaciones.getSelectedItem());        
    }    
    
    public void ActualizarInterfaz(){
        model_empleados.llenarActualizarDatos();
        getValores();
    }
    public void jbtn_nuevo_click(){
        agregar_true();
        view_empleados.jtf_id_empleado.setText("0");
        view_empleados.jtf_nombre.setText("");
        view_empleados.jtf_clave_elector.setText("");
        view_empleados.jtf_edad.setText("");
        view_empleados.jtf_telefono.setText("");
        view_empleados.jtf_telefono2.setText("");
        view_empleados.jcb_genero.setSelectedItem(null);
        view_empleados.jcb_identificaciones.setSelectedItem(null);
    }
     public void jbtn_agregar_click(){
        
        if(view_empleados.jtf_nombre.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Ingrese texto! >:(");
        }else{
        setValores();
        model_empleados.insertar();
        ActualizarInterfaz();
        agregar_falso();
        }
    }
    public void jbtn_editar_click(){
        setValores();
        if (JOptionPane.showConfirmDialog(null, "Se modificará el registro ¿Desea continuar?",
        "Modificar registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        model_empleados.modificar();
        ActualizarInterfaz();
    }
    public void jbtn_eliminar_click(){
        setValores();
        if (JOptionPane.showConfirmDialog(null, "Se eliminará el registro, ¿Desea continuar?",
        "Eliminar Registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        model_empleados.borrar();
        ActualizarInterfaz();
    }
    
/************************************BOTONES NAVEGACION**********************************************/
    public void jbtn_primero_click(){
        view_empleados.jbtn_anterior.setEnabled(true);
        view_empleados.jbtn_siguiente.setEnabled(true);
        model_empleados.llenarActualizarDatos();
        model_empleados.moverPrimero();
        getValores();
        agregar_falso();
    }
    public void jbtn_ultimo_click(){
        view_empleados.jbtn_anterior.setEnabled(true);
        view_empleados.jbtn_siguiente.setEnabled(true);
        model_empleados.llenarActualizarDatos();
        model_empleados.moverUltimo();
        getValores();
        agregar_falso();        
    }
    public void jbtn_anterior_click(){
        model_empleados.moverAnterior();
        getValores();
        agregar_falso();
    }
    public void jbtn_siguiente_click(){
        model_empleados.moverSiguiente();
        getValores();
        agregar_falso();
    }    

    @Override
    public void focusGained(FocusEvent e) {
        model_empleados.llenarActualizarDatos();
        model_empleados.moverPrimero();
        getValores();
    }

    @Override
    public void focusLost(FocusEvent e) {
    }
    /***********************************BOTONES ESTILO************************************************/
    public void agregar_falso(){
        view_empleados.jbtn_agregar.setEnabled(false);
        view_empleados.jbtn_editar.setEnabled(true);
        view_empleados.jbtn_eliminar.setEnabled(true);          
    }
    public void agregar_true(){
        view_empleados.jbtn_agregar.setEnabled(true);
        view_empleados.jbtn_eliminar.setEnabled(false);
        view_empleados.jbtn_editar.setEnabled(false);        
    }
    public void botones(){
        view_empleados.jbtn_agregar.setOpaque(false);
        view_empleados.jbtn_agregar.setContentAreaFilled(false);                  
        view_empleados.jbtn_agregar.setBorderPainted(false);
        
        view_empleados.jbtn_anterior.setOpaque(false);
        view_empleados.jbtn_anterior.setContentAreaFilled(false);                  
        view_empleados.jbtn_anterior.setBorderPainted(false);
        
        view_empleados.jbtn_editar.setOpaque(false);
        view_empleados.jbtn_editar.setContentAreaFilled(false);                  
        view_empleados.jbtn_editar.setBorderPainted(false);
        
        view_empleados.jbtn_eliminar.setOpaque(false);
        view_empleados.jbtn_eliminar.setContentAreaFilled(false);                  
        view_empleados.jbtn_eliminar.setBorderPainted(false);
        
        view_empleados.jbtn_nuevo.setOpaque(false);
        view_empleados.jbtn_nuevo.setContentAreaFilled(false);                  
        view_empleados.jbtn_nuevo.setBorderPainted(false);
        
        view_empleados.jbtn_primero.setOpaque(false);
        view_empleados.jbtn_primero.setContentAreaFilled(false);                  
        view_empleados.jbtn_primero.setBorderPainted(false);
        
        view_empleados.jbtn_siguiente.setOpaque(false);
        view_empleados.jbtn_siguiente.setContentAreaFilled(false);                  
        view_empleados.jbtn_siguiente.setBorderPainted(false);
        
        view_empleados.jbtn_ultimo.setOpaque(false);
        view_empleados.jbtn_ultimo.setContentAreaFilled(false);                  
        view_empleados.jbtn_ultimo.setBorderPainted(false);
        
    }    
}
