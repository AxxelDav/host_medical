package com.medical.business.facade.impl;

import com.medical.business.facade.PatientFacade;
import com.medical.business.mapper.PatientDtoMapper;
import com.medical.business.mapper.PatientRequestMapper;
import com.medical.business.service.PatientService;
import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.dto.response.PatientResponse;
import com.medical.domain.dto.request.PatientRequest;
import com.medical.domain.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientFacadeImpl implements PatientFacade {

    @Autowired
    private PatientDtoMapper patientDtoMapper;

    @Autowired
    private PatientRequestMapper patientRequestMapper;

    @Autowired
    private PatientService patientService;


    @Override
    public PatientResponse findById(Long patientId) throws NonExistingResourceException {
        Patient patient = patientService.findById(patientId);
        return patientDtoMapper.toDto(patient);
    }

    @Override
    public PatientResponse create(PatientRequest request) throws IllegalArgumentException  {
        Patient patientToBeCreated = patientRequestMapper.toDomain(request);
        Patient patientCreated = patientService.create(patientToBeCreated);
        return patientDtoMapper.toDto(patientCreated);
    }

    @Override
    public PatientResponse update(PatientRequest request, Long patientId) throws NonExistingResourceException, IllegalArgumentException {
        Patient patientToBeUpdated = patientRequestMapper.toDomain(request);
        patientToBeUpdated.setId(patientId);
        Patient patientUpdated = patientService.update(patientToBeUpdated);
        return patientDtoMapper.toDto(patientUpdated);
    }

    @Override
    public void delete(Long patientId) throws NonExistingResourceException {
        patientService.delete(patientId);
    }
}
