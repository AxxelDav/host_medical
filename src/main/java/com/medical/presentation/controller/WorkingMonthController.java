package com.medical.presentation.controller;

import com.medical.business.facade.WorkingMonthFacade;
import com.medical.common.exception.DataInconsistencyException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.dto.response.WorkingDayResponse;
import com.medical.domain.dto.response.WorkingMonthResponse;
import com.medical.presentation.controller.endpoint.WorkingMonthEndpoint;
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
@RequestMapping(WorkingMonthEndpoint.BASE)
public class WorkingMonthController implements WorkingMonthEndpoint {

    @Autowired
    private WorkingMonthFacade workingMonthFacade;



    @ApiOperation(value = "Obtencion de Mes de consulta medica", notes = "Este metodo permite obtener un Mes para una consulta medica")
    @GetMapping(value = WORKING_MONTH_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WorkingMonthResponse> getWorkingMonth(@PathVariable Long workingMonthId) throws NonExistingResourceException {
        WorkingMonthResponse workingMonth = workingMonthFacade.getWorkingMonth(workingMonthId);
        return new ResponseEntity<>(workingMonth, HttpStatus.OK);
    }


    @ApiOperation(value = "Obtencion de un listado de Meses para una consulta medica", notes = "Este metodo permite obtener un listado de Meses para una consulta medica")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<WorkingMonthResponse>> getWorkingMonths() throws DataInconsistencyException {
        List<WorkingMonthResponse> workingMonths = workingMonthFacade.getAll();
        ResponseEntity<List<WorkingMonthResponse>> response;
        if (isNull(workingMonths) || workingMonths.isEmpty()) {
            response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            response = new ResponseEntity<>(workingMonths, HttpStatus.OK);
        }
        return response;
    }
}
