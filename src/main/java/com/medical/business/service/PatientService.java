package com.medical.business.service;

import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.model.Patient;

public interface PatientService {

    Patient findById(Long patientId) throws NonExistingResourceException;

    Patient create(Patient patient) throws IllegalArgumentException;

    Patient update(Patient patient) throws NonExistingResourceException, IllegalArgumentException;

    void delete(Long patientId) throws NonExistingResourceException;

}