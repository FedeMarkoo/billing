package com.prosegur.sol.servicebilling.view.search.resource.response.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Material {
    private String materialType;
    private Long quantity;
}
