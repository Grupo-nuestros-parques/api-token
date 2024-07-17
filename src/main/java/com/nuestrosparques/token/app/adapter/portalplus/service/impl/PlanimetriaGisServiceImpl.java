package com.nuestrosparques.token.app.adapter.portalplus.service.impl;

import com.nuestrosparques.token.app.adapter.portalplus.dto.BasePlaniDTO;
import com.nuestrosparques.token.app.adapter.portalplus.dto.GeolocationDTO;
import com.nuestrosparques.token.app.adapter.portalplus.mapper.PlanimetriaMapper;
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
    private final PlanimetriaMapper planimetriaMapper;

    public PlanimetriaGisServiceImpl(RestTemplate restTemplate, PlanimetriaMapper planimetriaMapper) {
        this.restTemplate = restTemplate;
        this.planimetriaMapper = planimetriaMapper;
    }

    @Override
    public List<GeolocationDTO> findGeolocationForSector(Integer codParque, String sector, Integer estado) {
        String apiUrl = portalPlusApiUrl + "/planimetria-gis"+
                "?parque=" + codParque + "&sector=" + sector + "&estado=" + estado;
        ResponseEntity<List<GeolocationDTO>> response =
                restTemplate.exchange(apiUrl, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<GeolocationDTO> >(){});
        if (response.getStatusCode().is2xxSuccessful()) {
            return planimetriaMapper.transformPlanimetriaDTO(response.getBody());
        }else {
            return new ArrayList<>();
        }
    }

    @Override
    public List<BasePlaniDTO> findAllByArea(Integer codParque) {
        String apiUrl = portalPlusApiUrl + "/baseplani/area/codParque/" + codParque;
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

    @Override
    public List<GeolocationDTO> findLocationsBySectorAndSepultura(String sector, String sepultura, String coordenada) {
        String apiUrl = portalPlusApiUrl + "/planimetria-gis/rut"+
                "?sector=" + sector + "&sepultura=" + sepultura + "&coordenada=" + coordenada;
        ResponseEntity<List<GeolocationDTO>> response =
                restTemplate.exchange(apiUrl, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<GeolocationDTO> >(){});
        if (response.getStatusCode().is2xxSuccessful()) {
            return planimetriaMapper.transformPlanimetriaDTO(response.getBody());
        }else {
            return new ArrayList<>();
        }
    }

    @Override
    public List<GeolocationDTO> findLocationsByLatitudAndLongitud(String latitud, String longitud) {
        String apiUrl = portalPlusApiUrl + "/planimetria-gis/proximidad"+
                "?latitud=" + latitud + "&longitud=" + longitud;
        ResponseEntity<List<GeolocationDTO>> response =
                restTemplate.exchange(apiUrl, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<GeolocationDTO> >(){});
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }else {
            return new ArrayList<>();
        }
    }
}
