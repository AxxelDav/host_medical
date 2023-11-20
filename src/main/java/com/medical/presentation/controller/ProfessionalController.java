package com.medical.presentation.controller;

import com.medical.business.facade.ProfessionalFacade;
import com.medical.common.exception.DataInconsistencyException;
import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.dto.request.ProfessionalRequest;
import com.medical.domain.dto.request.WorkingDayRequest;
import com.medical.domain.dto.response.ProfessionalResponse;
import com.medical.presentation.controller.endpoint.ProfessionalEndpoint;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.isNull;

@RestController
@RequestMapping(value = ProfessionalEndpoint.BASE)
public class ProfessionalController implements ProfessionalEndpoint {

    @Autowired
    private ProfessionalFacade professionalFacade;


    @ApiOperation(value = "Obtener un Medico Profesional", notes = "Este metodo permite obtener un Medico Profesional")
    @GetMapping(value = PROFESSIONAL_ID)
    public ResponseEntity<ProfessionalResponse> getProfessionalById(@PathVariable Long professionalId) throws NonExistingResourceException {
        ProfessionalResponse professional = professionalFacade.getById(professionalId);
        return new ResponseEntity<>(professional, HttpStatus.OK);
    }


    @ApiOperation(value = "Creacion/Alta de un Medico Profesional", notes = "Este metodo permite dar de alta a un Medico Profesional")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfessionalResponse> createProfessional(@RequestBody ProfessionalRequest request) throws IllegalArgumentException, NonExistingResourceException {
        ProfessionalResponse professionalCreated = professionalFacade.create(request);
        return new ResponseEntity<>(professionalCreated, HttpStatus.CREATED);
    }


    @ApiOperation(value = "Actualizacion de un Medico Profesional", notes = "Este metodo permite actualizar datos de un Medico Profesional")
    @PutMapping(value = PROFESSIONAL_ID, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateProfessional(@PathVariable Long professionalId, @RequestBody ProfessionalRequest request) throws NonExistingResourceException, IllegalArgumentException {
        professionalFacade.update(request, professionalId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @ApiOperation(value = "Eliminacion de un Medico Profesional", notes = "Este metodo permite eliminar un Medico Profesional")
    @DeleteMapping(value = PROFESSIONAL_ID)
    public ResponseEntity<Void> deleteProfessional(@PathVariable Long professionalId) throws NonExistingResourceException {
        professionalFacade.delete(professionalId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @ApiOperation(value = "Obtener listado de Medicos Profesionales ", notes = "Este metodo permite obtener un listado de Medicos Profesionales")
    @GetMapping(value = WORKING_SHIFT_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProfessionalResponse>> getAllProfesionalByWorkShiftId(@PathVariable Long workingShiftId) throws DataInconsistencyException, IllegalArgumentException {
        List<ProfessionalResponse> professionals = professionalFacade.getAllProfesionalByWorkShiftId(workingShiftId);
        ResponseEntity<List<ProfessionalResponse>> response;
        if (isNull(professionals) || professionals.isEmpty()) {
            response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            response = new ResponseEntity<>(professionals, HttpStatus.OK);
        }
        return response;
    }


    @ApiOperation(value = "Obtener listado de Medicos Profesionales por especialidad", notes = "Este metodo permite obtener un listado de Medicos Profesionales por especialidad")
    @GetMapping(value = SPECIALIZATION_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProfessionalResponse>> getAllProfesionalBySpecializationId(@PathVariable Long specializationId) throws DataInconsistencyException, IllegalArgumentException {
        List<ProfessionalResponse> professionals = professionalFacade.getAllProfesionalBySpecializationId(specializationId);
        ResponseEntity<List<ProfessionalResponse>> response;
        if (isNull(professionals) || professionals.isEmpty()) {
            response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            response = new ResponseEntity<>(professionals, HttpStatus.OK);
        }
        return response;
    }

    @ApiOperation(value = "Obtener listado de Medicos Profesionales por tiempo de Consulta", notes = "Este metodo permite obtener un listado de Medicos Profesionales por tiempo de Consulta")
    @GetMapping(value = TIME_CONSULTATION_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProfessionalResponse>> getAllProfesionalByTimeConsultationId(@PathVariable Long timeConsultationId) throws DataInconsistencyException, IllegalArgumentException {
        List<ProfessionalResponse> professionals = professionalFacade.getAllProfesionalByTimeConsultationId(timeConsultationId);
        ResponseEntity<List<ProfessionalResponse>> response;
        if (isNull(professionals) || professionals.isEmpty()) {
            response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            response = new ResponseEntity<>(professionals, HttpStatus.OK);
        }
        return response;
    }


    @ApiOperation(value = "Se actualiza los dias laborales para un Professional", notes = "Este metodo permite actualizar los dias laborales para un Professional")
    @PostMapping(value = UPDATE_WORKING_DAYS, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addWorkingDaysToProfessional(@PathVariable Long professionalId, @RequestBody List<Long> workingDayIds) throws NonExistingResourceException {
        professionalFacade.addWorkingDaysToProfessional(professionalId, workingDayIds);
        return new ResponseEntity<>("WorkingDays added to Professional successfully", HttpStatus.CREATED);
    }


    @ApiOperation(value = "Obtener listado de Medicos Profesionales por dia laboral", notes = "Este metodo permite obtener un listado de Medicos Profesionales por dia laboral")
    @GetMapping(value = WORKING_DAY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProfessionalResponse>> getAllProfessionalIdByWorkingdayId(@PathVariable Long workingDayId) throws DataInconsistencyException, IllegalArgumentException, NonExistingResourceException {
        List<ProfessionalResponse> professionals = professionalFacade.getAllProfessionalIdByWorkingdayId(workingDayId);
        ResponseEntity<List<ProfessionalResponse>> response;
        if (isNull(professionals) || professionals.isEmpty()) {
            response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            response = new ResponseEntity<>(professionals, HttpStatus.OK);
        }
        return response;
    }


    @ApiOperation(value = "Actualizacion de una especializacion", notes = "Este metodo permite actualizar el tiempo de consulta de una consulta medica")
    @PutMapping(value = UPDATE_TIME_CONSULTATION)
    public ResponseEntity<Void> updateTimeConsultationForProfessional(@PathVariable Long professionalId, @PathVariable Long timeConsultationId) throws NonExistingResourceException, IllegalArgumentException, DataInconsistencyException {
        professionalFacade.updateTimeConsultationForProfessional(professionalId, timeConsultationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @ApiOperation(value = "Actualizacion de especialidad medica por Medico Profesional", notes = "Este metodo permite actualizar de especialidad medica por Medico Profesional")
    @PutMapping(value = UPDATE_SPECIALIZATION)
    public ResponseEntity<Void> updateSpecializationForProfessional(@PathVariable Long professionalId, @PathVariable Long specializationId) throws NonExistingResourceException, DataInconsistencyException, IllegalArgumentException {
        professionalFacade.updateSpecializationForProfessional(professionalId, specializationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
