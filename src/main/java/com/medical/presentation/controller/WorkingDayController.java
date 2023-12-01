package com.medical.presentation.controller;

import com.medical.business.facade.WorkingDayFacade;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.dto.response.ProfessionalResponse;
import com.medical.domain.dto.response.WorkingDayResponse;
import com.medical.presentation.controller.endpoint.WorkingDayEndpoint;
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
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(WorkingDayEndpoint.BASE)
public class WorkingDayController implements WorkingDayEndpoint {


    @Autowired
    private WorkingDayFacade workingDayFacade;


    @ApiOperation(value = "Obtencion de un Dia Laboral para una consulta medica", notes = "Este metodo permite obtener un Dia Laboral para una consulta medica")
    @GetMapping(value = WORKING_DAY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WorkingDayResponse> getWorkingDay(@PathVariable Long workingDayId) throws NonExistingResourceException {
        WorkingDayResponse workingDay = workingDayFacade.findById(workingDayId);
        return new ResponseEntity<>(workingDay, HttpStatus.OK);
    }


    @ApiOperation(value = "Obtencion de un listado de todos los Dias laborales", notes = "Este metodo permite obtener de un listado de todos los Dias laborales")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<WorkingDayResponse>> getAllWorkingDay() {
        List<WorkingDayResponse> workingDays = workingDayFacade.getAll();
        ResponseEntity<List<WorkingDayResponse>> response;
        if (isNull(workingDays) || workingDays.isEmpty()) {
            response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            response = new ResponseEntity<>(workingDays, HttpStatus.OK);
        }
        return response;
    }

}
