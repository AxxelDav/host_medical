package com.medical.business.facade;

import com.medical.common.exception.DataInconsistencyException;
import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.dto.response.SpecializationResponse;
import com.medical.domain.dto.request.SpecializationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface SpecializationFacade {

    SpecializationResponse create(SpecializationRequest request) throws IllegalArgumentException;

    SpecializationResponse findById(Long specializationId) throws NonExistingResourceException;

    List<SpecializationResponse> findAll();

    SpecializationResponse update(SpecializationRequest request, Long specializationId) throws NonExistingResourceException, IllegalArgumentException;

    void deleteSpecialization(Long id) throws Exception;

    SpecializationResponse findSpecializationByDescripcion(String specialization) throws DataInconsistencyException;

    List<SpecializationResponse> findAllSpecializationByModality(Long modalityId) throws NonExistingResourceException, DataInconsistencyException, IllegalArgumentException;

}
