package com.nuestrosparques.token.app.adapter.qr.dto;

import java.io.Serializable;

public class CrematorioScanDto implements Serializable {

    private String a1; //descrionEstado;
    private String a2; //cambio;
    private String a3; //estado;
    private String a4; //respuesta;

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }

    public String getA3() {
        return a3;
    }

    public void setA3(String a3) {
        this.a3 = a3;
    }

    public String getA4() {
        return a4;
    }

    public void setA4(String a4) {
        this.a4 = a4;
    }
}
