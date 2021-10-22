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
@Table(name = "SLDG_TTIPO_OT")
@AttributeOverride(name = "id", column = @Column(name = "OID_TIPO_OT", unique = true, nullable = false, length = 36))
public class WorkOrderType extends BasicEntity implements Serializable {
    private static final long serialVersionUID = -1760858422377635120L;
    @Column(name = "DES_CORTA_TIPO_OT")
    private String description;
}
