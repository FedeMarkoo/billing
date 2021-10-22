package com.prosegur.sol.servicebilling.view.search.resource.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ServiceBillingFilter {
    @NotBlank
    private String id;
}
