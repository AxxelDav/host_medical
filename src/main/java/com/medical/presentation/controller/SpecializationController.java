package com.medical.presentation.controller;

import com.medical.business.facade.SpecializationFacade;
import com.medical.domain.dto.SpecializationDTO;
import com.medical.domain.dto.request.SpecializationRequest;
import com.medical.presentation.controller.endpoint.SpecializationEndpoint;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api
@RestController
@RequestMapping(SpecializationEndpoint.BASE)
public class SpecializationController implements SpecializationEndpoint {

    @Autowired
    private SpecializationFacade specializationFacade;


    @ApiOperation(value = "Creacion de una especialidad Medica", notes = "Este metodo permite crear una especialidad Medica")
    @PostMapping
    public ResponseEntity<SpecializationDTO> createSpecialization(@RequestBody SpecializationRequest request) {
        SpecializationDTO specialization = specializationFacade.createSpecialization(request);
        return new ResponseEntity<>(specialization, HttpStatus.CREATED);
    }


    @ApiOperation(value = "Regresa una especialidad Medica", notes = "Este metodo permite obtener una especialidad Medica")
    @GetMapping(SpecializationEndpoint.SPECIALIZATION_BY_ID)
    public ResponseEntity<SpecializationDTO> getSpecialization(@PathVariable Long specializationId) throws Exception {
        SpecializationDTO specialization = specializationFacade.getSpecialization(specializationId);
        return new ResponseEntity<>(specialization, HttpStatus.OK);
    }


    @ApiOperation(value = "Regresa un listado de especialidades Medicas", notes = "Este metodo permite obtener un listado de especialidades Medicas")
    @GetMapping(value = SPECIALIZATIONS)
    public ResponseEntity<List<SpecializationDTO>> getAllSpecializations() throws Exception {
        List<SpecializationDTO> specializations = specializationFacade.getAllSpecializations();
        return new ResponseEntity<>(specializations, HttpStatus.OK);
    }


    @ApiOperation(value = "Actualizacion de una especialidad Medica", notes = "Este metodo permite actualizar una especialidad Medica")
    @PutMapping(value = SPECIALIZATION_BY_ID)
    public ResponseEntity<SpecializationDTO> updateSpecialization(@RequestBody SpecializationRequest request, @PathVariable Long specializationId) throws Exception {
        SpecializationDTO specialization = specializationFacade.updateSpecialization(request, specializationId);
        return new ResponseEntity<>(specialization, HttpStatus.OK);
    }


    @ApiOperation(value = "Regresa una especialidad Medica por descripcion", notes = "Este metodo permite obtener una especialidad Medica por descripcion")
    @GetMapping(value = SPECIALIZATION_BY_DESCRIPTION)
    public ResponseEntity<SpecializationDTO> findByDescription(@PathVariable String specializationDescription) {
        SpecializationDTO specialization = specializationFacade.findSpecializationByDescripcion(specializationDescription);
        return new ResponseEntity<>(specialization, HttpStatus.OK);
    }
}