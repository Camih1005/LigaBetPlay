package com.ligabetplay.view;


import com.ligabetplay.Controller;
import com.ligabetplay.model.Stadium;


public class ShowValues {


    public boolean showStadiums(){
        if(Controller.getInstance().estadios.isEmpty()){
            System.out.println("No hay estadios disponibles");
            Stadium stadium = new Stadium();
            System.out.println(stadium.getId() + stadium.getNombre() + stadium.getUbicacion());
            return false;
        }
        Controller.getInstance().estadios.forEach((key, value)-> 
        System.out.println("Codigo: " + key + ", Nombre: " + value.getNombre()));
        return true;
    };

    public boolean showTeam(){
        if(Controller.getInstance().equipos.isEmpty()){
            System.out.println("No hay equipos disponibles");
            return false;
        }
        
            System.out.println("╔════════════════════════════════════════════════════╗");
            System.out.println("║                       EQUIPOS                      ║");
            System.out.println("╠════════════════════════════════════════════════════╣");
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


    // public boolean showMatch(){
    //     if(Controller.getInstance().partidos.isEmpty()){
    //         System.out.println("No hay partidos disponibles");
    //         return false;
    //     }
    //     Controller.getInstance().partidos.forEach((key, value)-> 
    //     System.out.println("codigo: " + key + ", Fecha partido: " + value.getFecha()));
    //     return true;
    // }


    
        
}
