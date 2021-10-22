package com.prosegur.sol.servicebilling.complement.api.controller.resource.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Map;

@Data
public class AdditionalInformationRequest {
    @NotBlank
    private String serviceCode;
    @NotEmpty
    private Map<String, Object> additionalInformation;
    @NotBlank
    private String type;
}
