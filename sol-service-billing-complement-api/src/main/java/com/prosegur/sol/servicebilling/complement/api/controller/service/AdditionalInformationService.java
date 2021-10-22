package com.prosegur.sol.servicebilling.complement.api.controller.service;

import com.prosegur.sol.servicebilling.complement.api.controller.resource.request.AdditionalInformationRequest;
import com.prosegur.sol.servicebilling.complement.api.data.model.AdditionalInformation;
import com.prosegur.sol.servicebilling.complement.api.data.repository.AdditionalInformationRepository;
import com.prosegur.sol.servicebilling.complement.api.mapper.AdditionalInformationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdditionalInformationService {

    private final AdditionalInformationRepository repository;
    private final AdditionalInformationMapper mapper;

    public void saveJson(final AdditionalInformationRequest request) {
        final String serviceId = this.repository.findServiceIdByCode(request.getServiceCode());
        AdditionalInformation addInfo = this.repository.findByServiceIdAndType(serviceId, request.getType());
        if (addInfo != null) {
            addInfo.setAdditionalInformation(this.mapper.mapToJson(request.getAdditionalInformation()));
        } else {
            addInfo = this.mapper.toEntity(request);
            addInfo.setServiceId(serviceId);
        }
        this.repository.save(addInfo);
    }

}