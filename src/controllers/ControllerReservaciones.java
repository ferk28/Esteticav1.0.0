/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.Time;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import models.ModelMain;
import models.ModelReservaciones;
import views.ViewReservaciones;

/**
 *
 * @author fernando
 */
public class ControllerReservaciones implements FocusListener{
    private final ModelReservaciones model_reservaciones;
    private final ViewReservaciones view_reservaciones;
    private final ModelMain model_main;
    public ControllerReservaciones(Object[] models, Object[] views, Object[] controllers){
        this.model_reservaciones = (ModelReservaciones) models[7];
        this.view_reservaciones = (ViewReservaciones) views[7];
        this.model_main = (ModelMain) models[0];
        //*******botones
        botones();
        initView();

        view_reservaciones.jbtn_editar.addActionListener(e-> jbtn_editar_click());
        view_reservaciones.jbtn_agregar.addActionListener(e-> jbtn_agregar_click());
        view_reservaciones.jbtn_eliminar.addActionListener(e-> jbtn_eliminar_click());
    }
    public void initView(){
        view_reservaciones.addFocusListener(this);
        model_reservaciones.Conectar();
        view_reservaciones.jtf_id_reservacion.setEditable(false);
        view_reservaciones.jtf_fecha_reservacion.setEditable(false);
        view_reservaciones.jtf_hora_reservacion.setEditable(false);
        view_reservaciones.jtf_asdasd.setVisible(false);
        
        view_reservaciones.jtf_id_reservacion.setText("0");
        view_reservaciones.jtf_fecha_reservacion.setText("");
        view_reservaciones.jtf_hora_reservacion.setText("");
                                
    }
    public void getValores(){
        view_reservaciones.jcb_clientes.setSelectedItem(model_reservaciones.getCombobox());
        view_reservaciones.jTable1.setModel(model_reservaciones.getTabla());
    }
    public void setValores(){
        model_reservaciones.setId_reservacion(Integer.parseInt(view_reservaciones.jtf_id_reservacion.getText())); //integer
        model_reservaciones.setFecha(java.sql.Date.valueOf(view_reservaciones.jtf_fecha_reservacion.getText())); //String        
        model_reservaciones.setHora(java.sql.Time.valueOf(view_reservaciones.jtf_hora_reservacion.getText()));
        model_reservaciones.setCliente("" + view_reservaciones.jcb_clientes.getSelectedItem());
        
    }
    public void ActualizarInterfaz(){
        model_reservaciones.llenarActualizarDatos();
        view_reservaciones.jtf_id_reservacion.setEditable(false);
        getValores();
    }
    @Override
    public void focusGained(FocusEvent e) {
        model_reservaciones.llenarActualizarDatos();
        model_reservaciones.moverPrimero();
        model_reservaciones.JComboboxR(view_reservaciones.jcb_clientes);
        model_reservaciones.diaReservacionFecha(view_reservaciones.jtf_asdasd);
        model_reservaciones.diaReservacionHora(view_reservaciones.jtf_ASDASD);
        getValores();
    }

    @Override
    public void focusLost(FocusEvent e) {
        
    }

