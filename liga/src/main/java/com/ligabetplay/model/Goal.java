package com.ligabetplay.model;

public class Goal {
    private Integer id;
    private Player jugador;
    private Team equipo;
    private int minuto;
    private SchedulingMatch partido;


    public Goal() {
    }


    public Goal(Integer id, Player jugador, Team equipo, int minuto, SchedulingMatch partido) {
        this.id = id;
        this.jugador = jugador;
        this.equipo = equipo;
        this.minuto = minuto;
        this.partido = partido;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Player getJugador() {
        return jugador;
    }


    public void setJugador(Player jugador) {
        this.jugador = jugador;
    }


    public Team getEquipo() {
        return equipo;
    }


    public void setEquipo(Team equipo) {
        this.equipo = equipo;
    }


    public int getMinuto() {
        return minuto;
    }


    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }


    public SchedulingMatch getPartido() {
        return partido;
    }


    public void setPartido(SchedulingMatch partido) {
        this.partido = partido;
    }

    

    



    
}



