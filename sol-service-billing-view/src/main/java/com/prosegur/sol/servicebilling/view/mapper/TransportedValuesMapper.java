package com.prosegur.sol.servicebilling.view.mapper;

import com.prosegur.rest.mapper.configuration.DefaultResponseMapperConfig;
import com.prosegur.sol.servicebilling.view.data.model.Document;
import com.prosegur.sol.servicebilling.view.data.model.DocumentAmount;
import com.prosegur.sol.servicebilling.view.search.resource.response.model.Composition;
import com.prosegur.sol.servicebilling.view.search.resource.response.model.DeclaredValue;
import com.prosegur.sol.servicebilling.view.search.resource.response.model.TransportedValuesResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper(componentModel = "spring"
        , unmappedTargetPolicy = ReportingPolicy.WARN
        , config = DefaultResponseMapperConfig.class)
public interface TransportedValuesMapper {

    @Mapping(target = "document", source = "code")
    @Mapping(target = "documentId", source = "id")
    @Mapping(target = "composition", source = "documentsAmounts")
    TransportedValuesResponse map(Document document);

    default List<Composition> mapComposition(final List<DocumentAmount> document) {
        final Map<String, Composition> compositions = new HashMap<>();
        if (document != null) {
            document.stream()
                    .filter(documentAmount ->
                            documentAmount.getMerchandiseType() != null
                                    && documentAmount.getMerchandiseType().getDescription() != null)
                    .forEach(documentAmount -> {
                        final String merchandiseType = documentAmount.getMerchandiseType().getDescription();
                        final Composition comp = compositions.getOrDefault(merchandiseType, new Composition());
                        compositions.put(merchandiseType, this.mapToComposition(documentAmount, merchandiseType, comp));
                    });
        }

        return new ArrayList<>(compositions.values());
    }

    default Composition mapToComposition(final DocumentAmount documentAmount, final String merchandiseType, @MappingTarget final Composition comp) {
        comp.setMerchandiseType(merchandiseType);

        if (comp.getDeclaredValue() == null) {
            comp.setDeclaredValue(new ArrayList<>());
        }

        comp.getDeclaredValue().add(this.mapDeclaredValue(documentAmount));

        return comp;
    }

    @Mapping(target = "currencyCode", source = "currency.isoCode")
    DeclaredValue mapDeclaredValue(DocumentAmount documentAmount);
}
