package com.medical.presentation.controller;

import com.medical.business.facade.WorkingMonthFacade;
import com.medical.domain.dto.WorkingMonthDTO;
import com.medical.presentation.controller.endpoint.WorkingMonthEndpoint;
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
@RequestMapping(WorkingMonthEndpoint.BASE)
public class WorkingMonthController implements WorkingMonthEndpoint {

    @Autowired
    private WorkingMonthFacade workingMonthFacade;



    @ApiOperation(value = "Obtencion de Mes de consulta medica", notes = "Este metodo permite obtener un Mes para una consulta medica")
    @GetMapping(value = WORKING_MONTH_ID)
    public ResponseEntity<WorkingMonthDTO> getWorkingMonth(@PathVariable Long workingMonthId) throws Exception {
        WorkingMonthDTO workingMonth = workingMonthFacade.getWorkingMonth(workingMonthId);
        return new ResponseEntity<>(workingMonth, HttpStatus.OK);
    }


    @ApiOperation(value = "Obtencion de un listado de Meses para una consulta medica", notes = "Este metodo permite obtener un listado de Meses para una consulta medica")
    @GetMapping
    public ResponseEntity<List<WorkingMonthDTO>> getWorkingMonths() {
        List<WorkingMonthDTO> workingMonths = workingMonthFacade.getWorkingMonths();
        return new ResponseEntity<>(workingMonths, HttpStatus.OK);
    }
}
