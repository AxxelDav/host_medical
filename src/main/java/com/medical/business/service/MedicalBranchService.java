package com.medical.business.service;

import com.medical.common.exception.DataInconsistencyException;
import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.model.MedicalBranch;

import java.util.List;

public interface MedicalBranchService {

    MedicalBranch create(MedicalBranch medicalBranch) throws IllegalArgumentException;

    MedicalBranch getMedicalBranch(Long id) throws NonExistingResourceException;

    MedicalBranch updateMedicalBranch(MedicalBranch medicalBranch) throws NonExistingResourceException, IllegalArgumentException;

    void deleteMedicalBranch(Long id) throws NonExistingResourceException;

    MedicalBranch findByLocaleAndNumberAndStreet(String locale, String streetNumber, String street) throws DataInconsistencyException, IllegalArgumentException;

    List<MedicalBranch> findMedicalBranchBySpecialization(Long specializationId) throws IllegalArgumentException, DataInconsistencyException;

    List<MedicalBranch> findMedicalBranchByProfessional(Long professionalId) throws IllegalArgumentException, DataInconsistencyException;


}
