package com.medical.presentation.controller;

import com.medical.business.facade.TimeConsultationFacade;
import com.medical.domain.dto.TimeConsultationDTO;
import com.medical.domain.dto.request.TimeConsultationRequest;
import com.medical.presentation.controller.endpoint.TimeConsultationEndpoint;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Api
@RestController
@RequestMapping(TimeConsultationEndpoint.BASE)
public class TimeConsultationController implements TimeConsultationEndpoint {

    @Autowired
    private TimeConsultationFacade timeConsultationFacade;


    @ApiOperation(value = "Creacion de tiempo de consulta Medica", notes = "Este metodo permite crear tiempo para una consulta Medica")
    @PostMapping
    public ResponseEntity<TimeConsultationDTO> createTimeConsultation(@RequestBody TimeConsultationRequest request) {
        TimeConsultationDTO timeConsultationDTO = timeConsultationFacade.createTimeConsultation(request);
        return new ResponseEntity<>(timeConsultationDTO, HttpStatus.CREATED);
    }


    @ApiOperation(value = "Obtencion de tiempo de consulta Medica", notes = "Este metodo permite obtener el tiempo de una consulta Medica")
    @GetMapping(value = TIME_CONSULTATION_ID)
    public ResponseEntity<TimeConsultationDTO> getTimeConsultation(@PathVariable Long timeConsultationId) throws Exception {
        TimeConsultationDTO timeConsultationDTO = timeConsultationFacade.getTimeConsultation(timeConsultationId);
        return new ResponseEntity<>(timeConsultationDTO, HttpStatus.OK);
    }


    @ApiOperation(value = "Actualizacion de tiempo de consulta Medica", notes = "Este metodo permite actualizar el tiempo de una consulta Medica")
    @PutMapping
    public ResponseEntity<TimeConsultationDTO> updateTimeConsultation(@RequestBody TimeConsultationRequest request, Long timeConsultationId) throws Exception {
        TimeConsultationDTO timeConsultationDTO = timeConsultationFacade.updateTimeConsultation(request, timeConsultationId);
        return new ResponseEntity<>(timeConsultationDTO, HttpStatus.OK);
    }


    @ApiOperation(value = "Eliminacion de tiempo de consulta Medica", notes = "Este metodo permite eliminar el tiempo de una consulta Medica")
    @DeleteMapping(value = TIME_CONSULTATION_ID)
    public ResponseEntity<String> deleteTimeConsultation(@PathVariable Long timeConsultationId) throws Exception {
        timeConsultationFacade.deleteTimeConsultation(timeConsultationId);
        return new ResponseEntity<>("TimeConsultation deleted with success", HttpStatus.NO_CONTENT);
    }

}
