package com.ligabetplay.view.SubViews;

import java.util.Scanner;

import com.ligabetplay.Controller;
import com.ligabetplay.model.Coach;
import com.ligabetplay.view.ShowValues;
import com.ligabetplay.view.Validation;

public class viewGestionCoach {
    Controller controlador = Controller.getInstance();
    Scanner sc = controlador.sc;
    Validation val =  new Validation();
    ShowValues mostrar = new ShowValues();


    public void start(){
        
        int choice = 0;
        
        System.out.println("\r\n" + //
                        "█▀▀ █▀▀ █▀ ▀█▀ █ █▀█ █▄░█   █▀▄ █▀▀   █▀▀ █▄░█ ▀█▀ █▀█ █▀▀ █▄░█ ▄▀█ █▀▄ █▀█ █▀█ █▀▀ █▀\r\n" + //
                        "█▄█ ██▄ ▄█ ░█░ █ █▄█ █░▀█   █▄▀ ██▄   ██▄ █░▀█ ░█░ █▀▄ ██▄ █░▀█ █▀█ █▄▀ █▄█ █▀▄ ██▄ ▄█");

        while (true) {
            System.out.println("\n1. Agregar Entrenador");
            System.out.println("2. Editar Entrenador");
            System.out.println("3. Eliminar Entrenador");
            System.out.println("4. Volver");

            choice = Integer.parseInt(Validation.leerdato("Elija una opcion: ", controlador.sc));
            System.out.println("\n");

            switch (choice) {
                case 1:
                    addCoach();
                    break;
                case 2:
                    editCoach();
                    break;
                case 3:
                    deleteCoach();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opcion invalida, intentelo de nuevo.");
            }

        }
    }

    public void addCoach(){
        Coach entrenador = new Coach();
        Integer codigoEntrenador = Validation.leerNumero("Digite el id del entrenador: ", sc);

        if((controlador.entrenadores.containsKey(codigoEntrenador))){
            System.out.println("Codigo ya Existe");    
            return;
        }

        entrenador.setId(codigoEntrenador);
        entrenador.setNombre(Validation.leerdato("Digite el nombre del entrenador: ", sc));
        entrenador.setIdFederacion(Validation.leerNumero("Digite el id de federacion del entrenador: ",sc));

        
        controlador.entrenadores.put(codigoEntrenador, entrenador);
        System.out.println("Creado satisfactoriamente");
    }

    

    public void editCoach(){
        boolean mostrarEntrenadores = mostrar.showCoach();
        if(mostrarEntrenadores==false){
            return;
        }

        int codigoEntrenador = Validation.leerNumero("Digite el id del entrenador a actualizar: ",sc);
        if(!controlador.entrenadores.containsKey(codigoEntrenador)){
            System.out.println("Error codigo no valido");
            return ;
        }

        Coach entrenador = controlador.entrenadores.get(codigoEntrenador);

        System.out.println("Campos de Entrenador");
        System.out.println("1. Nombre");
        System.out.println("2. id Federacion");

        int opcion = Validation.leerNumero("Digite la opcion que desea editar: ",sc);


        switch (opcion) {
            case 1:
                System.out.println("Campo Actual: " + entrenador.getNombre());
                entrenador.setNombre(Validation.leerdato("Digite el nombre del entrenador: ",sc ));
                
                break;
            case 2:
                System.out.println("Campo Actual: " + entrenador.getIdFederacion());
                entrenador.setIdFederacion(Validation.leerNumero("Digite el id de federacion del entrenador: ",sc ));
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
        System.out.println("---------------------------------");
        System.out.println("Campo actualizado  exitosamente");
        System.out.println("---------------------------------");
        return;
    }


    public void deleteCoach(){
        boolean mostrarEntrenadores = mostrar.showCoach();
        if(mostrarEntrenadores==false){
            return;
        }

        int codigoEntrenador = Validation.leerNumero("\nDigite el id del entrenador a eliminar: ",sc);
        if(!controlador.entrenadores.containsKey(codigoEntrenador)){
            System.out.println("Error codigo no valido");
            return ;
        }
        
        controlador.entrenadores.remove(codigoEntrenador);
        System.out.println("Entrenador Eliminado Exitosamente");

        return;
    }

}
