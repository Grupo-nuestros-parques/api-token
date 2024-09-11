package com.nuestrosparques.token.app.adapter.agenda.response;

import javax.persistence.Column;
import java.io.Serializable;

public class ComunaResponse implements Serializable {

    private String codigoComuna;

    private String codigoCiudad;

    private String comuna;

    private String siglaComuna;

    public String getCodigoComuna() {
        return codigoComuna;
    }

    public void setCodigoComuna(String codigoComuna) {
        this.codigoComuna = codigoComuna;
    }

    public String getCodigoCiudad() {
        return codigoCiudad;
    }

    public void setCodigoCiudad(String codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getSiglaComuna() {
        return siglaComuna;
    }

    public void setSiglaComuna(String siglaComuna) {
        this.siglaComuna = siglaComuna;
    }
}
