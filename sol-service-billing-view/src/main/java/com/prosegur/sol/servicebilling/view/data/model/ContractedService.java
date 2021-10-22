package com.prosegur.sol.servicebilling.view.data.model;

import com.prosegur.data.model.BasicEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "SLDL_TSERVICIO_CONTRATADO")
@AttributeOverride(name = "id", column = @Column(name = "OID_SERVICIO_CONTRATADO", unique = true, nullable = false, length = 36))
public class ContractedService extends BasicEntity implements Serializable {
    private static final long serialVersionUID = 3426046934264529003L;
    @Column(name = "COD_SERVICIO_ORIGEN")
    private String code;

    @Column(name = "CONTRACT_ID")
    private String contractId;

    @Column(name = "SERVICE_ORDER_ID")
    private String serviceOrderId;

    @Column(name = "SERVICE_ORDER_CODE")
    private String serviceOrderCode;

    @Column(name = "COD_MODALIDAD_CRM")
    private String stopType;

    @JoinColumn(name = "OID_ACUERDO")
    @OneToOne
    private Agreement agreement;

    @Column(name = "COD_UNICO_PUNTO_SERVICIO")
    private String servicePointUniqueCode;
}
