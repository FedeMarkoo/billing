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
@Table(name = "SLDL_TVEHICULO")
@AttributeOverride(name = "id", column = @Column(name = "OID_VEHICULO", unique = true, nullable = false, length = 36))
public class Vehicle extends BasicEntity implements Serializable {

    private static final long serialVersionUID = 7584927730917905808L;
    @Column(name = "COD_PATENTE")
    private String vehiclePlate;
}
