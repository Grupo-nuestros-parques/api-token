package com.nuestrosparques.token.app.adapter.boleta.response;

import java.io.Serializable;

public class BoletaResponse implements Serializable {

    private String folio;
    private String tipoCob;
    private String fechaPago;
    private String base;
    private String idTipoDocumento;
    private String descriptionTipoDocumento;
    private String rutEmpresa;
    private String vieneDe;
    private String contrato;
    private String caja;
    private String tipoContrato;



    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getTipoCob() {
        return tipoCob;
    }

    public void setTipoCob(String tipoCob) {
        this.tipoCob = tipoCob;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(String idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getDescriptionTipoDocumento() {
        return descriptionTipoDocumento;
    }

    public void setDescriptionTipoDocumento(String descriptionTipoDocumento) {
        this.descriptionTipoDocumento = descriptionTipoDocumento;
    }

    public String getRutEmpresa() {
        return rutEmpresa;
    }

    public void setRutEmpresa(String rutEmpresa) {
        this.rutEmpresa = rutEmpresa;
    }

    public String getVieneDe() {
        return vieneDe;
    }

    public void setVieneDe(String vieneDe) {
        this.vieneDe = vieneDe;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public String getCaja() {
        return caja;
    }

    public void setCaja(String caja) {
        this.caja = caja;
    }
}
