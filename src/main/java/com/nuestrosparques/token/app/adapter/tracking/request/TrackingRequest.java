package com.nuestrosparques.token.app.adapter.tracking.request;

import java.io.Serializable;

public class TrackingRequest implements Serializable {

    private String nombreFuncion;
    private int rut;
    private String tokenSession;
    private String nombreCompletoAgente;

    // Getters and setters
    public String getNombreFuncion() {
        return nombreFuncion;
    }

    public void setNombreFuncion(String nombreFuncion) {
        this.nombreFuncion = nombreFuncion;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getTokenSession() {
        return tokenSession;
    }

    public void setTokenSession(String tokenSession) {
        this.tokenSession = tokenSession;
    }

    public String getNombreCompletoAgente() {
        return nombreCompletoAgente;
    }

    public void setNombreCompletoAgente(String nombreCompletoAgente) {
        this.nombreCompletoAgente = nombreCompletoAgente;
    }
}
