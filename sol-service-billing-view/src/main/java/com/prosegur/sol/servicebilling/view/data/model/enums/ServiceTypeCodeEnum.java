package com.prosegur.sol.servicebilling.view.data.model.enums;

import lombok.Getter;

@Getter
public enum ServiceTypeCodeEnum {
    FIJO(0, "tipo_servicio_fijo"),
    EVENTUAL(1, "tipo_servicio_eventual"),
    ESPECIAL(2, "tipo_servicio_especial"),
    COINCIDENTE(3, "tipo_servicio_coincidente"),
    ADMINISTRATIVO(4, "tipo_servicio_administrativo"),
    SERVICIO_DEL_TERCERO(5, "tipo_servicio_servicio_del_tercero"),
    ALTA_TM(6, "tipo_servicio_servicio_del_tm");

    private final int value;
    private final String code;

    ServiceTypeCodeEnum(final Integer value, final String code) {
        this.value = value;
        this.code = code;
    }
}
