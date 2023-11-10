package com.medical.business.facade.impl;

import com.medical.business.facade.SpecializationFacade;
import com.medical.business.mapper.SpecializationDtoMapper;
import com.medical.business.mapper.SpecializationRequestMapper;
import com.medical.business.service.SpecializationService;
import com.medical.domain.dto.SpecializationDTO;
import com.medical.domain.dto.request.SpecializationRequest;
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


    @Override
    public SpecializationDTO createSpecialization(SpecializationRequest request) {
        Specialization specializationToBeCreated = specializationRequestMapper.toDomain(request);
        Specialization specializationCreated = specializationService.createSpecialization(specializationToBeCreated);
        return specializationDtoMapper.toDto(specializationCreated);
    }

    @Override
    public SpecializationDTO getSpecialization(Long id) throws Exception {
        Specialization specialization = specializationService.getSpecialization(id);
        return specializationDtoMapper.toDto(specialization);
    }

    @Override
    public List<SpecializationDTO> getAllSpecializations() {
        List<Specialization> specializations = specializationService.getAllSpecializations();
        return specializationDtoMapper.toDto(specializations);
    }

    @Override
    public SpecializationDTO updateSpecialization(SpecializationRequest request, Long specializationId) throws Exception {
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
    public SpecializationDTO findSpecializationByDescripcion(String specialization) {
        Specialization specializationToFind = specializationService.findSpecializationByDescripcion(specialization);
        return specializationDtoMapper.toDto(specializationToFind);
    }
}
