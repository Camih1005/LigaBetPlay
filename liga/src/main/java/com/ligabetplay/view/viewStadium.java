package com.ligabetplay.view;

import java.util.Scanner;

import com.ligabetplay.Controller;
import com.ligabetplay.model.Stadium;

public class viewStadium {

    Controller controlador = Controller.getInstance();
    Scanner sc = controlador.sc;
    Validation val =  new Validation();

    public void gestionDeEstadios(){

        int choice = 0;
        Boolean validar;

        System.out.println("\n" + //
                        "█▀▀ █▀▀ █▀ ▀█▀ █ █▀█ █▄░█   █▀▄ █▀▀   █▀▀ █▀ ▀█▀ ▄▀█ █▀▄ █ █▀█ █▀\n" + //
                        "█▄█ ██▄ ▄█ ░█░ █ █▄█ █░▀█   █▄▀ ██▄   ██▄ ▄█ ░█░ █▀█ █▄▀ █ █▄█ ▄█");

        while (true) {
            System.out.println("\n1. Agregar Estadio");
            System.out.println("2. Editar Estadio");
            System.out.println("3. Eliminar Estadio");
            System.out.println("4. Volver");

            choice = Integer.parseInt(val.leerdato("Elija una opcion: ", controlador.sc));
            System.out.println("\n");
          

            switch (choice) {
                case 1:
                    validar = addStadium();
                    if(validar==false){
                        continue;
                    }
                    break;
                case 2:
                    validar = editStadium();
                    if(validar==false){
                    continue;
                    }
                    
                    
                    break;
                case 3:
                    
                    break;
            
                default:
                    break;
            }
        
        }

    }

    public boolean addStadium(){

        Stadium estadio = new Stadium();

        Integer codigoEstadio = val.leerNumero("Digite el id del estadio: ", sc);

        
        if((!controlador.entrenadores.containsKey(codigoEstadio))){
            System.out.println("Codigo Incorrecto");    
            return false;
        }

        estadio.setId(codigoEstadio);

        estadio.setNombre(val.leerdato("Digite el nombre del estadio", sc));
        estadio.setUbicacion(val.leerdato("Digite la ubicacion del estadio", sc));
        estadio.setCapacidad(val.leerNumero("Digite la capacidad del estadio", sc));

        controlador.estadios.put(codigoEstadio, estadio);
        System.out.println("Creacion del estadio exitosa");

        return true;
    }


    public boolean editStadium(){

        int codigoEstadio = val.leerNumero("Digite el estadio a actualizar",sc);

        System.out.println("Campos de estadio");
        System.out.println("1. nombre");
        System.out.println("2. Ubicacion");
        System.out.println("3. Capacidad");
        


        System.out.println("");

        int opcion = val.leerNumero("Digite la opcion que desea editar",sc);







        return false;
        
    }

    

}
