package com.prosegur.sol.servicebilling.view.data.repository;

import com.prosegur.data.repository.SimpleRepository;
import com.prosegur.sol.servicebilling.view.data.model.ServiceBilling;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceBillingRepository extends SimpleRepository<ServiceBilling> {

}
