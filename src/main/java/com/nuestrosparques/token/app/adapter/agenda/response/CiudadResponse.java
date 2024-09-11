package com.nuestrosparques.token.app.adapter.agenda.response;

import javax.persistence.Column;
import java.io.Serializable;

public class CiudadResponse implements Serializable {

    private String codigoCiudad;

    private String capital;

    private String siglaCiudad;

    public String getCodigoCiudad() {
        return codigoCiudad;
    }

    public void setCodigoCiudad(String codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getSiglaCiudad() {
        return siglaCiudad;
    }

    public void setSiglaCiudad(String siglaCiudad) {
        this.siglaCiudad = siglaCiudad;
    }
}
