package com.medical.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TURNO_MEDICO")
public class MedicalShift implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TURNO_MEDICO_ID", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SUCURSAL_ID")
    private MedicalBranch medicalBranch;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USUARIO_ID", nullable = true)
    private Patient patient;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PROFESIONAL_ID")
    private Professional professional;

    @Column(name = "FECHA")
    private LocalDateTime ShiftDate;

    @Column(name = "DISPONIBLE")
    private String available;

    @Column(name = "MODALIDAD")
    private String modality;

}
