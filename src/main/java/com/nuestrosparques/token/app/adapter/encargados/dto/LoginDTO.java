package com.nuestrosparques.token.app.adapter.encargados.dto;

import java.io.Serializable;

public class LoginDTO implements Serializable {

    private String a1; //mensaje
    private boolean a2; //usuarioConsulta

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public boolean isA2() {
        return a2;
    }

    public void setA2(boolean a2) {
        this.a2 = a2;
    }
}
