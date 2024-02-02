package com.nuestrosparques.token.app.adapter.encargados.service.impl;

import com.nuestrosparques.token.app.adapter.encargados.dto.LoginDTO;
import com.nuestrosparques.token.app.adapter.encargados.response.LoginResponse;
import com.nuestrosparques.token.app.adapter.encargados.service.EncargadosService;
import com.nuestrosparques.token.app.request.LoginRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EncargadosServiceImpl implements EncargadosService {

    @Value("${api.encargados.service}")
    private String encargadosApiUrl; // This would be your API endpoint

    private final RestTemplate restTemplate;

    public EncargadosServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public LoginDTO validateLogin(LoginRequest loginRequest) {
        LoginDTO loginResponse = new LoginDTO();
        String apiUrl = encargadosApiUrl + "/login?codigoUsuario="+ loginRequest.getUsuario() +
                "&password=" + loginRequest.getPassword(); // Modify this to match your API's endpoint structure
        ResponseEntity<LoginResponse> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, new ParameterizedTypeReference<LoginResponse>() {});
        if (response.getStatusCode().is2xxSuccessful()) {
            if(response.getBody().isLoginValid()){
                loginResponse.setA2(true);
            }else{
                loginResponse.setA2(false);
            }
            loginResponse.setA1("Login exitoso");
        }else {
            loginResponse.setA2(false);
            loginResponse.setA1("Login fallido"); // or throw an exception
        }
        return loginResponse;
    }
}
