package com.prosegur.sol.servicebilling.view.search.resource.response.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Setter
@Getter
public class Composition {
    @NotNull
    private String merchandiseType;
    @NotNull
    private List<DeclaredValue> declaredValue;
}
