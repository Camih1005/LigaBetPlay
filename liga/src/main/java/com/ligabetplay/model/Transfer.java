package com.ligabetplay.model;

import java.util.Date;

public class Transfer {
    private Integer id;
    private Player jugador;
    private Team equipoOrigen;
    private Team equipoDestino;
    private double monto;
    private Date fecha;


    public Transfer() {
    }


    public Transfer(Integer id, Player jugador, Team equipoOrigen, Team equipoDestino, double monto, Date fecha) {
        this.id = id;
        this.jugador = jugador;
        this.equipoOrigen = equipoOrigen;
        this.equipoDestino = equipoDestino;
        this.monto = monto;
        this.fecha = fecha;
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


    public Team getEquipoOrigen() {
        return equipoOrigen;
    }


    public void setEquipoOrigen(Team equipoOrigen) {
        this.equipoOrigen = equipoOrigen;
    }


    public Team getEquipoDestino() {
        return equipoDestino;
    }


    public void setEquipoDestino(Team equipoDestino) {
        this.equipoDestino = equipoDestino;
    }


    public double getMonto() {
        return monto;
    }


    public void setMonto(double monto) {
        this.monto = monto;
    }


    public Date getFecha() {
        return fecha;
    }


    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
