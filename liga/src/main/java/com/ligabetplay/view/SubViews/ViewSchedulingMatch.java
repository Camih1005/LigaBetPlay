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

    
    ShowValues mostrar = new ShowValues();
    SchedulingMatch schedulingMatch = new SchedulingMatch();
    Controller controlador = Controller.getInstance();
    Scanner sc = controlador.sc;

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

   

}
