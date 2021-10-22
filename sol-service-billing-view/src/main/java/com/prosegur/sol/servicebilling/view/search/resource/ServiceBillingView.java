package com.prosegur.sol.servicebilling.view.search.resource;

import com.prosegur.sol.servicebilling.view.mapper.ServiceBillingMapper;
import com.prosegur.sol.servicebilling.view.search.resource.request.ServiceBillingFilter;
import com.prosegur.sol.servicebilling.view.search.resource.response.model.ServiceBillingResponse;
import com.prosegur.sol.servicebilling.view.search.service.ServiceBillingService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Tag(name = "serviceBilling")
@RestController
@RequestMapping("/service-billing")
@RequiredArgsConstructor
public class ServiceBillingView {

    private final ServiceBillingService service;
    private final ServiceBillingMapper mapper;

    @Transactional(readOnly = true)
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ServiceBillingResponse findWO(@Parameter @Valid final ServiceBillingFilter filter) {
        return this.mapper.toResponse(this.service.findById(filter));
    }

}