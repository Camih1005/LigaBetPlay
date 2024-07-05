package com.ligabetplay.view.SubViews;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.ligabetplay.Controller;
import com.ligabetplay.model.Goal;
import com.ligabetplay.model.Incident;
import com.ligabetplay.model.Player;
import com.ligabetplay.model.Result;
import com.ligabetplay.model.SchedulingMatch;
import com.ligabetplay.model.Team;
import com.ligabetplay.view.Validation;

public class ViewResults {

    Controller controlador = Controller.getInstance();
    Scanner sc = controlador.sc;
    Result result = new Result();

    public void registrarResultados() {

        while (true) {
            // Mostrar partidos programados
            System.out.println("\nPartidos programados:");
            for (Map.Entry<Integer, SchedulingMatch> entry : controlador.programacionPartidos.entrySet()) {
                SchedulingMatch partido = entry.getValue();
                System.out.println("ID: " + entry.getKey() + ", " + partido.getEquipoLocal().getNombre() + " vs "
                        + partido.getEquipoVisitante().getNombre());
            }

            // Ingresar ID del partido para registrar resultados
            int partidoId = Validation.leerNumero("\nIngrese el ID del partido para registrar resultados: ", sc);
            if (!controlador.programacionPartidos.containsKey(partidoId)) {
                System.out.println("ID del partido no válido. Intente de nuevo.");
                continue;
            }

            SchedulingMatch partido = controlador.programacionPartidos.get(partidoId);

            // Ingresar resultados

            while (true) {
                int golId = Validation.leerNumero("Ingrese el id del gol (0 para terminar): ", sc);
                if (golId == 0)
                    break;

                Goal goal = new Goal();
                goal.setId(golId);

                int jugadorId = Validation.leerNumero("Ingrese el id del jugador que anotó: ", sc);
                Player jugador = controlador.jugadores.get(jugadorId);
                goal.setJugador(jugador);

                int equipoId = Validation.leerNumero("Ingrese el id del equipo que anotó: ", sc);
                Team equipo = controlador.equipos.get(equipoId);
                goal.setEquipo(equipo);

                int minuto;
                try {
                    minuto = Validation.leerNumero("Ingrese el minuto del gol: ", sc);
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida para el minuto. Debe ser un número entero. Intente de nuevo.");
                    continue;
                }

                goal.setMinuto(minuto);
                goal.setPartido(partido);
                partido.addGoal(goal);
            }

            controlador.ResultadosPartido.put(partidoId, partido);

            String deseaIngresarIncidentes = Validation.leerdato("¿Desea ingresar incidentes del partido? (s/n): ", sc);
            if (deseaIngresarIncidentes.equalsIgnoreCase("s")) {
                while (true) {
                    String incidentes = Validation
                            .leerdato("Ingrese la descripción del incidente (n para salir o s para dijotar otro): ", sc);
                    if (incidentes == "n"){
                        break;
                    }else{
                    Incident incident = new Incident();
                    incident.setDescripcion(incidentes);
                    int minuto;
                    try {
                        minuto = Validation.leerNumero("Ingrese el minuto del incidente: ", sc);
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida para el minuto. Debe ser un número entero. Intente de nuevo.");
                        continue;
                    }

                    incident.setMinuto(minuto);
                    incident.setPartido(partido);
                    partido.addIncident(incident);
                }
                }
            }

            System.out.println("\nResultado registrado:");
            System.out.println(partido.getEquipoLocal().getNombre() + " vs " + partido.getEquipoVisitante().getNombre());
            System.out.println("Goles:");
            for (Goal goal : partido.getLstGoles()) {
                System.out.println("Gol ID: " + goal.getId() + ", Jugador: " + goal.getJugador().getNombre()
                        + ", Equipo: " + goal.getEquipo().getNombre() + ", Minuto: " + goal.getMinuto());
            }

            // Mostrar incidentes si existen
            if (!partido.getLstIncidentes().isEmpty()) {
                System.out.println("Incidentes:");
                for (Incident incident : partido.getLstIncidentes()) {
                    System.out.println("Descripción: " + incident.getDescripcion() + ", Minuto: " + incident.getMinuto());
                }
            }

            // Preguntar si desea registrar resultados de otro partido
            String continuar = Validation.leerdato("¿Desea registrar resultados de otro partido? (s/n): ", sc);
            if (!continuar.equalsIgnoreCase("s")) {
                break;
            }
        }
    }
}
