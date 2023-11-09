package com.medical.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PROFESSIONAL")
public class Professional implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROFESIONAL_ID", nullable = false)
    private Long id;

    @Column(name = "NOMBRE")
    private String name;

    @Column(name = "APELLIDO")
    private String lastName;

    @Column(name = "DNI")
    private Integer identificationNumber;

    @Column(name = "TELEFONO")
    private Integer phoneNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TURNO_LABORAL_ID")
    private WorkingShift workingShift;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ESPECIALIDAD_ID")
    private Specialization specialization;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "DIA_LABORAL_POR_PROFESIONAL"
            , joinColumns = {@JoinColumn(name = "DIA_LABORAL_ID")}
            , inverseJoinColumns = {@JoinColumn(name = "PROFESIONAL_ID")})
    private List<WorkingDay> workingDays;

    @Column(name = "HORAS_TRABAJADAS_POR_DIA")
    private Integer hoursPerDay;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TIEMPO_POR_CONSULTA_ID")
    private TimeConsultation timeConsultation;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SUCURSAL_ID")
    private MedicalBranch medicalBranch;



}
