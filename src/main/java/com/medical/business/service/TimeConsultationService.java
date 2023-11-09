package com.medical.business.service;

import com.medical.domain.model.TimeConsultation;

public interface TimeConsultationService {

    TimeConsultation createTimeConsultation(TimeConsultation timeConsultation);

    TimeConsultation getTimeConsultation(Long id) throws Exception;

    TimeConsultation updateTimeConsultation(TimeConsultation timeConsultation) throws Exception;

    void deleteTimeConsultation(Long id) throws Exception;
}
