package com.prosegur.sol.servicebilling.view.data.model;

import com.prosegur.data.model.BasicEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "SLDL_TPARADA_OPERATIVA")
@AttributeOverride(name = "id", column = @Column(name = "OID_PARADA_OPERATIVA", unique = true, nullable = false, length = 36))
public class ServicePointStop extends BasicEntity implements Serializable {
    private static final long serialVersionUID = -4845950424632720584L;

    @Column(name = "FYH_INICIO_PARADA_OPERATIVA")
    private LocalDateTime stopStartDatetime;

    @Column(name = "FYH_FIN_PARADA_OPERATIVA")
    private LocalDateTime stopEndDatetime;


}