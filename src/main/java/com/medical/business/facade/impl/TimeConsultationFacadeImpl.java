package com.medical.business.facade.impl;

import com.medical.business.facade.TimeConsultationFacade;
import com.medical.business.mapper.TimeConsultationDtoMapper;
import com.medical.business.mapper.TimeConsultationRequestMapper;
import com.medical.business.service.TimeConsultationService;
import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.dto.response.TimeConsultationResponse;
import com.medical.domain.dto.request.TimeConsultationRequest;
import com.medical.domain.model.TimeConsultation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeConsultationFacadeImpl implements TimeConsultationFacade {

    @Autowired
    private TimeConsultationRequestMapper timeConsultationRequestMapper;

    @Autowired
    private TimeConsultationDtoMapper timeConsultationDtoMapper;

    @Autowired
    private TimeConsultationService timeConsultationService;


    @Override
    public TimeConsultationResponse create(TimeConsultationRequest request) throws IllegalArgumentException {
        TimeConsultation timeConsultationToBeCreated = timeConsultationRequestMapper.toDomain(request);
        TimeConsultation timeConsultationCreated = timeConsultationService.create(timeConsultationToBeCreated);
        return timeConsultationDtoMapper.toDto(timeConsultationCreated);
    }

    @Override
    public TimeConsultationResponse findById(Long timeConsultationId) throws NonExistingResourceException {
        TimeConsultation timeConsultation = timeConsultationService.findById(timeConsultationId);
        return timeConsultationDtoMapper.toDto(timeConsultation);
    }

    @Override
    public TimeConsultationResponse update(TimeConsultationRequest request, Long timeConsultationId) throws NonExistingResourceException, IllegalArgumentException {
        TimeConsultation timeConsultationToBeUpdated = timeConsultationRequestMapper.toDomain(request);
        timeConsultationToBeUpdated.setId(timeConsultationId);
        TimeConsultation timeConsultationUpdated = timeConsultationService.update(timeConsultationToBeUpdated);
        return timeConsultationDtoMapper.toDto(timeConsultationUpdated);
    }

    @Override
    public void delete(Long id) throws NonExistingResourceException {
        timeConsultationService.delete(id);
    }
}
