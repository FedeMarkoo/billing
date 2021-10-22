package com.prosegur.sol.servicebilling.view.mapper;

import com.prosegur.rest.mapper.configuration.DefaultRequestMapperConfig;
import com.prosegur.sol.servicebilling.view.data.model.enums.ServiceTypeCodeEnum;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = DefaultRequestMapperConfig.class)
public class ENUMMapper {

    static String mapEnumfrequency(final ServiceTypeCodeEnum serviceTypeCode) {
        if (serviceTypeCode == null) {
            return "default";
        }
        switch (serviceTypeCode) {
            case FIJO:
                return "1";
            case EVENTUAL:
                return "2";
            case ESPECIAL:
                return "3";
            default:
                return "default";
        }
    }


    static String mapEnumStopType(final Integer stopTypeId) {
        if (stopTypeId == null) {
            return "";
        }
        switch (stopTypeId) {
            case 0:
                return "1";
            case 1:
                return "0";
            default:
                return "default";
        }
    }
}

