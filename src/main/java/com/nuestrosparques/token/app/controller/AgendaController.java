package com.nuestrosparques.token.app.controller;

import com.nuestrosparques.token.app.adapter.agenda.dto.*;
import com.nuestrosparques.token.app.adapter.agenda.response.InformeAgenteResponse;
import com.nuestrosparques.token.app.adapter.agenda.service.AgendaService;
import com.nuestrosparques.token.app.adapter.tracking.response.TrackingResponse;
import com.nuestrosparques.token.app.adapter.tracking.service.TrackingService;
import com.nuestrosparques.token.app.request.RegistrarContactoRequest;
import com.nuestrosparques.token.app.request.RegistrarIntentoRequest;
import org.springframework.data.domain.Page;
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
    List<OrigenDTO> findAllOrigin(){
        return agendaService.getOriginList();
    }

    @GetMapping("/tipo")
    @ResponseBody
    List<TipoDTO> findAllTipos(
            @RequestParam("idSub") String idSub
    ){
        return agendaService.getTipoList(idSub);
    }

    @GetMapping("/ciudades")
    @ResponseBody
    List<CiudadDTO> findAllCiudades(){
        return agendaService.getCiudadesList();
    }

    @GetMapping("/comunas")
    @ResponseBody
    List<ComunaDTO> findAllComunas(
            @RequestParam("idCiudad") String idCiudad
    ){
        return agendaService.getComunasList(idCiudad);
    }

    @PostMapping ("/registrarContacto")
    public Integer registrarContacto(@RequestBody RegistrarContactoRequest request) {
        return agendaService.registrarContacto(
                request.getCodigoAgente(),
                request.getNombreContacto(),
                request.getApellidoPaternoContacto(),
                request.getApellidoMaternoContacto(),
                request.getRutContacto(),
                request.getDvContacto(),
                request.getDireccionContacto(),
                request.getTelefonoContacto(),
                request.getEmailContacto()
        );
    }

    @PostMapping ("/registrarIntento")
    public void registrarIntento(@RequestBody RegistrarIntentoRequest request) {
        agendaService.registrarIntento(
                request.getCodigoAgente(),
                request.getIdOrigin(),
                request.getIdTypeGrupoPp(),
                request.getIdTypeSubGrupoPp(),
                request.getIdCity(),
                request.getIdComuna(),
                request.getExitoso()
        );
    }

    @GetMapping("/obtener-lista-contactos")
    @ResponseBody
    public Page<InformeAgenteResponse> getInformes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) Long rut,
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String codigoAgente // Agregar el nuevo parámetro
    ) {
        return agendaService.getInformes(page, size, rut, nombre, codigoAgente); // Modificar el llamado al servicio
    }

    @GetMapping("/obtener-contacto")
    @ResponseBody
    public InformeAgenteResponse getContacto(
            @RequestParam(required = false) String correlativo,
            @RequestParam(required = false) String codigoAgente // Agregar el nuevo parámetro
    ) {
        return agendaService.getContacto(correlativo, codigoAgente); // Modificar el llamado al servicio
    }

    @PostMapping("/editar-contacto")
    public Integer editarContacto(@RequestBody ContactoDTO contactoDTO) {
        return agendaService.editarContacto(
                contactoDTO.getCorrelativo(),
                contactoDTO.getCodigoAgente(),
                contactoDTO.getRutContacto(),
                contactoDTO.getDvContacto(),
                contactoDTO.getNombreContacto(),
                contactoDTO.getApellidoPaternoContacto(),
                contactoDTO.getApellidoMaternoContacto(),
                contactoDTO.getDireccionContacto(),
                contactoDTO.getTelefonoContacto(),
                contactoDTO.getEmail()
        );
    }

}
