package com.medical.business.facade;

import com.medical.common.exception.DataInconsistencyException;
import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.dto.response.MedicalShiftResponse;
import com.medical.domain.dto.response.SpecializationResponse;
import com.medical.domain.dto.request.*;

import java.util.List;

public interface MedicalShiftFacade {

    MedicalShiftResponse findById(Long id) throws NonExistingResourceException;

    void createMedicalShiftForProfessional(Long professionalId, String registrationProfessionalDate) throws IllegalArgumentException, NonExistingResourceException;

    void takeMedicalShift(Long medicalShiftId, Long patientId) throws NonExistingResourceException, IllegalArgumentException;

    void cancelMedicalShift(Long medicalShiftId) throws NonExistingResourceException;

    List<MedicalShiftResponse> findAllMedicalShiftBySpecialization(String specialization) throws DataInconsistencyException, IllegalArgumentException;

    List<MedicalShiftResponse> requestMedicalShift(Long specializationId,
                                                   Long professionalId,
                                                   Long medicalBranchId,
                                                   Long workingMonthId,
                                                   Long workingShiftId,
                                                   List<Long> workingDayIds) throws DataInconsistencyException, IllegalArgumentException;

}
