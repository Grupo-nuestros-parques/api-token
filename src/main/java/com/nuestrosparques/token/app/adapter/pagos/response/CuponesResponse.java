package com.nuestrosparques.token.app.adapter.pagos.response;

import java.util.Date;

public class CuponesResponse {
    private String base;
    private String serie;
    private Integer numero;
    private Integer nroCupon;
    private Integer rut;
    private Integer nroCuota;
    private Date fechaVenc;
    private String estadoPagoCupon;
    private String tipoMov;
    private Integer montoCuotaPeso;
    private String dv;
    private String tipoMoneda;
    private String piePactado;


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
    public Integer getNroCupon() {
        return nroCupon;
    }
    public void setNroCupon(Integer nroCupon) {
        this.nroCupon = nroCupon;
    }
    public Integer getRut() {
        return rut;
    }
    public void setRUT(Integer rut) {
        this.rut = rut;
    }
    public Integer getNroCuota() {
        return nroCuota;
    }
    public void setNroCuota(Integer nroCuota) {
        this.nroCuota = nroCuota;
    }
    public Date getFechaVenc() {
        return fechaVenc;
    }
    public void setFechaVenc(Date fechaVenc) {
        this.fechaVenc = fechaVenc;
    }
    public String getEstadoPagoCupon() {
        return estadoPagoCupon;
    }
    public void setEstadoPagoCupon(String estadoPagoCupon) {
        this.estadoPagoCupon = estadoPagoCupon;
    }
    public String getTipoMov() {
        return tipoMov;
    }
    public void setTipoMov(String tipoMov) {
        this.tipoMov = tipoMov;
    }
    public Integer getMontoCuotaPeso() {
        return montoCuotaPeso;
    }
    public void setMontoCuotaPeso(Integer montoCuotaPeso) {
        this.montoCuotaPeso = montoCuotaPeso;
    }
    public String getDv() {
        return dv;
    }
    public void setDv(String dv) {
        this.dv = dv;
    }
    public String getTipoMoneda() {
        return tipoMoneda;
    }
    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }
    public String getPiePactado() {
        return piePactado;
    }
    public void setPiePactado(String piePactado) {
        this.piePactado = piePactado;
    }

}
