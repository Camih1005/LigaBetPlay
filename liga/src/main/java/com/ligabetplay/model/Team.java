package com.ligabetplay.model;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private int id;
    private String nombre;
    private String ciudad;
    private String estadio;
    private String Coach;
    private List<Player> lstJugadores;
    private List<Match> lstPartidos;

    public Team() {
        lstJugadores = new ArrayList<Player>();
        lstPartidos = new ArrayList<Match>();
    }

    public Team(int id, String nombre, String ciudad, String estadio, String coach, List<Player> lstJugadores,
            List<Match> lstPartidos) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estadio = estadio;
        Coach = coach;
        this.lstJugadores = lstJugadores;
        this.lstPartidos = lstPartidos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public String getCoach() {
        return Coach;
    }

    public void setCoach(String coach) {
        Coach = coach;
    }

    public List<Player> getLstJugadores() {
        return lstJugadores;
    }

    public void setLstJugadores(Player player) {
        this.lstJugadores.add(player);
    }

    public List<Match> getLstPartidos() {
        return lstPartidos;
    }

    public void setLstPartidos(Match match) {
        this.lstPartidos.add(match);
    }
}
