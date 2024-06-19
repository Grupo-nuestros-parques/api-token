package com.nuestrosparques.token.app.adapter.tracking.dto;

import java.io.Serializable;

public class TrackingDTO implements Serializable {
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
    private String serie;
    private String base;
    private String numero;
    private String capacidad;
    private String sector;
    private String sepultura;
    private String area;

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getSepultura() {
        return sepultura;
    }

    public void setSepultura(String sepultura) {
        this.sepultura = sepultura;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

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

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
