package com.medical.business.service.impl;

import com.medical.domain.model.WorkingDay;
import com.medical.persistence.WorkingDayRepository;
import com.medical.business.service.WorkingDayService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingDayServiceImpl implements WorkingDayService {
    
    private WorkingDayRepository workingDayRepository;

    public WorkingDayServiceImpl(WorkingDayRepository workingDayRepository) {
        this.workingDayRepository = workingDayRepository;
    }

    @Override
    public WorkingDay getWorkingDay(Long id) throws Exception {
        return workingDayRepository.findById(id).orElseThrow(() -> new Exception("No existe DIA_SEMANAL con id " + id));
    }

    @Override
    public List<WorkingDay> getAllWorkingDay() {
        return workingDayRepository.findAll();
    }


}
