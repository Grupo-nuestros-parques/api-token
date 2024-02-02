package com.nuestrosparques.token.app.controller;

import com.nuestrosparques.token.app.adapter.fallecidos.dto.FallecidosDTO;
import com.nuestrosparques.token.app.adapter.fallecidos.response.FallecidosResponse;
import com.nuestrosparques.token.app.adapter.fallecidos.service.FallecidosService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fallecidos")
public class FallecidosController {

    private final FallecidosService pradoService;

    public FallecidosController(FallecidosService pradoService) {
        this.pradoService = pradoService;
    }

    @GetMapping
    @ResponseBody
    List<FallecidosDTO> findAll(
            @RequestParam(value = "parque") Integer parque,
            @RequestParam(value = "nombres", required = false) String nombres,
            @RequestParam(value = "apellidoPaterno", required = false) String apellidoPaterno,
            @RequestParam(value = "apellidoMaterno", required = false) String apellidoMaterno,
            @RequestParam(value = "rut", required = false) String rut
    ){
        return pradoService.encontrarTodosFallecidos(parque, nombres, apellidoPaterno, apellidoMaterno, rut);
    }
}
