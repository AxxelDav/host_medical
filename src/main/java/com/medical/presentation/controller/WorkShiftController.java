package com.medical.presentation.controller;

import com.medical.business.facade.WorkingShiftFacade;
import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.dto.response.WorkingMonthResponse;
import com.medical.domain.dto.response.WorkingShiftResponse;
import com.medical.domain.dto.request.WorkingShiftRequest;
import com.medical.presentation.controller.endpoint.WorkingShiftEndpoint;
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
@RequestMapping(WorkingShiftEndpoint.BASE)
public class WorkShiftController implements WorkingShiftEndpoint {

    @Autowired
    private WorkingShiftFacade workingShiftFacade;


    @ApiOperation(value = "Obtencion de un Turno Laboral", notes = "Este metodo permite obtener un Turno Laboral")
    @GetMapping(value = WORKING_SHIFT_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WorkingShiftResponse> getWorkingShift(@PathVariable Long workingShiftId) throws NonExistingResourceException {
        WorkingShiftResponse workingShift = workingShiftFacade.findById(workingShiftId);
        return new ResponseEntity<>(workingShift, HttpStatus.OK);
    }


    @ApiOperation(value = "Creacion de Turno Laboral", notes = "Este metodo permite crear un Turno Laboral")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WorkingShiftResponse> createWorkShift(@RequestBody WorkingShiftRequest request) throws IllegalArgumentException {
        WorkingShiftResponse workingShiftCreated = workingShiftFacade.create(request);
        return new ResponseEntity<>(workingShiftCreated, HttpStatus.CREATED);
    }


    @ApiOperation(value = "Actualizacion de un Turno Laboral", notes = "Este metodo permite actualizar un Turno Laboral")
    @PutMapping(value = WORKING_SHIFT_ID)
    public ResponseEntity<Void> updateWorkShift(@RequestBody WorkingShiftRequest request, @PathVariable Long workingShiftId) throws NonExistingResourceException, IllegalArgumentException {
        workingShiftFacade.update(request, workingShiftId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @ApiOperation(value = "Eliminacion de un Turno Laboral", notes = "Este metodo permite eliminar un Turno Laboral")
    @DeleteMapping(value = WORKING_SHIFT_ID)
    public ResponseEntity<Void> deleteWorkingShift(@PathVariable Long workingShiftId) throws NonExistingResourceException {
        workingShiftFacade.delete(workingShiftId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @ApiOperation(value = "Obtención de un listado de Turnos Laborales", notes = "Este metodo permite obtener un listado de Turnos Laborales")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<WorkingShiftResponse>> findAllWorkingShift() {
        List<WorkingShiftResponse> workingShifts = workingShiftFacade.getAll();
        ResponseEntity<List<WorkingShiftResponse>> response;
        if (isNull(workingShifts) || workingShifts.isEmpty()) {
            response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            response = new ResponseEntity<>(workingShifts, HttpStatus.OK);
        }
        return response;
    }

}
