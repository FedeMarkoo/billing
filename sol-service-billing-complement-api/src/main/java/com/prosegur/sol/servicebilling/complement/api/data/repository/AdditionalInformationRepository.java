package com.prosegur.sol.servicebilling.complement.api.data.repository;

import com.prosegur.data.repository.SimpleRepository;
import com.prosegur.sol.servicebilling.complement.api.data.model.AdditionalInformation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalInformationRepository extends SimpleRepository<AdditionalInformation> {

    AdditionalInformation findByServiceIdAndType(String serviceId, String type);

    @Query("SELECT id FROM Service WHERE serviceCode = :serviceCode")
    String findServiceIdByCode(@Param("serviceCode") String serviceCode);
}
