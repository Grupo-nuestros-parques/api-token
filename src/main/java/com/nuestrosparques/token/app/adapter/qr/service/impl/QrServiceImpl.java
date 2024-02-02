package com.nuestrosparques.token.app.adapter.qr.service.impl;

import com.nuestrosparques.token.app.adapter.qr.dto.CrematorioFcDTO;
import com.nuestrosparques.token.app.adapter.qr.dto.CrematorioScanDto;
import com.nuestrosparques.token.app.adapter.qr.mapper.QrMapper;
import com.nuestrosparques.token.app.adapter.qr.response.CrematorioResponse;
import com.nuestrosparques.token.app.adapter.qr.service.QrService;
import com.nuestrosparques.token.app.adapter.qr.response.CrematorioScanResponse;
import com.nuestrosparques.token.app.request.CrematorioScanRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class QrServiceImpl implements QrService {

    @Value("${api.qr.service}")
    private String qrApiUrl; // This would be your API endpoint

    private final RestTemplate restTemplate;
    private final QrMapper qrMapper;

    public QrServiceImpl(RestTemplate restTemplate, QrMapper qrMapper) {
        this.restTemplate = restTemplate;
        this.qrMapper = qrMapper;
    }

    @Override
    public CrematorioFcDTO getDataFolioCrematorio(Integer nroFolio) {
        String apiUrl = qrApiUrl + "/fc/" + nroFolio; // Modify this to match your API's endpoint structure
        ResponseEntity<CrematorioResponse> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, new ParameterizedTypeReference<CrematorioResponse>() {});
        if (response.getStatusCode().is2xxSuccessful()) {
            return qrMapper.transformResponseToCrematorioFcDTO(response.getBody());
        }else {
            // Handle failure here
            return new CrematorioFcDTO(); // or throw an exception
        }
    }

    @Override
    public String getDataFolioCrematorioScan(CrematorioScanRequest crematorioScanRequest) {
        String apiUrl = qrApiUrl + "/scan";
        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, setHeaderScan(crematorioScanRequest), new ParameterizedTypeReference<String>() {});
        if (response.getStatusCode().is2xxSuccessful()) {
            return String.valueOf(response.getBody());
        }else {
            // Handle failure here
            return ""; // or throw an exception
        }
    }

    private HttpEntity<CrematorioScanRequest> setHeaderScan(CrematorioScanRequest resquest){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<CrematorioScanRequest> entity = new HttpEntity<>(resquest, headers);
        return entity;
    }
}
