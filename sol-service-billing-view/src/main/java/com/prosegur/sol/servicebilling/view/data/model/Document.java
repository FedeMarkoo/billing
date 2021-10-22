package com.prosegur.sol.servicebilling.view.data.model;

import com.prosegur.data.model.BasicEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "SLDL_TDOCUMENTO")
@AttributeOverride(name = "id", column = @Column(name = "OID_DOCUMENTO", unique = true, nullable = false, length = 36))
public class Document extends BasicEntity implements Serializable {
    private static final long serialVersionUID = -6193893225649787645L;
    @Column(name = "COD_DOCUMENTO")
    private String code;

    @OneToMany
    @JoinColumn(name = "OID_DOCUMENTO", referencedColumnName = "OID_DOCUMENTO")
    private List<DocumentAmount> documentsAmounts;


}