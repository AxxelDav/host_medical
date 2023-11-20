package com.medical.business.service;

import com.medical.common.exception.DataInconsistencyException;
import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.model.Professional;
import com.medical.domain.model.WorkingDay;

import java.util.List;

public interface ProfessionalService {

    Professional getById(Long professionalId) throws NonExistingResourceException;

    Professional create(Professional professional) throws IllegalArgumentException;

    Professional update(Professional professional) throws IllegalArgumentException;

    void delete(Long specializationId) throws NonExistingResourceException;

    List<Professional> getAllProfessionalByWorkShiftId(Long specializationId) throws DataInconsistencyException, IllegalArgumentException;

    List<Professional> getAllProfesionalBySpecializationId(Long specializationId) throws DataInconsistencyException, IllegalArgumentException;

    List<Professional> getAllProfesionalByTimeConsultationId(Long timeConsultationId) throws DataInconsistencyException, IllegalArgumentException;

    List<Professional> getAllProfessionalIdByWorkingdayId(Long workingDayId) throws DataInconsistencyException, IllegalArgumentException, NonExistingResourceException;

    void addWorkingDaysToProfessional(Long professionalId, List<Long> workingDayIds) throws NonExistingResourceException;

    void updateTimeConsultationForProfessional(Long professionalId, Long timeConsultationId) throws NonExistingResourceException, IllegalArgumentException, DataInconsistencyException;

    void updateSpecializationForProfessional(Long professionalId, Long specializationId);

}
