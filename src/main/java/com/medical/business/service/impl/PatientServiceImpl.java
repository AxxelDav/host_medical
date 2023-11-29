package com.medical.business.service.impl;

import com.medical.business.service.PatientService;
import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.model.Patient;
import com.medical.persistence.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient findById(Long patientId) throws NonExistingResourceException {
        return patientRepository.findById(patientId).orElseThrow(() -> new NonExistingResourceException("No existe patient con ID " + patientId));
    }

    @Override
    public Patient create(Patient patient) throws IllegalArgumentException {
        if (Objects.isNull(patient)) {
            throw new IllegalArgumentException("Error creating patient", "patient can´t be null");
        }
        return patientRepository.save(patient);
    }

    @Override
    public Patient update(Patient patient) throws NonExistingResourceException, IllegalArgumentException {
        if (Objects.isNull(patient)) {
            throw new IllegalArgumentException("Error: with patient", "patient can´t be null");
        }
        findById(patient.getId());
        return patientRepository.save(patient);
    }

    @Override
    public void delete(Long patientId) throws NonExistingResourceException {
        findById(patientId);
        patientRepository.deleteById(patientId);
    }

}
