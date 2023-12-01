package com.medical.business.facade.impl;

import com.medical.business.facade.MedicalBranchFacade;
import com.medical.business.mapper.MedicalBranchDtoMapper;
import com.medical.business.mapper.MedicalBranchRequestMapper;
import com.medical.business.service.MedicalBranchService;
import com.medical.common.exception.DataInconsistencyException;
import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.dto.response.MedicalBranchResponse;
import com.medical.domain.dto.request.MedicalBranchRequest;
import com.medical.domain.model.MedicalBranch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalBranchFacadeImpl implements MedicalBranchFacade {

    @Autowired
    private MedicalBranchService medicalBranchService;

    @Autowired
    private MedicalBranchDtoMapper medicalBranchDtoMapper;

    @Autowired
    private MedicalBranchRequestMapper medicalBranchRequestMapper;



    @Override
    public MedicalBranchResponse create(MedicalBranchRequest request) throws IllegalArgumentException {
        MedicalBranch medicalBranchToBeCreate = medicalBranchRequestMapper.toDomain(request);
        MedicalBranch medicalBranchCreated = medicalBranchService.create(medicalBranchToBeCreate);
        return medicalBranchDtoMapper.toDto(medicalBranchCreated);
    }

    @Override
    public MedicalBranchResponse findById(Long medicalBranchId) throws NonExistingResourceException {
        MedicalBranch medicalBranch = medicalBranchService.getMedicalBranch(medicalBranchId);
        return medicalBranchDtoMapper.toDto(medicalBranch);
    }

    @Override
    public MedicalBranchResponse update(MedicalBranchRequest request, Long medicalBranchId) throws NonExistingResourceException, IllegalArgumentException {
        findById(medicalBranchId);
        MedicalBranch medicalBranchToBeUpdate = medicalBranchRequestMapper.toDomain(request);
        medicalBranchToBeUpdate.setId(medicalBranchId);
        MedicalBranch medicalBranchUpdated = medicalBranchService.updateMedicalBranch(medicalBranchToBeUpdate);
        return medicalBranchDtoMapper.toDto(medicalBranchUpdated);
    }

    @Override
    public void deleteById(Long id) throws NonExistingResourceException {
        medicalBranchService.deleteMedicalBranch(id);
    }

    @Override
    public MedicalBranchResponse findByLocaleAndNumberAndStreet(String locale, String streetNumber, String street) throws DataInconsistencyException, IllegalArgumentException {
        MedicalBranch medicalBranch = medicalBranchService.findByLocaleAndNumberAndStreet(locale, streetNumber, street);
        return medicalBranchDtoMapper.toDto(medicalBranch);
    }

    @Override
    public List<MedicalBranchResponse> findMedicalBranchBySpecializationAndProfessional(Long specializationId) throws DataInconsistencyException, IllegalArgumentException {
        List<MedicalBranch> medicalBranches = medicalBranchService.findMedicalBranchBySpecializationAndProfessional(specializationId);
        return medicalBranchDtoMapper.toDto(medicalBranches);
    }
}
