package com.nuestrosparques.token.app.adapter.pagos.response;

public class RezagosResponse {

    private Integer folio;
    private String fechaPago;
    private String tipoMov;
    private Integer monto;
    private String cuotasPag;
    private Double valorUf;
    private String rut;
    private String descripcionTipoMovimiento;
    private String nombre;
    private String apPaterno;
    private String base;

    public Integer getFolio() {
        return folio;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getTipoMov() {
        return tipoMov;
    }

    public void setTipoMov(String tipoMov) {
        this.tipoMov = tipoMov;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public String getCuotasPag() {
        return cuotasPag;
    }

    public void setCuotasPag(String cuotasPag) {
        this.cuotasPag = cuotasPag;
    }

    public Double getValorUf() {
        return valorUf;
    }

    public void setValorUf(Double valorUf) {
        this.valorUf = valorUf;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getDescripcionTipoMovimiento() {
        return descripcionTipoMovimiento;
    }

    public void setDescripcionTipoMovimiento(String descripcionTipoMovimiento) {
        this.descripcionTipoMovimiento = descripcionTipoMovimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }
}
