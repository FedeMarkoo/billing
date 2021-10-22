package com.prosegur.sol.servicebilling.view.data.model;

import com.prosegur.data.model.BasicEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "SLDG_TTIPO_MERCANCIA")
@AttributeOverride(name = "id", column = @Column(name = "OID_TIPO_MERCANCIA", unique = true, nullable = false, length = 36))
public class MerchandiseType extends BasicEntity implements Serializable {

    private static final long serialVersionUID = 6542982311908477493L;
    @Column(name = "DES_TIPO_MERCANCIA", unique = true, nullable = false, length = 10)
    private String description;

    @OneToOne
    @JoinColumn(name = "OID_MERCANCIA_CRM")
    private MerchandiseCRM merchandiseCRM;

}
