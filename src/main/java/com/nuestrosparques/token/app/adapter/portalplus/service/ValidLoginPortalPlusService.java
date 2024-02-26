package com.nuestrosparques.token.app.adapter.portalplus.service;

import com.nuestrosparques.token.app.adapter.portalplus.dto.LoginPortalPlusDTO;

public interface ValidLoginPortalPlusService {

    LoginPortalPlusDTO validateLogin(Integer rut);
}
