package com.medical.presentation.controller;

import com.medical.business.facade.WorkingShiftFacade;
import com.medical.domain.dto.WorkingShiftDTO;
import com.medical.domain.dto.request.WorkingShiftRequest;
import com.medical.presentation.controller.endpoint.WorkingShiftEndpoint;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api
@RestController
@RequestMapping(WorkingShiftEndpoint.BASE)
public class WorkShiftController implements WorkingShiftEndpoint {

    @Autowired
    private WorkingShiftFacade workingShiftFacade;


    @ApiOperation(value = "Creacion de Turno Laboral", notes = "Este metodo permite crear un Turno Laboral")
    @PostMapping
    public ResponseEntity<WorkingShiftDTO> createWorkShift(@RequestBody WorkingShiftRequest request) {
        WorkingShiftDTO workingShiftCreated = workingShiftFacade.createWorkShift(request);
        return new ResponseEntity<>(workingShiftCreated, HttpStatus.CREATED);
    }


    @ApiOperation(value = "Obtencion de un Turno Laboral", notes = "Este metodo permite obtener un Turno Laboral")
    @GetMapping(value = WORKING_SHIFT_ID)
    public ResponseEntity<WorkingShiftDTO> getWorkingShift(@PathVariable Long workingShiftId) throws Exception {
        WorkingShiftDTO workingShift = workingShiftFacade.getWorkShift(workingShiftId);
        return new ResponseEntity<>(workingShift, HttpStatus.OK);
    }


    @ApiOperation(value = "Actualizacion de un Turno Laboral", notes = "Este metodo permite actualizar un Turno Laboral")
    @PutMapping(value = WORKING_SHIFT_ID)
    public ResponseEntity<WorkingShiftDTO> updateWorkShift(@RequestBody WorkingShiftRequest request, @PathVariable Long workingShiftId) throws Exception {
        WorkingShiftDTO workingShiftUpdated = workingShiftFacade.updateWorkShift(request, workingShiftId);
        return new ResponseEntity<>(workingShiftUpdated, HttpStatus.CREATED);
    }


    @ApiOperation(value = "Eliminacion de un Turno Laboral", notes = "Este metodo permite eliminar un Turno Laboral")
    @DeleteMapping(value = WORKING_SHIFT_ID)
    public ResponseEntity<String> deleteWorkingShift(@PathVariable Long workingShiftId) throws Exception {
        workingShiftFacade.deleteWorkShift(workingShiftId);
        return new ResponseEntity<>("WorkingShift eliminado con éxito", HttpStatus.NO_CONTENT);
    }


    @ApiOperation(value = "Obtencion de un listado de Turnos Laborales", notes = "Este metodo permite obtener un listado de Turnos Laborales")
    @GetMapping(value = LOCALE_NUMBER_AND_STREET)
    public ResponseEntity<List<WorkingShiftDTO>> findByLocaleAndNumberAndStreet() {
        List<WorkingShiftDTO> workingShifts = workingShiftFacade.getAllWorkingShift();
        return new ResponseEntity<>(workingShifts, HttpStatus.OK);
    }

}
