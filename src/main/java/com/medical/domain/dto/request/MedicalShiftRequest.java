package com.medical.domain.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MedicalShiftRequest {

    private MedicalBranchRequest medicalBranch;
    private PatientRequest patient;
    private ProfessionalRequest professional;
    private LocalDateTime ShiftDate;
    private String available;
    private String modality;
}
