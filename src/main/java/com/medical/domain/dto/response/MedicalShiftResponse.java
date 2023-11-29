package com.medical.domain.dto.response;

import com.medical.domain.model.MedicalBranch;
import com.medical.domain.model.Professional;
import com.medical.domain.model.Patient;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MedicalShiftResponse {

    private Long id;
    private MedicalBranchResponse medicalBranch;
    private PatientResponse patient;
    private ProfessionalResponse professional;
    private LocalDateTime ShiftDate;
    private String available;
    private String modality;
}
