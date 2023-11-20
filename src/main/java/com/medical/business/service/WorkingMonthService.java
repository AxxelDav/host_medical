package com.medical.business.service;

import com.medical.common.exception.DataInconsistencyException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.model.WorkingMonth;

import java.util.List;

public interface WorkingMonthService {

    WorkingMonth getWorkingMonth(Long workingMonthId) throws NonExistingResourceException;

    List<WorkingMonth> getAll() throws DataInconsistencyException;
}
