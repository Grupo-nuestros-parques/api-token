package com.nuestrosparques.token.app.adapter.boleta.service.impl;

import com.nuestrosparques.token.app.adapter.boleta.dto.DteDto;
import com.nuestrosparques.token.app.adapter.boleta.mapper.BoletaMapper;
import com.nuestrosparques.token.app.adapter.boleta.response.BoletaResponse;
import com.nuestrosparques.token.app.adapter.boleta.service.BoletaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class BoletaServiceImpl implements BoletaService {

    @Value("${api.boleta.service}")
    private String boletaApiUrl; // This would be your API endpoint

    private final RestTemplate restTemplate;
    private final BoletaMapper boletaMapper;

    public BoletaServiceImpl(RestTemplate restTemplate, BoletaMapper boletaMapper) {
        this.restTemplate = restTemplate;
        this.boletaMapper = boletaMapper;
    }

    @Override
    public DteDto getDte(Integer folio, Integer tipoDocumento, Integer rutEmrpesa) {
        String apiUrl = boletaApiUrl + "/dte?folio=" + folio + "&tipoDocumento=" + tipoDocumento +
                "&rutEmpresa=" + rutEmrpesa;
        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, new ParameterizedTypeReference<String>() {});
        if (response.getStatusCode().is2xxSuccessful()) {
            return boletaMapper.transformDteToResponse(response.getBody());
        }else {
            // Handle failure here
            return new DteDto(); // or throw an exception
        }
    }

    @Override
    public List<BoletaResponse> getBoletaByRut(Integer rut) {
        String apiUrl = boletaApiUrl + "/rut/" + rut;
        ResponseEntity<List<BoletaResponse>> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<BoletaResponse>>() {});
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }else {
            // Handle failure here
            return new ArrayList<>(); // or throw an exception
        }
    }
}
