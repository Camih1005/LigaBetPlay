package com.ligabetplay.view.SubViews;

import java.util.Scanner;

import com.ligabetplay.Controller;
import com.ligabetplay.Main;
import com.ligabetplay.model.Referee;
import com.ligabetplay.view.ShowValues;
import com.ligabetplay.view.Validation;

public class VistaReferee {

    Controller controlador = Controller.getInstance();
    Scanner sc = controlador.sc;
    ShowValues mostrar = new ShowValues();

    public void start(){
        Main.limpiarPantalla();
        int choice = 0;
        
        System.out.println("Vista Referee");

        while (true) {
            System.out.println("\n1. Agregar Arbitro");
            System.out.println("2. Editar Arbitro");
            System.out.println("3. Eliminar Arbitro");
            System.out.println("4. Volver");

            choice = Integer.parseInt(Validation.leerdato("Elija una opcion: ", controlador.sc));
            System.out.println("\n");
          

            switch (choice) {
                case 1:
                    addReferee();
                    break;
                case 2:
                    editReferee();
                    break;
                case 3:
                    deleteReferee();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Campo no Valido");
                    break;
            }
           
        }
    }

    public void addReferee(){
        Referee arbitro = new Referee();
        Integer codigoArbitro = Validation.leerNumero("Digite el id del arbitro: ", sc);

        if((controlador.Arbitro.containsKey(codigoArbitro))){
            System.out.println("Codigo ya Existe");    
            return;
        }

        arbitro.setId(codigoArbitro);
        arbitro.setNombre(Validation.leerdato("Digite el nombre del Arbitro: ", sc));
        arbitro.setExperiencia(Validation.leerdato("Digite la experiencia del Arbitro: ", sc));
        controlador.Arbitro.put(codigoArbitro, arbitro);

        System.out.println("---------------------------------");
        System.out.println("Creacion del Arbitro exitosa");  
        System.out.println("---------------------------------");
        return;
    }

    public void editReferee(){

        boolean mostrarArbitros = mostrar.showReferee();
        if(mostrarArbitros==false){
            return;
        }

        int codigoArbitro = Validation.leerNumero("Digite el arbitro a actualizar: ",sc);
        if(!controlador.Arbitro.containsKey(codigoArbitro)){
            System.out.println("Error codigo no valido");
            return ;
        }

        Referee arbitro = controlador.Arbitro.get(codigoArbitro);

        System.out.println("Campos del Arbitro");
        System.out.println("1. nombre");
        System.out.println("2. experiencia");
        
        int opcion = Validation.leerNumero("Digite la opcion que desea editar: ",sc);


        switch (opcion) {
            case 1:
                System.out.println("Campo Actual: " + arbitro.getNombre());
                arbitro.setNombre(Validation.leerdato("Digite el nombre del arbitro: ",sc ));
                break;
            case 2:
                System.out.println("Campo Actual: " + arbitro.getExperiencia());
                arbitro.setExperiencia(Validation.leerdato("Digite la experiencia del arbitro: ",sc ));
                break;
            default:
                break;
        }
        System.out.println("---------------------------------");
        System.out.println("Campo actualizado  exitosamente");
        System.out.println("---------------------------------");
        return;
    }

    public void deleteReferee(){
        boolean mostrarArbitros = mostrar.showStadiums();
        if(mostrarArbitros==false){
            return;
        }

        int codigoArbitro = Validation.leerNumero("\nDigite el arbitro a eliminar: ",sc);
        if(!controlador.Arbitro.containsKey(codigoArbitro)){
            System.out.println("Error codigo no valido");
            return ;
        }
        
        controlador.Arbitro.remove(codigoArbitro);
        System.out.println("Arbitro Eliminado Exitosamente");

        return;
    }
}
