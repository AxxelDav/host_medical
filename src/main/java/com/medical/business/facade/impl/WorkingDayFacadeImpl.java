package com.medical.business.facade.impl;

import com.medical.business.facade.WorkingDayFacade;
import com.medical.business.mapper.WorkingDayDtoMapper;
import com.medical.business.mapper.WorkingDayRequestMapper;
import com.medical.business.service.WorkingDayService;
import com.medical.domain.dto.WorkingDayDTO;
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
    public WorkingDayDTO getWorkingDay(Long workingDayId) throws Exception {
        WorkingDay workingDay = workDayService.getWorkingDay(workingDayId);
        return workingDayDtoMapper.toDto(workingDay);
    }

    @Override
    public List<WorkingDayDTO> getAllWorkingDay() {
        List<WorkingDay> workingDays = workDayService.getAllWorkingDay();
        return workingDayDtoMapper.toDto(workingDays);
    }
}
