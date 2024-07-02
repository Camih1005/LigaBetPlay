package com.ligabetplay.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Match {
    private int id;
    private Team equipoLocal;
    private Team equipoVisitante;
    private String fecha;
    private String hora;
    private Stadium estadio;
    private List<Goal> lstGoles;
    private List<Card> lstTarjetas;
    private List <Incident> lstIncidentes;
    private String resultado;
   
    
    
    public Match() {
        lstGoles = new ArrayList<Goal>();
        lstTarjetas = new ArrayList<Card>();
        lstIncidentes = new ArrayList<Incident>();
    }

    public Match(int id, Team equipoLocal, Team equipoVisitante, String fecha, String hora, Stadium estadio,
            List<Goal> lstGoles, List<Card> lstTarjetas, List<Incident> lstIncidentes, String resultado) {
        this.id = id;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.fecha = fecha;
        this.hora = hora;
        this.estadio = estadio;
        this.lstGoles = lstGoles;
        this.lstTarjetas = lstTarjetas;
        this.lstIncidentes = lstIncidentes;
        this.resultado = resultado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Team getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Team equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Team getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Team equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Stadium getEstadio() {
        return estadio;
    }

    public void setEstadio(Stadium estadio) {
        this.estadio = estadio;
    }

    public List<Goal> getLstGoles() {
        return lstGoles;
    }

    public void setLstGoles(Goal goal) {
        this.lstGoles.add(goal);
    }

    public List<Card> getLstTarjetas() {
        return lstTarjetas;
    }

    public void setLstTarjetas(Card card) {
        this.lstTarjetas.add(card);
    }

    public List<Incident> getLstIncidentes() {
        return lstIncidentes;
    }

    public void setLstIncidentes(Incident incident) {
        this.lstIncidentes.add(incident);
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
