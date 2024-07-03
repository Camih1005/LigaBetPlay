package com.ligabetplay.view.SubViews;

import java.util.Scanner;

import com.ligabetplay.Controller;
import com.ligabetplay.Main;
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
                    // addStadium();
                    break;
                case 2:
                    // editStadium();
                    break;
                case 3:
                    // deleteStadium();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Campo no Valido");
                    break;
            }
           
        }

    }


}
