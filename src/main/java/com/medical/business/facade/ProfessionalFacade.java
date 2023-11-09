package com.medical.business.facade;

import com.medical.domain.dto.ProfessionalDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface ProfessionalFacade {

    ProfessionalDTO getProfessionalById(Long id);

    List<ProfessionalDTO> getAllProfesionalByWorkShiftId(Long workingShiftId);

    List<ProfessionalDTO> getAllProfesionalBySpecializationId(Long specializationId);

    List<ProfessionalDTO> getAllProfesionalByTimeConsultationId(Long timeConsultationId);

    List<ProfessionalDTO> getAllProfessionalIdByWorkingdayId(Long workingDayId);

    void updateTimeConsultation(Long professionalId, Long timeConsultationId); //TIENE SENTIDO??

    void updateSpecialization(Long professionalId, Long timeConsultationId); //TIENE SENTIDO??

    public void createSchedulesForProfessional(Long professionalId, LocalDateTime registrationProfessionalDate); //Se podria pasar directamente el objeto Professional, y dentro del metodo desempaquetar la informacion que necesites (pensa si te conviene)

}
