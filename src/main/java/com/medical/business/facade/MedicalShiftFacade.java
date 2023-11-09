package com.medical.business.facade;

import com.medical.domain.dto.MedicalShiftDTO;
import com.medical.domain.dto.SpecializationDTO;
import com.medical.domain.dto.request.*;

import java.time.LocalDateTime;
import java.util.List;

public interface MedicalShiftFacade {

    MedicalShiftDTO getMedicalShift(Long id) throws Exception;

    void createSchedules(LocalDateTime registrationProfessionalDate, ProfessionalRequest request);

    void takeMedicalShift(Long medicalShiftId, UserRequest request) throws Exception;

    void cancelMedicalShift(Long medicalShiftId) throws Exception;

    List<MedicalShiftDTO> findAllForProfessionalBySpecialization(SpecializationRequest request);

    List<SpecializationDTO> findAllSpecializationByModality(ModalityRequest request);

    public List<MedicalShiftDTO> requestMedicalShift(SpecializationRequest specializationRequest, ProfessionalRequest professionalRequest, MedicalBranchRequest medicalBranchRequest, WorkingMonthRequest workingMonthRequest, List<WorkingDayRequest> workingDayRequests, WorkingShiftRequest workingShiftRequest);

}
