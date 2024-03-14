package com.nuestrosparques.token.app.controller;

import com.nuestrosparques.token.app.adapter.pagos.dto.PagosDTO;
import com.nuestrosparques.token.app.adapter.pagos.service.PagoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @GetMapping()
    @ResponseBody
    public List<PagosDTO> getUltimosPagosPorContrato(@RequestParam(value="numero") String numero, @RequestParam(value="base") String base, @RequestParam(value="serie") String serie) {
        return pagoService.getUltimosPagosPorContrato(base,serie,numero);
    }
}
