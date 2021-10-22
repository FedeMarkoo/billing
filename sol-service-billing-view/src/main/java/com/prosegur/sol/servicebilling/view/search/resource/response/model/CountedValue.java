package com.prosegur.sol.servicebilling.view.search.resource.response.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

@Getter
@Setter
public class CountedValue {
    private String currencyCode;
    @NumberFormat(pattern = "##,00")
    private Double value;
}
