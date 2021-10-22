package com.prosegur.sol.servicebilling.view.data.model;

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
@Table(name = "SLDG_TMERCANCIA_CRM")
@AttributeOverride(name = "id", column = @Column(name = "OID_MERCANCIA_CRM", unique = true, nullable = false, length = 36))
public class MerchandiseCRM extends BasicEntity implements Serializable {

    private static final long serialVersionUID = 4296471506844857542L;
    @Column(name = "DES_MERCANCIA_CRM", unique = true, nullable = false, length = 10)
    private String description;
}
