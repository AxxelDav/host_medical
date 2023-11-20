package com.medical.business.service.impl;

import com.medical.business.service.ModalityService;
import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.model.Modality;
import com.medical.persistence.ModalityRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ModalityServiceImpl implements ModalityService {

    private ModalityRepository modalityRepository;

    public ModalityServiceImpl(ModalityRepository modalityRepository) {
        this.modalityRepository = modalityRepository;
    }

    @Override
    public Modality getById(Long modalityId) throws NonExistingResourceException {
        return modalityRepository.findById(modalityId).orElseThrow(() -> new NonExistingResourceException("No existe MODALIDAD con ID " + modalityId));
    }

    @Override
    public Modality create(Modality modality) throws IllegalArgumentException {
        if (Objects.isNull(modality)) {
            throw new IllegalArgumentException("Error creating MODALIDAD", "MODALIDAD can´t be null");
        }
        return modalityRepository.save(modality);
    }

    @Override
    public void update(Modality modality) throws IllegalArgumentException, NonExistingResourceException {
        if (Objects.isNull(modality)) {
            throw new IllegalArgumentException("Error: with MODALIDAD", "MODALIDAD can´t be null");
        }
        getById(modality.getId());
        modalityRepository.save(modality);
    }


    @Override
    public void delete(Long modalityId) throws NonExistingResourceException {
        getById(modalityId);
        modalityRepository.deleteById(modalityId);
    }
}
