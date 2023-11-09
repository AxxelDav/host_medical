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
@Table(name = "TURNO_LABORAL")
public class WorkingShift implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TURNO_LABORAL_ID", nullable = false)
    private Long id;

    @Column(name = "TURNO")
    private String description;

    @Column(name = "HORARIO_ENTRADA")
    private Integer entryHour;
}
