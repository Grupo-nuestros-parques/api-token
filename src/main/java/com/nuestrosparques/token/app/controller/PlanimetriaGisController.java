package com.nuestrosparques.token.app.controller;

import com.nuestrosparques.token.app.adapter.portalplus.dto.BasePlaniDTO;
import com.nuestrosparques.token.app.adapter.portalplus.dto.GeolocationDTO;
import com.nuestrosparques.token.app.adapter.portalplus.service.PlanimetriaGisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/planimetria-gis")
public class PlanimetriaGisController {

    private final PlanimetriaGisService planimetriaGisService;

    public PlanimetriaGisController(PlanimetriaGisService planimetriaGisService) {
        this.planimetriaGisService = planimetriaGisService;
    }

    @GetMapping
    @ResponseBody
    List<GeolocationDTO> findSectorForGeolocation(
            @RequestParam(value = "parque") Integer parque,
            @RequestParam(value = "sector", required = false) String sector,
            @RequestParam(value = "estado", required = false) Integer estado
    ){
        return planimetriaGisService.findGeolocationForSector(parque, sector, estado);
    }

    @GetMapping("/baseplani/area/codParque/{codParque}")
    List<BasePlaniDTO> findAllByArea(@PathVariable("codParque") Integer codParque){
        return planimetriaGisService.findAllByArea(codParque);
    }

    @GetMapping("/baseplani/area/{area}")
    List<BasePlaniDTO> findAllSectorByArea(@PathVariable("area") String area){
        return planimetriaGisService.findAllSectorByArea(area);
    }

    @GetMapping("/baseplani/area/{area}/sector/{sector}")
    List<BasePlaniDTO> findAllByAreaAndSector(@PathVariable("area") String area, @PathVariable("sector") String sector){
        return planimetriaGisService.findAllByAreaAndSector(area, sector);
    }

    @GetMapping("/rut")
    @ResponseBody
    List<GeolocationDTO> getLocationsBySectorAndSepultura(
            @RequestParam(value = "sector", required = false) String sector,
            @RequestParam(value = "sepultura", required = false) String sepultura,
            @RequestParam(value = "coordenada", required = false) String coordenada
    ){
        return planimetriaGisService.findLocationsBySectorAndSepultura(sector, sepultura, coordenada);
    }

    @GetMapping("/proximidad")
    @ResponseBody
    List<GeolocationDTO> getLocationsByLatitudAndLongitud(
            @RequestParam(value = "latitud") String latitud,
            @RequestParam(value = "longitud", required = false) String longitud
    ){
        return planimetriaGisService.findLocationsByLatitudAndLongitud(latitud, longitud);
    }
}
