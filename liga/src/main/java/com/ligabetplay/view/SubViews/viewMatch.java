package com.ligabetplay.view.SubViews;

import java.util.Scanner;

import com.ligabetplay.Controller;
import com.ligabetplay.model.Match;
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
        if(mostrarEquipo==false){return; }
        if(bandera==true){
            int codigoEquipoLocal = Validation.leerNumero("Digite el codigo del Equipo Local: ",sc);
            if(!controlador.equipos.containsKey(codigoEquipoLocal)){ System.out.println("Error codigo no valido"); bandera=false;}
            if(bandera==true){partido.setEquipoLocal(controlador.equipos.get(codigoEquipoLocal));}
            int codigoEquipoVisitante = Validation.leerNumero("Digite el codigo del Equipo Visitante: ",sc);
            if(codigoEquipoLocal==codigoEquipoVisitante){System.out.println("Error al asignar el codigo");}

            if(controlador.equipos.containsKey(codigoEquipoVisitante)){partido.setEquipoVisitante(controlador.equipos.get(codigoEquipoVisitante));}
            else{
                System.out.println("No se pudo crear partido");
                partido = null;
                return;
            }
        }

        partido.setFecha(Validation.leerdato("Digite la fecha del partido ",sc));
        partido.setHora(Validation.leerdato("Digite la hora del partido ",sc));
        controlador.partidos.put(codigoPartido, partido);
        System.out.println("---------------------------------");
        System.out.println("Creacion del partido exitosa");
        System.out.println("---------------------------------");



    }

    public void editMatch(){
          boolean mostrarPartidos = mostrar.showMatch();
        if(mostrarPartidos==false){
            return;
        }

        int codigoPartido = Validation.leerNumero("Digite el partido a actualizar: ",sc);
        if(!controlador.partidos.containsKey(codigoPartido)){
            System.out.println("Error codigo no valido");
            return ;
        }

        Match partido = controlador.partidos.get(codigoPartido);

        System.out.println("Campos de Partido");
        System.out.println("1. equipo local");
        System.out.println("2. equipo visitante");
        System.out.println("3. fecha");
        System.out.println("4- Hora");

        int opcion = Validation.leerNumero("Digite la opcion que desea editar: ",sc);


        switch (opcion) {
            case 1:
                System.out.println("Campo Actual: " + partido.getEquipoLocal().getNombre());
                boolean bandera = true;
                boolean mostrarEquipo = mostrar.showTeam();
                if(mostrarEquipo==false){return; }
                if(bandera==true){
                    int codigoEquipoLocal = Validation.leerNumero("Digite el codigo del Equipo Local: ",sc);
                    if(!controlador.equipos.containsKey(codigoEquipoLocal)){ System.out.println("Error codigo no valido"); bandera=false;}
                    if(bandera==true){partido.setEquipoLocal(controlador.equipos.get(codigoEquipoLocal));}}
                
                break;
            case 2:
                System.out.println("Campo Actual: " + partido.getEquipoVisitante().getNombre());
                boolean mostrarEquipo2 = mostrar.showTeam();
                if(mostrarEquipo2==false){return; }
                int codigoEquipoVisitante = Validation.leerNumero("Digite el codigo del Equipo Visitante: ",sc);
                if(partido.getEquipoLocal().getId()==codigoEquipoVisitante){System.out.println("Error al asignar el codigo");}

                if(controlador.equipos.containsKey(codigoEquipoVisitante)){partido.setEquipoVisitante(controlador.equipos.get(codigoEquipoVisitante));}
                else{
                    System.out.println("No se pudo crear partido");
                    partido = null;
                    return;
                }
                break;
            case 3:
                System.out.println("Campo Actual: " + partido.getFecha());
                partido.setFecha(Validation.leerdato("Digite la fecha del partido: ",sc ));
                break;
            case 4:
                System.out.println("Campo Actual: " + partido.getHora());
                partido.setHora(Validation.leerdato("Digite la hora del partido: ",sc ));
                break;
            default:
                System.out.println("Codigo no valido");
                break;
        }
    
        System.out.println("---------------------------------");
        System.out.println("Campo actualizado  exitosamente");
        System.out.println("---------------------------------");
        return;
        


    }

    public void deleteMatch(){
        boolean mostrarPartidos = mostrar.showMatch();
        if(mostrarPartidos==false){
            return;
        }

        int codigoPartido = Validation.leerNumero("\nDigite el Partido a eliminar: ",sc);
        if(!controlador.partidos.containsKey(codigoPartido)){
            System.out.println("Error codigo no valido");
            return ;
        }
        
        controlador.partidos.remove(codigoPartido);
        System.out.println("Partido Eliminado Exitosamente");

        return;

    }
}
