package com.medical.business.service.impl;

import com.medical.business.service.TimeConsultationService;
import com.medical.domain.model.TimeConsultation;
import com.medical.persistence.TimeConsultationRepository;
import org.springframework.stereotype.Service;

@Service
public class TimeConsultationServiceImpl implements TimeConsultationService {

    private TimeConsultationRepository timeConsultationRepository;

    public TimeConsultationServiceImpl(TimeConsultationRepository timeConsultationRepository) {
        this.timeConsultationRepository = timeConsultationRepository;
    }

    @Override
    public TimeConsultation createTimeConsultation(TimeConsultation timeConsultation) {
        return timeConsultationRepository.save(timeConsultation);

    }

    @Override
    public TimeConsultation getTimeConsultation(Long id) throws Exception {
        return timeConsultationRepository.findById(id).orElseThrow(() -> new Exception("No existe TIEMPO_POR_CONSULTA con id " + id));
    }

    @Override
    public TimeConsultation updateTimeConsultation(TimeConsultation timeConsultation) throws Exception {
        getTimeConsultation(timeConsultation.getId());
        return timeConsultationRepository.save(timeConsultation);
    }

    @Override
    public void deleteTimeConsultation(Long id) throws Exception {
        getTimeConsultation(id);
        timeConsultationRepository.deleteById(id);
    }

}
