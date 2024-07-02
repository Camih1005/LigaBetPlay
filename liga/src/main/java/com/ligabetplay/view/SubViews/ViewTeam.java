package com.ligabetplay.view.SubViews;
import java.util.Scanner;

import com.ligabetplay.Controller;
import com.ligabetplay.model.Team;
import com.ligabetplay.view.ShowValues;
import com.ligabetplay.view.Validation;

public class ViewTeam {

    Controller controlador = Controller.getInstance();
    Scanner sc = controlador.sc;
    ShowValues mostrar = new ShowValues();

    public void start(){
        
        int choice = 0;

        System.out.println("\r\n" + //
                        "█▀▀ █▀▀ █▀ ▀█▀ █ █▀█ █▄░█   █▀▄ █▀▀   █▀▀ █▀█ █░█ █ █▀█ █▀█\r\n" + //
                        "█▄█ ██▄ ▄█ ░█░ █ █▄█ █░▀█   █▄▀ ██▄   ██▄ ▀▀█ █▄█ █ █▀▀ █▄█");

        while (true) {
            
            System.out.println("\n1. Agregar Equipo");
            System.out.println("2. Editar Equipo");
            System.out.println("3. Eliminar Equipo");
            System.out.println("4. Volver");

            choice = Integer.parseInt(Validation.leerdato("Elija una opcion: ", controlador.sc));
            System.out.println("\n");


            switch (choice) {
                case 1:
                    addTeam();
                    break;
                case 2:
                    editTeam();
                    break;
                case 3:
                    deleteTeam();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opcion invalida, intentelo de nuevo.");
            }

        }
    }

    
    public void addTeam(){
        boolean bandera=true;
        Team equipo = new Team();

        int codigoE = Validation.leerNumero("Ingrese el codigo del equipo: ", controlador.sc);
            
        if (controlador.equipos.containsKey(codigoE)) {
            System.out.println("Error: Codigo ya Existe");
                return;
        }

        equipo.setNombre(Validation.leerdato("Ingrese Nombre del equipo: ",controlador.sc));
        equipo.setCiudad(Validation.leerdato("Ingrese la ciudad: ",controlador.sc));

        boolean mostrarEstadio = mostrar.showStadiums();
        if(mostrarEstadio==false){ bandera = false; }
            if(bandera==true){
                int codigoEstadio = Validation.leerNumero("Digite el codigo del estadio: ",sc);
                if(!controlador.estadios.containsKey(codigoEstadio)){ System.out.println("Error codigo no valido"); bandera=false;}
                    if(bandera==true){equipo.setEstadio(controlador.estadios.get(codigoEstadio).getNombre());}
            }
        
    
        bandera=true;
        boolean mostrarEntrenadores = mostrar.showCoach();
        if(mostrarEntrenadores==false){ bandera = false; }
            if(bandera==true){
                int codigoEntrenador = Validation.leerNumero("Digite el codigo del entrenador: ",sc);
                if(!controlador.entrenadores.containsKey(codigoEntrenador)){ System.out.println("Error codigo no valido"); bandera=false;}
                    if(bandera==true){equipo.setCoach(controlador.entrenadores.get(codigoEntrenador).getNombre());}
            }
        
        controlador.equipos.put(codigoE, equipo);
        System.out.println("\nEquipo creado con exito");
        return;

    }

    
    public void editTeam(){
            
        boolean mostrarEquipos = mostrar.showTeam();
        if(mostrarEquipos==false){
            return;
        }

        int codigoEquipo = Validation.leerNumero("Digite el equipo a actualizar: ",sc);
        if(!controlador.equipos.containsKey(codigoEquipo)){
            System.out.println("Error codigo no valido");
            return ;
        }

        Team equipo = controlador.equipos.get(codigoEquipo);

        System.out.println("Campos de equipo");
        System.out.println("1. nombre");
        System.out.println("2. Ciudad");
        System.out.println("3. Estadio");
        System.out.println("4. Couch");

        int opcion = Validation.leerNumero("Digite la opcion que desea editar: ",sc);


        switch (opcion) {
            case 1:
                System.out.println("Campo Actual: " + equipo.getNombre());
                equipo.setNombre(Validation.leerdato("Digite el nombre del equipo: ",sc ));
                
                break;
            case 2:
                System.out.println("Campo Actual: " + equipo.getCiudad());
                equipo.setCiudad(Validation.leerdato("Digite la Ciudad del equipo: ",sc ));
                break;
            case 3:
                boolean mostrarEstadio = mostrar.showStadiums();
                if(mostrarEstadio==false){ return; }
                int codigoEstadio = Validation.leerNumero("Digite el codigo del estadio: ",sc);
                if(!controlador.estadios.containsKey(codigoEstadio)){ System.out.println("Error codigo no valido"); return;}
                equipo.setEstadio(controlador.estadios.get(codigoEstadio).getNombre());
            case 4:
                boolean mostrarCoach = mostrar.showCoach();
                if(mostrarCoach==false){ return; }
                int codigoCoach = Validation.leerNumero("Digite el codigo del coach: ",sc);
                if(!controlador.entrenadores.containsKey(codigoCoach)){ System.out.println("Error codigo no valido"); return;}
                equipo.setCoach(controlador.entrenadores.get(codigoCoach).getNombre());
            default:
                break;
        }
        System.out.println("---------------------------------");
        System.out.println("Campo actualizado  exitosamente");
        System.out.println("---------------------------------");
        return;
    }

    
    public void deleteTeam(){
             
        boolean mostrarEquipos = mostrar.showTeam();
        if(mostrarEquipos==false){
            return;
        }

        int codigoEquipo = Validation.leerNumero("\nDigite el equipo a eliminar: ",sc);
        if(!controlador.equipos.containsKey(codigoEquipo)){
            System.out.println("Error codigo no valido");
            return ;
        }
        
        controlador.equipos.remove(codigoEquipo);
        System.out.println("Estadio Eliminado Exitosamente");

        return;
        }

    }
    