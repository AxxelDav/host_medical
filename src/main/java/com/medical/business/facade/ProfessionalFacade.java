package com.medical.business.facade;

import com.medical.domain.dto.ProfessionalDTO;
import com.medical.domain.dto.request.ProfessionalRequest;

import java.time.LocalDateTime;
import java.util.List;

public interface ProfessionalFacade {

    ProfessionalDTO getProfessionalById(Long id);

    ProfessionalDTO createProfessional(ProfessionalRequest request);

    ProfessionalDTO updateProfessional(ProfessionalRequest request, Long professionalId);

    void deleteProfessional(Long specializationId) throws Exception;

    List<ProfessionalDTO> getAllProfesionalByWorkShiftId(Long workingShiftId);

    List<ProfessionalDTO> getAllProfesionalBySpecializationId(Long specializationId);

    List<ProfessionalDTO> getAllProfesionalByTimeConsultationId(Long timeConsultationId);

    List<ProfessionalDTO> getAllProfessionalIdByWorkingdayId(Long workingDayId);

    void updateTimeConsultation(Long professionalId, Long timeConsultationId);

    void updateSpecialization(Long professionalId, Long timeConsultationId);

    public void createSchedulesForProfessional(Long professionalId, LocalDateTime registrationProfessionalDate);

}
