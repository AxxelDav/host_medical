package com.medical.business.service.impl;

import com.medical.business.service.TimeConsultationService;
import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.model.TimeConsultation;
import com.medical.persistence.TimeConsultationRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TimeConsultationServiceImpl implements TimeConsultationService {

    private TimeConsultationRepository timeConsultationRepository;

    public TimeConsultationServiceImpl(TimeConsultationRepository timeConsultationRepository) {
        this.timeConsultationRepository = timeConsultationRepository;
    }

    @Override
    public TimeConsultation create(TimeConsultation timeConsultation) throws IllegalArgumentException {
        if (Objects.isNull(timeConsultation)) {
            throw new IllegalArgumentException("Error creating timeConsultation", "TimeConsultation can´t be null");
        }
        return timeConsultationRepository.save(timeConsultation);
    }

    @Override
    public TimeConsultation findById(Long id) throws NonExistingResourceException {
        return timeConsultationRepository.findById(id).orElseThrow(() -> new NonExistingResourceException("No existe TIEMPO_POR_CONSULTA con id " + id));
    }

    @Override
    public TimeConsultation update(TimeConsultation timeConsultation) throws NonExistingResourceException, IllegalArgumentException {
        if (Objects.isNull(timeConsultation)) {
            throw new IllegalArgumentException("Error: with timeConsultation", "TimeConsultation can´t be null");
        }
        findById(timeConsultation.getId());
        return timeConsultationRepository.save(timeConsultation);
    }

    @Override
    public void delete(Long id) throws NonExistingResourceException {
        findById(id);
        timeConsultationRepository.deleteById(id);
    }

}
