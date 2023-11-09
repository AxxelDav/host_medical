package com.medical.business.facade;

import com.medical.domain.dto.MedicalBranchDTO;
import com.medical.domain.dto.request.MedicalBranchRequest;

import java.util.List;

public interface MedicalBranchFacade {

    MedicalBranchDTO createMedicalBranch(MedicalBranchRequest request);

    MedicalBranchDTO getMedicalBranch(Long id) throws Exception;

    MedicalBranchDTO updateMedicalBranch(MedicalBranchRequest request) throws Exception;

    void deleteMedicalBranch(Long id) throws Exception;

    MedicalBranchDTO findByLocaleAndNumberAndStreet(String locale, String streetNumber, String street);

    List<MedicalBranchDTO> findMedicalBranchBySpecializationAndProfessional(Long specializationId, Long professionalId);
}
