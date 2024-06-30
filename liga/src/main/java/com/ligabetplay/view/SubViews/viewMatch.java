package com.ligabetplay.view.SubViews;

import java.util.Scanner;

import com.ligabetplay.Controller;
import com.ligabetplay.model.Match;
import com.ligabetplay.model.Stadium;
import com.ligabetplay.view.ShowValues;
import com.ligabetplay.view.Validation;

public class viewMatch {

    Controller controlador = Controller.getInstance();
    Scanner sc = controlador.sc;
    ShowValues mostrar = new ShowValues();

    public void start(){
        int choice = 0;

        System.out.println("\r\n" + //
                        "█▀▀ █▀▀ █▀ ▀█▀ █ █▀█ █▄░█   █▀▄ █▀▀   █▀█ ▄▀█ █▀█ ▀█▀ █ █▀▄ █▀█ █▀\r\n" + //
                        "█▄█ ██▄ ▄█ ░█░ █ █▄█ █░▀█   █▄▀ ██▄   █▀▀ █▀█ █▀▄ ░█░ █ █▄▀ █▄█ ▄█");
        while (true) {
            System.out.println("\n1. Agregar Partido");
            System.out.println("2. Editar partido");
            System.out.println("3. Eliminar Partido");
            System.out.println("4. Volver");

            choice = Integer.parseInt(Validation.leerdato("Elija una opcion: ", controlador.sc));
            System.out.println("\n");

            switch (choice) {
                case 1:
                    addMatch();
                    break;
                case 2:
                    editMatch();
                    break;
                case 3:
                    deleteMatch();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opcion invalida, intentelo de nuevo.");
            }

        }
    }

    public void addMatch(){

        Match partido = new Match();
        Integer codigoPartido = Validation.leerNumero("Digite el id del Partido: ", sc);

        if((controlador.partidos.containsKey(codigoPartido))){
            System.out.println("Codigo ya Existe");
            return;
        }

        partido.setId(codigoPartido);

        if(controlador.equipos.size()<2){
            System.out.println("Deben haber mas de dos equipos");
            return;
        }
        boolean bandera = true;
        boolean mostrarEquipo = mostrar.showTeam();
        if(mostrarEquipo==false){ bandera = false; }
            if(bandera==true){
                int codigoEquipo = Validation.leerNumero("Digite el codigo del Equipo: ",sc);
                if(!controlador.equipos.containsKey(codigoEquipo)){ System.out.println("Error codigo no valido"); bandera=false;}
                    if(bandera==true){partido.setEquipoLocal(controlador.equipos.get(codigoEquipo));}
        }



        // estadio.setUbicacion(val.leerdato("Digite la ubicacion del estadio: ", sc));
        // estadio.setCapacidad(val.leerNumero("Digite la capacidad del estadio: ", sc));
        // controlador.estadios.put(codigoEstadio, estadio);

        System.out.println("---------------------------------");
        System.out.println("Creacion del estadio exitosa");
        System.out.println("---------------------------------");



    }

    public void editMatch(){

    }

    public void deleteMatch(){

    }



}
