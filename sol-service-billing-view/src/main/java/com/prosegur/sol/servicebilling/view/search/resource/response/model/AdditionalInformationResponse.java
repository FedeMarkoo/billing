package com.prosegur.sol.servicebilling.view.search.resource.response.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class AdditionalInformationResponse {

    private Map<String, Object> json;

    private String originalSystem;
}
