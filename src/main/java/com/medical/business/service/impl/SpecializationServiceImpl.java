package com.medical.business.service.impl;

import com.medical.business.service.SpecializationService;
import com.medical.domain.model.Specialization;
import com.medical.persistence.SpecializationRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SpecializationServiceImpl implements SpecializationService {
    
    private SpecializationRepository specializationRepository;

    public SpecializationServiceImpl(SpecializationRepository specializationRepository) {
        this.specializationRepository = specializationRepository;
    }

    @Override
    public Specialization createSpecialization(Specialization specialization) {
        return specializationRepository.save(specialization);
    }

    @Override
    public Specialization getSpecialization(Long id) throws Exception {
        return specializationRepository.findById(id).orElseThrow(() -> new Exception("No existe ESPECIALIZACION con id " + id));
    }

    public List<Specialization> getAllSpecializations() {
        return specializationRepository.findAll();
    }

    @Override
    public Specialization updateSpecialization(Specialization specialization) throws Exception {
        getSpecialization(specialization.getId());
        return specializationRepository.save(specialization);
    }

    @Override
    public void deleteSpecialization(Long id) throws Exception {
        getSpecialization(id);
        specializationRepository.deleteById(id);
    }

    @Override
    public Specialization findSpecializationByDescripcion(String specialization) {
        return specializationRepository.findSpecializationByDescripcion(specialization);
    }

}
