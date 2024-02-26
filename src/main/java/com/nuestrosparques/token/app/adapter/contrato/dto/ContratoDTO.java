package com.nuestrosparques.token.app.adapter.contrato.dto;

import java.io.Serializable;

public class ContratoDTO implements Serializable {
    private Integer rut;
    private String barra;
    private String descripcion;
    private String nombreParque;
    private String siglaEstado;
    private String nombre;
    private String aPaterno;
    private Float fallecidos;
    private Float moracred;
    private Float moraMant;

    public Integer getRut() {
        return rut;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }

    public String getBarra() {
        return barra;
    }

    public void setBarra(String barra) {
        this.barra = barra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreParque() {
        return nombreParque;
    }

    public void setNombreParque(String nombreParque) {
        this.nombreParque = nombreParque;
    }

    public String getSiglaEstado() {
        return siglaEstado;
    }

    public void setSiglaEstado(String siglaEstado) {
        this.siglaEstado = siglaEstado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public Float getFallecidos() {
        return fallecidos;
    }

    public void setFallecidos(Float fallecidos) {
        this.fallecidos = fallecidos;
    }

    public Float getMoracred() {
        return moracred;
    }

    public void setMoracred(Float moracred) {
        this.moracred = moracred;
    }

    public Float getMoraMant() {
        return moraMant;
    }

    public void setMoraMant(Float moraMant) {
        this.moraMant = moraMant;
    }
}
