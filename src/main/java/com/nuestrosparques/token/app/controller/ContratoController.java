package com.nuestrosparques.token.app.controller;

import com.nuestrosparques.token.app.adapter.contrato.dto.ContratoDTO;
import com.nuestrosparques.token.app.adapter.contrato.service.ContratoService;
import com.nuestrosparques.token.app.adapter.tracking.service.TrackingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contrato")
public class ContratoController {

    private ContratoService contratoService;

    private TrackingService trackingService;

    public ContratoController(ContratoService contratoService, TrackingService trackingService) {
        this.contratoService = contratoService;
        this.trackingService = trackingService;
    }

    @GetMapping("/contractPage")
    @ResponseBody
    public List<ContratoDTO> getContratosPorRutContratoPage(
            @RequestParam("rut" )Integer rut,
            @RequestHeader("x-schema") String schema,
            @RequestParam("rutAgente") String rutAgente,
            @RequestParam("tokenSession") String tokenSession,
            @RequestParam("nombreCompletoAgente") String nombreCompletoAgente
    ){
        System.out.println("rut = " + rut + "schema = " + schema);
        trackingService.registerTracking(
                "Buscar contrato en Pagina Contratos",
                Integer.valueOf(rutAgente),
                tokenSession,
                nombreCompletoAgente
        );
        return contratoService.getContratosPorRutForContract(rut,schema.replaceAll("\"", ""));
    }

    @GetMapping("/payPage")
    @ResponseBody
    public List<ContratoDTO> getContratosPorRutPagoPage(
            @RequestParam("rut" )Integer rut,
            @RequestHeader("x-schema") String schema,
            @RequestParam("rutAgente") String rutAgente,
            @RequestParam("tokenSession") String tokenSession,
            @RequestParam("nombreCompletoAgente") String nombreCompletoAgente
    ){
        System.out.println("rut = " + rut + "schema = " + schema);
        trackingService.registerTracking(
                "Buscar contrato en Pagina de buscar Pagos",
                Integer.valueOf(rutAgente),
                tokenSession,
                nombreCompletoAgente
        );
        return contratoService.getContratosPorRutForPay(rut,schema.replaceAll("\"", ""));
    }
}
