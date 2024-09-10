package com.nuestrosparques.token.app.controller;

import com.nuestrosparques.token.app.adapter.agenda.dto.OrigenDTO;
import com.nuestrosparques.token.app.adapter.agenda.service.AgendaService;
import com.nuestrosparques.token.app.adapter.tracking.service.TrackingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agenda")
public class AgendaController {

    private final AgendaService agendaService;
    private TrackingService trackingService;

    public AgendaController(
            AgendaService agendaService,
            TrackingService trackingService
    ) {
        this.agendaService = agendaService;
        this.trackingService = trackingService;
    }

    @GetMapping("/origen")
    @ResponseBody
    List<OrigenDTO> findAll(){
        return agendaService.getOriginList();
    }

}
