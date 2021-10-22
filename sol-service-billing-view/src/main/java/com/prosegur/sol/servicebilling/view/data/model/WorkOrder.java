package com.prosegur.sol.servicebilling.view.data.model;


import com.prosegur.data.model.BasicEntity;
import com.prosegur.sol.servicebilling.view.data.model.enums.ServiceTypeCodeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "SLDL_TOT")
@AttributeOverride(name = "id", column = @Column(name = "OID_OT", unique = true, nullable = false, length = 36))
public class WorkOrder extends BasicEntity implements Serializable {
    private static final long serialVersionUID = -5870967492024013192L;
    @OneToOne
    @JoinColumn(name = "OID_PUNTO_SERVICIO", referencedColumnName = "OID_PUNTO_SERVICIO")
    private ServicePoint servicePoint;
    @OneToOne
    @JoinColumn(name = "OID_TIPO_OT", referencedColumnName = "OID_TIPO_OT")
    private WorkOrderType workOrderType;
    @Column(name = "FYH_SOLICITADA_INICIO")
    private LocalDateTime requestedStartTime;
    @Column(name = "FYH_SOLICITADA_FIN")
    private LocalDateTime requestedEndTime;
    @Column(name = "FYH_REALIZADA_INICIO")
    private LocalDateTime startTime;
    @Column(name = "FYH_REALIZADA_FIN")
    private LocalDateTime endTime;
    @OneToOne
    @JoinColumn(name = "OID_MOTIVO_NO_REALIZACION", referencedColumnName = "OID_MOTIVO_NO_REALIZACION")
    private NonPerforming nonPerforming;
    @OneToOne
    @JoinColumn(name = "OID_RUTA", referencedColumnName = "OID_RUTA")
    private Route route;
    @JoinColumn(name = "OID_PARADA_CENTRO")
    @OneToOne
    private CenterStop centerStop;
    @JoinColumn(name = "OID_PARADA_OPERATIVA")
    @OneToOne
    private ServicePointStop servicePointStop;
    @Column(name = "OID_PARADA")
    private String stopId;
    @Column(name = "COD_MODALIDAD")
    private Integer operationalStopType;

    @OneToOne
    @JoinColumn(name = "OID_ACUERDO")
    private Agreement agreement;

    @JoinColumn(name = "OID_DELEGACION_LV")
    @OneToOne
    private Delegation delegation;

    @Column(name = "COD_TIPO_SERVICIO")
    private ServiceTypeCodeEnum serviceTypeCode;

    @OneToOne
    @JoinColumn(name = "OID_DIRECCION")
    private Address address;

    @Column(name = "NEC_TIEMPO_DESPLAZAMIENTO")
    private String travelTime;
}
