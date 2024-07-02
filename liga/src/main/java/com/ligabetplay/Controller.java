package com.ligabetplay;

import java.util.Hashtable;
import java.util.Scanner;

import com.ligabetplay.model.Coach;
import com.ligabetplay.model.Player;
import com.ligabetplay.model.Rol;
import com.ligabetplay.model.Stadium;
import com.ligabetplay.model.Team;

public class Controller {

    public Scanner sc = new Scanner(System.in);
    public Hashtable<Rol, String> credenciales = new Hashtable<>();
    public Hashtable<Integer, Stadium> estadios = new Hashtable<>();
    public Hashtable<Integer, Team> equipos = new Hashtable<>();
    public Hashtable<Integer, Player> jugadores = new Hashtable<>();
    public Hashtable<Integer, Coach> entrenadores = new Hashtable<>();

    private static Controller controlador;

    private Controller() {
        inicializarCredenciales();
    }

    //DATOS BASE
   
        
   

    private void inicializarCredenciales() {
        credenciales.put(Rol.ADMINISTRADOR, "admin123");
        credenciales.put(Rol.EQUIPO_TECNICO, "tecnico123");
        credenciales.put(Rol.ARBITRO, "arbitro123");
        credenciales.put(Rol.PERIODISTA, "periodista123");
        credenciales.put(Rol.AFICIONADO, "aficionado123");

        // ESTADIOS

        Stadium estadio = new Stadium();
        estadio.setId(1);
        estadio.setNombre("Montanini");
        estadio.setUbicacion("Bucaramanga");
        estadio.setCapacidad(27000);
        estadios.put(01,estadio);

        //JUGADORES

        Team team = new Team();
        team.setId(1);
        team.setNombre("Santa fé");
        team.setCiudad("Bogota");
        team.setCoach("Christian");
        team.setEstadio("Atanacio girardot");
        equipos.put(1, team);
        //otros jugadores
        Team team2 = new Team();
        team2.setId(2);
        team2.setNombre("Atletico Bucaramanga");
        team2.setCiudad("Bucaramanga");
        team2.setCoach("Hader");
        team2.setEstadio("Montanini");
        equipos.put(2, team2);
    }

    public synchronized static Controller getInstance() {
        if (controlador == null) {
            controlador = new Controller();
        }
        return controlador;
    }
}
