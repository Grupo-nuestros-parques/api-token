package com.nuestrosparques.token.app.adapter.portalplus.dto;

import java.io.Serializable;

public class GeolocationDTO implements Serializable {

    private Integer codParque;
    private String sector;
    private String sepultura;
    private String nroTecnico;
    private String estado;
    private String tipoConst;
    private String base;
    private String serie;
    private Integer numero;
    private String nombreFallecido;
    private String area;
    private String latitud;
    private String longitud;

    public Integer getCodParque() {
        return codParque;
    }

    public void setCodParque(Integer codParque) {
        this.codParque = codParque;
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

    public String getNroTecnico() {
        return nroTecnico;
    }

    public void setNroTecnico(String nroTecnico) {
        this.nroTecnico = nroTecnico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoConst() {
        return tipoConst;
    }

    public void setTipoConst(String tipoConst) {
        this.tipoConst = tipoConst;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNombreFallecido() {
        return nombreFallecido;
    }

    public void setNombreFallecido(String nombreFallecido) {
        this.nombreFallecido = nombreFallecido;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
}
