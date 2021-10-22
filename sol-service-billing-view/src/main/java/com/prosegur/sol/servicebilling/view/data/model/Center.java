package com.prosegur.sol.servicebilling.view.data.model;

import com.prosegur.data.model.BasicEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@javax.persistence.Entity
@Table(name = "SLDL_TCENTRO")
@AttributeOverride(name = "id", column = @Column(name = "OID_CENTRO", unique = true, nullable = false, length = 36))
public class Center extends BasicEntity implements Serializable {
    private static final long serialVersionUID = 130282581898353543L;
}
