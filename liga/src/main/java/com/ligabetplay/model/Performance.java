package com.ligabetplay.model;

public class Performance {
    private Integer id;
    private Player jugador;
    private Match partido;
    private int minutosJugados;
    private int numeroGoles;
    private int asistencias;
    private int tarjetasAmarillas;
    private int tarjetasRojas;

    public Performance() {
    }

    public Performance(Integer id, Player jugador, Match partido, int minutosJugados, int numeroGoles, int asistencias,
            int tarjetasAmarillas, int tarjetasRojas) {
        this.id = id;
        this.jugador = jugador;
        this.partido = partido;
        this.minutosJugados = minutosJugados;
        this.numeroGoles = numeroGoles;
        this.asistencias = asistencias;
        this.tarjetasAmarillas = tarjetasAmarillas;
        this.tarjetasRojas = tarjetasRojas;
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

    public Match getPartido() {
        return partido;
    }

    public void setPartido(Match partido) {
        this.partido = partido;
    }

    public int getMinutosJugados() {
        return minutosJugados;
    }

    public void setMinutosJugados(int minutosJugados) {
        this.minutosJugados = minutosJugados;
    }

    public int getNumeroGoles() {
        return numeroGoles;
    }

    public void setNumeroGoles(int numeroGoles) {
        this.numeroGoles = numeroGoles;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    public int getTarjetasAmarillas() {
        return tarjetasAmarillas;
    }

    public void setTarjetasAmarillas(int tarjetasAmarillas) {
        this.tarjetasAmarillas = tarjetasAmarillas;
    }

    public int getTarjetasRojas() {
        return tarjetasRojas;
    }

    public void setTarjetasRojas(int tarjetasRojas) {
        this.tarjetasRojas = tarjetasRojas;
    }

    
}
