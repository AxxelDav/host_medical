package com.medical.business.facade;

import com.medical.common.exception.DataInconsistencyException;
import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.dto.response.MedicalBranchResponse;
import com.medical.domain.dto.request.MedicalBranchRequest;

import java.util.List;

public interface MedicalBranchFacade {

    MedicalBranchResponse create(MedicalBranchRequest request) throws IllegalArgumentException;

    MedicalBranchResponse findById(Long id) throws NonExistingResourceException;

    MedicalBranchResponse update(MedicalBranchRequest request, Long medicalBranchId) throws NonExistingResourceException, IllegalArgumentException;

    void deleteById(Long id) throws NonExistingResourceException;

    MedicalBranchResponse findByLocaleAndNumberAndStreet(String locale, String streetNumber, String street) throws DataInconsistencyException, IllegalArgumentException;

    List<MedicalBranchResponse> findMedicalBranchBySpecializationAndProfessional(Long specializationId, Long professionalId) throws DataInconsistencyException, IllegalArgumentException;
}
