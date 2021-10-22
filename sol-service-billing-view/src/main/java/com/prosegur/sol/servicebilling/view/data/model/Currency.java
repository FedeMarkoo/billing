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
@Table(name = "SLDG_TDIVISA")
@AttributeOverride(name = "id", column = @Column(name = "OID_DIVISA", unique = true, nullable = false, length = 36))
public class Currency extends BasicEntity implements Serializable {
    private static final long serialVersionUID = 7027511491214338304L;
    @Column(name = "COD_ISO")
    private String isoCode;
}
