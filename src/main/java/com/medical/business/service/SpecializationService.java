package com.medical.business.service;

import com.medical.common.exception.DataInconsistencyException;
import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.dto.response.SpecializationResponse;
import com.medical.domain.model.Modality;
import com.medical.domain.model.Specialization;

import java.util.List;

public interface SpecializationService {

    Specialization create(Specialization specialization) throws IllegalArgumentException;

    List<Specialization> findAll();

    Specialization getSpecialization(Long id) throws NonExistingResourceException;

    Specialization updateSpecialization(Specialization specialization) throws NonExistingResourceException, IllegalArgumentException;

    void deleteSpecialization(Long id) throws Exception;

    Specialization findSpecializationByDescripcion(String specialization) throws DataInconsistencyException;

    List<Specialization> findAllSpecializationByModality(Modality modality) throws IllegalArgumentException, DataInconsistencyException;

}
