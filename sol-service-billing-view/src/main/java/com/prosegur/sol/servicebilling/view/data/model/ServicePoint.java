package com.prosegur.sol.servicebilling.view.data.model;

import com.prosegur.data.model.BasicEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "SLDL_TPUNTO_SERVICIO")
@AttributeOverride(name = "id", column = @Column(name = "OID_PUNTO_SERVICIO", unique = true, nullable = false, length = 36))
public class ServicePoint extends BasicEntity implements Serializable {

    private static final long serialVersionUID = 5944582169875251485L;
    @Column(name = "COD_UNICO_PUNTO_SERVICIO")
    private String code;

    @OneToOne
    @JoinColumn(name = "OID_CENTRO")
    private Center center;
}

