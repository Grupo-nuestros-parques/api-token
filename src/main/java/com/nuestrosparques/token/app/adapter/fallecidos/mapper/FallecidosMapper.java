package com.nuestrosparques.token.app.adapter.fallecidos.mapper;

import com.nuestrosparques.token.app.adapter.fallecidos.dto.FallecidosDTO;
import com.nuestrosparques.token.app.adapter.fallecidos.dto.WebGeolocationDTO;
import com.nuestrosparques.token.app.adapter.fallecidos.response.FallecidosResponse;
import com.nuestrosparques.token.app.util.Fechas;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FallecidosMapper {

    public FallecidosDTO transformObjectToFallecidosDTO(FallecidosResponse data){
        FallecidosDTO fallecidosDTO = new FallecidosDTO();
        WebGeolocationDTO webGeolocation = new WebGeolocationDTO();
        fallecidosDTO.setA2(data.getFolio());
        fallecidosDTO.setA16(data.getNl());
        fallecidosDTO.setA17(data.getNm());
        fallecidosDTO.setA18(data.getBase());
        fallecidosDTO.setA19(data.getSs());
        fallecidosDTO.setA3(data.getContrato());
        fallecidosDTO.setA4(data.getSector());
        fallecidosDTO.setA20(data.getnSep());
        fallecidosDTO.setA5(data.getNombres());
        fallecidosDTO.setA6(data.getApaterno());
        fallecidosDTO.setA7(data.getAmaterno());
        if(data.getFechaSepultura() != null && !"".equalsIgnoreCase(data.getFechaSepultura())
                && !"null".equalsIgnoreCase(String.valueOf(data.getFechaSepultura()))){
            fallecidosDTO.setA21(Fechas.transformStringDateToDate(data.getFechaSepultura(), "yyyy-MM-dd"));
        }
        fallecidosDTO.setA22(data.getEst());
        fallecidosDTO.setA23(data.getOp());
        fallecidosDTO.setA24(data.getRut());
        fallecidosDTO.setA25(data.getDv());
        fallecidosDTO.setA26(data.getSexo());
        fallecidosDTO.setA27(data.getEdad());
        fallecidosDTO.setA28(data.getPeriodo());
        if(data.getFechaNacimiento() != null && !"".equalsIgnoreCase(data.getFechaNacimiento())
                && !"null".equalsIgnoreCase(String.valueOf(data.getFechaNacimiento()))){
            fallecidosDTO.setA29(Fechas.transformStringDateToDate(data.getFechaNacimiento(), "yyyy-MM-dd"));
        }
        if(data.getFechaFallecido() != null && !"".equalsIgnoreCase(data.getFechaFallecido())
                && !"null".equalsIgnoreCase(String.valueOf(data.getFechaFallecido()))){
            fallecidosDTO.setA8(Fechas.transformStringDateToDate(data.getFechaFallecido(), "yyyy-MM-dd"));
        }
        fallecidosDTO.setA30(data.getPase());
        fallecidosDTO.setA11(data.getRegistroCivil());
        fallecidosDTO.setA12(data.getCausaFallecimiento());
        fallecidosDTO.setA31(data.getEnfObl());
        fallecidosDTO.setA13(data.getFuneraria());
        fallecidosDTO.setA32(data.getBoleta());
        fallecidosDTO.setA33(data.getCartaAut());
        fallecidosDTO.setA34(data.getRgEst());
        fallecidosDTO.setA35(data.getnTec());
        fallecidosDTO.setA36(data.getNivel());
        fallecidosDTO.setA37(data.getVta());
        fallecidosDTO.setA38(data.getObservaciones());
        fallecidosDTO.setA14(data.getEstadoContrato());
        fallecidosDTO.setA39(data.getNroResolucionTraslado());
        fallecidosDTO.setA40(data.getOtorgadoPor());
        fallecidosDTO.setA41(data.getCementerioOrigen());
        fallecidosDTO.setA15(data.getCodigoParque());
        if(data.getFechaSistema() != null && !"".equalsIgnoreCase(data.getFechaSistema())
                && !"null".equalsIgnoreCase(String.valueOf(data.getFechaSistema()))){
            fallecidosDTO.setA42(Fechas.transformStringDateToDate(data.getFechaSistema(), "yyyy-MM-dd"));
        }
        fallecidosDTO.setA43(data.getLlaveAnterior());
        fallecidosDTO.setA44(data.getNroSarcofago());
        fallecidosDTO.setA45(data.getCodUsuario());
        fallecidosDTO.setA46(data.getUsuarioUltimaModificacion());
        if(data.getFechaUltimaModificacion() != null && !"".equalsIgnoreCase(data.getFechaUltimaModificacion())
                && !"null".equalsIgnoreCase(String.valueOf(data.getFechaUltimaModificacion()))){
            fallecidosDTO.setA47(Fechas.transformStringDateToDate(data.getFechaUltimaModificacion(), "yyyy-MM-dd"));
        }
        fallecidosDTO.setA48(data.getFolioEncuesta());
        webGeolocation.setA1(data.getAreaWebLocation());
        webGeolocation.setA2(data.getSectorWebLocation());
        webGeolocation.setA3(data.getSepulturaWebLocation());
        webGeolocation.setA4(data.getNroTecnicoWebLocation());
        webGeolocation.setA5(data.getLatitudWebLocation());
        webGeolocation.setA6(data.getLongitudWebLocation());
        webGeolocation.setA7(data.getCodigoParqueWeblocation());
        fallecidosDTO.setA49(webGeolocation);
        return fallecidosDTO;
    }

    public List<FallecidosDTO> transformToFallecidosList(List<FallecidosResponse> data){
        List<FallecidosDTO> response = new ArrayList<>();
        data.forEach(objects -> {
            response.add(transformObjectToFallecidosDTO(objects));
        });
        return response;
    }
}
