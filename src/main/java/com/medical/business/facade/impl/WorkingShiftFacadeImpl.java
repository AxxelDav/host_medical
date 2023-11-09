package com.medical.business.facade.impl;

import com.medical.business.facade.WorkingShiftFacade;
import com.medical.business.mapper.WorkingShiftDtoMapper;
import com.medical.business.mapper.WorkingShiftRequestMapper;
import com.medical.business.service.WorkShiftService;
import com.medical.domain.dto.WorkingShiftDTO;
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
    public WorkingShiftDTO createWorkShift(WorkingShiftRequest request) {
        WorkingShift workingShiftToCreate = workingShiftRequestMapper.toDomain(request);
        WorkingShift workingShiftCreated = workShiftService.createWorkShift(workingShiftToCreate);
        return workingShiftDtoMapper.toDto(workingShiftCreated);
    }

    @Override
    public WorkingShiftDTO getWorkShift(Long id) throws Exception {
        WorkingShift workingShift = workShiftService.getWorkShift(id);
        return workingShiftDtoMapper.toDto(workingShift);
    }

    @Override
    public WorkingShiftDTO updateWorkShift(WorkingShiftRequest request, Long id) throws Exception {
        WorkingShift workingShift = workShiftService.getWorkShift(id);
        WorkingShift workingShiftToUpdate = workingShiftRequestMapper.toDomain(request);
        WorkingShift workingShiftUpdated = workShiftService.updateWorkShift(workingShiftToUpdate);
        return workingShiftDtoMapper.toDto(workingShiftUpdated);
    }

    @Override
    public void deleteWorkShift(Long id) throws Exception {
        WorkingShift workingShiftToDelete = workShiftService.getWorkShift(id);
        workShiftService.deleteWorkShift(id);
    }

    @Override
    public List<WorkingShiftDTO> getAllWorkingShift() {
        List<WorkingShift> workingShifts = workShiftService.getAllWorkingShift();
        return workingShiftDtoMapper.toDto(workingShifts);
    }

}
