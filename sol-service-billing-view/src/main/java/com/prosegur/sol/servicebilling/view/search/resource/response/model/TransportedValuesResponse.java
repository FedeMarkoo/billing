package com.prosegur.sol.servicebilling.view.search.resource.response.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Setter
@Getter
public class TransportedValuesResponse {
    @JsonIgnore
    private String documentId;
    @NotNull
    private String document;
    private String bags;
    @NotNull
    private List<Composition> composition;
}
