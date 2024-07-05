package com.ligabetplay.view.SubViews;

import java.util.Scanner;

import com.ligabetplay.Controller;
import com.ligabetplay.model.Player;
import com.ligabetplay.model.Team;
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

            choice = Integer.parseInt(Validation.leerdato("Elija una opcion: ", controlador.sc));
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
        Integer codigoJugador = Validation.leerNumero("Digite el id del jugador: ", sc);

        if((controlador.jugadores.containsKey(codigoJugador))){
            System.out.println("Codigo ya Existe");    
            return;
        }

        jugador.setId(codigoJugador);
        jugador.setNombre(Validation.leerdato("Digite el nombre del jugador: ", sc));
        jugador.setEdad(Validation.leerNumero("Digite la edad del jugador: ",sc));
        jugador.setPosicion(Validation.leerdato("Digite la posicion del jugador: ",sc));
        jugador.setNacionalidad(Validation.leerdato("Digite la nacionalidad del jugador: ",sc));
        jugador.setNumeroCamiseta(Validation.leerNumero("Digite el numero de la camisa del jugador", sc));
        
        boolean mostrarEquipo = mostrar.showTeam();
        
        if(mostrarEquipo==false){ bandera = false; }
            if(bandera==true){
                int codigoEquipo = Validation.leerNumero("Digite el codigo del equipo: ",sc);
                if(!controlador.equipos.containsKey(codigoEquipo)){ System.out.println("Error codigo no valido"); bandera=false;}
                    if(bandera==true){
                    jugador.setEquipo(controlador.equipos.get(codigoEquipo));
                    controlador.equipos.get(codigoEquipo).getLstJugadores().add(jugador);
                    System.out.println("Jugador añadido al equipo");}   
            }
        
        controlador.jugadores.put(codigoJugador, jugador);
        System.out.println("Creado satisfactoriamente");
    }

    public void editPlayer(){
        
        boolean mostrarJugadores = mostrar.showPlayer();
        if(mostrarJugadores==false){
            return;
        }

        int codigoJugador = Validation.leerNumero("Digite el jugador a actualizar: ",sc);
        if(!controlador.jugadores.containsKey(codigoJugador)){
            System.out.println("Error codigo no valido");
            return ;
        }

        Player jugador = controlador.jugadores.get(codigoJugador);

        System.out.println("Campos de Jugador");
        System.out.println("1. Nombre");
        System.out.println("2. Edad");
        System.out.println("3. Posicion");
        System.out.println("4. Nacionalidad");
        System.out.println("5. Numero de la camiseta");

        int opcion = Validation.leerNumero("Digite la opcion que desea editar: ",sc);


        switch (opcion) {
            case 1:
                System.out.println("Campo Actual: " + jugador.getNombre());
                jugador.setNombre(Validation.leerdato("Digite el nombre del Jugador: ",sc ));
                
                break;
            case 2:
                System.out.println("Campo Actual: " + jugador.getEdad());
                jugador.setEdad(Validation.leerNumero("Digite la edad del jugador: ",sc ));
                break;
            case 3:
                System.out.println("Campo Actual: " + jugador.getPosicion());
                jugador.setPosicion(Validation.leerdato("Digite la posicion del jugador: ",sc ));
                break;
            case 4:
                System.out.println("Campo Actual: " + jugador.getNacionalidad());
                jugador.setNacionalidad(Validation.leerdato("Digite la nacionalidad del jugador: ",sc ));
                break;
            case 5:
                System.out.println("Campo Actual: " + jugador.getNumeroCamiseta());
                jugador.setNumeroCamiseta(Validation.leerNumero("Digite el numero de la camiseta del jugador: ",sc ));
                break;  
            default:
                System.out.println("Opcion no valida");
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

        int codigoJugador = Validation.leerNumero("\nDigite el jugador a eliminar: ",sc);
        if(!controlador.jugadores.containsKey(codigoJugador)){
            System.out.println("Error codigo no valido");
            return ;
        }

        System.out.println("Jugador eliminado de la lista de jugadores");
        controlador.jugadores.remove(codigoJugador);
    
        for (Integer key: controlador.equipos.keySet()) {
            Team e = controlador.equipos.get(key);
            boolean a = e.getLstJugadores().removeIf((Player valor) -> valor.getId()==codigoJugador);
            if(a==true){
                System.out.println("Jugador eliminado del equipo");
            }
        }

        return;

    }

}
