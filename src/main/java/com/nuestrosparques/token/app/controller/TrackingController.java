package com.nuestrosparques.token.app.controller;

import com.nuestrosparques.token.app.adapter.tracking.response.TrackingResponse;
import com.nuestrosparques.token.app.adapter.tracking.service.TrackingService;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/tracking")
public class TrackingController {

    private TrackingService trackingService;

    public TrackingController(TrackingService trackingService) {
        this.trackingService = trackingService;
    }

    @GetMapping("/getTrackings")
    @ResponseBody
    public Page<TrackingResponse> getTrackings(
            @RequestHeader("x-schema") String schema,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) Integer rut,
            @RequestParam(required = false) String fechaInicio,
            @RequestParam(required = false) String fechaFin,
            @RequestParam("rutAgente") String rutAgente,
            @RequestParam("tokenSession") String tokenSession,
            @RequestParam("nombreCompletoAgente") String nombreCompletoAgente
    ){
        trackingService.registerTracking(
                "Buscar tracking en Página Trackings",
                Integer.valueOf(rutAgente),
                tokenSession,
                nombreCompletoAgente
        );
        return trackingService.getTrackings(schema.replaceAll("\"", ""), page, size, rut, fechaInicio, fechaFin);
    }

}
