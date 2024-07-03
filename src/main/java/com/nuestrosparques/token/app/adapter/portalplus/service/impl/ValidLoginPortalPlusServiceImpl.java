package com.nuestrosparques.token.app.adapter.portalplus.service.impl;

import com.nuestrosparques.token.app.adapter.contrato.dto.ContratoDTO;
import com.nuestrosparques.token.app.adapter.portalplus.dto.LoginPortalPlusDTO;
import com.nuestrosparques.token.app.adapter.portalplus.request.UpdateProfile;
import com.nuestrosparques.token.app.adapter.portalplus.service.ValidLoginPortalPlusService;
import com.nuestrosparques.token.app.request.CrematorioScanRequest;
import com.nuestrosparques.token.app.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;

import java.util.Arrays;
import java.util.List;

@Component
public class ValidLoginPortalPlusServiceImpl implements ValidLoginPortalPlusService {

    @Value("${api.portalplus.service}")
    private String portalPlusApiUrl; // This would be your API endpoint

    private final RestTemplate restTemplate;

    public ValidLoginPortalPlusServiceImpl(
            RestTemplate restTemplate
    ) {
        this.restTemplate = restTemplate;
    }

    @Override
    public LoginPortalPlusDTO validateLogin(Integer rut, String password) {
        LoginPortalPlusDTO valid = new LoginPortalPlusDTO();
        String apiUrl = portalPlusApiUrl + "/rut/"+ rut + "?password=" + password; // Modify this to match your API's endpoint structure
        ResponseEntity<LoginPortalPlusDTO> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, new ParameterizedTypeReference<LoginPortalPlusDTO>() {});
        if (response.getStatusCode().is2xxSuccessful()) {
            valid = response.getBody();
            String nanoId = generateNanoId();
            valid.setTokenSession(nanoId);
            // URL para obtener los roles
            String apiUrlRoles = portalPlusApiUrl + "/mantenedor/get-roles?rut=" + rut;
            ResponseEntity<List<String>> rolesResponse = restTemplate.exchange(apiUrlRoles, HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>() {});
            if (rolesResponse.getStatusCode().is2xxSuccessful()) {
                List<String> roles = rolesResponse.getBody();
                valid.setRoles(roles);
            }
        }
        return valid;
    }

    public static String generateNanoId() {
        return NanoIdUtils.randomNanoId(); // Genera un NanoID con la configuración predeterminada
    }

    @Override
    public LoginPortalPlusDTO guardarCorreoAgente(Integer rut, String email) {
        LoginPortalPlusDTO valid = new LoginPortalPlusDTO();
        String apiUrl = portalPlusApiUrl + "/rut/"+ rut + "/email?email=" + email; // Modify this to match your API's endpoint structure
        ResponseEntity<LoginPortalPlusDTO> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, new ParameterizedTypeReference<LoginPortalPlusDTO>() {});
        if (response.getStatusCode().is2xxSuccessful()) {
            valid = response.getBody();
        }
        return valid;
    }

    @Override
    public Integer restoreVerifyPassword(String token) {
        String apiUrl = portalPlusApiUrl + "/restore/verify/"+ token; // Modify this to match your API's endpoint structure
        ResponseEntity<Integer> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, new ParameterizedTypeReference<Integer>() {});
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }
        return 0;
    }

    @Override
    public Integer restorePassword(String token, String clave) {
        String apiUrl = portalPlusApiUrl + "/restore/"+ token + "?clave=" + clave; // Modify this to match your API's endpoint structure
        ResponseEntity<Integer> response = restTemplate.exchange(apiUrl, HttpMethod.POST, null, new ParameterizedTypeReference<Integer>() {});
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }
        return 0;
    }

    @Override
    public Integer sendEmail(String correo) {
        String apiUrl = portalPlusApiUrl + "/send/email?correo="+ correo; // Modify this to match your API's endpoint structure
        ResponseEntity<Integer> response = restTemplate.exchange(apiUrl, HttpMethod.POST, null, new ParameterizedTypeReference<Integer>() {});
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }
        return 0;
    }

    @Override
    public UpdateProfile updateProfile(UpdateProfile updateProfile) {
        String apiUrl = portalPlusApiUrl + "/agent/update-profile"; // Modify this to match your API's endpoint structure
        ResponseEntity<UpdateProfile> response =
                restTemplate.exchange(apiUrl, HttpMethod.POST, setHeaderScan(updateProfile),
                        new ParameterizedTypeReference<UpdateProfile>() {});
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }else{
            return new UpdateProfile();
        }
    }

    private HttpEntity<UpdateProfile> setHeaderScan(UpdateProfile updateProfile){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<UpdateProfile> entity = new HttpEntity<>(updateProfile, headers);
        return entity;
    }
}
