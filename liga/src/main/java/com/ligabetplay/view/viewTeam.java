package com.ligabetplay.view;

import java.util.Enumeration;
import java.util.Scanner;

import com.ligabetplay.Controller;
import com.ligabetplay.model.Team;

public class viewTeam {

    private static final  Controller controlador = Controller.getInstance();

    public void gestionEquipo(){

        Validation val = new Validation();
        Team equipo = new Team();

        int codigoE;

        int choice = 0;

        System.out.println("\r\n" + //
                        "█▀▀ █▀▀ █▀ ▀█▀ █ █▀█ █▄░█   █▀▄ █▀▀   █▀▀ █▀█ █░█ █ █▀█ █▀█\r\n" + //
                        "█▄█ ██▄ ▄█ ░█░ █ █▄█ █░▀█   █▄▀ ██▄   ██▄ ▀▀█ █▄█ █ █▀▀ █▄█");

        while (true) {
            System.out.println("\n1. Agregar Equipo");
            System.out.println("2. Editar Equipo");
            System.out.println("3. Eliminar Equipo");
            System.out.println("4. Volver");

            choice = Integer.parseInt(val.leerdato("Elija una opcion: ", controlador.sc));
            System.out.println("\n");

           
           

            switch (choice) {
                case 1:
                    Boolean validar = addTeam(controlador.sc,val);
                    if(validar==false){
                        continue;
                    }
                    break;
                case 2:
                    try {
                        String campoActualizado = "";

                        codigoE = val.leerNumero("Ingrese Codigo del Equipo: ",controlador.sc);
                        equipo = controlador.equipos.get(codigoE);

                        System.out.println("\nCampos del equipo " + equipo.getNombre());
                        System.out.println("1.nombre");
                        System.out.println("2.ciudad");

                        int op = Integer.parseInt(val.leerdato("Elige la opcion del campo a actualizar:",controlador.sc));

                        switch (op) {
                            case 1:
                                try {
                                    System.out.println("Campo Actual: " + equipo.getNombre());
                                    campoActualizado = val.leerdato("Digita el nombre: ",controlador.sc);
                                    equipo.setNombre(campoActualizado);
                                } catch (Exception e) {
                                    System.out.println("Error al actualizar el campo: " + e);
                                }
                                break;

                            case 2:
                                try {
                                    System.out.println("Campo Actual: " + equipo.getNombre());
                                    campoActualizado = val.leerdato("Digita la ciudad: ",controlador.sc);
                                    equipo.setCiudad(campoActualizado);

                                } catch (Exception e) {
                                    System.out.println("Error al actualizar el campo: " + e);
                                }
                                break;

                            default:
                                System.out.println("Opcion no Valida");
                                break;
                        }

                    } catch (Exception e) {
                        System.out.println("Equipo no encontrado -> Mensaje de Error: " + e);
                    }
                    break;

                case 3:
                try {
                    codigoE = val.leerNumero("Ingrese Codigo del Equipo: ",controlador.sc);
                    equipo = controlador.equipos.get(codigoE);
                    Enumeration<Integer> llaves = controlador.equipos.keys();
                    int llave;
                    while (llaves.hasMoreElements()) {
                        llave = llaves.nextElement();
                        if (codigoE == llave) {
                            controlador.equipos.remove(codigoE);
                            System.out.println("Equipo " + equipo.getNombre() + " eliminado");
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Equipo no encontrado -> Mensaje de Error: " + e);
                }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opcion invalida, intentelo de nuevo.");
            }

        }
    }

    
    public static  boolean addTeam(Scanner sc, Validation val){
        
        Team equipo = new Team();
        ShowValues imprimir = new ShowValues();
        
        int codigoE = val.leerNumero("Ingrese el codigo del equipo: ", controlador.sc);
            
        if (controlador.equipos.containsKey(codigoE)) {
            System.out.println("Error: Codigo ya Existe");
                return false;
        }

        equipo.setNombre(val.leerdato("Ingrese Nombre del equipo: ",controlador.sc));
        equipo.setCiudad(val.leerdato("Ingrese la ciudad: ",controlador.sc));

        Boolean bandera = imprimir.showStadiums();
        if (bandera == true) {
        
        Integer codigoEstadio = val.leerNumero("Ingrese el codigo del estadio donde juega: ",controlador.sc);
        
        if(controlador.estadios.containsKey(codigoEstadio)){
                equipo.setEstadio(controlador.estadios.get(codigoEstadio).getNombre());
            }else{
                System.out.println("No existe el codigo");
                return false;
            }  
        }


            bandera = imprimir.showTrainers();

            if (bandera == true) {
                Integer codigoEntrenador = val.leerNumero("Ingrese el codigo del entrenador donde juega: ",controlador.sc);

                if(controlador.entrenadores.containsKey(codigoEntrenador)){
                    equipo.setCoach(controlador.entrenadores.get(codigoEntrenador).getNombre());
                }else{
                    System.out.println("----No existe codigo------");
                }  
            }

            controlador.equipos.put(codigoE, equipo);
            System.out.println("\nEquipo creado con exito");

            return true;

        }
    }

