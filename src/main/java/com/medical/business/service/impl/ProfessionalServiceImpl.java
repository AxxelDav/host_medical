package com.medical.business.service.impl;

import com.medical.business.service.ProfessionalService;
import com.medical.business.service.WorkingDayService;
import com.medical.common.exception.DataInconsistencyException;
import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.model.Professional;
import com.medical.domain.model.WorkingDay;
import com.medical.persistence.ProfessionalRepository;
import com.medical.persistence.WorkingDayRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProfessionalServiceImpl implements ProfessionalService {


    private WorkingDayService workingDayService;

    private ProfessionalRepository professionalRepository;

    private WorkingDayRepository workingDayRepository;


    public ProfessionalServiceImpl(ProfessionalRepository professionalRepository, WorkingDayRepository workingDayRepository, WorkingDayService workingDayService) {
        this.professionalRepository = professionalRepository;
        this.workingDayRepository = workingDayRepository;
        this.workingDayService = workingDayService;
    }


    @Override
    public Professional getById(Long professionalId) throws NonExistingResourceException {
        return professionalRepository.findById(professionalId)
                .orElseThrow(() -> new NonExistingResourceException("No existe el Professional con ID " + professionalId));
    }

    @Override
    public Professional create(Professional professional) throws IllegalArgumentException {
        if (Objects.isNull(professional)) {
            throw new IllegalArgumentException("Error creating professional", "Professional can´t be null");
        }
        return professionalRepository.save(professional);
    }

    @Override
    public Professional update(Professional professional) throws IllegalArgumentException {
        if (Objects.isNull(professional)) {
            throw new IllegalArgumentException("Error: with professional", "Professional can´t be null");
        }
        return professionalRepository.save(professional);
    }

    @Transactional
    @Override
    public void delete(Long specializationId) throws NonExistingResourceException {
        getById(specializationId);
        professionalRepository.deleteById(specializationId);
    }

    @Override
    public List<Professional> getAllProfessionalByWorkShiftId(Long workShiftId) throws DataInconsistencyException, IllegalArgumentException {
        if (Objects.isNull(workShiftId)) {
            throw new IllegalArgumentException("Error workShiftId can´t be null", "workShiftId can´t be null");
        }
        try {
            return professionalRepository.getAllProfessionalByWorkShiftId(workShiftId);
        } catch (DataAccessException ex) {
            throw new DataInconsistencyException("Error executing query in database", ex);
        }
    }


    @Override
    public List<Professional> getAllProfesionalBySpecializationId(Long specializationId) throws DataInconsistencyException, IllegalArgumentException {
        if (Objects.isNull(specializationId)) {
            throw new IllegalArgumentException("Error specializationId can´t be null", "specializationId can´t be null");
        }
        try {
            return professionalRepository.getProfesionalBySpecializationId(specializationId);
        } catch (DataAccessException ex) {
            throw new DataInconsistencyException("Error executing query in database", ex);
        }
    }

    @Override
    public List<Professional> getAllProfesionalByTimeConsultationId(Long timeConsultationId) throws DataInconsistencyException, IllegalArgumentException {
        if (Objects.isNull(timeConsultationId)) {
            throw new IllegalArgumentException("Error timeConsultationId can´t be null", "timeConsultationId can´t be null");
        }
        try {
            return professionalRepository.getProfesionalByTimeConsultationId(timeConsultationId);
        } catch (DataAccessException ex) {
            throw new DataInconsistencyException("Error executing query in database", ex);
        }
    }

    @Override
    public List<Professional> getAllProfessionalIdByWorkingdayId(Long workingDayId) throws DataInconsistencyException, IllegalArgumentException, NonExistingResourceException {
        if (Objects.isNull(workingDayId)) {
            throw new IllegalArgumentException("Error specializationId can´t be null", "specializationId can´t be null");
        }
        WorkingDay workingDay = workingDayRepository.findById(workingDayId)
                .orElseThrow(() -> new NonExistingResourceException("No existe el día de la semana con ID " + workingDayId));

        try {
            List<Long> professionalsId = professionalRepository.getAllProfessionalIdByWorkingdayId(workingDayId);
            List<Professional> professionals = new ArrayList<>();
            professionalsId.forEach(professionalId -> {
                try {
                    professionals.add(getById(professionalId));
                } catch (NonExistingResourceException e) {
                    e.printStackTrace();
                }
            });
            return professionals;

        } catch (DataAccessException ex) {
            throw new DataInconsistencyException("Error executing query in database", ex);
        }
    }


    @Override
    public void addWorkingDaysToProfessional(Long professionalId, List<Long> workingDayIds) throws NonExistingResourceException {
        Professional professionalToBeCreatedWithWorkingDays = getById(professionalId);
        List<WorkingDay> workingDays = workingDayService.findAllByIds(workingDayIds);
        professionalToBeCreatedWithWorkingDays.setWorkingDays(workingDays);
        professionalRepository.save(professionalToBeCreatedWithWorkingDays);
    }


    @Transactional
    @Override
    public void updateTimeConsultationForProfessional(Long professionalId, Long timeConsultationId) throws NonExistingResourceException, IllegalArgumentException, DataInconsistencyException {
        if (Objects.isNull(professionalId)) {
            throw new IllegalArgumentException("Error: with professionalId", "professionalId can´t be null");
        }
        if (Objects.isNull(timeConsultationId)) {
            throw new IllegalArgumentException("Error: with timeConsultationId", "timeConsultationId can´t be null");
        }

        try {
            professionalRepository.updateTimeConsultationForProfessional(professionalId, timeConsultationId);
        } catch (DataAccessException ex) {
            throw new DataInconsistencyException("Error executing query in database", ex);
        }
    }

    @Transactional
    @Override
    public void updateSpecializationForProfessional(Long professionalId, Long specializationId) {
        professionalRepository.updateSpecializationForProfessional(professionalId, specializationId);
    }

}
