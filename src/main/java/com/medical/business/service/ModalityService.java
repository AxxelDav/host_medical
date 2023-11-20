package com.medical.business.service;

import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.model.Modality;

public interface ModalityService {

    Modality getById(Long modalityId) throws NonExistingResourceException;

    Modality create(Modality modality) throws IllegalArgumentException;

    void update(Modality modality) throws IllegalArgumentException, NonExistingResourceException;

    void delete(Long modalityId) throws NonExistingResourceException;
}
