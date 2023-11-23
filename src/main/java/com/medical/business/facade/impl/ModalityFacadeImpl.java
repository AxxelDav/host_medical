package com.medical.business.facade.impl;

import com.medical.business.facade.ModalityFacade;
import com.medical.business.mapper.ModalityDtoMapper;
import com.medical.business.mapper.ModalityRequestMapper;
import com.medical.business.service.ModalityService;
import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.dto.request.ModalityRequest;
import com.medical.domain.dto.response.ModalityResponse;
import com.medical.domain.model.Modality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModalityFacadeImpl implements ModalityFacade {

    @Autowired
    private ModalityDtoMapper modalityDtoMapper;

    @Autowired
    private ModalityRequestMapper modalityRequestMapper;

    @Autowired
    private ModalityService modalityService;

    @Override
    public ModalityResponse findById(Long modalityId) throws NonExistingResourceException {
        Modality modality = modalityService.getById(modalityId);
        return modalityDtoMapper.toDto(modality);
    }

    @Override
    public ModalityResponse create(ModalityRequest request) throws IllegalArgumentException {
        Modality modalityToBeCreated = modalityRequestMapper.toDomain(request);
        Modality modalityCreated = modalityService.create(modalityToBeCreated);
        return modalityDtoMapper.toDto(modalityCreated);
    }

    @Override
    public ModalityResponse update(ModalityRequest request, Long modalityId) throws NonExistingResourceException, IllegalArgumentException {
        Modality modalityToBeUpdated = modalityRequestMapper.toDomain(request);
        modalityToBeUpdated.setId(modalityId);
        Modality modalityUpdated = modalityService.update(modalityToBeUpdated);
        return modalityDtoMapper.toDto(modalityUpdated);
    }

    @Override
    public void delete(Long modalityId) throws NonExistingResourceException {
        modalityService.delete(modalityId);
    }
}