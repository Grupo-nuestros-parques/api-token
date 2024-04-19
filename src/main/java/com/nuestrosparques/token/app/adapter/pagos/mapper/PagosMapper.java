package com.nuestrosparques.token.app.adapter.pagos.mapper;

import com.nuestrosparques.token.app.adapter.pagos.dto.PagosDTO;
import com.nuestrosparques.token.app.adapter.pagos.response.PagosResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PagosMapper {

    public List<PagosDTO> transformPagosToDTO(List<PagosResponse> pagosResponses){
        List<PagosDTO> pagos = new ArrayList<>();
        pagosResponses.forEach(resp ->{
            PagosDTO pagosDTO = new PagosDTO();
            pagosDTO.setA1(resp.getFolio());
            pagosDTO.setA2(resp.getTipoCob());
            pagosDTO.setA3(resp.getFechaPago());
            pagosDTO.setA4(resp.getTipoMov());
            pagosDTO.setA5(resp.getMonto());
            pagosDTO.setA6(resp.getCuotasPag());
            pagosDTO.setA7(resp.getSerie());
            pagosDTO.setA8(resp.getContrato());
            pagosDTO.setA9(resp.getCodCaja());
            pagosDTO.setA10(resp.getRezago());
            pagosDTO.setA11(resp.getValorUf());
            pagosDTO.setA12(resp.getPagoHist());
            pagosDTO.setA13(resp.getBase());
            pagosDTO.setA14(resp.getRut());
            pagosDTO.setA15(resp.getUsuario());
            pagosDTO.setA16(resp.getCodAge());
            pagosDTO.setA17(resp.getFechaVenc());
            pagosDTO.setA18(resp.getPagoExterno());
            pagosDTO.setA19(resp.getLugarExterno());
            pagosDTO.setA20(resp.getVieneDe());
            pagosDTO.setA21(resp.getFechaAnt());
            pagosDTO.setA22(resp.getFchaAnt());
            pagosDTO.setA23(resp.getServipag());
            pagosDTO.setA24(resp.getCodigoOtro());
            pagosDTO.setA25(resp.getTraspasoE());
            pagosDTO.setA26(resp.getFechaTraspasoRezago());
            pagosDTO.setA27(resp.getFechaSistema());
            pagosDTO.setA28(resp.getCodParque());
            pagosDTO.setA29(resp.getEstadoSap());
            pagosDTO.setA30(resp.getEstadoPagoSap());
            pagosDTO.setA31(resp.getCtasPagCtto());
            pagosDTO.setA32(resp.getMonedaSap());
            pagosDTO.setA33(resp.getMontoUf());
            pagosDTO.setA34(resp.getRezagoSap());
            pagosDTO.setA35(resp.getFechaDeposito());
            pagosDTO.setA36(resp.getConvenioBanco());
            pagosDTO.setA37(resp.getReingreso());
            pagosDTO.setA38(resp.getNroCupon());
            pagosDTO.setA39(resp.getTipoCobOriginal());
            pagosDTO.setA40(resp.getCodigoServicio());
            pagos.add(pagosDTO);
        });
        return pagos;
    }
}
