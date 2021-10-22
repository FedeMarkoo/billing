package com.prosegur.sol.servicebilling.view.mapper;

import com.prosegur.rest.mapper.configuration.DefaultResponseMapperConfig;
import com.prosegur.sol.servicebilling.view.data.model.TransportMerchandise;
import com.prosegur.sol.servicebilling.view.search.resource.response.model.Material;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring"
        , unmappedTargetPolicy = ReportingPolicy.WARN
        , config = DefaultResponseMapperConfig.class)
public abstract class MaterialMapper {

    protected static List<Material> transportMerchandiseToMaterial(final List<TransportMerchandise> list) {
        if (list == null) {
            return Collections.EMPTY_LIST;
        }

        return list.stream()
                .filter(transportMerchandise -> transportMerchandise.getQuantity() != null)
                .filter(transportMerchandise ->
                        transportMerchandise.getMerchandiseType() != null
                                && transportMerchandise.getMerchandiseType().getMerchandiseCRM() != null
                                && transportMerchandise.getMerchandiseType().getMerchandiseCRM().getDescription() != null)
                .collect(Collectors.groupingBy(transportMerchandise ->
                                transportMerchandise.getMerchandiseType().getMerchandiseCRM().getDescription()
                        , Collectors.summingLong(TransportMerchandise::getQuantity)))
                .entrySet().stream().map(entry ->
                        Material.builder()
                                .materialType(entry.getKey())
                                .quantity(entry.getValue())
                                .build())
                .collect(Collectors.toList());
    }
}
