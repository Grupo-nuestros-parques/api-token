package com.nuestrosparques.token.app.adapter.uf.service.impl;

import com.nuestrosparques.token.app.adapter.uf.dto.UfDTO;
import com.nuestrosparques.token.app.adapter.uf.mapper.UfMapper;
import com.nuestrosparques.token.app.adapter.uf.response.UfResponse;
import com.nuestrosparques.token.app.adapter.uf.service.UfService;
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
public class UfServiceImpl implements UfService {

    @Value("${api.uf.service}")
    private String ufApiUrl; // This would be your API endpoint

    private final RestTemplate restTemplate;
    private final UfMapper ufMapper;

    public UfServiceImpl(RestTemplate restTemplate, UfMapper ufMapper) {
        this.restTemplate = restTemplate;
        this.ufMapper = ufMapper;
    }

    @Override
    public UfDTO getUfValue() {
        ResponseEntity<UfResponse> response = restTemplate.exchange(ufApiUrl, HttpMethod.GET, null, new ParameterizedTypeReference<UfResponse>() {});
        if (response.getStatusCode().is2xxSuccessful()) {
            return ufMapper.transformUfResponseToUfDTO(response.getBody());
        }else {
            // Handle failure here
            return ufMapper.transformUfResponseToErrorUf(); // or throw an exception
        }
    }
}
