package com.medical.business.service;

import com.medical.domain.model.Professional;

import java.time.LocalDateTime;
import java.util.List;

public interface ProfessionalService {

    //TODO hacer un CRUD de Professional

    Professional getProfessionalById(Long id);

    List<Professional> getAllProfessionalByWorkShiftId(Long specializationId);

    List<Professional> getAllProfesionalBySpecializationId(Long specializationId);

    List<Professional> getAllProfesionalByTimeConsultationId(Long timeConsultationId);

    List<Professional> getAllProfessionalIdByWorkingdayId(Long workingDayId);

    void updateTimeConsultation(Long professionalId, Long timeConsultationId); //TIENE SENTIDO??

    void updateSpecialization(Long professionalId, Long timeConsultationId); //TIENE SENTIDO??

    public void createSchedulesForProfessional(Long professionalId, LocalDateTime registrationProfessionalDate); //Se podria pasar directamente el objeto Professional, y dentro del metodo desempaquetar la informacion que necesites (pensa si te conviene)
}
