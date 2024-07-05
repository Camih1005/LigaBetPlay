package com.ligabetplay.view.SubViews;

import java.util.Date;
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
            System.out.println("\n1. Agregar lesion");
            System.out.println("2. Editar lesion");
            System.out.println("3. Eliminar lesion");
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
        lesion.setJugador(controlador.jugadores.get(codigoJugador));
        lesion.setLesion(Validation.leerdato("Digite la lesion del jugador", sc));
        lesion.setGravedad(Validation.leerdato("Digite la gravedad de la lesion", sc));
        Date fechaInicio = Validation.LeerFecha("Ingrese la fecha de la lesion (yyyy-MM-dd): ", sc);
        lesion.setFechaInicion(fechaInicio);
        Date fechaFinalizacion = Validation.LeerFecha("Ingrese la fecha de la lesion (yyyy-MM-dd): ", sc);
        lesion.setFechaFinalizacion(fechaFinalizacion);
        
        controlador.lesiones.put(codigoLesion,lesion);
        controlador.jugadores.get(codigoJugador).setLstLesiones(lesion);



    }

    public void editInjury(){

    }

    public void deleteInjury(){

    }

}
