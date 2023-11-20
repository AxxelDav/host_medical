package com.medical.business.service;

import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.model.TimeConsultation;

public interface TimeConsultationService {

    TimeConsultation create(TimeConsultation timeConsultation) throws IllegalArgumentException;

    TimeConsultation findById(Long id) throws NonExistingResourceException;

    TimeConsultation update(TimeConsultation timeConsultation) throws NonExistingResourceException, IllegalArgumentException;

    void delete(Long id) throws NonExistingResourceException;
}
