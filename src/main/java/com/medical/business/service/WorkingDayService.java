package com.medical.business.service;

import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.model.WorkingDay;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface WorkingDayService {

    WorkingDay findById(Long workingDayId) throws NonExistingResourceException;

    List<WorkingDay> findAllByIds(List<Long> workingIds);

    List<WorkingDay> getAll();

    Set<String> getAllDays(List<WorkingDay> workingDays);
}