    public void jbtn_nuevo_click(){
        agregar_true();
        view_reservaciones.jtf_id_reservacion.setText("0");
        view_reservaciones.jtf_fecha_reservacion.setText("");
        view_reservaciones.jtf_hora_reservacion.setText("");        
        view_reservaciones.jtf_fecha_reservacion.setEditable(false);
        view_reservaciones.jtf_hora_reservacion.setEditable(false);
        view_reservaciones.jTable1.removeMouseListener(mouseID_Listener);
    }
     public void jbtn_agregar_click(){

        if(view_reservaciones.jtf_fecha_reservacion.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Ingrese la hora y fecha de su Reservacion");
        view_reservaciones.jbtn_eliminar.setEnabled(false);
        view_reservaciones.jbtn_editar.setEnabled(false);
        
        view_reservaciones.jtf_fecha_reservacion.setEditable(true);
        view_reservaciones.jtf_hora_reservacion.setEditable(true);

        view_reservaciones.jtf_id_reservacion.setText("0");
        view_reservaciones.jtf_fecha_reservacion.setText("YYYY-MM-DD");
        view_reservaciones.jtf_hora_reservacion.setText("HH:MM:SS"); 
        
        }else{
            
        if (JOptionPane.showConfirmDialog(null, "Se Agregará el registro ¿Desea continuar?",
        "Modificar registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)

        setValores();
        model_reservaciones.insertar();
        ActualizarInterfaz();
        view_reservaciones.jtf_id_reservacion.setText("0");
        view_reservaciones.jtf_fecha_reservacion.setText("");
        view_reservaciones.jtf_hora_reservacion.setText("");
        view_reservaciones.jtf_fecha_reservacion.setEditable(false);
        view_reservaciones.jtf_hora_reservacion.setEditable(false);
        view_reservaciones.jbtn_eliminar.setEnabled(true);
        view_reservaciones.jbtn_editar.setEnabled(true);

        }
        
    }
    public void jbtn_editar_click(){

        if(view_reservaciones.jtf_fecha_reservacion.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Seleccione en la tabla el elemento a editar");
        view_reservaciones.jtf_fecha_reservacion.setEditable(true);
        view_reservaciones.jtf_hora_reservacion.setEditable(true);
                
            //botones
            
        view_reservaciones.jTable1.addMouseListener(mouseID_Listener);
        view_reservaciones.jbtn_eliminar.setEnabled(false);
        view_reservaciones.jbtn_agregar.setEnabled(false);
        }else{
        if (JOptionPane.showConfirmDialog(null, "Se modificará el registro ¿Desea continuar?",
        "Modificar registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        
        setValores();
            
        model_reservaciones.modificar();
        ActualizarInterfaz();
        
        view_reservaciones.jTable1.removeMouseListener(mouseID_Listener);
        view_reservaciones.jtf_fecha_reservacion.setEditable(false);
        view_reservaciones.jtf_hora_reservacion.setEditable(false);
        view_reservaciones.jtf_id_reservacion.setText("0");
        view_reservaciones.jtf_fecha_reservacion.setText("");
        view_reservaciones.jtf_hora_reservacion.setText("");
        view_reservaciones.jbtn_eliminar.setEnabled(true);
        view_reservaciones.jbtn_agregar.setEnabled(true);
        }        
    }
    public void jbtn_eliminar_click(){
        if(view_reservaciones.jtf_fecha_reservacion.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Seleccione en la tabla el elemento a eliminar");
        
            //botones
            
        view_reservaciones.jTable1.addMouseListener(mouseID_Listener);
        view_reservaciones.jbtn_editar.setEnabled(false);
        view_reservaciones.jbtn_agregar.setEnabled(false);

        }else{

        if (JOptionPane.showConfirmDialog(null, "Se eliminará el registro, ¿Desea continuar?",
        "Eliminar Registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        setValores();
        model_reservaciones.borrar();
        ActualizarInterfaz();
//        getValores();
        view_reservaciones.jTable1.removeMouseListener(mouseID_Listener);
        
        view_reservaciones.jtf_id_reservacion.setText("0");
        view_reservaciones.jtf_fecha_reservacion.setText("");
        view_reservaciones.jtf_hora_reservacion.setText("");
        view_reservaciones.jbtn_editar.setEnabled(true);
        view_reservaciones.jbtn_agregar.setEnabled(true);

        }
    }
    public void jbtn_primero_click(){
        model_reservaciones.llenarActualizarDatos();
        model_reservaciones.moverPrimero();
        getValores();
        agregar_falso();
    }
    
    public void jbtn_agregar_cliente_interfaz_click(){
        
    }
    
    private MouseListener mouseID_Listener = new MouseListener(){
        @Override
        public void mouseClicked(MouseEvent e) {
            int posicion_y = view_reservaciones.jTable1.getSelectedRow();

            String mi_variable = "" + view_reservaciones.jTable1.getValueAt(posicion_y, 0);
            String variableHora = "" + view_reservaciones.jTable1.getValueAt(posicion_y, 1);
            String variableFecha = "" + view_reservaciones.jTable1.getValueAt(posicion_y, 2);
            view_reservaciones.jtf_id_reservacion.setText(mi_variable);
            view_reservaciones.jtf_fecha_reservacion.setText(variableFecha);
            view_reservaciones.jtf_hora_reservacion.setText(variableHora);
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
        
    public void agregar_falso(){
        view_reservaciones.jbtn_agregar.setEnabled(false);
        view_reservaciones.jbtn_editar.setEnabled(true);
        view_reservaciones.jbtn_eliminar.setEnabled(true);          
    }
    public void agregar_true(){
        view_reservaciones.jbtn_agregar.setEnabled(true);
        view_reservaciones.jbtn_eliminar.setEnabled(true);
        view_reservaciones.jbtn_editar.setEnabled(true);        
    }
    public void botones(){
        view_reservaciones.jbtn_agregar.setOpaque(false);
        view_reservaciones.jbtn_agregar.setContentAreaFilled(false);                  
        view_reservaciones.jbtn_agregar.setBorderPainted(false);
        
        view_reservaciones.jbtn_editar.setOpaque(false);
        view_reservaciones.jbtn_editar.setContentAreaFilled(false);                  
        view_reservaciones.jbtn_editar.setBorderPainted(false);
        
        view_reservaciones.jbtn_eliminar.setOpaque(false);
        view_reservaciones.jbtn_eliminar.setContentAreaFilled(false);                  
        view_reservaciones.jbtn_eliminar.setBorderPainted(false);

    }
        
}
