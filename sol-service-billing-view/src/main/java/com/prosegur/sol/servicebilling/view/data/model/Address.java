package com.prosegur.sol.servicebilling.view.data.model;

import com.prosegur.data.model.BasicEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "SLDL_TDIRECCION")
@AttributeOverride(name = "id", column = @Column(name = "OID_DIRECCION", unique = true, nullable = false, length = 36))
public class Address extends BasicEntity implements Serializable {

	private static final long serialVersionUID = -2035687896555825089L;
	@NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OID_CIUDAD", nullable = false)
    private City city;
}
