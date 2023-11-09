package com.medical.business.service.impl;

import com.medical.domain.model.WorkingMonth;
import com.medical.persistence.WorkingMonthRepository;
import com.medical.business.service.WorkingMonthService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class WorkingMonthServiceImpl implements WorkingMonthService {

    private WorkingMonthRepository workingMonthRepository;

    public WorkingMonthServiceImpl(WorkingMonthRepository workingMonthRepository) {
        this.workingMonthRepository = workingMonthRepository;
    }

    @Override
    public WorkingMonth getWorkingMonth(Long workingMonthId) throws Exception {
        return workingMonthRepository.findById(workingMonthId).orElseThrow(() -> new Exception("No existe Mes con id " + workingMonthId));
    }

    @Override
    public List<WorkingMonth> getWorkingMonths() {
        int actualMonth = LocalDate.now().getMonthValue();
        List<Integer> monthIds = Arrays.asList(actualMonth, actualMonth + 1, actualMonth + 2);
        return workingMonthRepository.getWorkingMonths(monthIds);
    }
}
