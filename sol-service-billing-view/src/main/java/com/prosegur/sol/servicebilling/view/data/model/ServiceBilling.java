package com.prosegur.sol.servicebilling.view.data.model;

import com.prosegur.data.model.BasicEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "SLDL_TSERVICIO")
@AttributeOverride(name = "id", column = @Column(name = "OID_SERVICIO", unique = true, nullable = false, length = 36))
public class ServiceBilling extends BasicEntity implements Serializable {
    private static final long serialVersionUID = -7344500505311334753L;
    @Column(name = "COD_SERVICIO")
    private String uniqueCode;

    @Column(name = "DES_ORIGEN")
    private String source;

    @JoinColumn(name = "OID_SERVICIO_CONTRATADO")
    @OneToOne
    private ContractedService contractedService;

    @Column(name = "COD_CLAVE_SOLICITUD")
    private String citCustomerServiceCode;
    @Column(name = "COD_CLAVE_SOLICITUD_GE")
    private String cpCustomerServiceCode;
    @OneToMany
    @JoinColumn(name = "OID_SERVICIO", referencedColumnName = "OID_SERVICIO")
    private List<WorkOrder> workOrders;
    @OneToMany
    @JoinColumn(name = "OID_SERVICIO", referencedColumnName = "OID_SERVICIO")
    private List<Document> documents;

    @OneToMany
    @JoinColumn(name = "OID_SERVICIO", referencedColumnName = "OID_SERVICIO")
    private List<AdditionalInformation> additionalInformation;

    @OneToMany
    @JoinColumn(name = "OID_SERVICIO", referencedColumnName = "OID_SERVICIO")
    private List<TransportMerchandise> transportMerchandise;

}
