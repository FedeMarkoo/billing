package com.prosegur.sol.servicebilling.view.data.model;

import com.prosegur.data.model.BasicEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "SLDG_TPAIS")
@AttributeOverride(name = "id", column = @Column(name = "OID_PAIS", unique = true, nullable = false, length = 36))
public class Country extends BasicEntity implements Serializable {
    private static final long serialVersionUID = 679961253708517644L;
    @Id
    @Column(name = "OID_PAIS")
    private String id;

    @Column(name = "COD_PAIS")
    private String code;
}
