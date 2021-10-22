package com.prosegur.sol.servicebilling.view.search.resource;


import com.prosegur.cash.integration.testhelper.generators.ObjectGenerator;
import com.prosegur.sol.servicebilling.view.data.model.ServiceBilling;
import com.prosegur.sol.servicebilling.view.mapper.ServiceBillingMapper;
import com.prosegur.sol.servicebilling.view.search.resource.request.ServiceBillingFilter;
import com.prosegur.sol.servicebilling.view.search.resource.response.model.ServiceBillingResponse;
import com.prosegur.sol.servicebilling.view.search.service.ServiceBillingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ServiceBillingViewTest {

    @Mock
    ServiceBillingService service;
    @Spy
    ServiceBillingMapper mapper;

    @InjectMocks
    ServiceBillingView resourse;

    @Test
    void shouldResponseOnCorrectFilter() {
        final ServiceBilling instance = ObjectGenerator.createInstance(ServiceBilling.class);
        when(this.service.findById(any())).thenReturn(instance);
        final ServiceBillingResponse response = this.resourse.findWO(ObjectGenerator.createInstance(ServiceBillingFilter.class));

        assertThat(response).isNull();
    }
}