package com.medical.business.facade;

import com.medical.domain.dto.SpecializationDTO;
import com.medical.domain.dto.request.SpecializationRequest;

import java.util.List;

public interface SpecializationFacade {

    SpecializationDTO createSpecialization(SpecializationRequest request);

    SpecializationDTO getSpecialization(Long id) throws Exception;

    List<SpecializationDTO> getAllSpecializations();

    SpecializationDTO updateSpecialization(SpecializationRequest request, Long specializationId) throws Exception;

    void deleteSpecialization(Long id) throws Exception;

    SpecializationDTO findSpecializationByDescripcion(String specialization);

}
