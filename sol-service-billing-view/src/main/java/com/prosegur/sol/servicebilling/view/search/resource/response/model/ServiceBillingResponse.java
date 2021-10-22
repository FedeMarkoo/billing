package com.prosegur.sol.servicebilling.view.search.resource.response.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ServiceBillingResponse {
    @NotNull
    private String eventType;
    @NotNull
    private String apiVersion;
    @NotNull
    private String systemCode;
    @NotNull
    private String countryCode;
    @NotNull
    private String contractId;
    @NotNull
    private String serviceOrderId;
    @NotNull
    private String serviceOrderCode;
    private String servicePointUniqueCode;
    @NotNull
    private String productCode;
    @NotNull
    private String serviceUniqueId;
    @NotNull
    private String serviceCode;
    private String citCustomerServiceCode;
    private String cpCustomerServiceCode;
    @NotNull
    private String frequency;
    @NotNull
    private String stopType;
    private List<WorkOrderResponse> workOrders;
    private List<TransportedValuesResponse> transportedValue;
    private List<CountedValue> countedValue;
    private List<Material> materials;
    private List<Map<String, Object>> additionalInformation;
}
