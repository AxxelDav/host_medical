package com.medical.domain.dto.request;

import com.medical.domain.model.*;
import lombok.Data;

import java.util.List;

@Data
public class ProfessionalRequest {

    private String name;
    private String lastName;
    private Integer identificationNumber;
    private Integer phoneNumber;
    private WorkingShiftRequest workingShift;
    private SpecializationRequest specialization;
    private List<WorkingDayRequest> workingDays;
    private Integer hoursPerDay;
    private TimeConsultationRequest timeConsultation;
    private MedicalBranchRequest medicalBranch;
    private ModalityRequest modality;
}
