package com.ligabetplay.view.SubViews;

import java.util.Scanner;

import com.ligabetplay.Controller;
import com.ligabetplay.Main;
import com.ligabetplay.model.Injury;
import com.ligabetplay.view.ShowValues;
import com.ligabetplay.view.Validation;

public class ViewInjury {

    Controller controlador = Controller.getInstance();
    Scanner sc = controlador.sc;
    ShowValues mostrar = new ShowValues();

    public void start(){
        Main.limpiarPantalla();
        int choice = 0;
        
        System.out.println("Gestion de Lesiones de Jugadores");

          while (true) {
            System.out.println("\n1. Agregar Arbitro");
            System.out.println("2. Editar Arbitro");
            System.out.println("3. Eliminar Arbitro");
            System.out.println("4. Volver");

            choice = Integer.parseInt(Validation.leerdato("Elija una opcion: ", controlador.sc));
            System.out.println("\n");
          

            switch (choice) {
                case 1:
                    addInjury();
                    break;
                case 2:
                    editInjury();
                    break;
                case 3:
                    deleteInjury();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Campo no Valido");
                    break;
            }
           
        }
    }


    public void addInjury(){
        Boolean mostrarJugadores = mostrar.showPlayer();
        if(mostrarJugadores==false){return;}
        
        Integer codigoJugador = Validation.leerNumero("Digite el id del jugador: ", sc);
        if((!controlador.jugadores.containsKey(codigoJugador))){
            System.out.println("Error - Codigo no Valido");    
            return;
        }

        Integer codigoLesion = Validation.leerNumero("Digite id de lesion", sc);
        if((controlador.lesiones.containsKey(codigoLesion))){
            System.out.println("Error - Codigo no Valido");    
            return;
        }

        Injury lesion = new Injury();
        lesion.setId(codigoLesion);
        
        //continuara;
        
        // controlador.lesiones.put(codigoLesion,)

    }

    public void editInjury(){

    }

    public void deleteInjury(){

    }

}
