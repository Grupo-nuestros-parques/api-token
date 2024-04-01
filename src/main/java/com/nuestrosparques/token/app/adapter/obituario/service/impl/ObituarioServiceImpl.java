package com.nuestrosparques.token.app.adapter.obituario.service.impl;

import com.nuestrosparques.token.app.adapter.obituario.dto.ObituarioCrematorioDTO;
import com.nuestrosparques.token.app.adapter.obituario.dto.ObituarioDTO;
import com.nuestrosparques.token.app.adapter.obituario.mapper.ObituarioCrematorioMapper;
import com.nuestrosparques.token.app.adapter.obituario.mapper.ObituarioMapper;
import com.nuestrosparques.token.app.adapter.obituario.response.ObituarioCrematorioResponse;
import com.nuestrosparques.token.app.adapter.obituario.response.ObituarioResponse;
import com.nuestrosparques.token.app.adapter.obituario.service.ObituarioService;
import com.nuestrosparques.token.app.adapter.qr.response.CrematorioScanResponse;
import com.nuestrosparques.token.app.request.CrematorioScanRequest;
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
public class ObituarioServiceImpl implements ObituarioService {

    @Value("${api.obituario.service}")
    private String obituarioApiUrl; // This would be your API endpoint

    private final RestTemplate restTemplate;
    private final ObituarioMapper obituarioMapper;

    private final ObituarioCrematorioMapper obituarioCrematorioMapper;

    public ObituarioServiceImpl(RestTemplate restTemplate, ObituarioMapper obituarioMapper, ObituarioCrematorioMapper obituarioCrematorioMapper) {
        this.restTemplate = restTemplate;
        this.obituarioMapper = obituarioMapper;
        this.obituarioCrematorioMapper = obituarioCrematorioMapper;
    }

    @Override
    public List<ObituarioDTO> obtenerTodosObituariosPorFechaYParque(String fechaInicio, String fechaFin, Integer parque) {
        List<ObituarioResponse> responses = new ArrayList<>();
        List<ObituarioDTO> fallecidosDTOS = new ArrayList<>();
        String apiUrl = obituarioApiUrl + "?fechaInicio="+ fechaInicio +
        "&fechaFin=" + fechaFin + "&parque=" + parque; // Modify this to match your API's endpoint structure
        ResponseEntity<List<ObituarioResponse>> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<ObituarioResponse>>() {});
        if (response.getStatusCode().is2xxSuccessful()) {
            responses = response.getBody();
            fallecidosDTOS = obituarioMapper.transformObituarioToDTO(responses);
        }else {
            // Handle failure here
            return Collections.emptyList(); // or throw an exception
        }
        return fallecidosDTOS;
    }

    @Override
    public List<ObituarioCrematorioDTO> encontrarTodosObiturariosCinerario(String fechaInicio, String fechaFin) {
        List<ObituarioCrematorioResponse> responses = new ArrayList<>();
        List<ObituarioCrematorioDTO> crematorioDTOS = new ArrayList<>();
        String apiUrl = obituarioApiUrl + "/crematorio?fechaInicio=" + fechaInicio + "&fechaFin=" + fechaFin;

        ResponseEntity<List<ObituarioCrematorioResponse>> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<ObituarioCrematorioResponse>>() {});
        if(response.getStatusCode().is2xxSuccessful()) {
            responses = response.getBody();
            crematorioDTOS = obituarioCrematorioMapper.transformObituarioCrematorioToDTO(responses);
        }else{
            return Collections.emptyList();
        }
        return crematorioDTOS;
    }
}
