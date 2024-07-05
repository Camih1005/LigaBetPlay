package com.ligabetplay.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SchedulingMatch {
    private int id;
    private Team equipoLocal;
    private Team equipoVisitante;
    private Date fecha;
    private Time hora;
    private Stadium estadio;
    private Referee arbitro;
    private Referee arbitro;
    private List<Goal> lstGoles;
    private List<Card> lstTarjetas;
    private List<Incident> lstIncidentes;
    private Result resultado;

    public SchedulingMatch() {}

   

    public SchedulingMatch(int id, Team equipoLocal, Team equipoVisitante, Date fecha, Time hora, Stadium estadio,
            Referee arbitro, List<Goal> lstGoles, List<Card> lstTarjetas, List<Incident> lstIncidentes,
            Result resultado) {
        this.id = id;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.fecha = fecha;
        this.hora = hora;
        this.estadio = estadio;
        this.arbitro = arbitro;
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

    public Result getResultado() {
        return resultado;
    }

    public void setResultado(Result resultado) {
        this.resultado = resultado;
    }

    public Referee getArbitro() {
        return arbitro;
    }

    public void setArbitro(Referee arbitro) {
        this.arbitro = arbitro;
    }

    

    public Referee getArbitro() {
        return arbitro;
    }

    public void setArbitro(Referee arbitro) {
        this.arbitro = arbitro;
    }

    
}
