package com.nuestrosparques.token.app.adapter.portalplus.service;

import com.nuestrosparques.token.app.adapter.portalplus.dto.BasePlaniDTO;
import com.nuestrosparques.token.app.adapter.portalplus.dto.GeolocationDTO;

import java.util.List;

public interface PlanimetriaGisService {

    List<GeolocationDTO> findGeolocationForSector(Integer codParque, String sector, Integer estado);

    List<BasePlaniDTO> findAllByArea();

    List<BasePlaniDTO> findAllSectorByArea(String area);

    List<BasePlaniDTO> findAllByAreaAndSector(String area, String sector);
}
