package com.medical.business.facade;

import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.dto.response.PatientResponse;
import com.medical.domain.dto.request.PatientRequest;

public interface PatientFacade {

    PatientResponse findById(Long patientId) throws NonExistingResourceException;

    PatientResponse create(PatientRequest request) throws IllegalArgumentException;

    PatientResponse update(PatientRequest request, Long patientId) throws NonExistingResourceException, IllegalArgumentException;

    void delete(Long patientId) throws NonExistingResourceException;

}
