package com.medical.business.facade.impl;

import com.medical.business.facade.TimeConsultationFacade;
import com.medical.business.mapper.TimeConsultationDtoMapper;
import com.medical.business.mapper.TimeConsultationRequestMapper;
import com.medical.business.service.TimeConsultationService;
import com.medical.domain.dto.TimeConsultationDTO;
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
    public TimeConsultationDTO createTimeConsultation(TimeConsultationRequest request) {
        TimeConsultation timeConsultationToBeCreated = timeConsultationRequestMapper.toDomain(request);
        TimeConsultation timeConsultationCreated = timeConsultationService.createTimeConsultation(timeConsultationToBeCreated);
        return timeConsultationDtoMapper.toDto(timeConsultationCreated);
    }

    @Override
    public TimeConsultationDTO getTimeConsultation(Long timeConsultationId) throws Exception {
        TimeConsultation timeConsultation = timeConsultationService.getTimeConsultation(timeConsultationId);
        return timeConsultationDtoMapper.toDto(timeConsultation);
    }

    @Override
    public TimeConsultationDTO updateTimeConsultation(TimeConsultationRequest request, Long timeConsultationId) throws Exception {
        TimeConsultation timeConsultationToBeUpdated = timeConsultationRequestMapper.toDomain(request);
        timeConsultationToBeUpdated.setId(timeConsultationId);
        TimeConsultation timeConsultationUpdated = timeConsultationService.createTimeConsultation(timeConsultationToBeUpdated);
        return timeConsultationDtoMapper.toDto(timeConsultationUpdated);
    }

    @Override
    public void deleteTimeConsultation(Long id) throws Exception {
        timeConsultationService.deleteTimeConsultation(id);
    }
}
