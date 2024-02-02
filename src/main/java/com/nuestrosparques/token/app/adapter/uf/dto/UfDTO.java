package com.nuestrosparques.token.app.adapter.uf.dto;

import java.io.Serializable;
import java.util.Date;

public class UfDTO implements Serializable {

    private Integer a1; //status;
    private String a2; //msg;
    private Double a3; //ufValue;
    private Date a4; //ufDate;

    public Integer getA1() {
        return a1;
    }

    public void setA1(Integer a1) {
        this.a1 = a1;
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }

    public Double getA3() {
        return a3;
    }

    public void setA3(Double a3) {
        this.a3 = a3;
    }

    public Date getA4() {
        return a4;
    }

    public void setA4(Date a4) {
        this.a4 = a4;
    }
}
