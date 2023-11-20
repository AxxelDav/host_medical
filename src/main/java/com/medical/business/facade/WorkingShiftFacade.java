package com.medical.business.facade;

import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.dto.response.WorkingShiftResponse;
import com.medical.domain.dto.request.WorkingShiftRequest;

import java.util.List;

public interface WorkingShiftFacade {

    WorkingShiftResponse findById(Long id) throws NonExistingResourceException;

    WorkingShiftResponse create(WorkingShiftRequest request) throws IllegalArgumentException;

    WorkingShiftResponse update(WorkingShiftRequest request, Long workingShiftId) throws NonExistingResourceException, IllegalArgumentException;

    void delete(Long id) throws NonExistingResourceException;

    List<WorkingShiftResponse> getAll();
}
