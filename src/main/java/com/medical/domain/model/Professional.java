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

    @ManyToOne
    @JoinColumn(name = "TURNO_LABORAL_ID")
    private WorkingShift workingShift;

    @ManyToOne
    @JoinColumn(name = "ESPECIALIDAD_ID")
    private Specialization specialization;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "DIA_LABORAL_POR_PROFESIONAL"
            , joinColumns = {@JoinColumn(name = "DIA_LABORAL_ID")}
            , inverseJoinColumns = {@JoinColumn(name = "PROFESIONAL_ID")})
    private List<WorkingDay> workingDays;

    @Column(name = "HORAS_TRABAJADAS_POR_DIA")
    private Integer hoursPerDay;

    @ManyToOne
    @JoinColumn(name = "TIEMPO_POR_CONSULTA_ID")
    private TimeConsultation timeConsultation;

    @ManyToOne
    @JoinColumn(name = "SUCURSAL_ID")
    private MedicalBranch medicalBranch;

    @ManyToOne
    @JoinColumn(name = "MODALIDAD_ID")
    private Modality modality;



    @Override
    public String toString() {
        return "Professional{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", identificationNumber=" + identificationNumber +
                ", phoneNumber=" + phoneNumber +
                ", workingShift=" + (workingShift != null ? workingShift.getId() : null) +
                ", specialization=" + (specialization != null ? specialization.getId() : null) +
                ", workingDays=" + workingDays.stream().map(WorkingDay::getId).toList() +
                ", hoursPerDay=" + hoursPerDay +
                ", timeConsultation=" + (timeConsultation != null ? timeConsultation.getId() : null) +
                ", medicalBranch=" + (medicalBranch != null ? medicalBranch.getId() : null) +
                ", modality=" + (modality != null ? modality.getId() : null) +
                '}';
    }


}
