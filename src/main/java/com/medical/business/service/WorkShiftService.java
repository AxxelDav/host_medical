package com.medical.business.service;

import com.medical.domain.model.WorkingShift;

import java.util.List;

public interface WorkShiftService {

    WorkingShift createWorkShift(WorkingShift workingShift);

    WorkingShift getWorkShift(Long id) throws Exception;

    WorkingShift updateWorkShift(WorkingShift workingShift) throws Exception;

    void deleteWorkShift(Long id) throws Exception;

    List<WorkingShift> getAllWorkingShift();

}
