package com.prosegur.sol.servicebilling.view.data.model;

import com.prosegur.data.model.BasicEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "SLDL_TDOCUMENTO_IMPORTE")
@AttributeOverride(name = "id", column = @Column(name = "OID_DOCUMENTO_IMPORTE", unique = true, nullable = false, length = 36))
public class DocumentAmount extends BasicEntity implements Serializable {
    private static final long serialVersionUID = 7363707307944197770L;
    @Column(name = "NUM_DOCUMENTO_IMPORTE")
    private Double value;

    @OneToOne
    @JoinColumn(name = "OID_DIVISA", referencedColumnName = "OID_DIVISA")
    private Currency currency;

    @OneToOne
    @JoinColumn(name = "OID_TIPO_MERCANCIA", insertable = false, updatable = false)
    private MerchandiseType merchandiseType;


}
