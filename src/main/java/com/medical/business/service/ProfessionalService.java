package com.medical.business.service;

import com.medical.domain.model.Professional;

import java.time.LocalDateTime;
import java.util.List;

public interface ProfessionalService {

    Professional getProfessionalById(Long id);

    Professional createProfessional(Professional professional);

    Professional updateProfessional(Professional professional);

    void deleteProfessional(Long specializationId) throws Exception;

    List<Professional> getAllProfessionalByWorkShiftId(Long specializationId);

    List<Professional> getAllProfesionalBySpecializationId(Long specializationId);

    List<Professional> getAllProfesionalByTimeConsultationId(Long timeConsultationId);

    List<Professional> getAllProfessionalIdByWorkingdayId(Long workingDayId);

    void updateTimeConsultation(Long professionalId, Long timeConsultationId);

    void updateSpecialization(Long professionalId, Long timeConsultationId);

    public void createSchedulesForProfessional(Long professionalId, LocalDateTime registrationProfessionalDate);
}
