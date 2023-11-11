package com.medical.presentation.controller;

import com.medical.business.facade.WorkingDayFacade;
import com.medical.domain.dto.WorkingDayDTO;
import com.medical.presentation.controller.endpoint.WorkingDayEndpoint;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api
@RestController
@RequestMapping(WorkingDayEndpoint.BASE)
public class WorkingDayController implements WorkingDayEndpoint {


    @Autowired
    private WorkingDayFacade workingDayFacade;


    @ApiOperation(value = "Obtencion de un Dia Laboral para una consulta medica", notes = "Este metodo permite obtener un Dia Laboral para una consulta medica")
    @GetMapping(value = WORKING_DAY_ID)
    public ResponseEntity<WorkingDayDTO> getWorkingDay(@PathVariable Long workingDayId) throws Exception {
        WorkingDayDTO workingDay = workingDayFacade.getWorkingDay(workingDayId);
        return new ResponseEntity<>(workingDay, HttpStatus.OK);
    }


    @ApiOperation(value = "Obtencion de un listado de Dias laborales para una consulta medica", notes = "Este metodo permite obtener de un listado de Dias laborales para una consulta medica")
    @GetMapping
    public ResponseEntity<List<WorkingDayDTO>> getAllWorkingDay() {
        List<WorkingDayDTO> workingDays = workingDayFacade.getAllWorkingDay();
        return new ResponseEntity<>(workingDays, HttpStatus.OK);
    }

}
