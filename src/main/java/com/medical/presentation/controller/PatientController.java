package com.medical.presentation.controller;

import com.medical.business.facade.ProfessionalFacade;
import com.medical.business.facade.PatientFacade;
import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.dto.response.PatientResponse;
import com.medical.domain.dto.request.PatientRequest;
import com.medical.presentation.controller.endpoint.PatientEndpoint;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping(PatientEndpoint.BASE)
public class PatientController implements PatientEndpoint {

    @Autowired
    private PatientFacade patientFacade;


    @Autowired
    private ProfessionalFacade professionalFacade;


    @ApiOperation(value = "Obtencion de un Usuario/Paciente", notes = "Este metodo permite obtener un Usuario/Paciente")
    @GetMapping(value = PATIENT_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientResponse> getpatientById(@PathVariable Long patientId) throws NonExistingResourceException {
        PatientResponse patient = patientFacade.findById(patientId);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }


    @ApiOperation(value = "Creacion de un Usuario/Paciente", notes = "Este metodo permite crear un Usuario/Paciente")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientResponse> createpatient(@RequestBody PatientRequest request) throws IllegalArgumentException {
        PatientResponse patient = patientFacade.create(request);
        return new ResponseEntity<>(patient, HttpStatus.CREATED);
    }


    @ApiOperation(value = "Actualizacion de un Usuario/Paciente", notes = "Este metodo permite actualizar un Usuario/Paciente")
    @PutMapping(value = PATIENT_ID, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updatepatient(@RequestBody PatientRequest request, @PathVariable Long patientId) throws Exception {
        PatientResponse patient = patientFacade.update(request, patientId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @ApiOperation(value = "Eliminacion de un Usuario/Paciente", notes = "Este metodo permite eliminar un Usuario/Paciente")
    @DeleteMapping(value = PATIENT_ID)
    public ResponseEntity<Void> deletepatient(@PathVariable Long patientId) throws NonExistingResourceException {
        patientFacade.delete(patientId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
