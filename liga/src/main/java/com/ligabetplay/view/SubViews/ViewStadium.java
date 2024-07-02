package com.ligabetplay.view.SubViews;

import java.util.Scanner;

import com.ligabetplay.Controller;
import com.ligabetplay.Main;
import com.ligabetplay.model.Stadium;
import com.ligabetplay.view.ShowValues;
import com.ligabetplay.view.Validation;

public class ViewStadium {

    Controller controlador = Controller.getInstance();
    Scanner sc = controlador.sc;
    ShowValues mostrar = new ShowValues();


    public void start(){
        Main.limpiarPantalla();
        int choice = 0;
        System.out.println("\n" + //
                        "█▀▀ █▀▀ █▀ ▀█▀ █ █▀█ █▄░█   █▀▄ █▀▀   █▀▀ █▀ ▀█▀ ▄▀█ █▀▄ █ █▀█ █▀\n" + //
                        "█▄█ ██▄ ▄█ ░█░ █ █▄█ █░▀█   █▄▀ ██▄   ██▄ ▄█ ░█░ █▀█ █▄▀ █ █▄█ ▄█");

        while (true) {
            System.out.println("\n1. Agregar Estadio");
            System.out.println("2. Editar Estadio");
            System.out.println("3. Eliminar Estadio");
            System.out.println("4. Volver");

            choice = Integer.parseInt(Validation.leerdato("Elija una opcion: ", controlador.sc));
            System.out.println("\n");
          

            switch (choice) {
                case 1:
                    addStadium();
                    break;
                case 2:
                    editStadium();
                    break;
                case 3:
                    deleteStadium();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Campo no Valido");
                    break;
            }
           
        }

    }

    public void addStadium(){

        Stadium estadio = new Stadium();
        Integer codigoEstadio = Validation.leerNumero("Digite el id del estadio: ", sc);

        if((controlador.estadios.containsKey(codigoEstadio))){
            System.out.println("Codigo ya Existe");    
            return;
        }

        estadio.setId(codigoEstadio);
        estadio.setNombre(Validation.leerdato("Digite el nombre del estadio: ", sc));
        estadio.setUbicacion(Validation.leerdato("Digite la ubicacion del estadio: ", sc));
        estadio.setCapacidad(Validation.leerNumero("Digite la capacidad del estadio: ", sc));
        controlador.estadios.put(codigoEstadio, estadio);

        System.out.println("---------------------------------");
        System.out.println("Creacion del estadio exitosa");  
        System.out.println("---------------------------------");

       

        return;
    }


    public void editStadium(){

        boolean mostrarEstadios = mostrar.showStadiums();
        if(mostrarEstadios==false){
            return;
        }

        int codigoEstadio = Validation.leerNumero("Digite el estadio a actualizar: ",sc);
        if(!controlador.estadios.containsKey(codigoEstadio)){
            System.out.println("Error codigo no valido");
            return ;
        }

        Stadium estadio = controlador.estadios.get(codigoEstadio);

        System.out.println("Campos de estadio");
        System.out.println("1. nombre");
        System.out.println("2. Ubicacion");
        System.out.println("3. Capacidad");

        int opcion = Validation.leerNumero("Digite la opcion que desea editar: ",sc);


        switch (opcion) {
            case 1:
                System.out.println("Campo Actual: " + estadio.getNombre());
                estadio.setNombre(Validation.leerdato("Digite el nombre del estadio: ",sc ));
                
                break;
            case 2:
                System.out.println("Campo Actual: " + estadio.getUbicacion());
                estadio.setUbicacion(Validation.leerdato("Digite la ubicacion del estadio: ",sc ));
                break;
            case 3:
            System.out.println("Campo Actual: " + estadio.getCapacidad());
            estadio.setCapacidad(Validation.leerNumero("Digite la capacidad del estadio: ",sc ));
                break;
            default:
                break;
        }
        System.out.println("---------------------------------");
        System.out.println("Campo actualizado  exitosamente");
        System.out.println("---------------------------------");
        return;
    }


    public void deleteStadium(){
        
        boolean mostrarEstadios = mostrar.showStadiums();
        if(mostrarEstadios==false){
            return;
        }

        int codigoEstadio = Validation.leerNumero("\nDigite el estadio a eliminar: ",sc);
        if(!controlador.estadios.containsKey(codigoEstadio)){
            System.out.println("Error codigo no valido");
            return ;
        }
        
        controlador.estadios.remove(codigoEstadio);
        System.out.println("Estadio Eliminado Exitosamente");

        return;
    }

    

}
