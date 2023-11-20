package com.medical.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DIA_LABORAL")
public class WorkingDay implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DIA_LABORAL_ID", nullable = false)
    private Long id;

    @Column(name = "DIA")
    private String day;

    @ManyToMany(mappedBy = "workingDays", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Professional> professionals;

}
