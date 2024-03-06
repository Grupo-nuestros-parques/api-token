package com.nuestrosparques.token.app.adapter.portalplus.service;

import com.nuestrosparques.token.app.adapter.portalplus.dto.LoginPortalPlusDTO;
import com.nuestrosparques.token.app.adapter.portalplus.request.UpdateProfile;

public interface ValidLoginPortalPlusService {

    LoginPortalPlusDTO validateLogin(Integer rut, String password);
    LoginPortalPlusDTO guardarCorreoAgente(Integer rut, String email);
    Integer restoreVerifyPassword(String token);
    Integer restorePassword(String token, String clave);
    Integer sendEmail(String correo);
    UpdateProfile updateProfile(UpdateProfile updateProfile);
}
