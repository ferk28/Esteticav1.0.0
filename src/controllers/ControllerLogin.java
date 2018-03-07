package controllers;
import models.ModelLogin;
import views.ViewMain;
import views.ViewLogin;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 *
 * @author fernando
 */
public class ControllerLogin{
    private final ModelLogin model_login;
    private final ViewMain view_main;
    private final ViewLogin view_login;
    private final ControllerMain controller_main;
    
    
    public ControllerLogin(Object models[], Object views[], Object controllers[]){
        this.model_login = (ModelLogin)models[1];
        this.view_login = (ViewLogin) views[1];
        this.view_main = (ViewMain) views[0];
        this.controller_main = (ControllerMain) controllers[0];

        initView();

    }
    public void initView(){
        view_login.jbtn_entrar.addActionListener(e-> jbtn_iniciarMouseClicker());
        view_login.setFocusable(true);
        view_login.requestFocusInWindow();
    }   
    
    
    public void setDatos(){
        model_login.setUsuario(view_login.jtf_usuario.getText());
        model_login.setContraseña_usuario(view_login.jpf_contraseña.getPassword());
    }
   
    
    public void jbtn_iniciarMouseClicker(){
        setDatos();
        model_login.Verificar_Usuario();
        model_login.Verificar_Tipo_Usuario();
        if(model_login.getTipo_usuario().equals("Admin")){
            view_main.jm_archivo.setVisible(false);
            view_main.jm_efectivo.setVisible(true);
            view_main.jm_iniciar_sesion.setVisible(true);
            view_main.jm_menu.setVisible(true);
            view_main.jm_sistema.setVisible(true);

            view_main.jm_salir.setVisible(true);
            view_main.jm_efectivo.setVisible(true);
            view_main.jmi_agregar_egreso.setVisible(true);
            view_main.jmi_clientes.setVisible(true);
            view_main.jmi_consultar_egreso.setVisible(true);
            view_main.jmi_egreso.setVisible(true);
            view_main.jmi_empleados.setVisible(true);
            view_main.jmi_ingresos.setVisible(true);
            view_main.jmi_inventario.setVisible(true);
            view_main.jmi_reservaciones.setVisible(true);
            view_main.jmi_servicios.setVisible(true);
        }
        else{
            view_main.jm_archivo.setVisible(false);
            view_main.jm_efectivo.setVisible(true);
            view_main.jm_iniciar_sesion.setVisible(false);
            view_main.jm_sistema.setVisible(true);
            view_main.jm_salir.setVisible(true);

            view_main.jmi_agregar_egreso.setVisible(true);
            view_main.jmi_cerrar_sesion.setVisible(true);
            view_main.jmi_consultar_egreso.setVisible(true);
            view_main.jmi_egreso.setVisible(true);
            view_main.jmi_ingresos.setVisible(false);
            view_main.jmi_inventario.setVisible(false);
            view_main.jmi_reservaciones.setVisible(true);
            view_main.jmi_servicios.setVisible(true);
        
        }
        view_login.jtf_usuario.setText("");
        view_login.jpf_contraseña.setText("");
    }    
} 
