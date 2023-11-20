package com.medical.business.facade.impl;

import com.medical.business.facade.WorkingMonthFacade;
import com.medical.business.mapper.WorkingMonthDtoMapper;
import com.medical.business.mapper.WorkingMonthRequestMapper;
import com.medical.business.service.WorkingMonthService;
import com.medical.common.exception.DataInconsistencyException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.dto.response.WorkingMonthResponse;
import com.medical.domain.model.WorkingMonth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingMonthFacadeImpl implements WorkingMonthFacade {

    @Autowired
    private WorkingMonthService workMonthService;

    @Autowired
    private WorkingMonthDtoMapper workingMonthDtoMapper;

    @Autowired
    private WorkingMonthRequestMapper workingMonthRequestMapper;


    @Override
    public WorkingMonthResponse getWorkingMonth(Long workingMonthId) throws NonExistingResourceException {
        WorkingMonth workingMonth = workMonthService.getWorkingMonth(workingMonthId);
        return workingMonthDtoMapper.toDto(workingMonth);
    }

    @Override
    public List<WorkingMonthResponse> getAll() throws DataInconsistencyException {
        List<WorkingMonth> workingMonths = workMonthService.getAll();
        return workingMonthDtoMapper.toDto(workingMonths);
    }
}
