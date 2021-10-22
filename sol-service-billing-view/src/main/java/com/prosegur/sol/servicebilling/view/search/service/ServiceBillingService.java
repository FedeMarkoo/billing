package com.prosegur.sol.servicebilling.view.search.service;

import com.prosegur.cash.exception.exceptions.EntityNotFoundException;
import com.prosegur.sol.servicebilling.view.data.model.*;
import com.prosegur.sol.servicebilling.view.data.repository.BagsRepository;
import com.prosegur.sol.servicebilling.view.data.repository.ServiceBillingRepository;
import com.prosegur.sol.servicebilling.view.data.repository.WorkOrderRepository;
import com.prosegur.sol.servicebilling.view.search.resource.request.ServiceBillingFilter;
import com.prosegur.sol.servicebilling.view.search.resource.response.model.TransportedValuesResponse;
import com.prosegur.sol.servicebilling.view.search.resource.response.model.WorkOrderResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
@Log
public class ServiceBillingService {

    public static final Supplier<EntityNotFoundException> NOT_FOUND_EXCEPTION_SUPPLIER = () -> new EntityNotFoundException("ServiceBilling");
    private final BagsRepository bagsRepository;
    private final ServiceBillingRepository repository;
    private final WorkOrderRepository woRepository;

    public ServiceBilling findById(final ServiceBillingFilter filter) {
        return this.repository.findById(filter.getId()).orElseThrow(NOT_FOUND_EXCEPTION_SUPPLIER);
    }

    public void fillQuantities(final WorkOrderResponse workOrderResponse, final List<WorkOrder> workOrders) {
        final String woid = workOrderResponse.getId();
        final Optional<WorkOrder> workOrder = workOrders.stream()
                .filter(wo -> Objects.equals(wo.getId(), woid))
                .findFirst();
        if (workOrder.isPresent()) {
            final WorkOrder workOrder1 = workOrder.get();
            final Route route = workOrder1.getRoute();
            if (route != null) {
                final String routeId = route.getId();
                final CenterStop centerStop = workOrder1.getCenterStop();
                if (centerStop != null) {
                    final long countCenterStopService = this.woRepository.countCenterStopService(routeId, centerStop.getId());
                    workOrderResponse.setCenterStopServiceQuantity(String.valueOf(countCenterStopService));
                } else {
                    workOrderResponse.setCenterStopServiceQuantity("0");
                }
                final ServicePointStop servicePointStop = workOrder1.getServicePointStop();
                if (servicePointStop != null) {
                    final long countServicePointStopService = this.woRepository.countServicePointStopService(routeId, servicePointStop.getId());
                    workOrderResponse.setServicePointStopServiceQuantity(String.valueOf(countServicePointStopService));
                } else {
                    workOrderResponse.setServicePointStopServiceQuantity("0");
                }
            }
        }
    }

    public String countBags(final TransportedValuesResponse transportedValuesResponse) {

        return String.valueOf(this.bagsRepository.countBags(transportedValuesResponse.getDocumentId()));
    }
}