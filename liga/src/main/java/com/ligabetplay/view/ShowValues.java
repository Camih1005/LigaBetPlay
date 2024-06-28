package com.ligabetplay.view;


import com.ligabetplay.Controller;


public class ShowValues {


    public boolean showStadiums(){
        if(Controller.getInstance().estadios.isEmpty()){
            System.out.println("No hay estadios disponibles");
            return false;
        }

        Controller.getInstance().estadios.forEach((key, value)-> 
        System.out.println("key: " + key + "Nombre: " + value.getNombre()));
        return true;
    };


    public boolean showTrainers(){
        if(Controller.getInstance().entrenadores.isEmpty()){
            System.out.println("No hay entrenadores disponibles");
            return false;
        }

        Controller.getInstance().entrenadores.forEach((key, value)-> 
        System.out.println("key: " + key + "Nombre: " + value.getNombre()));
        return true;
    };
        
}
