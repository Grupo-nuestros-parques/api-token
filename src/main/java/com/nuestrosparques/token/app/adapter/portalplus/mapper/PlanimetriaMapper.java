package com.nuestrosparques.token.app.adapter.portalplus.mapper;

import com.nuestrosparques.token.app.adapter.portalplus.dto.GeolocationDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlanimetriaMapper {

    public List<GeolocationDTO> transformPlanimetriaDTO(List<GeolocationDTO> geoLocations){
        List<GeolocationDTO> locations = new ArrayList<>();
        geoLocations.forEach(geo -> {
            GeolocationDTO geolocationDTO = new GeolocationDTO();
            geolocationDTO.setFirstLocation(geo.isFirstLocation());
            if(geo.getCodParque() == 1){
                geolocationDTO.setNombreParque("Cementerio Parque Puente Alto");
            }else if(geo.getCodParque() == 101){
                geolocationDTO.setNombreParque("Cementerio Parque Pudahuel");
            }else if(geo.getCodParque() == 102){
                geolocationDTO.setNombreParque("Cementerio Parque Maipú");
            }else if(geo.getCodParque() == 103){
                geolocationDTO.setNombreParque("Cementerio Parque Huechuraba");
            }else if(geo.getCodParque() == 11){
                geolocationDTO.setNombreParque("Cementerio Parque La Serena");
            }
            geolocationDTO.setArea(geo.getArea());
            geolocationDTO.setBase(geo.getBase());
            geolocationDTO.setEstado(geo.getEstado());
            geolocationDTO.setLatitud(geo.getLatitud());
            geolocationDTO.setCodParque(geo.getCodParque());
            geolocationDTO.setLongitud(geo.getLongitud());
            geolocationDTO.setNombreFallecido(geo.getNombreFallecido());
            geolocationDTO.setNumero(geo.getNumero());
            geolocationDTO.setNroTecnico(geo.getNroTecnico());
            geolocationDTO.setSector(geo.getSector());
            geolocationDTO.setSerie(geo.getSerie());
            geolocationDTO.setTipoConst(geo.getTipoConst());
            locations.add(geolocationDTO);
        });
        return locations;
    }
}
