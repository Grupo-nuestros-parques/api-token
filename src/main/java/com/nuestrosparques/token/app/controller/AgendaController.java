package com.nuestrosparques.token.app.controller;

import com.nuestrosparques.token.app.adapter.obituario.dto.ObituarioCrematorioDTO;
import com.nuestrosparques.token.app.adapter.obituario.dto.ObituarioDTO;
import com.nuestrosparques.token.app.adapter.obituario.service.ObituarioService;
import com.nuestrosparques.token.app.adapter.tracking.service.TrackingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obituario")
public class AgendaController {

    private final ObituarioService obituarioService;
    private TrackingService trackingService;

    public AgendaController(
            ObituarioService obituarioService,
            TrackingService trackingService
    ) {
        this.obituarioService = obituarioService;
        this.trackingService = trackingService;
    }

    @GetMapping
    @ResponseBody
    List<ObituarioDTO> findAll(
            @RequestParam("fechaInicio") String fechaInicio,
            @RequestParam("fechaFin") String fechaFin,
            @RequestParam("parque") Integer parque
    ){
        return obituarioService.obtenerTodosObituariosPorFechaYParque(fechaInicio, fechaFin, parque);
    }

    @GetMapping("/crematorio")
    @ResponseBody
    List<ObituarioCrematorioDTO> findAll(
            @RequestParam("fechaInicio") String fechaInicio,
            @RequestParam("fechaFin") String fechaFin

    ){
        return obituarioService.encontrarTodosObiturariosCinerario(fechaInicio, fechaFin);
    }
}
