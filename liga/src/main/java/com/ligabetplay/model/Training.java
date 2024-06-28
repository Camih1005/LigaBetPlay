package com.ligabetplay.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Training {
    private Integer id;
    private Team equipo;
    private Date fecha;
    private Time hora;
    private String lugar;
    private List<Activity> lstActividades;
    private List<Player> lstJugadoresCombocados;
    
    public Training() {
        lstActividades = new ArrayList<Activity>();
        lstJugadoresCombocados = new ArrayList<Player>();
    }

    public Training(Integer id, Team equipo, Date fecha, Time hora, String lugar, List<Activity> lstActividades,
            List<Player> lstJugadoresCombocados) {
        this.id = id;
        this.equipo = equipo;
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
        this.lstActividades = lstActividades;
        this.lstJugadoresCombocados = lstJugadoresCombocados;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Team getEquipo() {
        return equipo;
    }

    public void setEquipo(Team equipo) {
        this.equipo = equipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public List<Activity> getLstActividades() {
        return lstActividades;
    }

    public void setLstActividades(Activity activity) {
        this.lstActividades.add(activity);
    }

    public List<Player> getLstJugadoresCombocados() {
        return lstJugadoresCombocados;
    }

    public void setLstJugadoresCombocados(Player player) {
        this.lstJugadoresCombocados.add(player);
    }
    
}
