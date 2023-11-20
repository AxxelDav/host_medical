package com.medical.domain.dto.request;

import com.medical.domain.model.MedicalBranch;
import com.medical.domain.model.Professional;
import com.medical.domain.model.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MedicalShiftRequest {

    private MedicalBranchRequest medicalBranch;
    private UserRequest user;
    private ProfessionalRequest professional;
    private LocalDateTime ShiftDate;
    private String available;
    private String modality;
}
