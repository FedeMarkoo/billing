package com.prosegur.sol.servicebilling.view.data.model;

import com.prosegur.data.model.BasicEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "SLDL_TRUTA")
@AttributeOverride(name = "id", column = @Column(name = "OID_RUTA", unique = true, nullable = false, length = 36))
public class Route extends BasicEntity implements Serializable {

    private static final long serialVersionUID = 8402495020409786816L;
    @OneToOne
    @JoinColumn(name = "OID_VEHICULO", referencedColumnName = "OID_VEHICULO")
    private Vehicle vehicle;

    @Column(name = "FEC_RUTA")
    private LocalDate routeDate;

    @Column(name = "COD_RUTA")
    private String routeNumber;

}
