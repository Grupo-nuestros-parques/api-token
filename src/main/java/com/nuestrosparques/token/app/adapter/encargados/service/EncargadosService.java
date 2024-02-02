package com.nuestrosparques.token.app.adapter.encargados.service;

import com.nuestrosparques.token.app.adapter.encargados.dto.LoginDTO;
import com.nuestrosparques.token.app.request.LoginRequest;

public interface EncargadosService {

    LoginDTO validateLogin(LoginRequest loginRequest);
}
