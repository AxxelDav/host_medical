package com.medical.business.facade;

import com.medical.domain.dto.SpecializationDTO;
import com.medical.domain.dto.request.SpecializationRequest;

public interface SpecializationFacade {

    SpecializationDTO createSpecialization(SpecializationRequest request);

    SpecializationDTO getSpecialization(Long id) throws Exception;

    SpecializationDTO updateSpecialization(SpecializationRequest request) throws Exception;

    void deleteSpecialization(Long id) throws Exception;

    SpecializationDTO findSpecializationByDescripcion(String specialization);

}
