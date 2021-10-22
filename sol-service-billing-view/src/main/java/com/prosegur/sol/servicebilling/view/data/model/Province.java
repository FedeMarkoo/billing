package com.prosegur.sol.servicebilling.view.data.model;

import com.prosegur.data.model.BasicEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "SLDL_TPROVINCIA")
@AttributeOverride(name = "id", column = @Column(name = "OID_PROVINCIA", unique = true, nullable = false, length = 36))
public class Province extends BasicEntity implements Serializable {
    private static final long serialVersionUID = 5111944817278930238L;
    @Id
    @Column(name = "OID_PROVINCIA")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OID_PAIS")
    private Country country;
}
