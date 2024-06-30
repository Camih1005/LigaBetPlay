package com.ligabetplay.view.SubViews;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.ligabetplay.Controller;
import com.ligabetplay.model.*;
import com.ligabetplay.view.Validation;

public class ViewSchedulingMatch {

    public static void start() {
        Controller controlador = Controller.getInstance();
        Validation val = new Validation();
        Scanner sc = controlador.sc;

        while (true) {
            SchedulingMatch sm = new SchedulingMatch();
            sm.setId(UUID.randomUUID().toString());  

            // Mostrar equipos disponibles
            System.out.println("\nEquipos disponibles:");
            for (Map.Entry<Integer, Team> entry : controlador.equipos.entrySet()) {
                System.out.println("ID: " + entry.getKey() + ", Nombre: " + entry.getValue().getNombre());
            }

            // Ingresar equipo local
            int localId = val.leerNumero("\nIngrese el ID del equipo local: ", sc);
            if (!controlador.equipos.containsKey(localId)) {
                System.out.println("ID del equipo local no válido. Intente de nuevo.");
                continue;
            }
            sm.setEquipoLocal(controlador.equipos.get(localId));

            // Ingresar equipo visitante
            int visitanteId = val.leerNumero("Ingrese el ID del equipo visitante: ", sc);
            if (!controlador.equipos.containsKey(visitanteId)) {
                System.out.println("ID del equipo visitante no válido. Intente de nuevo.");
                continue;
            }
            sm.setEquipoVisitante(controlador.equipos.get(visitanteId));

            // Mostrar estadios disponibles
            System.out.println("\nEstadios disponibles:");
            for (Map.Entry<Integer, Stadium> entry : controlador.estadios.entrySet()) {
                System.out.println("ID: " + entry.getKey() + ", Nombre: " + entry.getValue().getNombre());
            }

            // Ingresar estadio
            int estadioId = val.leerNumero("Ingrese el ID del estadio: ", sc);
            if (!controlador.estadios.containsKey(estadioId)) {
                System.out.println("ID del estadio no válido. Intente de nuevo.");
                continue;
            }
            sm.setEstadio(controlador.estadios.get(estadioId));

            // Ingresar fecha y hora del partido
            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = null;
            while (true) {
                String fechaStr = val.leerdato("Ingrese la fecha del partido (yyyy-MM-dd): ", sc);
                try {
                    fecha = dateFormatter.parse(fechaStr);
                    sm.setFecha(fecha);
                    break;
                } catch (ParseException e) {
                    System.out.println("Formato de fecha no válido. Intente de nuevo.");
                }
            }

            SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm");
            Time hora = null;
            while (true) {
                String horaStr = val.leerdato("Ingrese la hora del partido (HH:mm): ", sc);
                try {
                    hora = new Time(timeFormatter.parse(horaStr).getTime());
                    sm.setHora(hora);
                    break;
                } catch (ParseException e) {
                    System.out.println("Formato de hora no válido. Intente de nuevo.");
                }
            }

            // Guardar el partido programado
            controlador.programacionPartidos.put(controlador.programacionPartidos.size() + 1, sm);
            System.out.println("Partido guardado exitosamente.\n");

            // Preguntar si desea programar otro partido
            String continuar = val.leerdato("¿Desea programar otro partido? (s/n): ", sc);
            if (!continuar.equalsIgnoreCase("s")) {
                break;
            }
        }
    }
    }

    // public static void registrarResultados() {
    //     Controller controlador = Controller.getInstance();
    //     Validation val = new Validation();
    //     Scanner sc = controlador.sc;
        

    //     while (true) {
    //         // Mostrar partidos programados
    //         System.out.println("\nPartidos programados:");
    //         for (Map.Entry<Integer, SchedulingMatch> entry : controlador.programacionPartidos.entrySet()) {
    //             SchedulingMatch partido = entry.getValue();
    //             System.out.println("ID: " + entry.getKey() + ", " + partido.getEquipoLocal().getNombre() + " vs " + partido.getEquipoVisitante().getNombre());
    //         }

    //         // Ingresar ID del partido para registrar resultados
    //         int partidoId = val.leerNumero("\nIngrese el ID del partido para registrar resultados: ", sc);
    //         if (!controlador.programacionPartidos.containsKey(partidoId)) {
    //             System.out.println("ID del partido no válido. Intente de nuevo.");
    //             continue;
    //         }

    //         SchedulingMatch partido = controlador.programacionPartidos.get(partidoId);

    //         // Ingresar resultados
    //         List<Goal> lstGoles = new ArrayList<>();
    //         while (true) {
    //             int golId = val.leerNumero("Ingrese el id del gol (0 para terminar): ", sc);
    //             if (golId == 0) break;

    //             Goal goal = new Goal();
    //             goal.setId(golId);

    //             int jugadorId = val.leerNumero("Ingrese el id del jugador que anotó: ", sc);
    //             Player jugador = controlador.jugadores.get(jugadorId);
    //             goal.setJugador(jugador);

    //             int equipoId = val.leerNumero("Ingrese el id del equipo que anotó: ", sc);
    //             Team equipo = controlador.equipos.get(equipoId);
    //             goal.setEquipo(equipo);

    //             int minuto = val.leerNumero("Ingrese el minuto del gol: ", sc);
    //             goal.setMinuto(minuto);

    //             goal.setPartido(partido);
    //             lstGoles.add(goal);
    //         }
    //         partido.setLstGoles(lstGoles);

    //         String incidentes = val.leerdato("Ingrese id del incidentes del partido: ", sc);
            
            
    //         partido.getId(val.leerNumero("Ingrese el minuto del gol: ", sc));
    //         Incident incident = controlador.incident.put(incidentes,);

    //         // Guardar resultado en historial
    //         controlador.programacionPartidos.put(partidoId, partido);

    //         // Mostrar resumen del resultado registrado
    //         System.out.println("\nResultado registrado:");
    //         System.out.println(partido.getEquipoLocal().getNombre() + " vs " + partido.getEquipoVisitante().getNombre());
    //         System.out.println("Goles:");
    //         for (Goal goal : lstGoles) {
    //             System.out.println("Gol ID: " + goal.getId() + ", Jugador: " + goal.getJugador().getNombre() + ", Equipo: " + goal.getEquipo().getNombre() + ", Minuto: " + goal.getMinuto());
    //         }
    //         System.out.println("Incidentes: " + partido.getIncidentes());

    //         // Preguntar si desea registrar resultados de otro partido
    //         String continuar = val.leerdato("¿Desea registrar resultados de otro partido? (s/n): ", sc);
    //         if (!continuar.equalsIgnoreCase("s")) {
    //             break;
    //         }
    //     }
    // }

