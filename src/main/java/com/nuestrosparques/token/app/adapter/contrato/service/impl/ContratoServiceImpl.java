package com.nuestrosparques.token.app.adapter.contrato.service.impl;

import com.nuestrosparques.token.app.adapter.contrato.dto.ContratoDTO;
import com.nuestrosparques.token.app.adapter.contrato.service.ContratoService;
import com.nuestrosparques.token.app.adapter.encargados.response.LoginResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContratoServiceImpl implements ContratoService {

    @Value("${api.contrato.service}")
    private String contratosApiUrl; // This would be your API endpoint

    private final RestTemplate restTemplate;

    public ContratoServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<ContratoDTO> getContratosPorRutForContract(Integer rut, String schema) {
        List<ContratoDTO> contratos = new ArrayList<>();
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-schema", schema);
        HttpEntity<?> httpEntity = new HttpEntity<>(headers);
        String apiUrl = contratosApiUrl + "/contractForContract?rut="+ rut; // Modify this to match your API's endpoint structure
        ResponseEntity<List<ContratoDTO>> response = restTemplate.exchange(apiUrl, HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<ContratoDTO>>() {});
        if (response.getStatusCode().is2xxSuccessful()) {
            contratos = response.getBody();
        }
        return contratos;
    }

    @Override
    public List<ContratoDTO> getContratosPorRutForPay(Integer rut, String schema) {
        List<ContratoDTO> contratos = new ArrayList<>();
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-schema", schema);
        HttpEntity<?> httpEntity = new HttpEntity<>(headers);
        String apiUrl = contratosApiUrl + "/contractForPay?rut="+ rut; // Modify this to match your API's endpoint structure
        ResponseEntity<List<ContratoDTO>> response = restTemplate.exchange(apiUrl, HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<ContratoDTO>>() {});
        if (response.getStatusCode().is2xxSuccessful()) {
            contratos = response.getBody();
        }
        return contratos;
    }
}
