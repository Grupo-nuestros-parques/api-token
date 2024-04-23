package com.nuestrosparques.token.app.adapter.pagos.service.impl;

import com.nuestrosparques.token.app.adapter.pagos.dto.PagosDTO;
import com.nuestrosparques.token.app.adapter.pagos.mapper.PagosMapper;
import com.nuestrosparques.token.app.adapter.pagos.response.PagosResponse;
import com.nuestrosparques.token.app.adapter.pagos.service.PagoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class PagoServiceImpl implements PagoService {

    @Value("${api.pagos.service}")
    private String pagosApiUrl; // This would be your API endpoint

    private final RestTemplate restTemplate;

    private final PagosMapper pagosMapper;

    public PagoServiceImpl(RestTemplate restTemplate, PagosMapper pagosMapper) {
        this.restTemplate = restTemplate;
        this.pagosMapper = pagosMapper;
    }

    @Override
    public List<PagosDTO> getUltimosPagosPorContrato(String base, String serie, String numero, String schema) {
        List<PagosResponse> pagosResponses = new ArrayList<>();
        List<PagosDTO> pagosDTO = new ArrayList<>();
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-schema", schema);
        HttpEntity<?> httpEntity = new HttpEntity<>(headers);
        String apiUrl = pagosApiUrl + "?numero="+ numero + "&base=" + base + "&serie=" + serie; // Modify this to match your API's endpoint structure
        ResponseEntity<List<PagosResponse>> response = restTemplate.exchange(apiUrl, HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<PagosResponse>>() {});
        if (response.getStatusCode().is2xxSuccessful()) {
            pagosResponses = response.getBody();
            pagosDTO = pagosMapper.transformPagosToDTO(pagosResponses);
        } else {
            return Collections.emptyList();
        }
        return pagosDTO;
    }
}
