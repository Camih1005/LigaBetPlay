package com.ligabetplay.view;


import com.ligabetplay.Controller;


public class ShowValues {


    public boolean showStadiums(){
        if(Controller.getInstance().estadios.isEmpty()){
            System.out.println("No hay estadios disponibles");
            return false;
        }
        Controller.getInstance().estadios.forEach((key, value)-> 
        System.out.println("Codigo: " + key + ", Nombre: " + value.getNombre()));
        return true;
    };


    public boolean showTrainers(){
        if(Controller.getInstance().entrenadores.isEmpty()){
            System.out.println("No hay entrenadores disponibles");
            return false;
        }
        Controller.getInstance().entrenadores.forEach((key, value)-> 
        System.out.println("codigo: " + key + ", Nombre: " + value.getNombre()));
        return true;
    };

    public boolean showTeam(){
        if(Controller.getInstance().equipos.isEmpty()){
            System.out.println("No hay equipos disponibles");
            return false;
        }
        Controller.getInstance().equipos.forEach((key, value)-> 
        System.out.println("codigo: " + key + ", Nombre: " + value.getNombre()));
        return true;
    }

    public boolean showCoach(){
        if(Controller.getInstance().entrenadores.isEmpty()){
            System.out.println("No hay entrenadores disponibles");
            return false;
        }
        Controller.getInstance().entrenadores.forEach((key, value)-> 
        System.out.println("codigo: " + key + ", Nombre: " + value.getNombre()));
        return true;
    }

    public boolean showPlayer(){
        if(Controller.getInstance().jugadores.isEmpty()){
            System.out.println("No hay jugadores disponibles");
            return false;
        }
        Controller.getInstance().jugadores.forEach((key, value)-> 
        System.out.println("codigo: " + key + ", Nombre: " + value.getNombre()));
        return true;
    }

    
        
}
