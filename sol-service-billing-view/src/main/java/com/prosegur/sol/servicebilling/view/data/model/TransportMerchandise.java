package com.prosegur.sol.servicebilling.view.data.model;

import com.prosegur.data.model.BasicEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "SLDL_TMERCANCIA_TRANSPORTAR")
@AttributeOverride(name = "id", column = @Column(name = "OID_MERCANCIA_TRANSPORTAR", unique = true, nullable = false, length = 36))
public class TransportMerchandise extends BasicEntity implements Serializable {

    private static final long serialVersionUID = 1468993304895175542L;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OID_TIPO_MERCANCIA", insertable = false, updatable = false)
    private MerchandiseType merchandiseType;

    @Column(name = "NEL_CANTIDAD")
    private Long quantity;
}
