package com.medical.business.facade;

import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.dto.response.WorkingDayResponse;

import java.util.List;

public interface WorkingDayFacade {

    WorkingDayResponse findById(Long workingDayId) throws NonExistingResourceException;

    List<WorkingDayResponse> getAll();
}
