package com.medical.business.facade.impl;

import com.medical.business.facade.WorkingMonthFacade;
import com.medical.business.mapper.WorkingMonthDtoMapper;
import com.medical.business.mapper.WorkingMonthRequestMapper;
import com.medical.business.service.WorkingMonthService;
import com.medical.domain.dto.WorkingMonthDTO;
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
    public WorkingMonthDTO getWorkingMonth(Long workingMonthId) throws Exception {
        WorkingMonth workingMonth = workMonthService.getWorkingMonth(workingMonthId);
        return workingMonthDtoMapper.toDto(workingMonth);
    }

    @Override
    public List<WorkingMonthDTO> getWorkingMonths() {
        List<WorkingMonth> workingMonths = workMonthService.getWorkingMonths();
        return workingMonthDtoMapper.toDto(workingMonths);
    }
}
