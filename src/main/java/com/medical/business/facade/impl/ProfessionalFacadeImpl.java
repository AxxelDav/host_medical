package com.medical.business.facade.impl;

import com.medical.business.facade.ProfessionalFacade;
import com.medical.business.mapper.ProfessionalDtoMapper;
import com.medical.business.mapper.ProfessionalRequestMapper;
import com.medical.business.mapper.WorkingDayRequestMapper;
import com.medical.business.service.ProfessionalService;
import com.medical.common.exception.DataInconsistencyException;
import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.dto.request.WorkingDayRequest;
import com.medical.domain.dto.response.ProfessionalResponse;
import com.medical.domain.dto.request.ProfessionalRequest;
import com.medical.domain.model.Professional;
import com.medical.domain.model.WorkingDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionalFacadeImpl implements ProfessionalFacade {

    @Autowired
    private ProfessionalService professionalService;

    @Autowired
    private ProfessionalDtoMapper professionalDtoMapper;

    @Autowired
    private ProfessionalRequestMapper professionalRequestMapper;

    @Autowired
    private WorkingDayRequestMapper workingDayRequestMapper;


    @Override
    public ProfessionalResponse getById(Long professionalId) throws NonExistingResourceException {
        Professional professional = professionalService.getById(professionalId);
        return professionalDtoMapper.toDto(professional);
    }

    @Override
    public ProfessionalResponse create(ProfessionalRequest request) throws IllegalArgumentException {
        Professional professionalToBeCreated = professionalRequestMapper.toDomain(request);
        Professional professionalCreated = professionalService.create(professionalToBeCreated);
        return professionalDtoMapper.toDto(professionalCreated);
    }

    @Override
    public ProfessionalResponse update(ProfessionalRequest request, Long professionalId) throws NonExistingResourceException, IllegalArgumentException {
        getById(professionalId);
        Professional professionalToBeUpdated = professionalRequestMapper.toDomain(request);
        professionalToBeUpdated.setId(professionalId);
        Professional professionalUpdated = professionalService.update(professionalToBeUpdated);
        return professionalDtoMapper.toDto(professionalUpdated);
    }

    @Override
    public void delete(Long specializationId) throws NonExistingResourceException {
        professionalService.delete(specializationId);
    }


    @Override
    public List<ProfessionalResponse> getAllProfesionalByWorkShiftId(Long workingShiftId) throws DataInconsistencyException, IllegalArgumentException {
        List<Professional> professionals = professionalService.getAllProfessionalByWorkShiftId(workingShiftId);
        return professionalDtoMapper.toDto(professionals);
    }

    @Override
    public List<ProfessionalResponse> getAllProfesionalBySpecializationId(Long specializationId) throws DataInconsistencyException, IllegalArgumentException {
        List<Professional> professionals = professionalService.getAllProfesionalBySpecializationId(specializationId);
        return professionalDtoMapper.toDto(professionals);
    }

    @Override
    public List<ProfessionalResponse> getAllProfesionalByTimeConsultationId(Long timeConsultationId) throws DataInconsistencyException, IllegalArgumentException {
        List<Professional> professionals = professionalService.getAllProfesionalByTimeConsultationId(timeConsultationId);
        return professionalDtoMapper.toDto(professionals);
    }

    @Override
    public List<ProfessionalResponse> getAllProfessionalIdByWorkingdayId(Long workingDayId) throws DataInconsistencyException, IllegalArgumentException, NonExistingResourceException {
        List<Professional> professionals = professionalService.getAllProfessionalIdByWorkingdayId(workingDayId);
        return professionalDtoMapper.toDto(professionals);
    }

    @Override
    public void addWorkingDaysToProfessional(Long professionalId, List<Long> workingDayIds) throws NonExistingResourceException {
        professionalService.addWorkingDaysToProfessional(professionalId, workingDayIds);
    }

    @Override
    public void updateTimeConsultationForProfessional(Long professionalId, Long timeConsultationId) throws NonExistingResourceException, IllegalArgumentException, DataInconsistencyException {
        professionalService.updateTimeConsultationForProfessional(professionalId, timeConsultationId);
    }

    @Override
    public void updateSpecializationForProfessional(Long professionalId, Long specializationId) throws NonExistingResourceException, DataInconsistencyException, IllegalArgumentException {
        professionalService.updateSpecializationForProfessional(professionalId, specializationId);
    }
}
