package com.prosegur.sol.servicebilling.view.data.model;

import com.prosegur.data.model.BasicEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@javax.persistence.Entity
@Table(name = "SLDL_TACUERDO")
@AttributeOverride(name = "id", column = @Column(name = "OID_ACUERDO", unique = true, nullable = false, length = 36))
public class Agreement extends BasicEntity implements Serializable {
    private static final long serialVersionUID = -8983177228309577868L;

    @OneToOne
    @JoinColumn(name = "OID_PAIS")
    private Country country;

    @JoinColumn(name = "OID_PRODUCTO")
    @OneToOne
    private Product product;

}
