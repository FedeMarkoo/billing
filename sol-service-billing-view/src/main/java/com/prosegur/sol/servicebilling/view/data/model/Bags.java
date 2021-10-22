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
@Table(name = "SLDL_TBULTO")
@AttributeOverride(name = "id", column = @Column(name = "OID_BULTO", unique = true, nullable = false, length = 36))
public class Bags extends BasicEntity implements Serializable {
    private static final long serialVersionUID = -860588915195640619L;
    @Column(name = "OID_DOCUMENTO")
    private String documentId;

    @Column(name = "COD_PRECINTO")
    private String seal;

    @Column(name = "COD_BOLSA")
    private String pouch;
}
