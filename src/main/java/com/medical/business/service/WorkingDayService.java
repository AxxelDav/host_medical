package com.medical.business.service;

import com.medical.domain.model.WorkingDay;

import java.util.List;

public interface WorkingDayService {

    WorkingDay getWorkingDay(Long workingDayId) throws Exception;

    List<WorkingDay> getAllWorkingDay();
}
