package com.medical.business.service;

import com.medical.domain.model.*;

import java.time.LocalDateTime;
import java.util.List;

public interface MedicalShiftService {

    MedicalShift getMedicalShift(Long id) throws Exception;

    void createSchedules(LocalDateTime registrationProfessionalDate, Professional professional);

    void takeMedicalShift(Long medicalShiftId, User user) throws Exception;

    void cancelMedicalShift(Long medicalShiftId) throws Exception;

    List<MedicalShift> findAllForProfessionalBySpecialization(Specialization specialization);

    List<Specialization> findAllSpecializationByModality(Modality modality);

    public List<MedicalShift> requestMedicalShift(Specialization specialization, Professional professional, MedicalBranch medicalBranch, WorkingMonth workingMonth, List<WorkingDay> workingDays, WorkingShift workingShift);
}
