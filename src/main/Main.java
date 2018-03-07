
package main;
import views.*;
import controllers.*;
import models.*;
/**
 *
 * @author fernando
 */
public class Main {   

    public static void main (String ferk[]){
        ModelMain model_main = new ModelMain();
        ModelLogin model_login = new ModelLogin(model_main);
        ModelClientes model_clientes = new ModelClientes(model_main);
        ModelInventario model_inventario = new ModelInventario(model_main);
        ModelEmpleados model_empleados = new ModelEmpleados(model_main);
        ModelEgreso model_egreso = new ModelEgreso(model_main);
        ModelIngresarEgreso model_ingresar_egreso = new ModelIngresarEgreso(model_main);
        ModelReservaciones model_reservaciones = new ModelReservaciones(model_main);
        ModelServicios model_servicios = new ModelServicios(model_main);
        ModelIngreso model_ingreso = new ModelIngreso(model_main);
        
        ViewMain view_main = new ViewMain();
        ViewLogin view_login = new ViewLogin();
        ViewClientes view_clientes = new ViewClientes();
        ViewInventario view_inventario = new ViewInventario();
        ViewEmpleados view_empleados = new ViewEmpleados();
        ViewEgreso view_egreso = new ViewEgreso();
        ViewIngresarEgreso view_ingresar_egreso = new ViewIngresarEgreso();
        ViewReservaciones view_reservaciones = new ViewReservaciones();
        ViewServicios view_servicios = new ViewServicios();
        ViewIngreso view_ingreso = new ViewIngreso();
        
        Object[] models = new Object[10];
        Object[] views = new Object[10];
        Object[] controllers = new Object[10];
        
        models[0] = model_main;
        models[1] = model_login;
        models[2] = model_clientes;
        models[3] = model_inventario;
        models[4] = model_empleados;
        models[5] = model_egreso;
        models[6] = model_ingresar_egreso;
        models[7] = model_reservaciones;
        models[8] = model_servicios;
        models[9] = model_ingreso;
        
        views[0] = view_main;
        views[1] = view_login;
        views[2] = view_clientes;
        views[3] = view_inventario;
        views[4] = view_empleados;
        views[5] = view_egreso;
        views[6] = view_ingresar_egreso;
        views[7] = view_reservaciones;
        views[8] = view_servicios;
        views[9] = view_ingreso;

        ControllerMain controller_main = new ControllerMain(models, views, controllers);
        controllers[0] = controller_main;  
        
        ControllerLogin controller_login = new ControllerLogin(models, views, controllers);
        controllers[1] = controller_login;
        
        ControllerClientes controller_clientes = new ControllerClientes(models, views, controllers);
        controllers[2] = controller_clientes;
        
        ControllerInventario controller_inventario = new ControllerInventario(models, views, controllers);
        controllers[3] = controller_inventario;
        
        ControllerEmpleados controller_empleados = new ControllerEmpleados(models, views, controllers);
        controllers[4] = controller_empleados;
        
        ControllerEgreso controller_egreso = new ControllerEgreso(models, views, controllers);
        controllers[5] = controller_egreso;
        
        ControllerIngresarEgreso controller_ingresar_egreso = new ControllerIngresarEgreso(models, views, controllers);
        controllers[6] = controller_ingresar_egreso;
        
        ControllerReservaciones controller_reservaciones = new ControllerReservaciones(models, views, controllers);
        controllers[7] = controller_reservaciones;
        
        ControllerServicios controller_servicios = new ControllerServicios(models, views, controllers);
        controllers[8] = controller_servicios;
        
        ControllerIngreso controller_ingreso = new ControllerIngreso(models, views, controllers);
        controllers[9] = controller_ingreso;
      }
}
