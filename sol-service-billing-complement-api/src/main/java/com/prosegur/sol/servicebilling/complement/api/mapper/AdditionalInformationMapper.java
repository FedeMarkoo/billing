package com.prosegur.sol.servicebilling.complement.api.mapper;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.prosegur.rest.mapper.configuration.DefaultRequestMapperConfig;
import com.prosegur.sol.servicebilling.complement.api.controller.resource.request.AdditionalInformationRequest;
import com.prosegur.sol.servicebilling.complement.api.data.model.AdditionalInformation;
import lombok.SneakyThrows;
import org.mapstruct.Mapper;

import java.util.Map;

@Mapper(componentModel = "spring"
        , config = DefaultRequestMapperConfig.class)
public interface AdditionalInformationMapper {

    JsonMapper JSON_MAPPER = new JsonMapper();

    AdditionalInformation toEntity(AdditionalInformationRequest request);

    @SneakyThrows
    default String mapToJson(final Map<String, Object> value) {
        return JSON_MAPPER.writeValueAsString(value);
    }
}

