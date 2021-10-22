package com.prosegur.sol.servicebilling.view.mapper;

import com.prosegur.rest.mapper.configuration.DefaultRequestMapperConfig;
import com.prosegur.sol.servicebilling.view.data.model.*;
import com.prosegur.sol.servicebilling.view.search.resource.response.model.ServiceBillingResponse;
import com.prosegur.sol.servicebilling.view.search.service.ServiceBillingService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring"
        , config = DefaultRequestMapperConfig.class
        , unmappedTargetPolicy = ReportingPolicy.IGNORE
        , uses = {WorkOrderMapper.class
        , TransportedValuesMapper.class
        , MaterialMapper.class
        , AdditionalInformationMapper.class})
public abstract class ServiceBillingMapper {

    @Autowired
    private ServiceBillingService serviceBilling;

    @Mapping(target = "eventType", constant = "sol-service-billing")
    @Mapping(target = "systemCode", constant = "sol")
    @Mapping(target = "apiVersion", constant = "1")
    @Mapping(target = "serviceUniqueId", source = "id")
    @Mapping(target = "serviceCode", source = "uniqueCode")
    @Mapping(target = "transportedValue", source = "documents")
    @Mapping(target = "countedValue", ignore = true)
    @Mapping(target = "citCustomerServiceCode", defaultValue = "")
    @Mapping(target = "cpCustomerServiceCode", defaultValue = "")
    @Mapping(target = "materials", source = "transportMerchandise")
    public abstract ServiceBillingResponse toResponse(ServiceBilling serviceBilling);

    @Mapping(target = "productCode", source = "agreement.product.code")
    abstract void addContractedServiceInfo(@MappingTarget ServiceBillingResponse serviceBillingResponse, ContractedService contractedService);

    @AfterMapping
    void afterMapping(@MappingTarget final ServiceBillingResponse serviceBillingResponse, final ServiceBilling serviceBilling) {
        this.addContractedServiceInfo(serviceBillingResponse, serviceBilling.getContractedService());
        ServiceBillingMapper.setWorkOrderInfo(serviceBillingResponse, serviceBilling);

        this.setQuantities(serviceBillingResponse, serviceBilling);
        this.setBags(serviceBillingResponse);
    }

    private static void setWorkOrderInfo(@MappingTarget final ServiceBillingResponse serviceBillingResponse, final ServiceBilling serviceBilling) {
        final List<WorkOrder> workOrders = serviceBilling.getWorkOrders();
        if (workOrders != null && !workOrders.isEmpty()) {
            final WorkOrder workOrder = workOrders.get(0);
            final Agreement agreement = workOrder.getAgreement();
            if (agreement != null) {
                final Country country = agreement.getCountry();
                if (country != null) {
                    serviceBillingResponse.setCountryCode(country.getCode());
                }
            }
            serviceBillingResponse.setFrequency(ENUMMapper.mapEnumfrequency(workOrder.getServiceTypeCode()));
        }
    }

    private void setQuantities(@MappingTarget final ServiceBillingResponse serviceBillingResponse, final ServiceBilling serviceBilling) {
        if (serviceBillingResponse.getWorkOrders() != null) {
            serviceBillingResponse.getWorkOrders().forEach(workOrderResponse ->
                    this.serviceBilling.fillQuantities(workOrderResponse, serviceBilling.getWorkOrders())
            );
        }
    }

    private void setBags(@MappingTarget final ServiceBillingResponse serviceBillingResponse) {
        if (serviceBillingResponse.getTransportedValue() != null) {
            serviceBillingResponse.getTransportedValue().forEach(transportedValuesResponse ->
                    transportedValuesResponse.setBags(this.serviceBilling.countBags(transportedValuesResponse))
            );
        }
    }

}

