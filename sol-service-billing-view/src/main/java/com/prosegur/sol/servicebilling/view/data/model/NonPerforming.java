package com.prosegur.sol.servicebilling.view.data.model;


import com.prosegur.data.model.BasicEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "SLDL_TMOTIVO_NO_REALIZACION")
@AttributeOverride(name = "id", column = @Column(name = "OID_MOTIVO_NO_REALIZACION", unique = true, nullable = false, length = 36))
public class NonPerforming extends BasicEntity implements Serializable {
    private static final long serialVersionUID = -8377913769848584787L;
    @Column(name = "DES_MOTIVO_NO_REALIZACION")
    private String nonPerformingDescription;
    @Column(name = "COD_MOTIVO_NO_REALIZACION")
    private String nonPerformingCode;
    @Column(name = "BOL_FACTURABLE")
    private String isNonPerformingBillable;
}
