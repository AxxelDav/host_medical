package com.medical.presentation.controller;

import com.medical.business.facade.MedicalShiftFacade;
import com.medical.domain.dto.MedicalShiftDTO;
import com.medical.domain.dto.SpecializationDTO;
import com.medical.domain.dto.request.*;
import com.medical.presentation.controller.endpoint.MedicalShiftEndpoint;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Api
@RestController
@RequestMapping(MedicalShiftEndpoint.BASE)
public class MedicalShiftController implements MedicalShiftEndpoint {

    @Autowired
    private MedicalShiftFacade medicalShiftFacade;

    @ApiOperation(value = "Regresa un Turno Medico", notes = "Este metodo permite obtener un Turno Medico")
    @GetMapping(value = ID)
    private ResponseEntity<MedicalShiftDTO> getMedicalShift(@PathVariable Long medicalShiftId) throws Exception {
        MedicalShiftDTO medicalShift = medicalShiftFacade.getMedicalShift(medicalShiftId);
        return new ResponseEntity<>(medicalShift, HttpStatus.OK);
    }


    @ApiOperation(value = "Creacion de horario para un Turno Medico", notes = "Este metodo permite crear el horario para un Turno Medico")
    @PutMapping(value = REGISTRATION_PROFESSIONAL_DATE)
    public ResponseEntity<String> createSchedules(@PathVariable String registrationProfessionalDate, @RequestBody ProfessionalRequest request) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime dateTime = LocalDateTime.parse(registrationProfessionalDate, formatter);
        medicalShiftFacade.createSchedules(dateTime, request);
        return new ResponseEntity<>("Schedule created with success", HttpStatus.CREATED);
    }

    @ApiOperation(value = "Toma un Turno Medico por un paciente", notes = "Este metodo permite tomar Turno Medico por un paciente, actualizando el estado del turno")
    @GetMapping(value = MEDICAL_SHIFT_ID)
    public ResponseEntity<String> takeMedicalShift(@PathVariable Long medicalShiftId, @RequestBody UserRequest request) throws Exception {
        medicalShiftFacade.takeMedicalShift(medicalShiftId, request);
        return new ResponseEntity<>("TakeShift with ID: ".concat(medicalShiftId.toString()).concat(" is taked."), HttpStatus.OK);
    }

    @ApiOperation(value = "Cancela un Turno Medico", notes = "Este metodo permite cancelar Turno Medico")
    @PutMapping(value = MEDICAL_SHIFT_ID)
    public ResponseEntity<String> cancelMedicalShift(@PathVariable Long medicalShiftId) throws Exception {
        medicalShiftFacade.cancelMedicalShift(medicalShiftId);
        return new ResponseEntity<>("MedicalShift with ID: ".concat(medicalShiftId.toString()).concat(" was canceled."), HttpStatus.OK);
    }


    @ApiOperation(value = "Regresa un Turno Medico por Profesional y Especialidad medica", notes = "Este metodo permite obtener Turno Medico por Profesional y Especialidad medica")
    @GetMapping(value = PROFESSIONALS)
    private ResponseEntity<List<MedicalShiftDTO>> findAllForProfessionalBySpecialization(@RequestBody SpecializationRequest request) throws Exception {
        List<MedicalShiftDTO> medicalShift = medicalShiftFacade.findAllForProfessionalBySpecialization(request);
        return new ResponseEntity<>(medicalShift, HttpStatus.OK);
    }


    @ApiOperation(value = "Regresa una lista de Especialidades por Especialidad medica y Modalidad", notes = "Este metodo permite obtener una lista de Especialidades por Especialidad medica y Modalidad")
    @GetMapping(value = SPECIALIZATIONS)
    private ResponseEntity<List<SpecializationDTO>> findAllSpecializationByModality(@RequestBody ModalityRequest request) throws Exception {
        List<SpecializationDTO> medicalShift = medicalShiftFacade.findAllSpecializationByModality(request);
        return new ResponseEntity<>(medicalShift, HttpStatus.OK);
    }


    @ApiOperation(value = "Devuelve un listado de Turnos Medicos disponibles para tomar", notes = "Este metodo permite obtener un listado de Turnos Medicos disponibles para tomar")
    @GetMapping(value = REQUEST_MEDICAL_SHIFT)
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
