package com.medical.presentation.controller;

import com.medical.business.facade.ProfessionalFacade;
import com.medical.domain.dto.ProfessionalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/professional")
public class ProfessionalController {

    @Autowired
    private ProfessionalFacade professionalFacade;

    @GetMapping("/{professionalId}")
    public ResponseEntity<ProfessionalDTO> getProfessionalById(@PathVariable Long professionalId) {
        ProfessionalDTO professional = professionalFacade.getProfessionalById(professionalId);
        return new ResponseEntity<>(professional, HttpStatus.OK);
    }

    @GetMapping("/{workingShiftId}")
    public ResponseEntity<List<ProfessionalDTO>> getAllProfesionalByWorkShiftId(@PathVariable Long workingShiftId) {
        List<ProfessionalDTO> professionals = professionalFacade.getAllProfesionalByWorkShiftId(workingShiftId);
        return new ResponseEntity<>(professionals, HttpStatus.OK);
    }

    @GetMapping("/{specializationId}")
    public ResponseEntity<List<ProfessionalDTO>> getAllProfesionalBySpecializationId(@PathVariable Long specializationId) {
        List<ProfessionalDTO> professionals = professionalFacade.getAllProfesionalBySpecializationId(specializationId);
        return new ResponseEntity<>(professionals, HttpStatus.OK);
    }

    @GetMapping("/{timeConsultationId}")
    public ResponseEntity<List<ProfessionalDTO>> getAllProfesionalByTimeConsultationId(@PathVariable Long timeConsultationId) {
        List<ProfessionalDTO> professionals = professionalFacade.getAllProfesionalByTimeConsultationId(timeConsultationId);
        return new ResponseEntity<>(professionals, HttpStatus.OK);
    }

    @GetMapping("/{workingDayId}")
    public ResponseEntity<List<ProfessionalDTO>> getAllProfessionalIdByWorkingdayId(@PathVariable Long workingDayId) {
        List<ProfessionalDTO> professionals = professionalFacade.getAllProfessionalIdByWorkingdayId(workingDayId);
        return new ResponseEntity<>(professionals, HttpStatus.OK);
    }

    @PutMapping("/time-consultation/{professionalId}/{timeConsultationId}")
    public ResponseEntity<String> updateTimeConsultation(@PathVariable Long professionalId, @PathVariable Long timeConsultationId) { //TIENE SENTIDO??
        professionalFacade.updateTimeConsultation(professionalId, timeConsultationId);
        return new ResponseEntity<>("TimeConsultation updated with success", HttpStatus.OK);
    }

    @PutMapping("/specialization/{professionalId}/{timeConsultationId}")
    public ResponseEntity<String> updateSpecialization(@PathVariable Long professionalId, @PathVariable Long timeConsultationId) { //TIENE SENTIDO??
        professionalFacade.updateSpecialization(professionalId, timeConsultationId);
        return new ResponseEntity<>("Specialization updated with success", HttpStatus.OK);
    }


    @PostMapping("/{professionalId}/{registrationProfessionalDate}")
    public ResponseEntity<String> createSchedulesForProfessional(@PathVariable Long professionalId, @PathVariable String registrationProfessionalDate) { //Se podria pasar directamente el objeto Professional, y dentro del metodo desempaquetar la informacion que necesites (pensa si te conviene)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime dateTime = LocalDateTime.parse(registrationProfessionalDate, formatter);
        professionalFacade.createSchedulesForProfessional(professionalId, dateTime);
        return new ResponseEntity<>("Schedules created with success", HttpStatus.CREATED);
    }

}
