package com.nuestrosparques.token.app.adapter.portalplus.dto;

import java.io.Serializable;

public class BasePlaniDTO implements Serializable {

    private String area;
    private String sector;
    private Integer capacidad;
    private String tipo;
    private Integer totalSep;
    private Integer totalAsignadas;
    private String tipoSep;
    private String sectorPlano;
    private Integer codParque;
    private Integer webAncho;
    private Integer webAlto;
    private String webOrienta;
    private Integer webNorte;
    private String codigoProducto;
    private String tablaPlano;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getTotalSep() {
        return totalSep;
    }

    public void setTotalSep(Integer totalSep) {
        this.totalSep = totalSep;
    }

    public Integer getTotalAsignadas() {
        return totalAsignadas;
    }

    public void setTotalAsignadas(Integer totalAsignadas) {
        this.totalAsignadas = totalAsignadas;
    }

    public String getTipoSep() {
        return tipoSep;
    }

    public void setTipoSep(String tipoSep) {
        this.tipoSep = tipoSep;
    }

    public String getSectorPlano() {
        return sectorPlano;
    }

    public void setSectorPlano(String sectorPlano) {
        this.sectorPlano = sectorPlano;
    }

    public Integer getCodParque() {
        return codParque;
    }

    public void setCodParque(Integer codParque) {
        this.codParque = codParque;
    }

    public Integer getWebAncho() {
        return webAncho;
    }

    public void setWebAncho(Integer webAncho) {
        this.webAncho = webAncho;
    }

    public Integer getWebAlto() {
        return webAlto;
    }

    public void setWebAlto(Integer webAlto) {
        this.webAlto = webAlto;
    }

    public String getWebOrienta() {
        return webOrienta;
    }

    public void setWebOrienta(String webOrienta) {
        this.webOrienta = webOrienta;
    }

    public Integer getWebNorte() {
        return webNorte;
    }

    public void setWebNorte(Integer webNorte) {
        this.webNorte = webNorte;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getTablaPlano() {
        return tablaPlano;
    }

    public void setTablaPlano(String tablaPlano) {
        this.tablaPlano = tablaPlano;
    }
}
