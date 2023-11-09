package com.medical.business.service;

import com.medical.domain.model.MedicalBranch;

import java.util.List;

public interface MedicalBranchService {

    MedicalBranch createMedicalBranch(MedicalBranch medicalBranch);

    MedicalBranch getMedicalBranch(Long id) throws Exception;

    MedicalBranch updateMedicalBranch(MedicalBranch medicalBranch) throws Exception;

    void deleteMedicalBranch(Long id) throws Exception;

    MedicalBranch findByLocaleAndNumberAndStreet(String locale, String streetNumber, String street);

    List<MedicalBranch> findMedicalBranchBySpecializationAndProfessional(Long specializationId, Long professionalId);

}
