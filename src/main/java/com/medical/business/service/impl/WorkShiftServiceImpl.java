package com.medical.business.service.impl;

import com.medical.business.service.WorkShiftService;
import com.medical.domain.model.WorkingShift;
import com.medical.persistence.WorkShiftRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkShiftServiceImpl implements WorkShiftService {

    private WorkShiftRepository workShiftRepository;

    public WorkShiftServiceImpl(WorkShiftRepository workShiftRepository) {
        this.workShiftRepository = workShiftRepository;
    }

    @Override
    public WorkingShift createWorkShift(WorkingShift workingShift) {
        return workShiftRepository.save(workingShift);
    }

    @Override
    public WorkingShift getWorkShift(Long id) throws Exception {
        return workShiftRepository.findById(id).orElseThrow(() -> new Exception("No existe TURNO_MEDICO con id " + id));
    }

    @Override
    public WorkingShift updateWorkShift(WorkingShift workingShift) throws Exception {
        getWorkShift(workingShift.getId());
        return workShiftRepository.save(workingShift);
    }

    @Override
    public void deleteWorkShift(Long id) throws Exception {
        getWorkShift(id);
        workShiftRepository.deleteById(id);
    }

    @Override
    public List<WorkingShift> getAllWorkingShift() {
        return workShiftRepository.findAll();
    }


}
