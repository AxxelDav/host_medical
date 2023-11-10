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
@Table(name = "ESPECIALIDAD")
public class Specialization implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ESPECIALIDAD_ID", nullable = false)
    private Long id;

    @Column(name = "DESCRIPCION")
    private String description;

    @ManyToOne
    @JoinColumn(name = "MODALIDAD_ID")
    private Modality modality;

}
