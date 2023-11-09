package com.medical.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SUCURSAL")
public class MedicalBranch implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUCURSAL_ID", nullable = false)
    private Long id;

    @Column(name = "CALLE")
    private String street;

    @Column(name = "NUMERO")
    private Integer numberStreet;

    @Column(name = "LOCALIDAD")
    private String location;

}
