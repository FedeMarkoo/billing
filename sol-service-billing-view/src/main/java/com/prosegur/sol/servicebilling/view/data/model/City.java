package com.prosegur.sol.servicebilling.view.data.model;

import com.prosegur.data.model.BasicEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "SLDL_TCIUDAD")
@AttributeOverride(name = "id", column = @Column(name = "OID_CIUDAD", unique = true, nullable = false, length = 36))
public class City extends BasicEntity implements Serializable  {
    private static final long serialVersionUID = 1370659874452124366L;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OID_PROVINCIA")
    private Province province;
}
