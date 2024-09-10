package com.nuestrosparques.token.app.adapter.agenda.service.impl;

import com.nuestrosparques.token.app.adapter.agenda.dto.OrigenDTO;
import com.nuestrosparques.token.app.adapter.agenda.mapper.OrigenMapper;
import com.nuestrosparques.token.app.adapter.agenda.response.OrigenResponse;
import com.nuestrosparques.token.app.adapter.agenda.service.AgendaService;
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
public class AgendaServiceImpl implements AgendaService {

    @Value("${api.agenda.service}")
    private String agendaApiUrl; // This would be your API endpoint

    private final RestTemplate restTemplate;
    private final OrigenMapper origenMapper;

    public AgendaServiceImpl(
            RestTemplate restTemplate,
            OrigenMapper origenMapper
    ) {
        this.restTemplate = restTemplate;
        this.origenMapper = origenMapper;
    }

    @Override
    public List<OrigenDTO> getOriginList() {
        List<OrigenResponse> responses = new ArrayList<>();
        List<OrigenDTO> origenDTOS = new ArrayList<>();
        String apiUrl = agendaApiUrl + "/origen";

        ResponseEntity<List<OrigenResponse>> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<OrigenResponse>>() {});
        if (response.getStatusCode().is2xxSuccessful()) {
            responses = response.getBody();
            origenDTOS = origenMapper.transformOrigenToDTO(responses);
        }else {
            // Handle failure here
            return Collections.emptyList(); // or throw an exception
        }
        return origenDTOS;
    }

}
