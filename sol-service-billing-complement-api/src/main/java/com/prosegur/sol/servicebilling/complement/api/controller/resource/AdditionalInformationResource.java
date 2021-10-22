package com.prosegur.sol.servicebilling.complement.api.controller.resource;

import com.prosegur.sol.servicebilling.complement.api.controller.resource.request.AdditionalInformationRequest;
import com.prosegur.sol.servicebilling.complement.api.controller.service.AdditionalInformationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Additional Information")
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class AdditionalInformationResource {

    private final AdditionalInformationService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveJson(@RequestBody @Valid final AdditionalInformationRequest request) {
        this.service.saveJson(request);
    }

}