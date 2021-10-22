package com.prosegur.sol.servicebilling.view;

import com.prosegur.cash.integration.testhelper.generators.ObjectGenerator;
import com.prosegur.cash.integration.testhelper.test.integrationtest.BaseSpringTest;
import com.prosegur.sol.servicebilling.view.data.model.ServiceBilling;
import com.prosegur.sol.servicebilling.view.data.model.enums.ServiceTypeCodeEnum;
import com.prosegur.sol.servicebilling.view.data.repository.BagsRepository;
import com.prosegur.sol.servicebilling.view.data.repository.ServiceBillingRepository;
import com.prosegur.sol.servicebilling.view.data.repository.WorkOrderRepository;
import com.prosegur.sol.utils.dateutils.repository.UtilRepository;
import com.querydsl.core.types.Predicate;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
@ActiveProfiles(value = "test", inheritProfiles = false)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SolServiceBillingViewApplicationTest extends BaseSpringTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void initialiseRestAssuredMockMvcWebApplicationContext() {
        RestAssuredMockMvc.webAppContextSetup(this.webApplicationContext);
    }

    @MockBean
    ServiceBillingRepository serviceBillingRepository;
    @MockBean
    UtilRepository utilRepository;
    @MockBean
    WorkOrderRepository workOrderRepository;
    @MockBean
    BagsRepository bagsRepository;

    @Test
    public void testFor_CIT_16076() {
        ObjectGenerator.createAllVariations(ServiceBilling.class).forEach(instance -> {
            Mockito.when(this.serviceBillingRepository.findById(any())).thenReturn(Optional.ofNullable(instance));
            Mockito.when(this.utilRepository.exists(any(Predicate.class))).thenReturn(true);
            Mockito.when(this.workOrderRepository.countCenterStopService(any(), any())).thenReturn(1L);
            Mockito.when(this.workOrderRepository.countServicePointStopService(any(), any())).thenReturn(1L);
            Mockito.when(this.bagsRepository.countBags(any())).thenReturn(1L);

            RestAssuredMockMvc.given()
                    .contentType(ContentType.JSON)
                    .param("id", instance.getId())
                    .get("/service-billing")
                    .then()
                    .statusCode(200);
        });
    }

    @Test
    public void test1() {
        final ServiceBilling instance = ObjectGenerator.createInstanceFully(ServiceBilling.class);
        Mockito.when(this.serviceBillingRepository.findById(any())).thenReturn(Optional.of(instance));
        Mockito.when(this.utilRepository.exists(any(Predicate.class))).thenReturn(true);
        Mockito.when(this.workOrderRepository.countCenterStopService(any(), any())).thenReturn(1L);
        Mockito.when(this.workOrderRepository.countServicePointStopService(any(), any())).thenReturn(1L);
        Mockito.when(this.bagsRepository.countBags(any())).thenReturn(1L);


        RestAssuredMockMvc.given()
                .contentType(ContentType.JSON)
                .param("id", instance.getId())
                .get("/service-billing")
                .then()
                .statusCode(200);
    }

    @Test
    public void test2() {
        final ServiceBilling instance = ObjectGenerator.createInstanceFully(ServiceBilling.class);
        Mockito.when(this.serviceBillingRepository.findById(any())).thenReturn(Optional.empty());

        RestAssuredMockMvc.given()
                .contentType(ContentType.JSON)
                .param("id", instance.getId())
                .get("/service-billing")
                .then()
                .statusCode(404);
    }

    @Test
    public void test3() {
        final ArrayList<String> ignoredFields = new ArrayList<>();
        ignoredFields.add("additionalInformation");
        ignoredFields.add("citCustomerServiceCode");
        ignoredFields.add("cpCustomerServiceCode");
        ignoredFields.add("contractedService");
        ignoredFields.add("documents");
        ignoredFields.add("workOrders");

        this.testIgnoringFields(ignoredFields);
    }

    @Test
    public void test4() {
        final ArrayList<String> ignoredFields = new ArrayList<>();
        ignoredFields.add("contractedService");

        this.testIgnoringFields(ignoredFields);
    }

    private void testIgnoringFields(final ArrayList<String> ignoredFields) {
        final ServiceBilling instance = ObjectGenerator.createInstance(ServiceBilling.class, ignoredFields);
        Mockito.when(this.serviceBillingRepository.findById(any())).thenReturn(Optional.of(instance));
        Mockito.when(this.utilRepository.exists(any(Predicate.class))).thenReturn(true);
        Mockito.when(this.workOrderRepository.countCenterStopService(any(), any())).thenReturn(1L);
        Mockito.when(this.workOrderRepository.countServicePointStopService(any(), any())).thenReturn(1L);
        Mockito.when(this.bagsRepository.countBags(any())).thenReturn(1L);

        RestAssuredMockMvc.given()
                .contentType(ContentType.JSON)
                .param("id", instance.getId())
                .get("/service-billing")
                .then()
                .statusCode(200);
    }

    @Test
    public void test5() {
        final ArrayList<String> ignoredFields = new ArrayList<>();
        ignoredFields.add("agreement");

        this.testIgnoringFields(ignoredFields);
    }

    @Test
    public void test6() {
        final ArrayList<String> ignoredFields = new ArrayList<>();
        ignoredFields.add("product");

        this.testIgnoringFields(ignoredFields);
    }

    @Test
    public void test7() {
        final ArrayList<String> ignoredFields = new ArrayList<>();
        ignoredFields.add("Product.code");

        this.testIgnoringFields(ignoredFields);
    }

    @Test
    public void test8() {
        final ArrayList<String> ignoredFields = new ArrayList<>();
        ignoredFields.add("documentAmount");

        this.testIgnoringFields(ignoredFields);
    }

    @Test
    public void test9() {
        final ArrayList<String> ignoredFields = new ArrayList<>();
        ignoredFields.add("currency");

        this.testIgnoringFields(ignoredFields);
    }

    @Test
    public void test10() {
        final ArrayList<String> ignoredFields = new ArrayList<>();
        ignoredFields.add("isoCode");

        this.testIgnoringFields(ignoredFields);
    }

    @Test
    public void test11() {
        final HashMap<String, Object> valuedFields = new HashMap<>();
        valuedFields.put("workOrder", new ArrayList<>());

        final ServiceBilling instance = ObjectGenerator.createInstance(ServiceBilling.class, valuedFields);
        Mockito.when(this.serviceBillingRepository.findById(any())).thenReturn(Optional.of(instance));
        Mockito.when(this.utilRepository.exists(any(Predicate.class))).thenReturn(true);
        Mockito.when(this.workOrderRepository.countCenterStopService(any(), any())).thenReturn(1L);
        Mockito.when(this.workOrderRepository.countServicePointStopService(any(), any())).thenReturn(1L);
        Mockito.when(this.bagsRepository.countBags(any())).thenReturn(1L);

        RestAssuredMockMvc.given()
                .contentType(ContentType.JSON)
                .param("id", instance.getId())
                .get("/service-billing")
                .then()
                .statusCode(200);
    }

    @Test
    public void test12() {
        final HashMap<String, Object> valuedFields = new HashMap<>();
        valuedFields.put("workOrder", new ArrayList<>());

        final ServiceBilling instance = ObjectGenerator.createInstance(ServiceBilling.class, valuedFields);
        Mockito.when(this.serviceBillingRepository.findById(any())).thenReturn(Optional.of(instance));
        Mockito.when(this.utilRepository.exists(any(Predicate.class))).thenReturn(false);
        Mockito.when(this.workOrderRepository.countCenterStopService(any(), any())).thenReturn(1L);
        Mockito.when(this.workOrderRepository.countServicePointStopService(any(), any())).thenReturn(1L);
        Mockito.when(this.bagsRepository.countBags(any())).thenReturn(1L);

        RestAssuredMockMvc.given()
                .contentType(ContentType.JSON)
                .param("id", instance.getId())
                .get("/service-billing")
                .then()
                .statusCode(200);
    }

    @Test
    public void test13() {
        final HashMap<String, Object> valuedFields = new HashMap<>();
        valuedFields.put("ServiceBilling.id", UUID.randomUUID().toString());

        final ServiceBilling instance = ObjectGenerator.createInstance(ServiceBilling.class, true, valuedFields);
        Mockito.when(this.serviceBillingRepository.findById(any())).thenReturn(Optional.of(instance));
        Mockito.when(this.utilRepository.exists(any(Predicate.class))).thenReturn(false);
        Mockito.when(this.workOrderRepository.countCenterStopService(any(), any())).thenReturn(1L);
        Mockito.when(this.workOrderRepository.countServicePointStopService(any(), any())).thenReturn(1L);
        Mockito.when(this.bagsRepository.countBags(any())).thenReturn(1L);

        RestAssuredMockMvc.given()
                .contentType(ContentType.JSON)
                .param("id", instance.getId())
                .get("/service-billing")
                .then()
                .statusCode(200);
    }

    @Test
    public void test14() {
        final HashMap<String, Object> valuedFields = new HashMap<>();
        valuedFields.put("ServiceBilling.id", UUID.randomUUID().toString());

        final ServiceBilling instance = ObjectGenerator.createInstance(ServiceBilling.class, true, valuedFields);
        Mockito.when(this.serviceBillingRepository.findById(any())).thenReturn(Optional.of(instance));
        Mockito.when(this.utilRepository.exists(any(Predicate.class))).thenReturn(false);
        Mockito.when(this.workOrderRepository.countCenterStopService(any(), any())).thenReturn(1L);
        Mockito.when(this.workOrderRepository.countServicePointStopService(any(), any())).thenReturn(1L);
        Mockito.when(this.bagsRepository.countBags(any())).thenReturn(1L);

        RestAssuredMockMvc.given()
                .contentType(ContentType.JSON)
                .param("id", instance.getId())
                .get("/service-billing")
                .then()
                .statusCode(200);
    }

    @Test
    public void test17() {
        Mockito.when(this.utilRepository.exists(any(Predicate.class))).thenReturn(true);
        Mockito.when(this.workOrderRepository.countCenterStopService(any(), any())).thenReturn(1L);
        Mockito.when(this.workOrderRepository.countServicePointStopService(any(), any())).thenReturn(1L);
        Mockito.when(this.bagsRepository.countBags(any())).thenReturn(1L);

        HashMap<String, Object> valuedFields = new HashMap<>();
        valuedFields.put("serviceTypeCode", ServiceTypeCodeEnum.FIJO);

        ServiceBilling instance = ObjectGenerator.createInstance(ServiceBilling.class, valuedFields);
        Mockito.when(this.serviceBillingRepository.findById(any())).thenReturn(Optional.of(instance));

        RestAssuredMockMvc.given()
                .contentType(ContentType.JSON)
                .param("id", instance.getId())
                .get("/service-billing")
                .then()
                .statusCode(200);

        valuedFields = new HashMap<>();
        valuedFields.put("serviceTypeCode", ServiceTypeCodeEnum.EVENTUAL);

        instance = ObjectGenerator.createInstance(ServiceBilling.class, valuedFields);
        Mockito.when(this.serviceBillingRepository.findById(any())).thenReturn(Optional.of(instance));

        RestAssuredMockMvc.given()
                .contentType(ContentType.JSON)
                .param("id", instance.getId())
                .get("/service-billing")
                .then()
                .statusCode(200);

        valuedFields = new HashMap<>();
        valuedFields.put("serviceTypeCode", ServiceTypeCodeEnum.ESPECIAL);

        instance = ObjectGenerator.createInstance(ServiceBilling.class, valuedFields);
        Mockito.when(this.serviceBillingRepository.findById(any())).thenReturn(Optional.of(instance));

        RestAssuredMockMvc.given()
                .contentType(ContentType.JSON)
                .param("id", instance.getId())
                .get("/service-billing")
                .then()
                .statusCode(200);

        valuedFields = new HashMap<>();
        valuedFields.put("serviceTypeCode", ServiceTypeCodeEnum.SERVICIO_DEL_TERCERO);

        instance = ObjectGenerator.createInstance(ServiceBilling.class, valuedFields);
        Mockito.when(this.serviceBillingRepository.findById(any())).thenReturn(Optional.of(instance));

        RestAssuredMockMvc.given()
                .contentType(ContentType.JSON)
                .param("id", instance.getId())
                .get("/service-billing")
                .then()
                .statusCode(200);

    }

    @Test
    public void test18() {
        Mockito.when(this.utilRepository.exists(any(Predicate.class))).thenReturn(true);
        Mockito.when(this.workOrderRepository.countCenterStopService(any(), any())).thenReturn(1L);
        Mockito.when(this.workOrderRepository.countServicePointStopService(any(), any())).thenReturn(1L);
        Mockito.when(this.bagsRepository.countBags(any())).thenReturn(1L);

        HashMap<String, Object> valuedFields = new HashMap<>();
        valuedFields.put("operationalStopType", 0);

        ServiceBilling instance = ObjectGenerator.createInstance(ServiceBilling.class, valuedFields);
        Mockito.when(this.serviceBillingRepository.findById(any())).thenReturn(Optional.of(instance));

        RestAssuredMockMvc.given()
                .contentType(ContentType.JSON)
                .param("id", instance.getId())
                .get("/service-billing")
                .then()
                .statusCode(200);

        valuedFields = new HashMap<>();
        valuedFields.put("operationalStopType", 1);

        instance = ObjectGenerator.createInstance(ServiceBilling.class, valuedFields);
        Mockito.when(this.serviceBillingRepository.findById(any())).thenReturn(Optional.of(instance));

        RestAssuredMockMvc.given()
                .contentType(ContentType.JSON)
                .param("id", instance.getId())
                .get("/service-billing")
                .then()
                .statusCode(200);

        valuedFields = new HashMap<>();
        valuedFields.put("operationalStopType", 2);

        instance = ObjectGenerator.createInstance(ServiceBilling.class, valuedFields);
        Mockito.when(this.serviceBillingRepository.findById(any())).thenReturn(Optional.of(instance));

        RestAssuredMockMvc.given()
                .contentType(ContentType.JSON)
                .param("id", instance.getId())
                .get("/service-billing")
                .then()
                .statusCode(200);

        valuedFields = new HashMap<>();
        valuedFields.put("serviceTypeCode", ServiceTypeCodeEnum.SERVICIO_DEL_TERCERO);
    }
}
