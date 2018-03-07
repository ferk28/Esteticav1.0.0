/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import models.ModelInventario;
import models.ModelMain;
import views.ViewInventario;

/**
 *
 * @author fernando
 */
public class ControllerInventario implements FocusListener{
    private final ModelInventario model_inventario;
    private final ViewInventario view_inventario;  
    private final ModelMain model_main;

    public ControllerInventario(Object models[], Object views[], Object controllers[]){
        this.model_inventario = (ModelInventario)models[3];
        this.view_inventario = (ViewInventario)views[3];
        this.model_main = (ModelMain)models[0];

        initView();
        }
    public void initView(){
        view_inventario.addFocusListener(this);
        view_inventario.jbtn_primero.addActionListener(e-> jbtn_primero_click());
        view_inventario.jbtn_ultimo.addActionListener(e-> jbtn_ultimo_click());
        view_inventario.jbtn_agregar.addActionListener(e-> jbtn_agregar_click());
        view_inventario.jbtn_editar.addActionListener(e-> jbtn_editar_click());
        view_inventario.jbtn_eliminar.addActionListener(e-> jbtn_eliminar_click());
        view_inventario.jbtn_nuevo.addActionListener(e-> jbtn_nuevo_click());         
        view_inventario.jbtn_siguiente.addActionListener(e-> jbtn_siguiente_click());
        view_inventario.jbtn_anterior.addActionListener(e-> jbtn_anterior_click());
        view_inventario.jbtn_agregar.setEnabled(false);
        view_inventario.jtf_id_articulo.setEditable(false);
        model_inventario.llenarActualizarDatos();
        getValores();
        botones();
    }
    public void getValores(){
        view_inventario.jtf_id_articulo.setText("" + model_inventario.getId_articulo());
        view_inventario.jtf_nombre.setText(model_inventario.getNombre());
        view_inventario.jtf_cantidad.setText("" + model_inventario.getCantidad());
        view_inventario.jcb_estado.setSelectedItem(model_inventario.getEstado());
        view_inventario.jt_inventario.setModel(model_inventario.getTabla_articulo());
    }
    public void setValores(){
        model_inventario.setId_articulo(Integer.parseInt(view_inventario.jtf_id_articulo.getText()));
        model_inventario.setNombre(view_inventario.jtf_nombre.getText());
        model_inventario.setCantidad(Integer.parseInt(view_inventario.jtf_cantidad.getText()));
        
    }    
    
    public void ActualizarInterfaz(){
        model_inventario.llenarActualizarDatos();
        getValores();
    }
    public void jbtn_nuevo_click(){
        agregar_true();
        view_inventario.jtf_id_articulo.setText("0");
        view_inventario.jtf_nombre.setText("");
        view_inventario.jtf_cantidad.setText("00");
    }
     public void jbtn_agregar_click(){
        
        if(view_inventario.jtf_nombre.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Ingrese texto! >:(");
        }else{
        setValores();
        model_inventario.insertar();
        ActualizarInterfaz();
        agregar_falso();
        }
    }
    public void jbtn_editar_click(){
        setValores();
        if (JOptionPane.showConfirmDialog(null, "Se modificará el registro ¿Desea continuar?",
        "Modificar registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        model_inventario.modificar();
        ActualizarInterfaz();
    }
    public void jbtn_eliminar_click(){
        setValores();
        if (JOptionPane.showConfirmDialog(null, "Se eliminará el registro, ¿Desea continuar?",
        "Eliminar Registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        model_inventario.borrar();
        ActualizarInterfaz();
    }

    public void jbtn_primero_click(){
        model_main.Mover_Primero();
        model_inventario.AsignarDatos();
        getValores();
        agregar_falso();
    }
    public void jbtn_ultimo_click(){
        model_main.Mover_Ultimo();
        model_inventario.AsignarDatos();
        getValores();
        agregar_falso();        
    }
    public void jbtn_anterior_click(){
        model_main.Mover_Anterior();
        model_inventario.AsignarDatos();
        getValores();
        agregar_falso();
    }
    public void jbtn_siguiente_click(){
        model_main.Mover_Siguiente();
        model_inventario.AsignarDatos();
        getValores();
        agregar_falso();
    }
    
    @Override
    public void focusGained(FocusEvent e) {
        model_inventario.llenarActualizarDatos();
        getValores();    }

    @Override
    public void focusLost(FocusEvent e) {
    }


    /***********************************BOTONES ESTILO************************************************/
    public void agregar_falso(){
        view_inventario.jbtn_agregar.setEnabled(false);
        view_inventario.jbtn_editar.setEnabled(true);
        view_inventario.jbtn_eliminar.setEnabled(true);          
    }
    public void agregar_true(){
        view_inventario.jbtn_agregar.setEnabled(true);
        view_inventario.jbtn_eliminar.setEnabled(false);
        view_inventario.jbtn_editar.setEnabled(false);        
    }
    public void botones(){
        view_inventario.jbtn_agregar.setOpaque(false);
        view_inventario.jbtn_agregar.setContentAreaFilled(false);                  
        view_inventario.jbtn_agregar.setBorderPainted(false);
        
        view_inventario.jbtn_anterior.setOpaque(false);
        view_inventario.jbtn_anterior.setContentAreaFilled(false);                  
        view_inventario.jbtn_anterior.setBorderPainted(false);
        
        view_inventario.jbtn_editar.setOpaque(false);
        view_inventario.jbtn_editar.setContentAreaFilled(false);                  
        view_inventario.jbtn_editar.setBorderPainted(false);
        
        view_inventario.jbtn_eliminar.setOpaque(false);
        view_inventario.jbtn_eliminar.setContentAreaFilled(false);                  
        view_inventario.jbtn_eliminar.setBorderPainted(false);
        
        view_inventario.jbtn_nuevo.setOpaque(false);
        view_inventario.jbtn_nuevo.setContentAreaFilled(false);                  
        view_inventario.jbtn_nuevo.setBorderPainted(false);
        
        view_inventario.jbtn_primero.setOpaque(false);
        view_inventario.jbtn_primero.setContentAreaFilled(false);                  
        view_inventario.jbtn_primero.setBorderPainted(false);
        
        view_inventario.jbtn_siguiente.setOpaque(false);
        view_inventario.jbtn_siguiente.setContentAreaFilled(false);                  
        view_inventario.jbtn_siguiente.setBorderPainted(false);
        
        view_inventario.jbtn_ultimo.setOpaque(false);
        view_inventario.jbtn_ultimo.setContentAreaFilled(false);                  
        view_inventario.jbtn_ultimo.setBorderPainted(false);
        
    }
    
}
