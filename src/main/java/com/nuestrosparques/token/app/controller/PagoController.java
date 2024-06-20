package com.nuestrosparques.token.app.controller;

import com.nuestrosparques.token.app.adapter.pagos.dto.CuponesDTO;
import com.nuestrosparques.token.app.adapter.pagos.dto.PagosDTO;
import com.nuestrosparques.token.app.adapter.pagos.dto.RezagosDTO;
import com.nuestrosparques.token.app.adapter.pagos.service.PagoService;
import com.nuestrosparques.token.app.adapter.tracking.service.TrackingService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    private final PagoService pagoService;
    private TrackingService trackingService;

    public PagoController(
            PagoService pagoService, TrackingService trackingService
    ) {
        this.pagoService = pagoService;
        this.trackingService = trackingService;
    }

    @GetMapping
    @ResponseBody
    public List<PagosDTO> getUltimosPagosPorContrato(
            @RequestParam(value="numero") String numero,
            @RequestParam(value="base") String base,
            @RequestParam(value="serie") String serie,
            @RequestHeader("x-schema") String schema,
            @RequestParam("rutAgente" )Integer rutAgente,
            @RequestParam("tokenSession") String tokenSession,
            @RequestParam("nombreCompletoAgente") String nombreCompletoAgente
    ) {
        System.out.println("schema = " + schema.replaceAll("\"", ""));
        /*trackingService.registerTracking(
                "Buscar pagos en Página Contratos",
                rutAgente,
                tokenSession,
                nombreCompletoAgente
        );*/
        return pagoService.getUltimosPagosPorContrato(base,serie,numero,schema.replaceAll("\"", ""));
    }

    @GetMapping("/cupones-pendientes")
    @ResponseBody
    public List<CuponesDTO> getCuponesPendientesPorRut(
            @RequestParam("rut") String rut,
            @RequestParam(defaultValue = "5") Integer limitE,
            @RequestParam(defaultValue = "2") Integer limitF,
            @RequestHeader("x-schema") String schema,
            @RequestParam("rutAgente" )Integer rutAgente,
            @RequestParam("tokenSession") String tokenSession,
            @RequestParam("nombreCompletoAgente") String nombreCompletoAgente
    ){
        /*trackingService.registerTracking(
                "Consultando Cupones Pendientes en pagina Pagos",
                rutAgente,
                tokenSession,
                nombreCompletoAgente
        );*/
        return pagoService.getCuponesPendientesPorRut(rut, limitE, limitF, schema.replaceAll("\"", ""));
    }

    @GetMapping("/cupones-futuros")
    @ResponseBody
    public List<CuponesDTO> getCuponesFuturosPorRut(
            @RequestParam("rut") String rut,
            @RequestParam(defaultValue = "5") Integer limitE,
            @RequestParam(defaultValue = "2") Integer limitF,
            @RequestHeader("x-schema") String schema,
            @RequestParam("rutAgente" )Integer rutAgente,
            @RequestParam("tokenSession") String tokenSession,
            @RequestParam("nombreCompletoAgente") String nombreCompletoAgente
    ){
        /*trackingService.registerTracking(
                "Consultando Cupones Futuros en pagina Pagos",
                rutAgente,
                tokenSession,
                nombreCompletoAgente
        );*/
        return pagoService.getCuponesFuturosPorRut(rut, limitE, limitF, schema.replaceAll("\"", ""));
    }

    @GetMapping("/rezagos")
    @ResponseBody
    public List<RezagosDTO> getRezagosPorRut(
            @RequestParam("rut") String rut,
            @RequestHeader("x-schema") String schema,
            @RequestParam("rutAgente" )Integer rutAgente,
            @RequestParam("tokenSession") String tokenSession,
            @RequestParam("nombreCompletoAgente") String nombreCompletoAgente
    ){
        /*trackingService.registerTracking(
                "Buscar pagos Rezagos",
                rutAgente,
                tokenSession,
                nombreCompletoAgente
        );*/
        return pagoService.getRezagosPorRut(rut, schema.replaceAll("\"", ""));
    }
}
