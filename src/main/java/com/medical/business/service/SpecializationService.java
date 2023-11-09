package com.medical.business.service;

import com.medical.domain.model.Specialization;

public interface SpecializationService {

    Specialization createSpecialization(Specialization specialization);

    Specialization getSpecialization(Long id) throws Exception;

    Specialization updateSpecialization(Specialization specialization) throws Exception;

    void deleteSpecialization(Long id) throws Exception;

    Specialization findSpecializationByDescripcion(String specialization);

}
