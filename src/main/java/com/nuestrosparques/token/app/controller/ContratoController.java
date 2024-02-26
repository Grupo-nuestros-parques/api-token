package com.nuestrosparques.token.app.controller;

import com.nuestrosparques.token.app.adapter.contrato.dto.ContratoDTO;
import com.nuestrosparques.token.app.adapter.contrato.service.ContratoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contrato")
public class ContratoController {

    private ContratoService contratoService;

    public ContratoController(ContratoService contratoService) {
        this.contratoService = contratoService;
    }

    @GetMapping
    @ResponseBody
    public List<ContratoDTO> getContratosPorRut(@RequestParam("rut" )Integer rut){
        System.out.println("rut = " + rut);
        return contratoService.getContratosPorRut(rut);
    }
}
