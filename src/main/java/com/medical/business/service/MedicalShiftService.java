package com.medical.business.service;

import com.medical.common.exception.DataInconsistencyException;
import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.model.*;

import java.util.List;

public interface MedicalShiftService {

    MedicalShift getMedicalShift(Long id) throws NonExistingResourceException;

    void createMedicalShiftForProfessional(Long professionalId, String registrationProfessionalDate) throws IllegalArgumentException, NonExistingResourceException;

    void takeMedicalShift(Long medicalShiftId, Long patientId) throws NonExistingResourceException, IllegalArgumentException;

    void cancelMedicalShift(Long medicalShiftId) throws NonExistingResourceException;

    List<MedicalShift> findAllMedicalShiftBySpecialization(String specialization) throws DataInconsistencyException, IllegalArgumentException;

    public List<MedicalShift> requestMedicalShift(Long specializationId,
                                                  Long professionalId,
                                                  Long medicalBranchId,
                                                  Long workingMonthId,
                                                  Long workingShiftId,
                                                  List<Long> workingDayIds) throws DataInconsistencyException, IllegalArgumentException;
}
