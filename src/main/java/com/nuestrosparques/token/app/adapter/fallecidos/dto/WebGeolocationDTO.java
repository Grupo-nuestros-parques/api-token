package com.nuestrosparques.token.app.adapter.fallecidos.dto;

import java.io.Serializable;

public class WebGeolocationDTO implements Serializable {

    private String a1; //area;
    private String a2; //sector;
    private String a3; //sepultura;
    private String a4; //nroTecnico;
    private String a5; //latitud;
    private String a6; //longitud;
    private Integer a7; //codigoParque;

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

    public String getA5() {
        return a5;
    }

    public void setA5(String a5) {
        this.a5 = a5;
    }

    public String getA6() {
        return a6;
    }

    public void setA6(String a6) {
        this.a6 = a6;
    }

    public Integer getA7() {
        return a7;
    }

    public void setA7(Integer a7) {
        this.a7 = a7;
    }
}
