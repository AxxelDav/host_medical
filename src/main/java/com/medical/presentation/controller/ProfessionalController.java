package com.medical.presentation.controller;

import com.medical.business.facade.ProfessionalFacade;
import com.medical.domain.dto.ProfessionalDTO;
import com.medical.domain.dto.request.ProfessionalRequest;
import com.medical.presentation.controller.endpoint.ProfessionalEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping(value = ProfessionalEndpoint.BASE)
public class ProfessionalController implements ProfessionalEndpoint {

    @Autowired
    private ProfessionalFacade professionalFacade;

    @GetMapping(value = PROFESSIONAL_ID)
    public ResponseEntity<ProfessionalDTO> getProfessionalById(@PathVariable Long professionalId) {
        ProfessionalDTO professional = professionalFacade.getProfessionalById(professionalId);
        return new ResponseEntity<>(professional, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProfessionalDTO> createProfessional(@RequestBody ProfessionalRequest request) {
        ProfessionalDTO professional = professionalFacade.createProfessional(request);
        return new ResponseEntity<>(professional, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProfessionalDTO> updateProfessional(@RequestBody ProfessionalRequest request, Long professionalId) {
        ProfessionalDTO professional = professionalFacade.updateProfessional(request, professionalId);
        return new ResponseEntity<>(professional, HttpStatus.OK);
    }

    @DeleteMapping(value = PROFESSIONAL_ID)
    public ResponseEntity<String> deleteProfessional(@PathVariable Long professionalId) throws Exception {
        professionalFacade.deleteProfessional(professionalId);
        return new ResponseEntity<>("Professional con ID: " + professionalId +  " eliminado con éxito", HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = WORKING_SHIFT_ID)
    public ResponseEntity<List<ProfessionalDTO>> getAllProfesionalByWorkShiftId(@PathVariable Long workingShiftId) {
        List<ProfessionalDTO> professionals = professionalFacade.getAllProfesionalByWorkShiftId(workingShiftId);
        return new ResponseEntity<>(professionals, HttpStatus.OK);
    }

    @GetMapping(value = SPECIALIZATION_ID)
    public ResponseEntity<List<ProfessionalDTO>> getAllProfesionalBySpecializationId(@PathVariable Long specializationId) {
        List<ProfessionalDTO> professionals = professionalFacade.getAllProfesionalBySpecializationId(specializationId);
        return new ResponseEntity<>(professionals, HttpStatus.OK);
    }

    @GetMapping(value = TIME_CONSULTATION_ID)
    public ResponseEntity<List<ProfessionalDTO>> getAllProfesionalByTimeConsultationId(@PathVariable Long timeConsultationId) {
        List<ProfessionalDTO> professionals = professionalFacade.getAllProfesionalByTimeConsultationId(timeConsultationId);
        return new ResponseEntity<>(professionals, HttpStatus.OK);
    }

    @GetMapping(value = WORKING_DAY_ID)
    public ResponseEntity<List<ProfessionalDTO>> getAllProfessionalIdByWorkingdayId(@PathVariable Long workingDayId) {
        List<ProfessionalDTO> professionals = professionalFacade.getAllProfessionalIdByWorkingdayId(workingDayId);
        return new ResponseEntity<>(professionals, HttpStatus.OK);
    }

    @PutMapping(value = UPDATE_TIME_CONSULTATION)
    public ResponseEntity<String> updateTimeConsultation(@PathVariable Long professionalId, @PathVariable Long timeConsultationId) {
        professionalFacade.updateTimeConsultation(professionalId, timeConsultationId);
        return new ResponseEntity<>("TimeConsultation updated with success", HttpStatus.OK);
    }

    @PutMapping(value = UPDATE_SPECIALIZATION)
    public ResponseEntity<String> updateSpecialization(@PathVariable Long professionalId, @PathVariable Long timeConsultationId) {
        professionalFacade.updateSpecialization(professionalId, timeConsultationId);
        return new ResponseEntity<>("Specialization updated with success", HttpStatus.OK);
    }

    @PostMapping(value = CREATE_SCHEDULES_FOR_PROFESSIONAL)
    public ResponseEntity<String> createSchedulesForProfessional(@PathVariable Long professionalId, @RequestBody String registrationProfessionalDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime dateTime = LocalDateTime.parse(registrationProfessionalDate, formatter);
        professionalFacade.createSchedulesForProfessional(professionalId, dateTime);
        return new ResponseEntity<>("Schedules created with success", HttpStatus.CREATED);
    }

}
