package controllers;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import models.ModelIngresarEgreso;
import models.ModelMain;
import views.ViewIngresarEgreso;

/**
 *
 * @author fernando
 */
public final class ControllerIngresarEgreso implements FocusListener{
    private final ModelIngresarEgreso model_ingresar_egreso;
    private final ViewIngresarEgreso view_ingresar_egreso;
    private final ModelMain model_main;
    
    public ControllerIngresarEgreso(Object[] models, Object[] views, Object[] controllers){
        this.model_ingresar_egreso = (ModelIngresarEgreso)models[6];
        this.view_ingresar_egreso = (ViewIngresarEgreso)views[6];
        this.model_main = (ModelMain)models[0];
        
        view_ingresar_egreso.jbtn_agregar.addActionListener(e-> jbtn_agregar_click());
        view_ingresar_egreso.jbtn_eliminar.addActionListener(e-> jbtn_eliminar_click());
        view_ingresar_egreso.jbtn_nuevo.addActionListener(e-> jbtn_nuevo_click());
        view_ingresar_egreso.jbtn_buscar.addActionListener(e-> jbtn_buscar_click());
        view_ingresar_egreso.jbtn_salir.addActionListener(e-> jbtn_salir_click());
        view_ingresar_egreso.jbtn_editar.addActionListener(e-> jbtn_editar_click());
        
        view_ingresar_egreso.jt_ingresar_egreso.addMouseListener(mi_mouse_listener);
        view_ingresar_egreso.jt_ingresar_egreso.addMouseListener(mi_mouse_listener2);
        
        view_ingresar_egreso.jtf_aux_id_egreso.setEditable(false);
        view_ingresar_egreso.jbtn_salir.setVisible(false);
        
        initView();
}
    public void initView(){
        view_ingresar_egreso.addFocusListener(this);
        model_ingresar_egreso.Conectar();
        botones();
    }
    public void getValores(){
        view_ingresar_egreso.jtf_aux_id_egreso.setText("" + model_ingresar_egreso.getId_egreso());
        view_ingresar_egreso.jtf_asdasd.setText(model_ingresar_egreso.getTipo_egreso());
        view_ingresar_egreso.jtf_aux_id_egreso.setText("" + model_ingresar_egreso.getAux_tipo_egreso());
        view_ingresar_egreso.jtf_buscar.setText(model_ingresar_egreso.getBuscar());
        view_ingresar_egreso.jt_ingresar_egreso.setModel(model_ingresar_egreso.getTable());
    }
    public void setValores(){
        model_ingresar_egreso.setId_egreso(Integer.parseInt(view_ingresar_egreso.jtf_aux_id_egreso.getText()));
        model_ingresar_egreso.setTipo_egreso(view_ingresar_egreso.jtf_asdasd.getText());
        
        model_ingresar_egreso.setBuscar(view_ingresar_egreso.jtf_buscar.getText());
        
    }
    public void ActualizarInterfaz(){
        model_ingresar_egreso.llenarActualizarDatos();
        getValores();
    }
    public void jbtn_nuevo_click(){
        model_ingresar_egreso.llenarActualizarDatos();
        model_ingresar_egreso.moverPrimero();
        getValores();    
        view_ingresar_egreso.jtf_aux_id_egreso.setText("0");
        view_ingresar_egreso.jtf_asdasd.setText("");
    }
     public void jbtn_agregar_click(){
        
        if(view_ingresar_egreso.jtf_asdasd.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Ingrese texto! >:(");
        model_ingresar_egreso.moverPrimero();    
        }else{
        setValores();
        model_ingresar_egreso.insertar();
        ActualizarInterfaz();
     
        }
    }
    public void jbtn_eliminar_click(){
        setValores();
        if (JOptionPane.showConfirmDialog(null, "Se eliminará el registro, ¿Desea continuar?",
        "Eliminar Registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        model_ingresar_egreso.borrar();
        ActualizarInterfaz();
//        getValores();
  
    }
    public void jbtn_editar_click(){
        setValores();
        if (JOptionPane.showConfirmDialog(null, "Se eliminará el registro, ¿Desea continuar?",
        "Eliminar Registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
         model_ingresar_egreso.modificar();
        ActualizarInterfaz();
    }
        
    /*****************************BUSCAR**********************************************/

    public void jbtn_buscar_click(){
        if(view_ingresar_egreso.jtf_buscar.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Ingrese texto! >:(");
        }else        
        setValores();
        model_ingresar_egreso.buscar();
        getValores();
        
    }     
    
    public void jbtn_salir_click(){
        
    }
    
    @Override
    public void focusGained(FocusEvent e) {
        model_ingresar_egreso.llenarActualizarDatos();
        model_ingresar_egreso.moverPrimero();
        getValores();    
    }

    @Override
    public void focusLost(FocusEvent e) {
    }

    
    private MouseListener mi_mouse_listener = new MouseListener(){
        @Override
        public void mouseClicked(MouseEvent e) {
        int posicion_y = view_ingresar_egreso.jt_ingresar_egreso.getSelectedRow();
        int posicion_x = 0;
        String mi_variable = "" + view_ingresar_egreso.jt_ingresar_egreso.getValueAt(posicion_y, posicion_x);
        view_ingresar_egreso.jtf_aux_id_egreso.setText(mi_variable);
            System.out.println(mi_variable);

        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
        
    };
    
    private MouseListener mi_mouse_listener2 = new MouseListener(){
        @Override
        public void mouseClicked(MouseEvent e) {
        int posicion_y = view_ingresar_egreso.jt_ingresar_egreso.getSelectedRow();
        int posicion_x = 1;
        String mi_variable = "" + view_ingresar_egreso.jt_ingresar_egreso.getValueAt(posicion_y, posicion_x);
        view_ingresar_egreso.jtf_asdasd.setText(mi_variable);
            System.out.println(mi_variable);
            
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
        view_ingresar_egreso.jbtn_agregar.setOpaque(false);
        view_ingresar_egreso.jbtn_agregar.setContentAreaFilled(false);                  
        view_ingresar_egreso.jbtn_agregar.setBorderPainted(false);
        
        view_ingresar_egreso.jbtn_editar.setOpaque(false);
        view_ingresar_egreso.jbtn_editar.setContentAreaFilled(false);                  
        view_ingresar_egreso.jbtn_editar.setBorderPainted(false);
        
        view_ingresar_egreso.jbtn_eliminar.setOpaque(false);
        view_ingresar_egreso.jbtn_eliminar.setContentAreaFilled(false);                  
        view_ingresar_egreso.jbtn_eliminar.setBorderPainted(false);
        
        view_ingresar_egreso.jbtn_nuevo.setOpaque(false);
        view_ingresar_egreso.jbtn_nuevo.setContentAreaFilled(false);                  
        view_ingresar_egreso.jbtn_nuevo.setBorderPainted(false);
    }        
}
