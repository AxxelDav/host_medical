package com.medical.business.facade;

import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.dto.request.ModalityRequest;
import com.medical.domain.dto.response.ModalityResponse;

public interface ModalityFacade {

    ModalityResponse findById(Long modalityId) throws NonExistingResourceException;

    ModalityResponse create(ModalityRequest request) throws IllegalArgumentException;

    ModalityResponse update(ModalityRequest request, Long modalityId) throws NonExistingResourceException, IllegalArgumentException;

    void delete(Long modalityId) throws NonExistingResourceException;
}
