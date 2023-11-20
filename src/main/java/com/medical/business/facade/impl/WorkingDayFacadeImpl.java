package com.medical.business.facade.impl;

import com.medical.business.facade.WorkingDayFacade;
import com.medical.business.mapper.WorkingDayDtoMapper;
import com.medical.business.mapper.WorkingDayRequestMapper;
import com.medical.business.service.WorkingDayService;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.dto.response.WorkingDayResponse;
import com.medical.domain.model.WorkingDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingDayFacadeImpl implements WorkingDayFacade {

    @Autowired
    private WorkingDayService workDayService;

    @Autowired
    private WorkingDayDtoMapper workingDayDtoMapper;

    @Autowired
    private WorkingDayRequestMapper workingDayRequestMapper;


    @Override
    public WorkingDayResponse findById(Long workingDayId) throws NonExistingResourceException {
        WorkingDay workingDay = workDayService.findById(workingDayId);
        return workingDayDtoMapper.toDto(workingDay);
    }

    @Override
    public List<WorkingDayResponse> getAll() {
        List<WorkingDay> workingDays = workDayService.getAll();
        return workingDayDtoMapper.toDto(workingDays);
    }
}
