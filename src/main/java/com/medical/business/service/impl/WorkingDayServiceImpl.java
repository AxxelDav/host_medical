package com.medical.business.service.impl;

import com.medical.business.service.WorkingDayService;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.model.WorkingDay;
import com.medical.persistence.WorkingDayRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class WorkingDayServiceImpl implements WorkingDayService {
    
    private WorkingDayRepository workingDayRepository;

    public WorkingDayServiceImpl(WorkingDayRepository workingDayRepository) {
        this.workingDayRepository = workingDayRepository;
    }

    @Override
    public WorkingDay findById(Long workingDayId) throws NonExistingResourceException {
        return workingDayRepository.findById(workingDayId).orElseThrow(() -> new NonExistingResourceException("No existe DIA_SEMANAL con id " + workingDayId));
    }

    @Override
    public List<WorkingDay> getAll() {
        return workingDayRepository.findAll();
    }

    @Override
    public List<WorkingDay> findAllByIds(List<Long> workingIds) {
        return workingDayRepository.findAllById(workingIds);
    }


    @Override
    public Set<String> getAllDays(List<WorkingDay> workingDays) {
        Set<String> days = new HashSet<>();
        for (WorkingDay day : workingDays) {
            days.add(day.getDay());
        }
        return days;
    }
}
