package com.prosegur.sol.servicebilling.view.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prosegur.rest.mapper.configuration.DefaultRequestMapperConfig;
import com.prosegur.sol.servicebilling.view.data.model.AdditionalInformation;
import org.mapstruct.Mapper;

import java.util.LinkedHashMap;
import java.util.Map;

@Mapper(componentModel = "spring", config = DefaultRequestMapperConfig.class)
public interface AdditionalInformationMapper {

    ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    default Map<String, Object> toMap(final AdditionalInformation additionalInformation) throws JsonProcessingException {
        final Map<String, Object> map = new LinkedHashMap<>();
        map.put("type", additionalInformation.getType());
        final String json = additionalInformation.getJson();
        if (json != null) {
            map.putAll(OBJECT_MAPPER.readValue(json, LinkedHashMap.class));
        }
        return map;
    }

}