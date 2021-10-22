package com.prosegur.sol.servicebilling.view.search.service;

import com.prosegur.cash.integration.testhelper.generators.ObjectGenerator;
import com.prosegur.sol.servicebilling.view.data.model.ServiceBilling;
import com.prosegur.sol.servicebilling.view.data.model.WorkOrder;
import com.prosegur.sol.servicebilling.view.data.repository.ServiceBillingRepository;
import com.prosegur.sol.servicebilling.view.search.resource.request.ServiceBillingFilter;
import com.prosegur.sol.servicebilling.view.search.resource.response.model.WorkOrderResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ServiceBillingServiceTest {

    @InjectMocks
    ServiceBillingService service;

    @Mock
    ServiceBillingRepository serviceBillingRepository;

    @Test
    void findById() {
        final ServiceBillingFilter filter = ObjectGenerator.createInstanceFully(ServiceBillingFilter.class);
        final ServiceBilling expected = ObjectGenerator.createInstanceFully(ServiceBilling.class);

        when(this.serviceBillingRepository.findById(any())).thenReturn(Optional.of(expected));

        final ServiceBilling actual = this.service.findById(filter);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void fillQuantities() {
        final WorkOrderResponse expected = ObjectGenerator.createInstanceFully(WorkOrderResponse.class);
        final List<WorkOrder> list = new ArrayList<>();
        list.add(ObjectGenerator.createInstanceFully(WorkOrder.class));

        this.service.fillQuantities(expected, list);

    }

    @Test
    void countBags() {
    }
}