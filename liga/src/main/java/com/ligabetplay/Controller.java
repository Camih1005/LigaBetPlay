package com.ligabetplay;

import java.util.Hashtable;
import java.util.Scanner;

import com.ligabetplay.model.Announcement;
import com.ligabetplay.model.Coach;
import com.ligabetplay.model.Incident;
import com.ligabetplay.model.Injury;
import com.ligabetplay.model.Player;
import com.ligabetplay.model.Referee;
import com.ligabetplay.model.Rol;
import com.ligabetplay.model.SchedulingMatch;
import com.ligabetplay.model.Stadium;
import com.ligabetplay.model.Team;
import com.ligabetplay.model.User;

public class Controller {

    public Scanner sc = new Scanner(System.in);
    public Hashtable<Rol, String> credenciales = new Hashtable<>();
    public Hashtable<Integer, Stadium> estadios = new Hashtable<>();
    public Hashtable<Integer, Team> equipos = new Hashtable<>();
    public Hashtable<Integer, Player> jugadores = new Hashtable<>();
    public Hashtable<Integer, Coach> entrenadores = new Hashtable<>();
    public Hashtable<Integer, User> usuarios = new Hashtable<>();
    public Hashtable<Integer, Announcement> comunicaciones = new Hashtable<>();
    public Hashtable<Integer, SchedulingMatch> programacionPartidos = new Hashtable<>();
    public Hashtable<Integer, SchedulingMatch> ResultadosPartido = new Hashtable<>();
    public Hashtable<Integer, Incident> incident = new Hashtable<>();
    public Hashtable<Integer, Referee> Arbitro = new Hashtable<>();
    public Hashtable<Integer, Injury> lesiones= new Hashtable<>();
    

    private static Controller controlador;

    private Controller() {
        inicializarCredenciales();
    }

    // DATOS BASE



    private void inicializarCredenciales() {
        credenciales.put(Rol.ADMINISTRADOR, "admin123");
        credenciales.put(Rol.EQUIPO_TECNICO, "tecnico123");
        credenciales.put(Rol.ARBITRO, "arbitro123");
        credenciales.put(Rol.PERIODISTA, "periodista123");
        credenciales.put(Rol.AFICIONADO, "aficionado123");

        // 

        // ESTADIOS

        Stadium estadio1 = new Stadium();
        estadio1.setId(1);
        estadio1.setNombre("Estadio Metropolitano Roberto Meléndez");
        estadio1.setUbicacion("Barranquilla");
        estadio1.setCapacidad(46000);
        estadios.put(1, estadio1);

        Stadium estadio2 = new Stadium();
        estadio2.setId(2);
        estadio2.setNombre("Estadio Atanasio Girardot");
        estadio2.setUbicacion("Medellín");
        estadio2.setCapacidad(40000);
        estadios.put(2, estadio2);

        Stadium estadio3 = new Stadium();
        estadio3.setId(3);
        estadio3.setNombre("Estadio Nemesio Camacho El Campín");
        estadio3.setUbicacion("Bogotá");
        estadio3.setCapacidad(36343);
        estadios.put(3, estadio3);

        Stadium estadio4 = new Stadium();
        estadio4.setId(4);
        estadio4.setNombre("Estadio Olímpico Pascual Guerrero");
        estadio4.setUbicacion("Cali");
        estadio4.setCapacidad(35405);
        estadios.put(4, estadio4);

        Stadium estadio5 = new Stadium();
        estadio5.setId(5);
        estadio5.setNombre("Estadio Deportivo Cali");
        estadio5.setUbicacion("Cali");
        estadio5.setCapacidad(42000);
        estadios.put(5, estadio5);

        Stadium estadio6 = new Stadium();
        estadio6.setId(6);
        estadio6.setNombre("Estadio Manuel Murillo Toro");
        estadio6.setUbicacion("Ibagué");
        estadio6.setCapacidad(28500);
        estadios.put(6, estadio6);

        Stadium estadio7 = new Stadium();
        estadio7.setId(7);
        estadio7.setNombre("Estadio Americo Montanini");
        estadio7.setUbicacion("Bucaramanga");
        estadio7.setCapacidad(28500);
        estadios.put(7, estadio7);

        Stadium estadio8 = new Stadium();
        estadio8.setId(8);
        estadio8.setNombre("Estadio Palogrande");
        estadio8.setUbicacion("Manizales");
        estadio8.setCapacidad(28679);
        estadios.put(8, estadio8);

        Stadium estadio9 = new Stadium();
        estadio9.setId(9);
        estadio9.setNombre("Estadio Hernán Ramírez Villegas");
        estadio9.setUbicacion("Pereira");
        estadio9.setCapacidad(30000);
        estadios.put(9, estadio9);

        Stadium estadio10 = new Stadium();
        estadio10.setId(10);
        estadio10.setNombre("Estadio Guillermo Plazas Alcid");
        estadio10.setUbicacion("Neiva");
        estadio10.setCapacidad(25000);

        // EQUIPOS

        // EQUIPOS

        

        Team team6 = new Team();
        team6.setId(1);
        team6.setNombre("Santa Fe");
        team6.setCiudad("Bogotá");
        team6.setCoach("Harold Rivera");
        equipos.put(1, team6);

        Team team10 = new Team();
        team10.setId(2);
        team10.setNombre("Atlético Bucaramanga");
        team10.setCiudad("Bucaramanga");
        team10.setCoach("Rafael Dudamel");
        equipos.put(2, team10);

        //JUGADORES

        Player player = new Player();
        player.setId(1);
        player.setPosicion("Delantero");
        player.setNacionalidad("Bumanguez");
        player.setNumeroCamiseta(9);
        player.setNombre("Cristian Zapata");
        player.setEquipo(equipos.get(2));
        jugadores.put(1, player);
        //
        Player player2 = new Player();

        player2.setId(2);
        player2.setPosicion("Defensa");
        player2.setNacionalidad("Rolo");
        player2.setNumeroCamiseta(10);
        player2.setNombre("Hugo Rodallega");
        player2.setEquipo(equipos.get(1));
        jugadores.put(2, player2);

    }

    public synchronized static Controller getInstance() {
        if (controlador == null) {
            controlador = new Controller();
        }
        return controlador;
    }
}
