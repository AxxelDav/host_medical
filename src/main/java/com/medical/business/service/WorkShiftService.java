package com.medical.business.service;

import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.model.WorkingShift;

import java.util.List;

public interface WorkShiftService {

    WorkingShift create(WorkingShift workingShift) throws IllegalArgumentException;

    WorkingShift findById(Long id) throws NonExistingResourceException;

    WorkingShift update(WorkingShift workingShift) throws IllegalArgumentException;

    void delete(Long id) throws NonExistingResourceException;

    List<WorkingShift> getAll();

}
