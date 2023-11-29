package com.medical.presentation.controller;

import com.medical.business.facade.MedicalShiftFacade;
import com.medical.common.exception.DataInconsistencyException;
import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.dto.response.MedicalShiftResponse;
import com.medical.presentation.controller.endpoint.MedicalShiftEndpoint;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.isNull;

@Api
@RestController
@RequestMapping(MedicalShiftEndpoint.BASE)
public class MedicalShiftController implements MedicalShiftEndpoint {

    @Autowired
    private MedicalShiftFacade medicalShiftFacade;

    @ApiOperation(value = "Regresa un Turno Medico", notes = "Este metodo permite obtener un Turno Medico")
    @GetMapping(value = MedicalShiftEndpoint.MEDICAL_SHIFT_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<MedicalShiftResponse> getMedicalShift(@PathVariable Long medicalShiftId) throws NonExistingResourceException {
        MedicalShiftResponse medicalShift = medicalShiftFacade.findById(medicalShiftId);
        return new ResponseEntity<>(medicalShift, HttpStatus.OK);
    }


    @ApiOperation(value = "Creacion de Turno Medicos Disponibles para un Professional", notes = "Este metodo permite crear Turno Medicos Disponibles para un Professional")
    @PostMapping(value = MedicalShiftEndpoint.PROFESSIONAL_ID)
    public ResponseEntity<String> createMedicalShiftForProfessional(@PathVariable Long professionalId, @RequestParam("registrationProfessionalDate") String registrationProfessionalDate) throws IllegalArgumentException, NonExistingResourceException {
        medicalShiftFacade.createMedicalShiftForProfessional(professionalId, registrationProfessionalDate);
        return new ResponseEntity<>("Medical Shift created with success for Professional with ID: " + professionalId, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Toma un Turno Medico por parte de un paciente", notes = "Este metodo permite tomar Turno Medico por parte de un paciente, actualizando la disponibilidad del turno")
    @PutMapping(value = TAKE_MEDICAL_SHIFT)
    public ResponseEntity<Void> takeMedicalShift(@PathVariable Long medicalShiftId, @PathVariable Long patientId) throws NonExistingResourceException, IllegalArgumentException {
        medicalShiftFacade.takeMedicalShift(medicalShiftId, patientId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Cancela un Turno Medico", notes = "Este metodo permite cancelar Turno Medico")
    @PutMapping(value = MEDICAL_SHIFT_ID)
    public ResponseEntity<Void> cancelMedicalShift(@PathVariable Long medicalShiftId) throws NonExistingResourceException {
        medicalShiftFacade.cancelMedicalShift(medicalShiftId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @ApiOperation(value = "Regresa todos los Turnos Medicos por Especialidad medica", notes = "Este metodo permite obtener todos los Turnos Medicos por Especialidad medica")
    @GetMapping(value = ALL_MEDICAL_SHIFT_BY_SPECIALIZATION, produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<MedicalShiftResponse>> findAllMedicalShiftBySpecialization(@RequestParam("specialization") String specialization) throws DataInconsistencyException, IllegalArgumentException {
        List<MedicalShiftResponse> medicalShifts = medicalShiftFacade.findAllMedicalShiftBySpecialization(specialization);
        ResponseEntity<List<MedicalShiftResponse>> response;
        if (isNull(medicalShifts) || medicalShifts.isEmpty()) {
            response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            response = new ResponseEntity<>(medicalShifts, HttpStatus.OK);
        }
        return response;
    }


    @ApiOperation(value = "Devuelve un listado de Turnos Medicos disponibles para tomar", notes = "Este metodo permite obtener un listado de Turnos Medicos disponibles para tomar")
    @GetMapping(value = REQUEST_MEDICAL_SHIFT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<MedicalShiftResponse>> requestMedicalShift(@PathVariable Long specializationId,
                                                                           @PathVariable Long professionalId,
                                                                           @PathVariable Long medicalBranchId,
                                                                           @PathVariable Long workingMonthId,
                                                                           @PathVariable Long workingShiftId,
                                                                           @RequestBody  List<Long> workingDayIds
                                                                           ) throws DataInconsistencyException, IllegalArgumentException {
        List<MedicalShiftResponse> medicalShifts = medicalShiftFacade.requestMedicalShift(specializationId, professionalId, medicalBranchId, workingMonthId, workingShiftId, workingDayIds);
        ResponseEntity<List<MedicalShiftResponse>> response;
        if (isNull(medicalShifts) || medicalShifts.isEmpty()) {
            response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            response = new ResponseEntity<>(medicalShifts, HttpStatus.OK);
        }
        return response;
    }

}
