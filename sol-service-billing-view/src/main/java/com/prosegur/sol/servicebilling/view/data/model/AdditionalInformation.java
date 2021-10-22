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
@Table(name = "SLDL_TINFORMACION_ADICIONAL")
@AttributeOverride(name = "id", column = @Column(name = "OID_INFORMACION_ADICIONAL", unique = true, nullable = false, length = 36))
public class AdditionalInformation extends BasicEntity implements Serializable {
    private static final long serialVersionUID = -8983177228309577868L;

    @Column(name = "DES_TIPO_ADICIONAL")
    private String type;

    @Column(name = "JSON")
    private String json;

}


