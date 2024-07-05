package com.nuestrosparques.token.app.adapter.portalplus.service.impl;

import com.nuestrosparques.token.app.adapter.portalplus.dto.BasePlaniDTO;
import com.nuestrosparques.token.app.adapter.portalplus.dto.GeolocationDTO;
import com.nuestrosparques.token.app.adapter.portalplus.service.PlanimetriaGisService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlanimetriaGisServiceImpl implements PlanimetriaGisService {

    @Value("${api.portalplus.service}")
    private String portalPlusApiUrl; // This would be your API endpoint

    private final RestTemplate restTemplate;

    public PlanimetriaGisServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<GeolocationDTO> findGeolocationForSector(Integer codParque, String sector, Integer estado) {
        String apiUrl = portalPlusApiUrl + "/planimetria-gis"+
                "?parque=" + codParque + "&sector=" + sector + "&estado=" + estado;
        ResponseEntity<List<GeolocationDTO>> response =
                restTemplate.exchange(apiUrl, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<GeolocationDTO> >(){});
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }else {
            return new ArrayList<>();
        }
    }

    @Override
    public List<BasePlaniDTO> findAllByArea() {
        String apiUrl = portalPlusApiUrl + "/baseplani/area";
        ResponseEntity<List<BasePlaniDTO>> response =
                restTemplate.exchange(apiUrl, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<BasePlaniDTO> >(){});
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }else {
            return new ArrayList<>();
        }
    }

    @Override
    public List<BasePlaniDTO> findAllSectorByArea(String area) {
        String apiUrl = portalPlusApiUrl + "/baseplani/area/" + area;
        ResponseEntity<List<BasePlaniDTO>> response =
                restTemplate.exchange(apiUrl, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<BasePlaniDTO> >(){});
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }else {
            return new ArrayList<>();
        }
    }

    @Override
    public List<BasePlaniDTO> findAllByAreaAndSector(String area, String sector) {
        String apiUrl = portalPlusApiUrl + "/baseplani/area/" + area + "/sector/" + sector;
        ResponseEntity<List<BasePlaniDTO>> response =
                restTemplate.exchange(apiUrl, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<BasePlaniDTO> >(){});
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }else {
            return new ArrayList<>();
        }
    }
}
