package com.nuestrosparques.token.app.adapter.portalplus.service;

import com.nuestrosparques.token.app.adapter.portalplus.dto.BasePlaniDTO;
import com.nuestrosparques.token.app.adapter.portalplus.dto.GeolocationDTO;

import java.util.List;

public interface PlanimetriaGisService {

    List<GeolocationDTO> findGeolocationForSector(Integer codParque, String sector, Integer estado);

    List<BasePlaniDTO> findAllByArea(Integer codParque);

    List<BasePlaniDTO> findAllSectorByArea(String area, String codigoProducto);

    List<BasePlaniDTO> findAllByAreaAndSector(String area, String sector);

    List<GeolocationDTO> findLocationsBySectorAndSepultura(String sector, String sepultura, String coordenada);

    List<GeolocationDTO> findLocationsByLatitudAndLongitud(String latitud, String longitud);

    List<String> getSepulturaContratosPorRut(Integer rut, String schema);
}
