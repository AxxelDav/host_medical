package com.medical.business.service.impl;

import com.medical.business.service.MedicalShiftService;
import com.medical.business.service.ProfessionalService;
import com.medical.business.service.PatientService;
import com.medical.business.service.WorkingDayService;
import com.medical.common.exception.DataInconsistencyException;
import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.model.*;
import com.medical.persistence.MedicalShiftRepository;
import com.medical.persistence.SpecializationRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.logging.Logger;

@Service
public class MedicalShiftServiceImpl implements MedicalShiftService {

    private static final Logger LOGGER = Logger.getLogger(MedicalShiftServiceImpl.class.getName());

    private static final Integer MINUTES_PER_HOUR = 60;
    private static final Integer HOURS_IN_WORKING_DAY = 4;
    private static final Integer TIME_PER_HOUR = 1;
    private static final Integer AMOUNT_MONTHS_PER_MEDICAL_SHIFT = 1; //Cantidad de meses que quiero que disponibilice al Professional para ofrecer un turno.

    private MedicalShiftRepository medicalShiftRepository;
    private SpecializationRepository specializationRepository;
    private ProfessionalService professionalService;
    private WorkingDayService workingDayService;
    private PatientService patientService;

    public MedicalShiftServiceImpl(MedicalShiftRepository medicalShiftRepository, SpecializationRepository specializationRepository, ProfessionalService professionalService, WorkingDayService workingDayService, PatientService patientService) {
        this.medicalShiftRepository = medicalShiftRepository;
        this.specializationRepository = specializationRepository;
        this.professionalService = professionalService;
        this.workingDayService = workingDayService;
        this.patientService = patientService;
    }


    @Override
    public MedicalShift getMedicalShift(Long medicalShiftId) throws NonExistingResourceException {
        return medicalShiftRepository.findById(medicalShiftId).orElseThrow(() -> new NonExistingResourceException("No existe TURNO_MEDICO con id " + medicalShiftId));
    }


    @Override
    public void createMedicalShiftForProfessional(Long professionalId, String registrationProfessionalDate) throws IllegalArgumentException, NonExistingResourceException {
        Professional professional = professionalService.getById(professionalId);

        if (Objects.isNull(registrationProfessionalDate))
            throw new IllegalArgumentException("Error creating Schedules for Professional", "RegistrationProfessionalDate can´t be null");

        try {

            LocalDate dateForRegistrationProfessionalDate = LocalDate.parse(registrationProfessionalDate);
            LocalDateTime dateForRegistrationProfessionalDateTime = dateForRegistrationProfessionalDate.atStartOfDay();

            //Voy 3 meses para delante con respecto a la fecha ingresada (dateForRegistrationProfessionalDate) y en base al turno laboral y al tiempo de consulta persisto en la base de datos (MedicalShift) lo asociado e inicialmente pongo que "NO" en la columna "Tomado"
            LocalDateTime finishPeriodDate = dateForRegistrationProfessionalDateTime.plus(AMOUNT_MONTHS_PER_MEDICAL_SHIFT, ChronoUnit.MONTHS);


            LOGGER.info("FECHA INICIO: " + dateForRegistrationProfessionalDateTime);
            LOGGER.info("FECHA FIN: " + finishPeriodDate);

            Map<DayOfWeek, String> dayOfWeekMap = new HashMap<>();
            dayOfWeekMap.put(DayOfWeek.MONDAY, "Lunes");
            dayOfWeekMap.put(DayOfWeek.TUESDAY, "Martes");
            dayOfWeekMap.put(DayOfWeek.WEDNESDAY, "Miércoles");
            dayOfWeekMap.put(DayOfWeek.THURSDAY, "Jueves");
            dayOfWeekMap.put(DayOfWeek.FRIDAY, "Viernes");
            dayOfWeekMap.put(DayOfWeek.SATURDAY, "Sábado");
            dayOfWeekMap.put(DayOfWeek.SUNDAY, "Domingo");

            List<LocalDateTime> dates = new ArrayList<>(); //lista de fechas LocalDateTime
            Set<String> workingDaysSet = new HashSet<>(); //Set de dias semanales String (Sin repetir) en ESPAÑOL

            for (WorkingDay dayValue : professional.getWorkingDays()) {
                workingDaysSet.add(dayValue.getDay());
            }

            while (!dateForRegistrationProfessionalDateTime.isAfter(finishPeriodDate)) {
                DayOfWeek currentDay = dateForRegistrationProfessionalDateTime.getDayOfWeek();
                if (dayOfWeekMap.containsKey(currentDay)) {
                    String currentSpanishDate = dayOfWeekMap.get(currentDay);
                    if (workingDaysSet.contains(currentSpanishDate)) {
                        dates.add(dateForRegistrationProfessionalDateTime);
                    }
                }
                LOGGER.info("FECHA REGISTRADA: " + dateForRegistrationProfessionalDateTime);
                dateForRegistrationProfessionalDateTime = dateForRegistrationProfessionalDateTime.plusDays(1);
            }

            int startWorkingHour = professional.getWorkingShift().getEntryHour(); //Aqui guardo la hora inicial
            int consultationPerHour = MINUTES_PER_HOUR / professional.getTimeConsultation().getMinutes();
            int hour = TIME_PER_HOUR;
            int finishWorkingHour = startWorkingHour + HOURS_IN_WORKING_DAY;
            int minutesSummatoryTimeConsultation = 0;


            for (LocalDateTime date : dates) { //POR CADA DIA
                while (startWorkingHour < finishWorkingHour) { //POR CADA HORA
                    while (hour <= consultationPerHour) { //POR CADA CONSULTA EN 1 HORA (TERMINAN SIENDO 4 CONSULTAS POR HORA)
                        MedicalShift medicalShift = new MedicalShift();
                        medicalShift.setMedicalBranch(professional.getMedicalBranch());
                        medicalShift.setModality(professional.getModality().getDescription());
                        medicalShift.setProfessional(professional);
                        medicalShift.setAvailable("SI");
                        medicalShift.setShiftDate(date.plusMinutes(minutesSummatoryTimeConsultation).plusHours(startWorkingHour));
                        medicalShiftRepository.save(medicalShift);
                        minutesSummatoryTimeConsultation += professional.getTimeConsultation().getMinutes();
                        hour++;
                    }
                    hour = TIME_PER_HOUR;
                    startWorkingHour++;
                    minutesSummatoryTimeConsultation = 0;
                }
                startWorkingHour = professional.getWorkingShift().getEntryHour();
            }
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Error parsing date", "Unable to parse the date: " + registrationProfessionalDate, e.getMessage());
        }
     }


