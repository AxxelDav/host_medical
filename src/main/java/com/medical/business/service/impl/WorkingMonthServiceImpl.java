package com.medical.business.service.impl;

import com.medical.common.exception.DataInconsistencyException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.model.WorkingMonth;
import com.medical.persistence.WorkingMonthRepository;
import com.medical.business.service.WorkingMonthService;
import org.springframework.dao.DataAccessException;
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
    public WorkingMonth getWorkingMonth(Long workingMonthId) throws NonExistingResourceException {
        return workingMonthRepository.findById(workingMonthId).orElseThrow(() -> new NonExistingResourceException("No existe Mes con id " + workingMonthId));
    }

    @Override
    public List<WorkingMonth> getAll() throws DataInconsistencyException {
        try {
            return workingMonthRepository.findAll();
        } catch (DataAccessException ex) {
            throw new DataInconsistencyException("Error executing query in database", ex);
        }
    }
}
