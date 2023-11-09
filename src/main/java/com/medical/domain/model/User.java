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
@Table(name = "USUARIO")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USUARIO_ID", nullable = false)
    private Long id;

    @Column(name = "NOMBRE")
    private String name;

    @Column(name = "APELLIDO")
    private String lastName;

    @Column(name = "DNI")
    private Integer identificationNumber;

    @Column(name = "TELEFONO")
    private String phoneNumber;
}
