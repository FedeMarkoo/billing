package com.prosegur.sol.servicebilling.view.search.resource.response.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;


@Getter
@Setter
public class DeclaredValue {
    @NotNull
    private String currencyCode;
    @NotNull
    @NumberFormat(pattern = "##,00")
    private Double value;
}
