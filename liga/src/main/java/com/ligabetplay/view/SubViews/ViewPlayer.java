package com.ligabetplay.view.SubViews;

import java.util.Scanner;

import com.ligabetplay.Controller;
import com.ligabetplay.model.Player;
import com.ligabetplay.model.Stadium;
import com.ligabetplay.view.ShowValues;
import com.ligabetplay.view.Validation;

public class ViewPlayer {

    Controller controlador = Controller.getInstance();
    Scanner sc = controlador.sc;
    Validation val =  new Validation();
    ShowValues mostrar = new ShowValues();

    public void start(){

        int choice = 0;

        System.out.println("\r\n" + //
                        "█▀▀ █▀▀ █▀ ▀█▀ █ █▀█ █▄░█   █▀▄ █▀▀\r\n" + //
                        "█▄█ ██▄ ▄█ ░█░ █ █▄█ █░▀█   █▄▀ ██▄\r\n" + //
                        "\r\n" + //
                        "░░█ █░█ █▀▀ ▄▀█ █▀▄ █▀█ █▀█ █▀▀ █▀\r\n" + //
                        "█▄█ █▄█ █▄█ █▀█ █▄▀ █▄█ █▀▄ ██▄ ▄█");

        while (true) {
            System.out.println("\n1. Agregar jugador");
            System.out.println("2. Editar Jugador");
            System.out.println("3. Eliminar Jugador");
            System.out.println("4. Volver");

            choice = Integer.parseInt(val.leerdato("Elija una opcion: ", controlador.sc));
            System.out.println("\n");

            switch (choice) {
                case 1:
                    addPlayer();
                    break;
                case 2:
                    editPlayer();
                    break;
                case 3:
                    deletePlayer();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opcion invalida, intentelo de nuevo.");
            }

        }
    }

    public void addPlayer(){
        boolean bandera = true;
        
        Player jugador = new Player();
        Integer codigoJugador = val.leerNumero("Digite el id del jugador: ", sc);

        if((controlador.jugadores.containsKey(codigoJugador))){
            System.out.println("Codigo ya Existe");    
            return;
        }

        jugador.setId(codigoJugador);
        jugador.setNombre(val.leerdato("Digite el nombre del jugador: ", sc));
        jugador.setEdad(val.leerNumero("Digite la edad del jugador: ",sc));
        jugador.setPosicion(val.leerdato("Digite la posicion del jugador: ",sc));
        jugador.setNacionalidad(val.leerdato("Digite la nacionalidad del jugador: ",sc));
        jugador.setNumeroCamiseta(val.leerNumero("Digite el numero de la camisa del jugador", sc));
        
        boolean mostrarEquipo = mostrar.showTeam();
        
        if(mostrarEquipo==false){ bandera = false; }
            if(bandera==true){
                int codigoEquipo = val.leerNumero("Digite el codigo del equipo: ",sc);
                if(!controlador.estadios.containsKey(codigoEquipo)){ System.out.println("Error codigo no valido"); bandera=false;}
                    if(bandera==true){jugador.setEquipo(controlador.estadios.get(codigoEquipo).getNombre());}
            }
    }

    public void editPlayer(){

    }

    public void deletePlayer(){

    }

}
