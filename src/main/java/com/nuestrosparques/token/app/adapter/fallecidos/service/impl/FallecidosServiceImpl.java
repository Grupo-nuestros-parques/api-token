package com.nuestrosparques.token.app.adapter.fallecidos.service.impl;

import com.nuestrosparques.token.app.adapter.fallecidos.dto.FallecidosDTO;
import com.nuestrosparques.token.app.adapter.fallecidos.mapper.FallecidosMapper;
import com.nuestrosparques.token.app.adapter.fallecidos.response.FallecidosResponse;
import com.nuestrosparques.token.app.adapter.fallecidos.service.FallecidosService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class FallecidosServiceImpl implements FallecidosService {

    @Value("${api.fallecidos.service}")
    private String fallecidosApiUrl; // This would be your API endpoint

    private final RestTemplate restTemplate;
    private final FallecidosMapper fallecidosMapper;

    public FallecidosServiceImpl(RestTemplate restTemplate, FallecidosMapper fallecidosMapper) {
        this.restTemplate = restTemplate;
        this.fallecidosMapper = fallecidosMapper;
    }

    @Override
    public List<FallecidosResponse> findAll() {

        List<FallecidosResponse> responses = new ArrayList<>();
        String apiUrl = fallecidosApiUrl; // Modify this to match your API's endpoint structure
        ResponseEntity<List<FallecidosResponse>> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<FallecidosResponse>>() {});
        if (response.getStatusCode().is2xxSuccessful()) {
            responses = response.getBody();
        }else {
            // Handle failure here
            return Collections.emptyList(); // or throw an exception
        }
        return responses;
    }

    @Override
    public List<FallecidosDTO> getTodosFallecidosPorFechaYParque(String fechaInicio, String fechaFin, Integer parque) {
        List<FallecidosResponse> responses = new ArrayList<>();
        List<FallecidosDTO> fallecidosDTOS = new ArrayList<>();
        String apiUrl = fallecidosApiUrl + "?fechaInicio="+ fechaInicio +
        "&fechaFin=" + fechaFin + "&parque=" + parque; // Modify this to match your API's endpoint structure
        ResponseEntity<List<FallecidosResponse>> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<FallecidosResponse>>() {});
        if (response.getStatusCode().is2xxSuccessful()) {
            responses = response.getBody();
            //fallecidosDTOS = fallecidosMapper.transformFallecidosToDTO(responses);
        }else {
            // Handle failure here
            return Collections.emptyList(); // or throw an exception
        }
        return fallecidosDTOS;
    }

    @Override
    public List<FallecidosDTO> encontrarTodosFallecidos(Integer parque, String nombres, String apellidoPaterno, String apellidoMaterno, String rut) {
        List<FallecidosResponse> responses = new ArrayList<>();
        List<FallecidosDTO> fallecidosDTOS = new ArrayList<>();
        String apiUrl = fallecidosApiUrl + "?parque="+ parque +
                "&nombres=" + nombres + "&apellidoPaterno=" + apellidoPaterno +
                "&apellidoMaterno=" + apellidoMaterno + "&rut=" + rut; // Modify this to match your API's endpoint structure
        ResponseEntity<List<FallecidosResponse>> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<FallecidosResponse>>() {});
        if (response.getStatusCode().is2xxSuccessful()) {
            responses = response.getBody();
            fallecidosDTOS = fallecidosMapper.transformToFallecidosList(responses);
        }else {
            // Handle failure here
            return Collections.emptyList(); // or throw an exception
        }
        return fallecidosDTOS;
    }
}
