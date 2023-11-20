package com.medical.presentation.controller;

import com.medical.business.facade.MedicalBranchFacade;
import com.medical.common.exception.DataInconsistencyException;
import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.dto.response.MedicalBranchResponse;
import com.medical.domain.dto.request.MedicalBranchRequest;
import com.medical.presentation.controller.endpoint.MedicalBranchEndpoint;
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
@RequestMapping(MedicalBranchEndpoint.BASE)
public class MedicalBranchController implements MedicalBranchEndpoint {

    @Autowired
    private MedicalBranchFacade medicalBranchFacade;


    @ApiOperation(value = "Regresa una Sucursal/Medical_Branch", notes = "Este metodo permite obtener una sucursal")
    @GetMapping(path = MedicalBranchEndpoint.MEDICAL_BRANCH_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MedicalBranchResponse> getMedicalBranch(@PathVariable Long medicalBranchId) throws NonExistingResourceException {
        MedicalBranchResponse medicalBranch = medicalBranchFacade.findById(medicalBranchId);
        return new ResponseEntity<>(medicalBranch, HttpStatus.OK);
    }


    @ApiOperation(value = "Creacion de una Sucursal/Medical_Branch", notes = "Este metodo permite crear una sucursal")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MedicalBranchResponse> createMedicalBranch(@RequestBody MedicalBranchRequest request) throws IllegalArgumentException {
        MedicalBranchResponse medicalBranchCreated = medicalBranchFacade.create(request);
        return new ResponseEntity<>(medicalBranchCreated, HttpStatus.CREATED);
    }


    @ApiOperation(value = "Actualiza una Sucursal/Medical_Branch", notes = "Este metodo permite editar una sucursal")
    @PutMapping(path = MedicalBranchEndpoint.MEDICAL_BRANCH_ID, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateMedicalBranch(@PathVariable Long medicalBranchId, @RequestBody MedicalBranchRequest request) throws NonExistingResourceException, IllegalArgumentException {
        medicalBranchFacade.update(request, medicalBranchId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @ApiOperation(value = "Elimina una Sucursal/Medical_Branch", notes = "Este metodo permite eliminar una sucursal")
    @DeleteMapping(path = MedicalBranchEndpoint.MEDICAL_BRANCH_ID)
    public ResponseEntity<Void> deleteMedicalBranch(@PathVariable Long medicalBranchId) throws NonExistingResourceException {
        medicalBranchFacade.deleteById(medicalBranchId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @ApiOperation(value = "Regresa una Sucursal/Medical_Branch por Localidad, Calle y Altura", notes = "Este metodo permite obtener una sucursal por Localidad, Calle y Altura")
    @GetMapping(path = MedicalBranchEndpoint.FIND_LOCAL_AND_NUMBER_AND_STREET)
    public ResponseEntity<MedicalBranchResponse> findByLocaleAndNumberAndStreet(@PathVariable String locale, @PathVariable String streetNumber, @PathVariable String street) throws DataInconsistencyException, IllegalArgumentException {
        MedicalBranchResponse medicalBranch = medicalBranchFacade.findByLocaleAndNumberAndStreet(locale, streetNumber, street);
        return new ResponseEntity<>(medicalBranch, HttpStatus.OK);
    }

    @ApiOperation(value = "Regresa una Sucursal/Medical_Branch por Especializacion y Profesional", notes = "Este metodo permite obtener una sucursal por Especializacion y Profesional")
    @GetMapping(path = MedicalBranchEndpoint.FIND_MEDICAL_BRANCH_BY_SPECIALIZATION_AND_PROFESSIONAL)
    public ResponseEntity<List<MedicalBranchResponse>> findMedicalBranchBySpecializationAndProfessional(@PathVariable Long specializationId, @PathVariable Long professionalId) throws Exception {
        List<MedicalBranchResponse> medicalBranches = medicalBranchFacade.findMedicalBranchBySpecializationAndProfessional(specializationId, professionalId);
        ResponseEntity<List<MedicalBranchResponse>> response;
        if (isNull(medicalBranches) || medicalBranches.isEmpty()) {
            response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            response = new ResponseEntity<>(medicalBranches, HttpStatus.OK);
        }
        return response;
    }

}
