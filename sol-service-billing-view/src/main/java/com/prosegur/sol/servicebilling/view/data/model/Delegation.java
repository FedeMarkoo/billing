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
@Table(name = "SLDL_TDELEGACION")
@AttributeOverride(name = "id", column = @Column(name = "OID_DELEGACION", unique = true, nullable = false, length = 36))
public class Delegation extends BasicEntity implements Serializable {
    private static final long serialVersionUID = -2588851726990775789L;
    @Column(name = "COD_UNICO_DELEGACION", unique = true, nullable = false, length = 15)
    private String uniqueCode;
}
