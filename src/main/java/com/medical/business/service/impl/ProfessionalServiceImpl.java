package com.medical.business.service.impl;

import com.medical.business.service.ProfessionalService;
import com.medical.domain.model.Professional;
import com.medical.domain.model.WorkingDay;
import com.medical.persistence.ProfessionalRepository;
import com.medical.persistence.WorkingDayRepository;
import com.medical.business.service.MedicalShiftService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ProfessionalServiceImpl implements ProfessionalService {

    private MedicalShiftService medicalShiftService;

    private ProfessionalRepository professionalRepository;

    private WorkingDayRepository workingDayRepository;


    public ProfessionalServiceImpl(ProfessionalRepository professionalRepository, WorkingDayRepository workingDayRepository, MedicalShiftService medicalShiftService) {
        this.professionalRepository = professionalRepository;
        this.workingDayRepository = workingDayRepository;
        this.medicalShiftService = medicalShiftService;
    }


    @Override
    public Professional getProfessionalById(Long specializationId) {
        return professionalRepository.findById(specializationId)
                .orElseThrow(() -> new NoSuchElementException("No existe el Professional con ID " + specializationId));
    }

    @Override
    public Professional createProfessional(Professional professional) {
        return professionalRepository.save(professional);
    }

    @Override
    public Professional updateProfessional(Professional professional) {
        getProfessionalById(professional.getId());
        return professionalRepository.save(professional);
    }

    @Override
    public void deleteProfessional(Long specializationId) throws Exception {
        getProfessionalById(specializationId);
        professionalRepository.deleteById(specializationId);
    }

    @Override
    public List<Professional> getAllProfessionalByWorkShiftId(Long workShiftId) {
        return professionalRepository.getProfessionalByWorkShiftId(workShiftId);
    }


    @Override
    public List<Professional> getAllProfesionalBySpecializationId(Long specializationId) {
        return professionalRepository.getProfesionalBySpecializationId(specializationId);
    }

    @Override
    public List<Professional> getAllProfesionalByTimeConsultationId(Long timeConsultationId) {
        return professionalRepository.getProfesionalByTimeConsultationId(timeConsultationId);
    }

    @Override
    public List<Professional> getAllProfessionalIdByWorkingdayId(Long workingDayId) {
        WorkingDay workingDay = workingDayRepository.findById(workingDayId)
                .orElseThrow(() -> new NoSuchElementException("No existe el día de la semana con ID " + workingDayId));
        List<Long> professionalsId = professionalRepository.getAllProfessionalIdByWorkingdayId(workingDayId);
        List<Professional> professionals = new ArrayList<>();
        professionalsId.forEach(professionalId -> {
            professionals.add(getProfessionalById(professionalId));
        });

        return professionals;
    }

    @Override
    public void updateTimeConsultation(Long professionalId, Long timeConsultationId) {
        professionalRepository.updateTimeConsultation(professionalId, timeConsultationId);
    }

    @Override
    public void updateSpecialization(Long professionalId, Long specializationId) {
        professionalRepository.updateSpecialization(professionalId, specializationId);
    }

    @Override
    public void createSchedulesForProfessional(Long professionalId, LocalDateTime registrationProfessionalDate) { //Esta es la fecha de alta de professional se debe sacar una vez que se regitro un usuario
        Professional professional = getProfessionalById(professionalId);
        medicalShiftService.createSchedules(registrationProfessionalDate, professional);
    }


}
