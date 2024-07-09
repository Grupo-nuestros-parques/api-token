package com.nuestrosparques.token.app.controller;

import com.nuestrosparques.token.app.adapter.mantenedor.response.UserRolesResponse;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import com.nuestrosparques.token.app.adapter.mantenedor.response.AsignacionRolesResponse;
import com.nuestrosparques.token.app.adapter.mantenedor.service.AsignacionRolesService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.util.*;

@RestController
@RequestMapping("/asignacion-roles")
public class AsignacionRolesController {

    private AsignacionRolesService asignacionRolesService;

    protected final Log logger = LogFactory.getLog(getClass());

    public AsignacionRolesController(AsignacionRolesService asignacionRolesService) {
        this.asignacionRolesService = asignacionRolesService;
    }

    @GetMapping("/getRolesAsignados")
    @ResponseBody
    public Page<AsignacionRolesResponse> getRolesAsignados(
            @RequestHeader("x-schema") String schema,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) Integer rutAsignador,
            @RequestParam(required = false) Integer rutAsignado,
            @RequestParam(required = false) Long idRol,
            @RequestParam(required = false) String fechaAsignacionDesde,
            @RequestParam(required = false) String fechaAsignacionHasta,
            @RequestParam(required = false) String fechaRevocacionDesde,
            @RequestParam(required = false) String fechaRevocacionHasta
    ) {
        return asignacionRolesService.getRolesAsignados(
                page, size, rutAsignador, rutAsignado, idRol, fechaAsignacionDesde,
                fechaAsignacionHasta, fechaRevocacionDesde, fechaRevocacionHasta
        );
    }

    @GetMapping("/getRolesAsignadosListado")
    @ResponseBody
    public List<AsignacionRolesResponse> getRolesAsignadosListado(
            @RequestHeader("x-schema") String schema,
            @RequestParam(required = false) Integer rutAsignador,
            @RequestParam(required = false) Integer rutAsignado,
            @RequestParam(required = false) Long idRol,
            @RequestParam(required = false) String fechaAsignacionDesde,
            @RequestParam(required = false) String fechaAsignacionHasta,
            @RequestParam(required = false) String fechaRevocacionDesde,
            @RequestParam(required = false) String fechaRevocacionHasta
    ) {
        return asignacionRolesService.getRolesAsignadosListado(
                rutAsignador, rutAsignado, idRol, fechaAsignacionDesde,
                fechaAsignacionHasta, fechaRevocacionDesde, fechaRevocacionHasta
        );
    }

    @GetMapping("/downloadRolesAsignadosCSV")
    public ResponseEntity<Resource> downloadRolesAsignadosCSV(
            @RequestHeader("x-schema") String schema,
            @RequestParam(required = false) Integer rutAsignador,
            @RequestParam(required = false) Integer rutAsignado,
            @RequestParam(required = false) Long idRol,
            @RequestParam(required = false) String fechaAsignacionDesde,
            @RequestParam(required = false) String fechaAsignacionHasta,
            @RequestParam(required = false) String fechaRevocacionDesde,
            @RequestParam(required = false) String fechaRevocacionHasta
    ) {
        List<AsignacionRolesResponse> listado = asignacionRolesService.getRolesAsignadosListado(
                rutAsignador, rutAsignado, idRol, fechaAsignacionDesde, fechaAsignacionHasta, fechaRevocacionDesde, fechaRevocacionHasta
        );

        // Obtener la ruta absoluta del proyecto
        String projectPath = System.getProperty("user.dir");
        // Ruta completa al directorio "files" dentro del proyecto
        String filesDirPath = projectPath + "/files";
        String csvFilePath = filesDirPath + "/archivo.csv";

        // Crear el directorio si no existe
        File filesDir = new File(filesDirPath);
        if (!filesDir.exists()) {
            filesDir.mkdirs(); // Crea el directorio y los directorios padres si no existen
        }

        // Generar el archivo CSV
        asignacionRolesService.exportToCSV(listado, csvFilePath);

        // Preparar la respuesta para descargar el archivo CSV
        File file = new File(csvFilePath);
        Resource resource = new FileSystemResource(file);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                .contentType(MediaType.parseMediaType("application/csv"))
                .body(resource);
    }


    @GetMapping("/consultar-rol-por-rut")
    @ResponseBody
    public UserRolesResponse getRolesByRut(
            @RequestHeader("x-schema") String schema,
            @RequestParam(required = false) Integer rut
    ) {
        return asignacionRolesService.getRolesByRut(
                schema,
                rut
        );
    }

    @GetMapping("/consultar-roles-sistema")
    @ResponseBody
    public List<String> getRolesExistentes() {
        return Arrays.asList("Administrador", "Gestor", "Normal");
    }

    @PostMapping("/salvar-rol-por-rut")
    public Boolean saveRole(
            @RequestHeader("x-schema") String schema,
            @RequestParam("rut") String rut,
            @RequestParam("nombre") String nombre,
            @RequestParam("Administrador") String Administrador,
            @RequestParam("Gestor") String Gestor,
            @RequestParam("Normal") String Normal
    ) {
        logger.info("Save Role for rut " + rut);

        Map<String, Object> datosUsuario = new HashMap<>();
        datosUsuario.put("rut", rut);
        datosUsuario.put("nombre", nombre);
        datosUsuario.put("Administrador", Administrador);
        datosUsuario.put("Gestor", Gestor);
        datosUsuario.put("Normal", Normal);

        return asignacionRolesService.setRolesByRut(
                datosUsuario
        );
    }

    private static Boolean castStringToBoolean(String Rol) {
        if(Rol.equals("true")){
            return true;
        }else{
            return false;
        }
    }
}
