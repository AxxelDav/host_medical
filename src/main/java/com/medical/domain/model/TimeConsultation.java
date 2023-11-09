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
@Table(name = "TIEMPO_POR_CONSULTA")
public class TimeConsultation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TIEMPO_POR_CONSULTA_ID", nullable = false)
    private Long id;

    @Column(name = "MINUTOS")
    private Integer minutes;
}
