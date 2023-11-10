package com.medical.business.service.impl;

import com.medical.business.service.MedicalShiftService;
import com.medical.common.util.ValidateParameterShiftRequest;
import com.medical.domain.model.*;
import com.medical.persistence.MedicalShiftRepository;
import com.medical.persistence.SpecializationRepository;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class MedicalShiftServiceImpl implements MedicalShiftService {

    private static final Integer MINUTES_PER_HOUR = 60;
    private static final Integer HOURS_IN_WORKING_DAY = 4;
    private static final Integer TIME_PER_HOUR = 1;
    private static final Integer AMOUNT_MONTHS_PER_MEDICAL_SHIFT = 1; //Cantidad de meses que quiero que disponibilice al Professional para ofrecer un turno.

    private ValidateParameterShiftRequest validateParameterShiftRequest;
    private MedicalShiftRepository medicalShiftRepository;
    private SpecializationRepository specializationRepository;

    public MedicalShiftServiceImpl(MedicalShiftRepository medicalShiftRepository, SpecializationRepository specializationRepository, ValidateParameterShiftRequest validateParameterShiftRequest) {
        this.medicalShiftRepository = medicalShiftRepository;
        this.specializationRepository = specializationRepository;
        this.validateParameterShiftRequest = validateParameterShiftRequest;
    }


    @Override
    public MedicalShift getMedicalShift(Long id) throws Exception {
        return medicalShiftRepository.findById(id).orElseThrow(() -> new Exception("No existe TURNO_MEDICO con id " + id));
    }


    @Override
    public void createSchedules(LocalDateTime registrationProfessionalDate, Professional professional) {
        //Voy 3 meses paa delante con respecto a la fecha actual y en base al turno laboral y al tiempo de consulta persisto en la base de datos (MedicalShift) lo asociado e inicialmente pongo que "NO" en la columna "Tomado"
        LocalDateTime finishPeriodDate = registrationProfessionalDate.plus(AMOUNT_MONTHS_PER_MEDICAL_SHIFT, ChronoUnit.MONTHS);

        Map<DayOfWeek, String> spanishDates = new HashMap<>();
        spanishDates.put(DayOfWeek.MONDAY, "Lunes");
        spanishDates.put(DayOfWeek.TUESDAY, "Martes");
        spanishDates.put(DayOfWeek.WEDNESDAY, "Miércoles");
        spanishDates.put(DayOfWeek.THURSDAY, "Jueves");
        spanishDates.put(DayOfWeek.FRIDAY, "Viernes");
        spanishDates.put(DayOfWeek.SATURDAY, "Sábado");
        spanishDates.put(DayOfWeek.SUNDAY, "Domingo");

        List<LocalDateTime> dates = new ArrayList<>();
        Set<String> workingDaysSet = new HashSet<>();

        for (WorkingDay dayValue : professional.getWorkingDays()) {
            workingDaysSet.add(dayValue.getDay());
        }

        while (registrationProfessionalDate.isBefore(finishPeriodDate)) {
            DayOfWeek currentDay = registrationProfessionalDate.getDayOfWeek();
            if (spanishDates.containsKey(currentDay)) {
                String spanishDate = spanishDates.get(currentDay);
                if (workingDaysSet.contains(spanishDate)) {
                    dates.add(registrationProfessionalDate);
                }
            }
            registrationProfessionalDate = registrationProfessionalDate.plusDays(1);
        }


        int startWorkingHour = professional.getWorkingShift().getEntryHour();
        int timeConsultationPerHour = MINUTES_PER_HOUR / professional.getTimeConsultation().getMinutes();
        int timePerHour = TIME_PER_HOUR;

        int finishWorkingHour = startWorkingHour + HOURS_IN_WORKING_DAY;

        for (LocalDateTime date : dates) {
            MedicalShift medicalShift = new MedicalShift();
            medicalShift.setMedicalBranch(professional.getMedicalBranch());
            medicalShift.setProfessional(professional);
            medicalShift.setShiftDate(date.plusHours(startWorkingHour));
            medicalShift.setAvailable("SI");
            medicalShiftRepository.save(medicalShift);

            while (startWorkingHour < finishWorkingHour) {
                while (timePerHour < timeConsultationPerHour) {
                    MedicalShift medicalShiftPerConsultation = new MedicalShift();
                    medicalShiftPerConsultation.setMedicalBranch(professional.getMedicalBranch());
                    medicalShiftPerConsultation.setProfessional(professional);
                    medicalShiftPerConsultation.setShiftDate(date.plusMinutes(professional.getTimeConsultation().getMinutes()));
                    medicalShiftPerConsultation.setAvailable("SI");
                    medicalShiftRepository.save(medicalShiftPerConsultation);
                    timePerHour++;
                }
                startWorkingHour++;
            }
        }
     }

    @Override
    public void takeMedicalShift(Long medicalShiftId, User user) throws Exception {
        MedicalShift medicalShift = getMedicalShift(medicalShiftId);
        medicalShift.setUser(user);
        medicalShift.setAvailable("NO");
    }

    @Override
    public void cancelMedicalShift(Long medicalShiftId) throws Exception {
        MedicalShift medicalShift = getMedicalShift(medicalShiftId);

        if (medicalShift.getShiftDate().isAfter(LocalDateTime.now())) {
            medicalShiftRepository.delete(medicalShift);
        } else {
            medicalShift.setAvailable("SI");
        }
    }


    @Override
    public List<MedicalShift> findAllForProfessionalBySpecialization(Specialization specialization) {
        return medicalShiftRepository.findAllMedicalShiftAvailableBySpecializationId(specialization.getId());
    }


    @Override
    public List<Specialization> findAllSpecializationByModality(Modality modality) {
        return specializationRepository.findAllSpecializationByModality(modality.getId());
    }

    @Override
    public List<MedicalShift> requestMedicalShift(Specialization specialization, Professional professional, MedicalBranch medicalBranch, WorkingMonth workingMonth, List<WorkingDay> workingDays, WorkingShift workingShift) throws Exception {
        Long professionalId = professional != null ? professional.getId() : null;
        Long medicalBranchId = medicalBranch != null ? medicalBranch.getId() : null;
        Long workingMonthId = workingMonth != null ? workingMonth.getId() : null;
        Long workingShiftId = workingShift != null ? workingShift.getId() : null;

        if (workingMonth != null && medicalBranch != null && workingShift != null ) {
            validateParameterShiftRequest.validate(specialization.getDescription(), workingMonth.getMonth(), medicalBranch.getLocation(), medicalBranch.getNumberStreet().toString(), medicalBranch.getStreet(), workingDays, workingShift.getDescription());
        }


        return medicalShiftRepository.requestMedicalShift(specialization.getId(),professionalId, medicalBranchId, workingMonthId, workingDays, workingShiftId);
    }


}
