/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.LocalDate;
import java.sql.Date;
import models.ModelEgreso;
import views.ViewEgreso;
import models.ModelMain;
import javax.swing.JOptionPane;

/**
 *
 * @author fernando
 */
public class ControllerEgreso implements FocusListener{
    private final ModelEgreso model_egreso;
    private final ViewEgreso view_egreso;
    private final ModelMain model_main;
    
    public ControllerEgreso(Object[] models, Object[] views, Object[] controllers){
        this.model_egreso = (ModelEgreso) models[5];
        this.view_egreso = (ViewEgreso) views[5];
        this.model_main = (ModelMain) models[0];
        
        view_egreso.jbtn_agregar.addActionListener(e-> jbtn_agregar_click());
        view_egreso.jbtn_anterior.addActionListener(e-> jbtn_anterior_click());
        view_egreso.jbtn_editar.addActionListener(e-> jbtn_editar_click());
        view_egreso.jbtn_eliminar.addActionListener(e-> jbtn_eliminar_click());
        view_egreso.jbtn_nuevo.addActionListener(e-> jbtn_nuevo_click());
        view_egreso.jbtn_primero.addActionListener(e-> jbtn_primero_click());
        view_egreso.jbtn_ultimo.addActionListener(e-> jbtn_ultimo_click());
        view_egreso.jbtn_siguiente.addActionListener(e-> jbtn_siguiente_click());
        
        initView();
    }
    public void initView(){
        view_egreso.addFocusListener(this);
        model_egreso.Conectar();        
        //Forma al Panel
        view_egreso.jtf_id_egreso.setEditable(false);
        botones();
    }
    public void getValores(){
        view_egreso.jtf_id_egreso.setText("" + model_egreso.getId_egreso());
        view_egreso.jtf_monto.setText("" + model_egreso.getMonto());
        view_egreso.jtf_cantidad.setText("" + model_egreso.getCantidad());
        view_egreso.jcb_tipo_egreso.setSelectedItem(model_egreso.getTipo_egreso());
        view_egreso.jt_table.setModel(model_egreso.getTabla());
        view_egreso.jtf_fecha.setText("" + model_egreso.getFecha());
    }
    public void setValores(){
        model_egreso.setId_egreso(Integer.parseInt(view_egreso.jtf_id_egreso.getText())); //integer
        model_egreso.setMonto(Integer.parseInt(view_egreso.jtf_monto.getText())); //String        
        model_egreso.setTipo_egreso("" + view_egreso.jcb_tipo_egreso.getSelectedItem()); //jCBox
        model_egreso.setCantidad(Integer.parseInt(view_egreso.jtf_cantidad.getText()));
        model_egreso.setFecha(java.sql.Date.valueOf(view_egreso.jtf_fecha.getText()));
        
    }    
    
    public void ActualizarInterfaz(){
        model_egreso.llenarActualizarDatos();
        getValores();
    }
    public void jbtn_nuevo_click(){
        agregar_true();
        view_egreso.jtf_id_egreso.setText("0");
        view_egreso.jtf_monto.setText("");
        view_egreso.jtf_cantidad.setText("");
        view_egreso.jtf_fecha.setText("yyyy-MM-dd");
    }
     public void jbtn_agregar_click(){
        
        if(view_egreso.jtf_monto.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Ingrese texto! >:(");
        }else{
        setValores();
        model_egreso.insertar();
        ActualizarInterfaz();
//        getValores();
        agregar_falso();
        }
    }
    public void jbtn_editar_click(){
        setValores();
        if (JOptionPane.showConfirmDialog(null, "Se modificará el registro ¿Desea continuar?",
        "Modificar registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        model_egreso.modificar();
        ActualizarInterfaz();
//        getValores();
    
    }
    public void jbtn_eliminar_click(){
        setValores();
        if (JOptionPane.showConfirmDialog(null, "Se eliminará el registro, ¿Desea continuar?",
        "Eliminar Registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        model_egreso.borrar();
        ActualizarInterfaz();
//        getValores();
  
    }
        
    /******************************BOTONES NAVEGACION****************************/
    public void jbtn_primero_click(){
        view_egreso.jbtn_anterior.setEnabled(true);
        view_egreso.jbtn_siguiente.setEnabled(true);
        model_egreso.llenarActualizarDatos();
        model_egreso.moverPrimero();
        getValores();
        agregar_falso();
    }

    public void jbtn_ultimo_click(){
        view_egreso.jbtn_anterior.setEnabled(true);
        view_egreso.jbtn_siguiente.setEnabled(true);        
        model_egreso.llenarActualizarDatos();        
        model_egreso.moverUltimo();
        getValores();
        agregar_falso();        
    }
    public void jbtn_anterior_click(){
        model_egreso.moverAnterior();
        getValores();
        agregar_falso();
    }
    public void jbtn_siguiente_click(){
        model_egreso.moverSiguiente();
        getValores();
        agregar_falso();
    }
    
    @Override
    public void focusGained(FocusEvent e) {
        model_egreso.llenarActualizarDatos();
        model_egreso.moverPrimero();
        model_egreso.JCombobox(view_egreso.jcb_tipo_egreso);
        
        getValores();
    }

    @Override
    public void focusLost(FocusEvent e) {
        
    }
    
    

    /***********************************BOTONES ESTILO************************************************/
    public void agregar_falso(){
        view_egreso.jbtn_agregar.setEnabled(false);
        view_egreso.jbtn_editar.setEnabled(true);
        view_egreso.jbtn_eliminar.setEnabled(true);          
    }
    public void agregar_true(){
        view_egreso.jbtn_agregar.setEnabled(true);
        view_egreso.jbtn_eliminar.setEnabled(false);
        view_egreso.jbtn_editar.setEnabled(false);        
    }
    public void botones(){
        view_egreso.jbtn_agregar.setOpaque(false);
        view_egreso.jbtn_agregar.setContentAreaFilled(false);                  
        view_egreso.jbtn_agregar.setBorderPainted(false);
        
        view_egreso.jbtn_anterior.setOpaque(false);
        view_egreso.jbtn_anterior.setContentAreaFilled(false);                  
        view_egreso.jbtn_anterior.setBorderPainted(false);
        
        view_egreso.jbtn_editar.setOpaque(false);
        view_egreso.jbtn_editar.setContentAreaFilled(false);                  
        view_egreso.jbtn_editar.setBorderPainted(false);
        
        view_egreso.jbtn_eliminar.setOpaque(false);
        view_egreso.jbtn_eliminar.setContentAreaFilled(false);                  
        view_egreso.jbtn_eliminar.setBorderPainted(false);
        
        view_egreso.jbtn_nuevo.setOpaque(false);
        view_egreso.jbtn_nuevo.setContentAreaFilled(false);                  
        view_egreso.jbtn_nuevo.setBorderPainted(false);
        
        view_egreso.jbtn_primero.setOpaque(false);
        view_egreso.jbtn_primero.setContentAreaFilled(false);                  
        view_egreso.jbtn_primero.setBorderPainted(false);
        
        view_egreso.jbtn_siguiente.setOpaque(false);
        view_egreso.jbtn_siguiente.setContentAreaFilled(false);                  
        view_egreso.jbtn_siguiente.setBorderPainted(false);
        
        view_egreso.jbtn_ultimo.setOpaque(false);
        view_egreso.jbtn_ultimo.setContentAreaFilled(false);                  
        view_egreso.jbtn_ultimo.setBorderPainted(false);
        
    }
    
}
