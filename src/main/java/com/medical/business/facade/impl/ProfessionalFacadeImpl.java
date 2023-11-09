package com.medical.business.facade.impl;

import com.medical.business.facade.ProfessionalFacade;
import com.medical.business.mapper.ProfessionalDtoMapper;
import com.medical.business.mapper.ProfessionalRequestMapper;
import com.medical.business.service.ProfessionalService;
import com.medical.domain.dto.ProfessionalDTO;
import com.medical.domain.dto.request.ProfessionalRequest;
import com.medical.domain.model.Professional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProfessionalFacadeImpl implements ProfessionalFacade {

    @Autowired
    private ProfessionalService professionalService;

    @Autowired
    private ProfessionalDtoMapper professionalDtoMapper;

    @Autowired
    private ProfessionalRequestMapper professionalRequestMapper;


    @Override
    public ProfessionalDTO getProfessionalById(Long id) {
        Professional professional = professionalService.getProfessionalById(id);
        return professionalDtoMapper.toDto(professional);
    }

    @Override
    public ProfessionalDTO createProfessional(ProfessionalRequest request) {
        Professional professionalToBeCreated = professionalRequestMapper.toDomain(request);
        Professional professionalCreated = professionalService.createProfessional(professionalToBeCreated);
        return professionalDtoMapper.toDto(professionalCreated);
    }

    @Override
    public ProfessionalDTO updateProfessional(ProfessionalRequest request) {
        Professional professionalToBeUpdated = professionalRequestMapper.toDomain(request);
        Professional professionalUpdated = professionalService.createProfessional(professionalToBeUpdated);
        return professionalDtoMapper.toDto(professionalUpdated);
    }

    @Override
    public void deleteProfessional(Long specializationId) throws Exception {

    }


    @Override
    public List<ProfessionalDTO> getAllProfesionalByWorkShiftId(Long workingShiftId) {
        List<Professional> professionals = professionalService.getAllProfessionalByWorkShiftId(workingShiftId);
        return professionalDtoMapper.toDto(professionals);
    }

    @Override
    public List<ProfessionalDTO> getAllProfesionalBySpecializationId(Long specializationId) {
        List<Professional> professionals = professionalService.getAllProfesionalBySpecializationId(specializationId);
        return professionalDtoMapper.toDto(professionals);
    }

    @Override
    public List<ProfessionalDTO> getAllProfesionalByTimeConsultationId(Long timeConsultationId) {
        List<Professional> professionals = professionalService.getAllProfesionalByTimeConsultationId(timeConsultationId);
        return professionalDtoMapper.toDto(professionals);
    }

    @Override
    public List<ProfessionalDTO> getAllProfessionalIdByWorkingdayId(Long workingDayId) {
        List<Professional> professionals = professionalService.getAllProfessionalIdByWorkingdayId(workingDayId);
        return professionalDtoMapper.toDto(professionals);
    }

    @Override
    public void updateTimeConsultation(Long professionalId, Long timeConsultationId) {
        professionalService.updateTimeConsultation(professionalId, timeConsultationId);
    }

    @Override
    public void updateSpecialization(Long professionalId, Long timeConsultationId) {
        professionalService.updateTimeConsultation(professionalId, timeConsultationId);
    }

    @Override
    public void createSchedulesForProfessional(Long professionalId, LocalDateTime registrationProfessionalDate) {
        professionalService.createSchedulesForProfessional(professionalId, registrationProfessionalDate);
    }
}
