package com.medical.business.service.impl;

import com.medical.business.service.WorkShiftService;
import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.model.WorkingShift;
import com.medical.persistence.WorkShiftRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class WorkShiftServiceImpl implements WorkShiftService {

    private WorkShiftRepository workShiftRepository;

    public WorkShiftServiceImpl(WorkShiftRepository workShiftRepository) {
        this.workShiftRepository = workShiftRepository;
    }

    @Override
    public WorkingShift findById(Long workingShiftId) throws NonExistingResourceException {
        return workShiftRepository.findById(workingShiftId).orElseThrow(() -> new NonExistingResourceException("No existe TURNO_MEDICO con id " + workingShiftId));
    }

    @Override
    public WorkingShift create(WorkingShift workingShift) throws IllegalArgumentException {
        if (Objects.isNull(workingShift)) {
            throw new IllegalArgumentException("Error creating workingShift", "WorkingShift can´t be null");
        }
        return workShiftRepository.save(workingShift);
    }

    @Override
    public WorkingShift update(WorkingShift workingShift) throws IllegalArgumentException {
        if (Objects.isNull(workingShift)) {
            throw new IllegalArgumentException("Error: with workingShift", "WorkingShift can´t be null");
        }
        return workShiftRepository.save(workingShift);
    }

    @Override
    public void delete(Long workingShiftId) throws NonExistingResourceException {
        findById(workingShiftId);
        workShiftRepository.deleteById(workingShiftId);
    }

    @Override
    public List<WorkingShift> getAll() {
        return workShiftRepository.findAll();
    }


}
