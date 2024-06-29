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
    public Hashtable <Rol, String> credenciales = new Hashtable<>();
    public Hashtable <Integer,Stadium> estadios = new Hashtable<>();
    public Hashtable <Integer,Team> equipos = new Hashtable<>();
    public Hashtable <Integer,Player> jugadores = new Hashtable<>();
    public Hashtable <Integer,Coach> entrenadores = new Hashtable<>();
    
   

    private static Controller controlador;

    private Controller(){
    }

    public synchronized static Controller getInstance(){
        if(controlador == null){
            controlador = new Controller();
        }
        return controlador;
    }

}
