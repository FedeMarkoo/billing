package com.prosegur.sol.servicebilling.complement.api.data.model;

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
@Table(name = "SLDL_TSERVICIO")
@AttributeOverride(name = "id", column = @Column(name = "OID_SERVICIO", unique = true, nullable = false, length = 36))
public class Service extends BasicEntity implements Serializable {
    private static final long serialVersionUID = -8983177228309577868L;

    @Column(name = "COD_SERVICIO")
    private String serviceCode;
}


