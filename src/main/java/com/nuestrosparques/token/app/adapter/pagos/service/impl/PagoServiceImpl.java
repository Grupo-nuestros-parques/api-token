package com.nuestrosparques.token.app.adapter.pagos.service.impl;

import com.nuestrosparques.token.app.adapter.pagos.dto.PagosDTO;
import com.nuestrosparques.token.app.adapter.pagos.service.PagoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class PagoServiceImpl implements PagoService {

    @Value("${api.pagos.service}")
    private String pagosApiUrl; // This would be your API endpoint

    private final RestTemplate restTemplate;

    public PagoServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<PagosDTO> getUltimosPagosPorContrato(String base, String serie, String numero) {
        List<PagosDTO> pagosDTO = new ArrayList<>();
        String apiUrl = pagosApiUrl + "?numero="+ numero + "&base=" + base + "&serie=" + serie; // Modify this to match your API's endpoint structure
        ResponseEntity<List<PagosDTO>> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<PagosDTO>>() {});
        if (response.getStatusCode().is2xxSuccessful()) {
            pagosDTO = response.getBody();
        }
        return pagosDTO;
    }
}
