package com.ligabetplay;

import java.util.Hashtable;
import java.util.Scanner;

import com.ligabetplay.model.Coach;
import com.ligabetplay.model.Player;
import com.ligabetplay.model.Stadium;
import com.ligabetplay.model.Team;

public class Controller {

    public Scanner sc = new Scanner(System.in);

    public Hashtable <String,Stadium> estadios = new Hashtable<>();
    public Hashtable <String,Team> equipos = new Hashtable<>();
    public Hashtable <String,Player> jugadores = new Hashtable<>();
    public Hashtable <String,Coach> entrenadores = new Hashtable<>();
   

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
