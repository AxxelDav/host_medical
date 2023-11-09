package com.medical.presentation.controller;

import com.medical.business.facade.MedicalShiftFacade;
import com.medical.domain.dto.MedicalShiftDTO;
import com.medical.domain.dto.SpecializationDTO;
import com.medical.domain.dto.request.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/medical-shift")
public class MedicalShiftController {

    @Autowired
    private MedicalShiftFacade medicalShiftFacade;

    @GetMapping("/{id}")
    private ResponseEntity<MedicalShiftDTO> getMedicalShift(@PathVariable Long id) throws Exception {
        MedicalShiftDTO medicalShift = medicalShiftFacade.getMedicalShift(id);
        return new ResponseEntity<>(medicalShift, HttpStatus.OK);
    }


    @PutMapping("/{registrationProfessionalDate}")
    public ResponseEntity<String> createSchedules(@PathVariable String registrationProfessionalDate, @RequestBody ProfessionalRequest request) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime dateTime = LocalDateTime.parse(registrationProfessionalDate, formatter);
        medicalShiftFacade.createSchedules(dateTime, request);
        return new ResponseEntity<>("Schedule created with success", HttpStatus.CREATED);
    }

    @GetMapping("/{medicalShiftId}")
    public ResponseEntity<String> takeMedicalShift(@PathVariable Long medicalShiftId, @RequestBody UserRequest request) throws Exception {
        medicalShiftFacade.takeMedicalShift(medicalShiftId, request);
        return new ResponseEntity<>("TakeShift with ID: ".concat(medicalShiftId.toString()).concat(" is taked."), HttpStatus.OK);
    }

    @PutMapping("/{medicalShiftId}")
    public ResponseEntity<String> cancelMedicalShift(Long medicalShiftId) throws Exception {
        medicalShiftFacade.cancelMedicalShift(medicalShiftId);
        return new ResponseEntity<>("MedicalShift with ID: ".concat(medicalShiftId.toString()).concat(" was canceled."), HttpStatus.OK);
    }


    @GetMapping("/professionals")
    private ResponseEntity<List<MedicalShiftDTO>> findAllForProfessionalBySpecialization(@RequestBody SpecializationRequest request) throws Exception {
        List<MedicalShiftDTO> medicalShift = medicalShiftFacade.findAllForProfessionalBySpecialization(request);
        return new ResponseEntity<>(medicalShift, HttpStatus.OK);
    }


    @GetMapping("/specializations")
    private ResponseEntity<List<SpecializationDTO>> findAllSpecializationByModality(@RequestBody ModalityRequest request) throws Exception {
        List<SpecializationDTO> medicalShift = medicalShiftFacade.findAllSpecializationByModality(request);
        return new ResponseEntity<>(medicalShift, HttpStatus.OK);
    }


    @GetMapping
    private ResponseEntity<List<MedicalShiftDTO>> requestMedicalShift(@RequestBody SpecializationRequest specializationRequest,
                                                                        @RequestBody ProfessionalRequest professionalRequest,
                                                                        @RequestBody MedicalBranchRequest medicalBranchRequest,
                                                                        @RequestBody WorkingMonthRequest workingMonthRequest,
                                                                        @RequestBody List<WorkingDayRequest> workingDayRequests,
                                                                        @RequestBody WorkingShiftRequest workingShiftRequest) throws Exception {
        List<MedicalShiftDTO> medicalShift = medicalShiftFacade.requestMedicalShift(specializationRequest, professionalRequest, medicalBranchRequest, workingMonthRequest, workingDayRequests, workingShiftRequest);
        return new ResponseEntity<>(medicalShift, HttpStatus.OK);
    }

}