    @Override
    public void takeMedicalShift(Long medicalShiftId, Long patientId) throws NonExistingResourceException, IllegalArgumentException {
        Patient patient = patientService.findById(patientId);
        MedicalShift medicalShift = getMedicalShift(medicalShiftId);
        medicalShift.setPatient(patient);
        medicalShift.setAvailable("NO");
        medicalShiftRepository.save(medicalShift);
    }


    @Override
    public void cancelMedicalShift(Long medicalShiftId) throws NonExistingResourceException {
        MedicalShift medicalShift = getMedicalShift(medicalShiftId);
        medicalShift.setAvailable("SI");
        medicalShift.setPatient(null);
        medicalShiftRepository.save(medicalShift);
    }


    @Override
    public List<MedicalShift> findAllMedicalShiftBySpecialization(String specialization) throws IllegalArgumentException, DataInconsistencyException {
        if (Objects.isNull(specialization)) {
            throw new IllegalArgumentException("Error specialization can´t be null", "specialization can´t be null");
        }
        try {
            return medicalShiftRepository.findAllMedicalShiftAvailableBySpecializationId(specialization);
        } catch (DataAccessException ex) {
            throw new DataInconsistencyException("Error executing query in database", ex);
        }
    }


    @Override
    public List<MedicalShift> requestMedicalShift(Long specializationId,
                                                  Long professionalId,
                                                  Long medicalBranchId,
                                                  Long workingMonthId,
                                                  Long workingShiftId,
                                                  List<Long> workingDayIds) throws DataInconsistencyException, IllegalArgumentException {

        try {
            List<WorkingDay> workingDays = workingDayService.findAllByIds(workingDayIds);
            Set<String> days = workingDayService.getAllDays(workingDays);

            return medicalShiftRepository.requestMedicalShift(specializationId,professionalId, medicalBranchId, workingMonthId, workingShiftId, days);
        } catch (DataAccessException ex) {
            throw new DataInconsistencyException("Error executing query in database", ex);
        }
    }


}
