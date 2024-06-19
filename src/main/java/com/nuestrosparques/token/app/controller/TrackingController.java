package com.nuestrosparques.token.app.controller;

//import com.nuestrosparques.token.app.adapter.tracking.dto.TrackingDTO;
import com.nuestrosparques.token.app.adapter.tracking.request.TrackingRequest;
import com.nuestrosparques.token.app.adapter.tracking.response.TrackingResponse;
import com.nuestrosparques.token.app.adapter.tracking.service.TrackingService;
import org.springframework.web.bind.annotation.*;

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
    public List<TrackingResponse> getTrackings(
            @RequestHeader("x-schema") String schema,
            @RequestParam("rutAgente") String rutAgente,
            @RequestParam("tokenSession") String tokenSession,
            @RequestParam("") String nombreCompletoAgente
    ){
        trackingService.registerTracking(
                "Buscar tracking en Pagina Trackings",
                Integer.valueOf(rutAgente),
                tokenSession,
                nombreCompletoAgente
        );
        return trackingService.getTrackings(schema.replaceAll("\"", ""));
    }

}
