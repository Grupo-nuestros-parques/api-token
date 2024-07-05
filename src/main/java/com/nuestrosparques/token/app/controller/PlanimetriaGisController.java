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

    @GetMapping("/baseplani/area")
    List<BasePlaniDTO> findAllByArea(){
        return planimetriaGisService.findAllByArea();
    }

    @GetMapping("/baseplani/area/{area}")
    List<BasePlaniDTO> findAllSectorByArea(@PathVariable("area") String area){
        return planimetriaGisService.findAllSectorByArea(area);
    }

    @GetMapping("/baseplani/area/{area}/sector/{sector}")
    List<BasePlaniDTO> findAllByAreaAndSector(@PathVariable("area") String area, @PathVariable("sector") String sector){
        return planimetriaGisService.findAllByAreaAndSector(area, sector);
    }
}
