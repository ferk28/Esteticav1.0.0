/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import views.*;
import models.*;

/**
 *
 * @author fernando
 */
public class ControllerMain {
    private final ViewMain view_main;
    private final ModelMain model_main;

    private final ViewLogin view_login;    
    private final ModelLogin model_login;
    private final ControllerLogin controller_login;
    
    private final ViewClientes view_clientes;
    private final ModelClientes model_clientes; 
    private final ControllerClientes controller_clientes;
    
    private final ViewInventario view_inventario;
    private final ModelInventario model_inventario;
    private final ControllerInventario controller_inventario;
    
    private final ViewEmpleados view_empleados;
    private final ModelEmpleados model_empleados;
    private final ControllerEmpleados controller_empleados;
    
    private final ViewEgreso view_egreso;
    private final ModelEgreso model_egreso;
    private final ControllerEgreso controller_egreso;
    
    private final ViewIngresarEgreso view_ingresar_egreso;
    private final ModelIngresarEgreso model_ingresar_egreso;
    private final ControllerIngresarEgreso controller_ingresar_egreso;
    
    private final ViewReservaciones view_reservaciones;
    private final ModelReservaciones model_reservaciones;
    private final ControllerReservaciones controller_reservaciones;
    
    private final ViewServicios view_servicios;
    private final ModelServicios model_servicios;
    private final ControllerServicios controller_servicios;
    
    private final ViewIngreso view_ingreso;
    private final ModelIngreso model_ingreso;
    private final ControllerIngreso controller_ingreso;
    
    public ControllerMain(Object[] models, Object[] views, Object[] controllers){
        this.view_main = (ViewMain)views[0];
        this.model_main = (ModelMain)models[0];
        
        this.view_login = (ViewLogin)views[1];
        this.model_login = (ModelLogin)models[1];
        this.controller_login = (ControllerLogin)controllers[1];
        
        this.view_clientes = (ViewClientes)views[2];
        this.model_clientes = (ModelClientes)models[2];
        this.controller_clientes = (ControllerClientes)controllers[2];
        
        this.view_inventario = (ViewInventario) views[3];
        this.model_inventario = (ModelInventario) models[3];
        this.controller_inventario = (ControllerInventario) controllers[3];
        
        this.view_empleados = (ViewEmpleados) views[4];
        this.model_empleados = (ModelEmpleados) models[4];
        this.controller_empleados = (ControllerEmpleados) controllers[4];
        
        this.view_egreso = (ViewEgreso) views[5];
        this.model_egreso = (ModelEgreso) models[5];
        this.controller_egreso = (ControllerEgreso) controllers[5];
        
        this.view_ingresar_egreso = (ViewIngresarEgreso) views[6];
        this.model_ingresar_egreso = (ModelIngresarEgreso) models[6];
        this.controller_ingresar_egreso = (ControllerIngresarEgreso) controllers[6];
        
        this.view_reservaciones = (ViewReservaciones) views[7];
        this.model_reservaciones = (ModelReservaciones) models[7];
        this.controller_reservaciones = (ControllerReservaciones) controllers[7];
        
        this.view_servicios = (ViewServicios) views[8];
        this.model_servicios = (ModelServicios) models[8];
        this.controller_servicios = (ControllerServicios) controllers[8];
        
        this.view_ingreso = (ViewIngreso) views[9];
        this.model_ingreso = (ModelIngreso) models[9];
        this.controller_ingreso = (ControllerIngreso) controllers[9];
        initView();
    }    
    public void initView(){
        view_main.setVisible(true);
        view_main.setResizable(false); //tamaño
        view_main.setLocationRelativeTo(null);
        view_main.setTitle("Bienvenido");
        //jmi
        
        view_main.jm_efectivo.setVisible(false);
        view_main.jm_menu.setVisible(false);
        view_main.jm_sistema.setVisible(false);
        view_main.jm_efectivo.setVisible(false);
        this.view_main.jmi_clientes.addActionListener(e-> jmi_clientesActionPerformed());    
        this.view_main.jmi_cerrar_sesion.addActionListener(e-> jmi_cerrar_sesionActionPerformed());
        this.view_main.jmi_iniciar_sesion.addActionListener(e -> jmi_verificacion_usuarioMouseClicked());
        this.view_main.jmi_inventario.addActionListener(e-> jmi_inventarioActionPerformed());
        this.view_main.jmi_empleados.addActionListener(e-> jmi_empleadosActionPerformed());
        this.view_main.jmi_agregar_egreso.addActionListener(e-> jmi_agregar_egresoActionPerformed());
        this.view_main.jmi_consultar_egreso.addActionListener(e-> jmi_consultar_egresoActionPerformed());
        this.view_main.jmi_reservaciones.addActionListener(e-> jmi_reservacionesActionPerformded());
        this.view_main.jmi_servicios.addActionListener(e-> jmi_serviciosActionPerformed());
        this.view_main.jmi_ingresos.addActionListener(e-> jmi_ingresosActionPerformed());
    }
     public void Cambiar_Interfaz(javax.swing.JPanel interfaz){
        view_main.setContentPane(interfaz);
        view_main.revalidate();
        view_main.repaint();
        interfaz.requestFocusInWindow();
    }   
    
     public void jmi_clientesActionPerformed(){
        Cambiar_Interfaz(view_clientes);
    }   
    
    public void jmi_inventarioActionPerformed(){
        Cambiar_Interfaz(view_inventario);
    }
    
    public void jmi_empleadosActionPerformed(){
        Cambiar_Interfaz(view_empleados);
    }
    
    public void jmi_consultar_egresoActionPerformed(){
        Cambiar_Interfaz(view_egreso);
    }
    public void jmi_agregar_egresoActionPerformed(){
        Cambiar_Interfaz(view_ingresar_egreso);
    }
    public void jmi_reservacionesActionPerformded(){
        Cambiar_Interfaz(view_reservaciones);
    }

    public void jmi_serviciosActionPerformed(){
        Cambiar_Interfaz(view_servicios);
    }
    public void jmi_ingresosActionPerformed(){
        Cambiar_Interfaz(view_ingreso);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    public void jmi_verificacion_usuarioMouseClicked(){
        view_main.setContentPane(view_login);
        view_main.revalidate();
        view_main.repaint();
        
    }
    
    
    public void jmi_cerrar_sesionActionPerformed(){
        System.exit(0);
    }    
}
