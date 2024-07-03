package com.ligabetplay.view.SubViews;

import java.util.Scanner;
import java.util.regex.MatchResult;

import com.ligabetplay.Controller;
import com.ligabetplay.Main;
import com.ligabetplay.model.SchedulingMatch;
import com.ligabetplay.model.Stadium;
import com.ligabetplay.view.ShowValues;
import com.ligabetplay.view.Validation;

public class ViewTicket {

    Controller controlador = Controller.getInstance();
    Scanner sc = controlador.sc;
    ShowValues mostrar = new ShowValues();


    public void start(){
        Main.limpiarPantalla();
        int choice = 0;
        
        System.out.println("Venta de Entradas");

        while (true) {
            System.out.println("\n1. Comprar Entradas");
            System.out.println("4. Volver");

            choice = Integer.parseInt(Validation.leerdato("Elija una opcion: ", controlador.sc));
            System.out.println("\n");
          

            switch (choice) {
                case 1:
                        BuyTicket();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Campo no Valido");
                    break;
            }
           
        }
    }

    public void BuyTicket(){
       
        boolean mostrarPartidos = mostrar.showMatch();
        if(mostrarPartidos==false){
            return;
        }

        int codigoPartido = Validation.leerNumero("Digite el id del partido que desea asistir: ",sc);
        if(!controlador.jugadores.containsKey(codigoPartido)){
            System.out.println("Error codigo no valido - No se puede comprar ticket");
            return ;
        }

        //en mantenimiento

        






    }


}
