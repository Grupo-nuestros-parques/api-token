package com.nuestrosparques.token.app.controller;

import com.nuestrosparques.token.app.adapter.mantenedor.response.AsignacionRolesResponse;
import com.nuestrosparques.token.app.adapter.tracking.response.TrackingResponse;
import com.nuestrosparques.token.app.adapter.tracking.service.TrackingService;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.Date;
import java.util.List;

import static java.lang.Boolean.TRUE;

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
            @RequestParam(required = false) String fechaFin
    ) {
        return trackingService.getTrackings(schema.replaceAll("\"", ""), page, size, rut, fechaInicio, fechaFin);
    }

    @PostMapping(value = "/setTracking")
    @ResponseBody
    public Boolean setTrackingRegister(
            @RequestParam("pageBreadCrumbs") String pageBreadCrumbs,
            @RequestParam("rutAgente") String rutAgente,
            @RequestParam("tokenSession") String tokenSession,
            @RequestParam("nombreCompletoAgente") String nombreCompletoAgente
    ) {
        return trackingService.registerTracking(
                pageBreadCrumbs,
                Integer.valueOf(rutAgente),
                tokenSession,
                nombreCompletoAgente
        );
    }

    @GetMapping("/downloadTrackingsCSV")
    public ResponseEntity<Resource> downloadTrackingsCSV(
            @RequestHeader("x-schema") String schema,
            @RequestParam(required = false) Integer rut,
            @RequestParam(required = false) String fechaInicio,
            @RequestParam(required = false) String fechaFin
    ) {
        List<TrackingResponse> listado = trackingService.getListTrackings(schema.replaceAll("\"", ""), rut, fechaInicio, fechaFin);

        // Obtener la ruta absoluta del proyecto
        String projectPath = System.getProperty("user.dir");
        // Ruta completa al directorio "files" dentro del proyecto
        String filesDirPath = projectPath + "/files";
        String csvFilePath = filesDirPath + "/listaTrackings.csv";

        // Crear el directorio si no existe
        File filesDir = new File(filesDirPath);
        if (!filesDir.exists()) {
            filesDir.mkdirs(); // Crea el directorio y los directorios padres si no existen
        }

        // Generar el archivo CSV
        trackingService.exportToCSV(listado, csvFilePath);

        // Preparar la respuesta para descargar el archivo CSV
        File file = new File(csvFilePath);
        Resource resource = new FileSystemResource(file);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                .contentType(MediaType.parseMediaType("application/csv"))
                .body(resource);
    }

}
