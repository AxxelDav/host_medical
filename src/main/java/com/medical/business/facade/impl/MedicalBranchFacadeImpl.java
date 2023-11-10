package com.medical.business.facade.impl;

import com.medical.business.facade.MedicalBranchFacade;
import com.medical.business.mapper.MedicalBranchDtoMapper;
import com.medical.business.mapper.MedicalBranchRequestMapper;
import com.medical.business.service.MedicalBranchService;
import com.medical.domain.dto.MedicalBranchDTO;
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
    public MedicalBranchDTO createMedicalBranch(MedicalBranchRequest request) {
        MedicalBranch medicalBranchToBeCreate = medicalBranchRequestMapper.toDomain(request);
        MedicalBranch medicalBranchCreated = medicalBranchService.createMedicalBranch(medicalBranchToBeCreate);
        return medicalBranchDtoMapper.toDto(medicalBranchCreated);
    }

    @Override
    public MedicalBranchDTO getMedicalBranch(Long medicalBranchId) throws Exception {
        MedicalBranch medicalBranch = medicalBranchService.getMedicalBranch(medicalBranchId);
        return medicalBranchDtoMapper.toDto(medicalBranch);
    }

    @Override
    public MedicalBranchDTO updateMedicalBranch(MedicalBranchRequest request, Long medicalBranchId) throws Exception {
        MedicalBranch medicalBranchToBeUpdate = medicalBranchRequestMapper.toDomain(request);
        medicalBranchToBeUpdate.setId(medicalBranchId);
        MedicalBranch medicalBranchUpdated = medicalBranchService.updateMedicalBranch(medicalBranchToBeUpdate);
        return medicalBranchDtoMapper.toDto(medicalBranchUpdated);
    }

    @Override
    public void deleteMedicalBranch(Long id) throws Exception {
        medicalBranchService.deleteMedicalBranch(id);
    }

    @Override
    public MedicalBranchDTO findByLocaleAndNumberAndStreet(String locale, String streetNumber, String street) {
        MedicalBranch medicalBranch = medicalBranchService.findByLocaleAndNumberAndStreet(locale, streetNumber, street);
        return medicalBranchDtoMapper.toDto(medicalBranch);
    }

    @Override
    public List<MedicalBranchDTO> findMedicalBranchBySpecializationAndProfessional(Long specializationId, Long professionalId) {
        List<MedicalBranch> medicalBranches = medicalBranchService.findMedicalBranchBySpecializationAndProfessional(specializationId, professionalId);
        return medicalBranchDtoMapper.toDto(medicalBranches);
    }
}
