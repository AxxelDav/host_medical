package com.medical.presentation.controller;

import com.medical.business.facade.TimeConsultationFacade;
import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.dto.response.TimeConsultationResponse;
import com.medical.domain.dto.request.TimeConsultationRequest;
import com.medical.presentation.controller.endpoint.TimeConsultationEndpoint;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Api
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(TimeConsultationEndpoint.BASE)
public class TimeConsultationController implements TimeConsultationEndpoint {

    @Autowired
    private TimeConsultationFacade timeConsultationFacade;


    @ApiOperation(value = "Obtencion de tiempo de consulta Medica", notes = "Este metodo permite obtener el tiempo de una consulta Medica")
    @GetMapping(value = TIME_CONSULTATION_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TimeConsultationResponse> getTimeConsultation(@PathVariable Long timeConsultationId) throws NonExistingResourceException {
        TimeConsultationResponse timeConsultationDTO = timeConsultationFacade.findById(timeConsultationId);
        return new ResponseEntity<>(timeConsultationDTO, HttpStatus.OK);
    }


    @ApiOperation(value = "Creacion de tiempo de consulta Medica", notes = "Este metodo permite crear tiempo para una consulta Medica")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TimeConsultationResponse> createTimeConsultation(@RequestBody TimeConsultationRequest request) throws IllegalArgumentException {
        TimeConsultationResponse timeConsultationDTO = timeConsultationFacade.create(request);
        return new ResponseEntity<>(timeConsultationDTO, HttpStatus.CREATED);
    }


    @ApiOperation(value = "Actualizacion de tiempo de consulta Medica", notes = "Este metodo permite actualizar el tiempo de una consulta Medica")
    @PutMapping(value = TIME_CONSULTATION_ID, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateTimeConsultation(@PathVariable Long timeConsultationId, @RequestBody TimeConsultationRequest request) throws NonExistingResourceException, IllegalArgumentException {
        timeConsultationFacade.update(request, timeConsultationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @ApiOperation(value = "Eliminacion de tiempo de consulta Medica", notes = "Este metodo permite eliminar el tiempo de una consulta Medica")
    @DeleteMapping(value = TIME_CONSULTATION_ID)
    public ResponseEntity<Void> deleteTimeConsultation(@PathVariable Long timeConsultationId) throws NonExistingResourceException {
        timeConsultationFacade.delete(timeConsultationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
