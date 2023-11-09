package com.medical.domain.dto;

import com.medical.domain.model.*;
import lombok.Data;

import java.util.List;

@Data
public class ProfessionalDTO {

    private Long id;
    private String name;
    private String lastName;
    private Integer identificationNumber;
    private Integer phoneNumber;
    private WorkingShift workingShift;
    private Specialization specialization;
    private List<WorkingDay> workingDays;
    private Integer hoursPerDay;
    private TimeConsultation timeConsultation;
    private MedicalBranch medicalBranch;
}
