/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import models.ModelIngreso;
import models.ModelMain;
import views.ViewIngreso;

/**
 *
 * @author fernando
 */
public class ControllerIngreso implements FocusListener{
    private final ModelIngreso model_ingreso;
    private final ViewIngreso view_ingreso;
    private final ModelMain model_main;
    
    public ControllerIngreso(Object[] models, Object[] views, Object[] controllers){
        this.model_ingreso = (ModelIngreso) models[9];
        this.view_ingreso = (ViewIngreso) views[9];
        this.model_main = (ModelMain) models[0];
        
        initView();
    }
    public void initView(){
        view_ingreso.addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
    }
}
