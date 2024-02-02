package com.nuestrosparques.token.app.adapter.uf.response;

import java.io.Serializable;

public class UfResponse implements Serializable {

    private boolean Ok;
    private Integer status;
    private String msg;
    private Uf uf;

    public boolean isOk() {
        return Ok;
    }

    public void setOk(boolean ok) {
        Ok = ok;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Uf getUf() {
        return uf;
    }

    public void setUf(Uf uf) {
        this.uf = uf;
    }
}
