package com.ligabetplay.view.SubViews;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.ligabetplay.Controller;
import com.ligabetplay.Main;
import com.ligabetplay.model.*;
import com.ligabetplay.view.ShowValues;
import com.ligabetplay.view.Validation;

public class ViewSchedulingMatch {

    Controller controlador = Controller.getInstance();
    Scanner sc = controlador.sc;
    ShowValues mostrar = new ShowValues();

    public void start() {
       
        while (true) {
            Main.limpiarPantalla();
            SchedulingMatch sm = new SchedulingMatch();

            // Generar un ID para el partido
            int newId = controlador.programacionPartidos.size() + 1;
            sm.setId(newId);

            mostrar.showTeam();

            // Ingresar equipo local
            int localId = Validation.leerNumero("\nIngrese el ID del equipo local: ", sc);
            if (!controlador.equipos.containsKey(localId)) {
                System.out.println("ID del equipo local no válido. Intente de nuevo.");
                continue;
            }
            sm.setEquipoLocal(controlador.equipos.get(localId));

            // Ingresar equipo visitante
            int visitanteId = Validation.leerNumero("Ingrese el ID del equipo visitante: ", sc);
            if (!controlador.equipos.containsKey(visitanteId)) {
                System.out.println("ID del equipo visitante no válido. Intente de nuevo.");
                continue;
            }
            sm.setEquipoVisitante(controlador.equipos.get(visitanteId));

            // Mostrar estadios disponibles
            mostrar.showStadiums();

            // Ingresar estadio
            int estadioId = Validation.leerNumero("Ingrese el ID del estadio: ", sc);
            if (!controlador.estadios.containsKey(estadioId)) {
                System.out.println("ID del estadio no válido. Intente de nuevo.");
                continue;
            }
            sm.setEstadio(controlador.estadios.get(estadioId));

            // Ingresar fecha y hora del partido
            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = null;
            while (true) {
                String fechaStr = Validation.leerdato("Ingrese la fecha del partido (yyyy-MM-dd): ", sc);
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
                String horaStr = Validation.leerdato("Ingrese la hora del partido (HH:mm): ", sc);
                try {
                    hora = new Time(timeFormatter.parse(horaStr).getTime());
                    sm.setHora(hora);
                    break;
                } catch (ParseException e) {
                    System.out.println("Formato de hora no válido. Intente de nuevo.");
                }
            }

            // Guardar el partido programado
            controlador.programacionPartidos.put(newId, sm);
            System.out.println("Partido guardado exitosamente.\n");

            // Preguntar si desea programar otro partido
            String continuar = Validation.leerdato("¿Desea programar otro partido? (s/n): ", sc);
            if (!continuar.equalsIgnoreCase("s")) {
                break;
            }
        }
    }

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
            List<Goal> lstGoles = new ArrayList<>();
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

                int minuto = Validation.leerNumero("Ingrese el minuto del gol: ", sc);
                goal.setMinuto(minuto);

                goal.setPartido(partido);
                lstGoles.add(goal);
            }
            partido.setLstGoles(lstGoles);

            List<Incident> lstIncidentes = new ArrayList<>();
            String deseaIngresarIncidentes = Validation.leerdato("¿Desea ingresar incidentes del partido? (s/n): ", sc);
            if (deseaIngresarIncidentes.equalsIgnoreCase("s")) {
                while (true) {
                    String incidentes = Validation.leerdato("Ingrese la descripción del incidente (deje vacío para terminar): ", sc);
                    if (incidentes.isEmpty())
                        break;

                    Incident incident = new Incident();
                    incident.setDescripcion(incidentes);
                    lstIncidentes.add(incident);
                }
            }
            partido.setLstIncidentes(lstIncidentes);

            controlador.programacionPartidos.put(partidoId, partido);

            System.out.println("\nResultado registrado:");
            System.out
                    .println(partido.getEquipoLocal().getNombre() + " vs " + partido.getEquipoVisitante().getNombre());
            System.out.println("Goles:");
            for (Goal goal : lstGoles) {
                System.out.println("Gol ID: " + goal.getId() + ", Jugador: " + goal.getJugador().getNombre()
                        + ", Equipo: " + goal.getEquipo().getNombre() + ", Minuto: " + goal.getMinuto());
            }

            // Mostrar incidentes si existen
            if (!lstIncidentes.isEmpty()) {
                System.out.println("Incidentes:");
                for (Incident incident : lstIncidentes) {
                    System.out.println("Descripción: " + incident.getDescripcion());
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
