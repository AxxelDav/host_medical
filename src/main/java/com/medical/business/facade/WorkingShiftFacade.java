package com.medical.business.facade;

import com.medical.domain.dto.WorkingShiftDTO;
import com.medical.domain.dto.request.WorkingShiftRequest;

import java.util.List;

public interface WorkingShiftFacade {

    WorkingShiftDTO createWorkShift(WorkingShiftRequest request);

    WorkingShiftDTO getWorkShift(Long id) throws Exception;

    WorkingShiftDTO updateWorkShift(WorkingShiftRequest request, Long id) throws Exception;

    void deleteWorkShift(Long id) throws Exception;

    List<WorkingShiftDTO> getAllWorkingShift();
}
