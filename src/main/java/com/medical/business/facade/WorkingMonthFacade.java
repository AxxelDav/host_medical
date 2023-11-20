package com.medical.business.facade;

import com.medical.common.exception.DataInconsistencyException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.dto.response.WorkingMonthResponse;

import java.util.List;

public interface WorkingMonthFacade {

    WorkingMonthResponse getWorkingMonth(Long workingMonthId) throws NonExistingResourceException;

    List<WorkingMonthResponse> getAll() throws DataInconsistencyException;
}
