package com.medical.business.service;

import com.medical.domain.model.Specialization;

import java.util.List;

public interface SpecializationService {

    Specialization createSpecialization(Specialization specialization);

    List<Specialization> getAllSpecializations();

    Specialization getSpecialization(Long id) throws Exception;

    Specialization updateSpecialization(Specialization specialization) throws Exception;

    void deleteSpecialization(Long id) throws Exception;

    Specialization findSpecializationByDescripcion(String specialization);

}
