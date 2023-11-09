package com.medical.domain.dto.request;

import com.medical.domain.model.MedicalBranch;
import com.medical.domain.model.Professional;
import com.medical.domain.model.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MedicalShiftRequest {

    private MedicalBranch medicalBranch;
    private User user;
    private Professional professional;
    private LocalDateTime ShiftDate;
    private String available;
    private String modality;
}
