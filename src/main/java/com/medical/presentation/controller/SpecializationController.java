package com.medical.presentation.controller;

import com.medical.business.facade.SpecializationFacade;
import com.medical.common.exception.DataInconsistencyException;
import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.dto.response.SpecializationResponse;
import com.medical.domain.dto.request.SpecializationRequest;
import com.medical.domain.model.Modality;
import com.medical.domain.model.Specialization;
import com.medical.presentation.controller.endpoint.SpecializationEndpoint;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

import static java.util.Objects.isNull;

@Api
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(SpecializationEndpoint.BASE)
public class SpecializationController implements SpecializationEndpoint {

    @Autowired
    private SpecializationFacade specializationFacade;


    @ApiOperation(value = "Regresa una especialidad Medica", notes = "Este metodo permite obtener una especialidad Medica")
    @GetMapping(value = SpecializationEndpoint.SPECIALIZATION_BY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SpecializationResponse> getSpecialization(@PathVariable Long specializationId) throws NonExistingResourceException {
        SpecializationResponse specialization = specializationFacade.findById(specializationId);
        return new ResponseEntity<>(specialization, HttpStatus.OK);
    }


    @ApiOperation(value = "Creacion de una especialidad Medica", notes = "Este metodo permite crear una especialidad Medica")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SpecializationResponse> createSpecialization(@RequestBody SpecializationRequest request) throws IllegalArgumentException  {
        SpecializationResponse specialization = specializationFacade.create(request);
        return new ResponseEntity<>(specialization, HttpStatus.CREATED);
    }


    @ApiOperation(value = "Regresa un listado de especialidades Medicas", notes = "Este metodo permite obtener un listado de especialidades Medicas")
    @GetMapping(value = SPECIALIZATIONS, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SpecializationResponse>> getAllSpecializations() throws Exception {
        List<SpecializationResponse> specializations = specializationFacade.findAll();
        return new ResponseEntity<>(specializations, HttpStatus.OK);
    }


    @ApiOperation(value = "Actualizacion de una especialidad Medica", notes = "Este metodo permite actualizar una especialidad Medica")
    @PutMapping(value = SPECIALIZATION_BY_ID, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateSpecialization(@RequestBody SpecializationRequest request, @PathVariable Long specializationId) throws NonExistingResourceException, IllegalArgumentException {
        specializationFacade.update(request, specializationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @ApiOperation(value = "Regresa una especialidad Medica por descripcion", notes = "Este metodo permite obtener una especialidad Medica por descripcion")
    @GetMapping(value = SPECIALIZATION_BY_DESCRIPTION, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SpecializationResponse> findByDescription(@PathVariable String specializationDescription) throws DataInconsistencyException {
        SpecializationResponse specialization = specializationFacade.findSpecializationByDescripcion(specializationDescription);
        return new ResponseEntity<>(specialization, HttpStatus.OK);
    }


    @ApiOperation(value = "Regresa todos los Turnos Medicos por Modalidad", notes = "Este metodo permite obtener todos los Turnos Medicos por Modalidad")
    @GetMapping(value = SPECIALIZATIONS_BY_MODALITY, produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<SpecializationResponse>> findAllSpecializationByModality(@PathVariable("modalityId") Long modalityId) throws DataInconsistencyException, IllegalArgumentException, NonExistingResourceException {
        List<SpecializationResponse> specializations = specializationFacade.findAllSpecializationByModality(modalityId);
        ResponseEntity<List<SpecializationResponse>> response;
        if (isNull(specializations) || specializations.isEmpty()) {
            response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            response = new ResponseEntity<>(specializations, HttpStatus.OK);
        }
        return response;
    }


}