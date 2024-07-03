package com.nuestrosparques.token.app.adapter.mantenedor.service;

import com.nuestrosparques.token.app.adapter.mantenedor.response.AsignacionRolesResponse;
import com.nuestrosparques.token.app.adapter.mantenedor.response.UserRolesResponse;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface AsignacionRolesService {
    Page<AsignacionRolesResponse> getRolesAsignados(
            int page, int size, Integer rutAsignador, Integer rutAsignado, Long idRol,
            String fechaAsignacionDesde, String fechaAsignacionHasta, String fechaRevocacionDesde,
            String fechaRevocacionHasta
    );

    UserRolesResponse getRolesByRut(
            String schema, Integer rut
    );

    Boolean setRolesByRut(
            Map<String, Object> data
    );
}
