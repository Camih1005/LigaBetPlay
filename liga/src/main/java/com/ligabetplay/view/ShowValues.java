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
            System.out.println("╔════════════════════════════════════════════════════╗");
            System.out.println("║                       ESTADIOS                     ║");
            System.out.println("╠════════════════════════════════════════════════════╣");
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
            System.out.println("╔════════════════════════════════════════════════════╗");
            System.out.println("║                     ENTRENADORES                   ║");
            System.out.println("╠════════════════════════════════════════════════════╣");
        Controller.getInstance().entrenadores.forEach((key, value)-> 
        System.out.println("codigo: " + key + ", Nombre: " + value.getNombre()));
        return true;
    }

    public boolean showPlayer(){
        if(Controller.getInstance().jugadores.isEmpty()){
            System.out.println("No hay jugadores disponibles");
            return false;
        }
            System.out.println("╔════════════════════════════════════════════════════╗");
            System.out.println("║                    JUGADORES                       ║");
            System.out.println("╠════════════════════════════════════════════════════╣");
        Controller.getInstance().jugadores.forEach((key, value)-> 
        System.out.println("codigo: " + key + ", Nombre: " + value.getNombre()));
        return true;
    }


    public boolean showUser(){
        if(Controller.getInstance().usuarios.isEmpty()){
            System.out.println("No hay usuarios disponibles");
            return false;
        }
            System.out.println("╔════════════════════════════════════════════════════╗");
            System.out.println("║                     USUARIOS                       ║");
            System.out.println("╠════════════════════════════════════════════════════╣");
        Controller.getInstance().usuarios.forEach((key, value)-> 
        System.out.println("codigo: " + key + ", Nombre: " + value.getNombre()));
        return true;
    }


    public boolean showAnnouncements(){
        if(Controller.getInstance().comunicaciones.isEmpty()){
            System.out.println("No hay comunicaciones disponibles");
            return false;
        }
            System.out.println("╔════════════════════════════════════════════════════╗");
            System.out.println("║                      COMUNICADOS                   ║");
            System.out.println("╠════════════════════════════════════════════════════╣");
        Controller.getInstance().comunicaciones.forEach((key, value)-> 
        System.out.println("codigo: " + key + ", Nombre: " + value.getTitulo()));
        return true;
    }
    
    public boolean showMatch(){
        if(Controller.getInstance().programacionPartidos.isEmpty()){
            System.out.println("No hay partidos disponibles");
            return false;
        }
            System.out.println("╔════════════════════════════════════════════════════╗");
            System.out.println("║                     PARTIDOS                       ║");
            System.out.println("╠════════════════════════════════════════════════════╣");
        Controller.getInstance().programacionPartidos.forEach((key, value)-> 
        System.out.println("codigo: " + key + ", Fecha partido: " + value.getFecha()));
        return true;
    }


    public boolean showReferee(){
        if(Controller.getInstance().Arbitro.isEmpty()){
            System.out.println("No hay arbitros disponibles");
            return false;
        }
            System.out.println("╔════════════════════════════════════════════════════╗");
            System.out.println("║                   ARBITROS                         ║");
            System.out.println("╠════════════════════════════════════════════════════╣");
        Controller.getInstance().Arbitro.forEach((key, value)-> 
        System.out.println("codigo: " + key + ", Nombre: " + value.getNombre()));
        return true;
    }


    
        
}
