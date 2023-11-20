package com.medical.business.facade;

import com.medical.common.exception.DataInconsistencyException;
import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.dto.request.WorkingDayRequest;
import com.medical.domain.dto.response.ProfessionalResponse;
import com.medical.domain.dto.request.ProfessionalRequest;

import java.util.List;

public interface ProfessionalFacade {

    ProfessionalResponse getById(Long professionalId) throws NonExistingResourceException;

    ProfessionalResponse create(ProfessionalRequest request) throws IllegalArgumentException;

    ProfessionalResponse update(ProfessionalRequest request, Long professionalId) throws NonExistingResourceException, IllegalArgumentException;

    void delete(Long specializationId) throws NonExistingResourceException;

    List<ProfessionalResponse> getAllProfesionalByWorkShiftId(Long workingShiftId) throws DataInconsistencyException, IllegalArgumentException;

    List<ProfessionalResponse> getAllProfesionalBySpecializationId(Long specializationId) throws DataInconsistencyException, IllegalArgumentException;

    List<ProfessionalResponse> getAllProfesionalByTimeConsultationId(Long timeConsultationId) throws DataInconsistencyException, IllegalArgumentException;

    List<ProfessionalResponse> getAllProfessionalIdByWorkingdayId(Long workingDayId) throws DataInconsistencyException, IllegalArgumentException, NonExistingResourceException;

    void addWorkingDaysToProfessional(Long professionalId, List<Long> workingDayIds) throws NonExistingResourceException;

    void updateTimeConsultationForProfessional(Long professionalId, Long timeConsultationId) throws NonExistingResourceException, IllegalArgumentException, DataInconsistencyException;

    void updateSpecializationForProfessional(Long professionalId, Long specializationId) throws NonExistingResourceException, DataInconsistencyException, IllegalArgumentException;

}
