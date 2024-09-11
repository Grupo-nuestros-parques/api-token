package com.nuestrosparques.token.app.request;

public class RegistrarIntentoRequest {
    private String codigoAgente;
    private String idOrigin;
    private String idTypeGrupoPp;
    private String idTypeSubGrupoPp;
    private String idCity;
    private String idComuna;
    private String exitoso;

    public String getCodigoAgente() {
        return codigoAgente;
    }

    public void setCodigoAgente(String codigoAgente) {
        this.codigoAgente = codigoAgente;
    }

    public String getIdOrigin() {
        return idOrigin;
    }

    public void setIdOrigin(String idOrigin) {
        this.idOrigin = idOrigin;
    }

    public String getIdTypeGrupoPp() {
        return idTypeGrupoPp;
    }

    public void setIdTypeGrupoPp(String idTypeGrupoPp) {
        this.idTypeGrupoPp = idTypeGrupoPp;
    }

    public String getIdTypeSubGrupoPp() {
        return idTypeSubGrupoPp;
    }

    public void setIdTypeSubGrupoPp(String idTypeSubGrupoPp) {
        this.idTypeSubGrupoPp = idTypeSubGrupoPp;
    }

    public String getIdCity() {
        return idCity;
    }

    public void setIdCity(String idCity) {
        this.idCity = idCity;
    }

    public String getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(String idComuna) {
        this.idComuna = idComuna;
    }

    public String getExitoso() {
        return exitoso;
    }

    public void setExitoso(String exitoso) {
        this.exitoso = exitoso;
    }
}
