package com.medical.business.facade.impl;

import com.medical.business.facade.WorkingShiftFacade;
import com.medical.business.mapper.WorkingShiftDtoMapper;
import com.medical.business.mapper.WorkingShiftRequestMapper;
import com.medical.business.service.WorkShiftService;
import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.dto.response.WorkingShiftResponse;
import com.medical.domain.dto.request.WorkingShiftRequest;
import com.medical.domain.model.WorkingShift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingShiftFacadeImpl implements WorkingShiftFacade {

    @Autowired
    private WorkShiftService workShiftService;

    @Autowired
    private WorkingShiftDtoMapper workingShiftDtoMapper;

    @Autowired
    private WorkingShiftRequestMapper workingShiftRequestMapper;


    @Override
    public WorkingShiftResponse findById(Long workingShiftId) throws NonExistingResourceException {
        WorkingShift workingShift = workShiftService.findById(workingShiftId);
        return workingShiftDtoMapper.toDto(workingShift);
    }

    @Override
    public WorkingShiftResponse create(WorkingShiftRequest request) throws IllegalArgumentException {
        WorkingShift workingShiftToCreate = workingShiftRequestMapper.toDomain(request);
        WorkingShift workingShiftCreated = workShiftService.create(workingShiftToCreate);
        return workingShiftDtoMapper.toDto(workingShiftCreated);
    }

    @Override
    public WorkingShiftResponse update(WorkingShiftRequest request, Long workingShiftId) throws NonExistingResourceException, IllegalArgumentException {
        findById(workingShiftId);
        WorkingShift workingShiftToUpdate = workingShiftRequestMapper.toDomain(request);
        workingShiftToUpdate.setId(workingShiftId);
        WorkingShift workingShiftUpdated = workShiftService.update(workingShiftToUpdate);
        return workingShiftDtoMapper.toDto(workingShiftUpdated);
    }

    @Override
    public void delete(Long workingShiftId) throws NonExistingResourceException {
        workShiftService.delete(workingShiftId);
    }

    @Override
    public List<WorkingShiftResponse> getAll() {
        List<WorkingShift> workingShifts = workShiftService.getAll();
        return workingShiftDtoMapper.toDto(workingShifts);
    }

}
