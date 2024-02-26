package com.nuestrosparques.token.app.adapter.portalplus.dto;

import java.io.Serializable;

public class LoginPortalPlusDTO implements Serializable {

    private boolean trabajadorExiste;

    public boolean isTrabajadorExiste() {
        return trabajadorExiste;
    }

    public void setTrabajadorExiste(boolean trabajadorExiste) {
        this.trabajadorExiste = trabajadorExiste;
    }
}
