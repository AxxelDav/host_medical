package com.medical.business.service.impl;

import com.medical.business.service.SpecializationService;
import com.medical.common.exception.DataInconsistencyException;
import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.dto.response.SpecializationResponse;
import com.medical.domain.model.Modality;
import com.medical.domain.model.Specialization;
import com.medical.persistence.SpecializationRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class SpecializationServiceImpl implements SpecializationService {
    
    private SpecializationRepository specializationRepository;

    public SpecializationServiceImpl(SpecializationRepository specializationRepository) {
        this.specializationRepository = specializationRepository;
    }

    @Override
    public Specialization create(Specialization specialization) throws IllegalArgumentException {
        if (Objects.isNull(specialization)) {
            throw new IllegalArgumentException("Error creating Specialization", "specialization can´t be null");
        }
        return specializationRepository.save(specialization);
    }

    @Override
    public Specialization getSpecialization(Long id) throws NonExistingResourceException {
        return specializationRepository.findById(id).orElseThrow(() -> new NonExistingResourceException("No existe ESPECIALIZACION con id " + id));
    }

    @Override
    public List<Specialization> findAll() {
        return specializationRepository.findAll();
    }

    @Override
    public Specialization updateSpecialization(Specialization specialization) throws NonExistingResourceException, IllegalArgumentException {
        if (Objects.isNull(specialization)) {
            throw new IllegalArgumentException("Error: with specialization", "Specialization can´t be null");
        }
        return specializationRepository.save(specialization);
    }

    @Override
    public void deleteSpecialization(Long id) throws Exception {
        getSpecialization(id);
        specializationRepository.deleteById(id);
    }

    @Override
    public Specialization findSpecializationByDescripcion(String specialization) throws DataInconsistencyException {
        try {
            return specializationRepository.findSpecializationByDescripcion(specialization);
        } catch (DataAccessException ex) {
            throw new DataInconsistencyException("Error executing query in database", ex);
        }
    }

    @Override
    public List<Specialization> findAllSpecializationByModality(Modality modality) throws IllegalArgumentException, DataInconsistencyException {
        if (Objects.isNull(modality)) {
            throw new IllegalArgumentException("Error modality can´t be null", "modality can´t be null");
        }
        try {
            return specializationRepository.findAllSpecializationByModality(modality.getId());
        } catch (DataAccessException ex) {
            throw new DataInconsistencyException("Error executing query in database", ex);
        }
    }

}
