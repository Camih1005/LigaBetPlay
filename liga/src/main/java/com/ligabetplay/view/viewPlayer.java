package com.ligabetplay.view;

import java.util.Scanner;

import com.ligabetplay.Controller;
import com.ligabetplay.model.Player;
import com.ligabetplay.model.Team;

public class viewPlayer {

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
                if(!controlador.equipos.containsKey(codigoEquipo)){ System.out.println("Error codigo no valido"); bandera=false;}
                    if(bandera==true){jugador.setEquipo(controlador.equipos.get(codigoEquipo).getNombre());
                    controlador.equipos.get(codigoEquipo).setLstJugadores(jugador);}
            }

        controlador.jugadores.put(codigoJugador, jugador);
        System.out.println("---------------------------------");
        System.out.println("Creacion del equipo exitosa");  
        System.out.println("---------------------------------");
    }

    public void editPlayer(){
        
        boolean mostrarJugadores = mostrar.showPlayer();
        if(mostrarJugadores==false){
            return;
        }

        int codigoJugador = val.leerNumero("Digite el jugador a actualizar: ",sc);
        if(!controlador.jugadores.containsKey(codigoJugador)){
            System.out.println("Error codigo no valido");
            return ;
        }

        Player jugador = controlador.jugadores.get(codigoJugador);

        System.out.println("Campos de jugador");
        System.out.println("1. Nombre");
        System.out.println("2. Edad");
        System.out.println("3. Posicion");
        System.out.println("4. Nacionalidad");
        System.out.println("5. Numero de camiseta");


        int opcion = val.leerNumero("Digite la opcion que desea editar: ",sc);

        switch (opcion) {
            case 1:
                System.out.println("Campo Actual: " + jugador.getNombre());
                jugador.setNombre(val.leerdato("Digite el nombre del jugador: ",sc ));
                break;
            case 2:
                System.out.println("Campo Actual: " + jugador.getEdad());
                jugador.setEdad(val.leerNumero("Digite la Edad del jugador: ",sc ));
                break;
            case 3:
                System.out.println("Campo Actual: " + jugador.getPosicion() );
                jugador.setPosicion(val.leerdato("Digite la posicion del jugador: ",sc ));
                break;
            case 4: 
                System.out.println("Campo Actual: "+ jugador.getNacionalidad());
                jugador.setNacionalidad(val.leerdato("Digite la nacionalidad del jugador", sc));

            case 5: 
                System.out.println("Campo Actual: " + jugador.getNumeroCamiseta());
                jugador.setNumeroCamiseta(val.leerNumero("Digite el numero de la camiseta del jugador", sc));
            default:
                break;
        }
        System.out.println("---------------------------------");
        System.out.println("Campo actualizado  exitosamente");
        System.out.println("---------------------------------");
        return;

    }

    public void deletePlayer(){
         
        boolean mostrarJugadores = mostrar.showPlayer();
        if(mostrarJugadores==false){
            return;
        }

        int codigoJugador = val.leerNumero("\nDigite el jugador a eliminar: ",sc);
        if(!controlador.jugadores.containsKey(codigoJugador)){
            System.out.println("Error codigo no valido");
            return ;
        }
        controlador.jugadores.remove(codigoJugador);

        for (Integer key : controlador.equipos.keySet()) {
            Team value = controlador.equipos.get(key);
            for (Player elemento : value.getLstJugadores()) {
                if(elemento.getId()==codigoJugador){
                    controlador.equipos.get(key).getLstJugadores().remove(elemento);
                    System.out.println("Estadio Eliminado Exitosamente");
                    break;
                }
            }
        }
       
        

        return;

    }

}
