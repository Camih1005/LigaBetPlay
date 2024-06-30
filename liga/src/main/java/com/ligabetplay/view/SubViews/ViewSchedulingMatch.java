package com.ligabetplay.view.SubViews;

import java.util.Map;
import java.util.Scanner;

import com.ligabetplay.Controller;
import com.ligabetplay.model.SchedulingMatch;
import com.ligabetplay.model.Team;
import com.ligabetplay.view.Validation;

public class ViewSchedulingMatch {

    public static void start() {
        Team team = new Team();
        Controller controlador = Controller.getInstance();
        Validation val = new Validation();
        Scanner sc = controlador.sc;
        while (true) {

            System.out.print(team.getId());
            SchedulingMatch sm = new SchedulingMatch();
            for (Map.Entry<Integer, Team> entry : controlador.equipos.entrySet()) {
                System.out.println("key: " + entry.getKey() + "value : " + entry.getValue());
            }
            System.out.println(team.getNombre());
            int choice = val.leerNumero("\nIngrese el id del equipo local: ", sc);
            controlador.estadios.get(choice);
            sm.setEquipoLocal(team);
            System.out.println(controlador.equipos.get(choice));
            break;
        }

    }
}
