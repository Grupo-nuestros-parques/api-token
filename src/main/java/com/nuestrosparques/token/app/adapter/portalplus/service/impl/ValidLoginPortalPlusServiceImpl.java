package com.nuestrosparques.token.app.adapter.portalplus.service.impl;

import com.nuestrosparques.token.app.adapter.contrato.dto.ContratoDTO;
import com.nuestrosparques.token.app.adapter.portalplus.dto.LoginPortalPlusDTO;
import com.nuestrosparques.token.app.adapter.portalplus.service.ValidLoginPortalPlusService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ValidLoginPortalPlusServiceImpl implements ValidLoginPortalPlusService {

    @Value("${api.portalplus.service}")
    private String portalPlusApiUrl; // This would be your API endpoint

    private final RestTemplate restTemplate;

    public ValidLoginPortalPlusServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public LoginPortalPlusDTO validateLogin(Integer rut) {
        LoginPortalPlusDTO valid = new LoginPortalPlusDTO();
        String apiUrl = portalPlusApiUrl + "/rut/"+ rut; // Modify this to match your API's endpoint structure
        ResponseEntity<LoginPortalPlusDTO> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, new ParameterizedTypeReference<LoginPortalPlusDTO>() {});
        if (response.getStatusCode().is2xxSuccessful()) {
            valid = response.getBody();
        }
        return valid;
    }
}
