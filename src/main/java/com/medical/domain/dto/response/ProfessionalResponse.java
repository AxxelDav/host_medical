package com.medical.domain.dto.response;

import com.medical.domain.model.*;
import lombok.Data;

import java.util.List;

@Data
public class ProfessionalResponse {

    private Long id;
    private String name;
    private String lastName;
    private Integer identificationNumber;
    private Integer phoneNumber;
    private WorkingShiftResponse workingShift;
    private SpecializationResponse specialization;
    private List<WorkingDayResponse> workingDays;
    private Integer hoursPerDay;
    private TimeConsultationResponse timeConsultation;
    private MedicalBranchResponse medicalBranch;
    private ModalityResponse modality;
}
