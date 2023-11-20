package com.medical.business.facade.impl;

import com.medical.business.facade.SpecializationFacade;
import com.medical.business.mapper.SpecializationDtoMapper;
import com.medical.business.mapper.SpecializationRequestMapper;
import com.medical.business.service.ModalityService;
import com.medical.business.service.SpecializationService;
import com.medical.common.exception.DataInconsistencyException;
import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.dto.response.SpecializationResponse;
import com.medical.domain.dto.request.SpecializationRequest;
import com.medical.domain.model.Modality;
import com.medical.domain.model.Specialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecializationFacadeImpl implements SpecializationFacade {

    @Autowired
    private SpecializationDtoMapper specializationDtoMapper;
    @Autowired
    private SpecializationRequestMapper specializationRequestMapper;
    @Autowired
    private SpecializationService specializationService;
    @Autowired
    private ModalityService modalityService;


    @Override
    public SpecializationResponse create(SpecializationRequest request) throws IllegalArgumentException {
        Specialization specializationToBeCreated = specializationRequestMapper.toDomain(request);
        Specialization specializationCreated = specializationService.create(specializationToBeCreated);
        return specializationDtoMapper.toDto(specializationCreated);
    }

    @Override
    public SpecializationResponse findById(Long specializationId) throws NonExistingResourceException {
        Specialization specialization = specializationService.getSpecialization(specializationId);
        return specializationDtoMapper.toDto(specialization);
    }

    @Override
    public List<SpecializationResponse> findAll() {
        List<Specialization> specializations = specializationService.findAll();
        return specializationDtoMapper.toDto(specializations);
    }

    @Override
    public SpecializationResponse update(SpecializationRequest request, Long specializationId) throws NonExistingResourceException, IllegalArgumentException {
        findById(specializationId);
        Specialization specializationToBeUpdated = specializationRequestMapper.toDomain(request);
        specializationToBeUpdated.setId(specializationId);
        Specialization specializationUpdated = specializationService.updateSpecialization(specializationToBeUpdated);
        return specializationDtoMapper.toDto(specializationUpdated);
    }

    @Override
    public void deleteSpecialization(Long specializationId) throws Exception {
        specializationService.deleteSpecialization(specializationId);
    }

    @Override
    public SpecializationResponse findSpecializationByDescripcion(String specialization) throws DataInconsistencyException {
        Specialization specializationToFind = specializationService.findSpecializationByDescripcion(specialization);
        return specializationDtoMapper.toDto(specializationToFind);
    }

    @Override
    public List<SpecializationResponse> findAllSpecializationByModality(Long modalityId) throws NonExistingResourceException, DataInconsistencyException, IllegalArgumentException {
        Modality modality = modalityService.getById(modalityId);
        List<Specialization> specializations = specializationService.findAllSpecializationByModality(modality);
        return specializationDtoMapper.toDto(specializations);
    }

}
