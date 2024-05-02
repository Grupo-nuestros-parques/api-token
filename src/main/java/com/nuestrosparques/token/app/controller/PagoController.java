package com.nuestrosparques.token.app.controller;

import com.nuestrosparques.token.app.adapter.pagos.dto.CuponesDTO;
import com.nuestrosparques.token.app.adapter.pagos.dto.PagosDTO;
import com.nuestrosparques.token.app.adapter.pagos.service.PagoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @GetMapping
    @ResponseBody
    public List<PagosDTO> getUltimosPagosPorContrato(
            @RequestParam(value="numero") String numero,
            @RequestParam(value="base") String base,
            @RequestParam(value="serie") String serie,
            @RequestHeader("x-schema") String schema) {
        System.out.println("schema = " + schema.replaceAll("\"", ""));
        return pagoService.getUltimosPagosPorContrato(base,serie,numero,schema.replaceAll("\"", ""));
    }

    @GetMapping("/cupones")
    @ResponseBody
    public List<CuponesDTO> getCuponesPorRut(@RequestParam("rut") String rut, @RequestParam(defaultValue = "5") Integer limitE, @RequestParam(defaultValue = "2") Integer limitF, @RequestHeader("x-schema") String schema){
        return pagoService.getCuponesPorRut(rut, limitE, limitF, schema.replaceAll("\"", ""));
    }
}
