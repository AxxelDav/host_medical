package com.medical.business.service;

import com.medical.domain.model.WorkingMonth;

import java.util.List;

public interface WorkingMonthService {

    WorkingMonth getWorkingMonth(Long workingMonthId) throws Exception;

    List<WorkingMonth> getWorkingMonths();
}
