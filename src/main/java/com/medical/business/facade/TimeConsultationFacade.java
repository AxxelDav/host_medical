package com.medical.business.facade;

import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.dto.response.TimeConsultationResponse;
import com.medical.domain.dto.request.TimeConsultationRequest;

public interface TimeConsultationFacade {

    TimeConsultationResponse create(TimeConsultationRequest request) throws IllegalArgumentException;

    TimeConsultationResponse findById(Long timeConsultationId) throws NonExistingResourceException;

    TimeConsultationResponse update(TimeConsultationRequest request, Long timeConsultationId) throws NonExistingResourceException, IllegalArgumentException;

    void delete(Long id) throws NonExistingResourceException;
}
