package com.medical.presentation.controller;

import com.medical.business.facade.ModalityFacade;
import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.dto.request.ModalityRequest;
import com.medical.domain.dto.response.ModalityResponse;
import com.medical.presentation.controller.endpoint.ModalityEndpoint;
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
@RequestMapping(ModalityEndpoint.BASE)
public class ModalityController {

    @Autowired
    private ModalityFacade modalityFacade;

    @ApiOperation(value = "Obtencion de una Modalidad", notes = "Este metodo permite obtener una Modalidad")
    @GetMapping(value = ModalityEndpoint.MODALITY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ModalityResponse> getModalityById(@PathVariable Long modalityId) throws NonExistingResourceException {
        ModalityResponse modality = modalityFacade.findById(modalityId);
        return new ResponseEntity<>(modality, HttpStatus.OK);
    }


    @ApiOperation(value = "Creacion de una Modalidad", notes = "Este metodo permite crear una Modalidad")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ModalityResponse> createModality(@RequestBody ModalityRequest request) throws IllegalArgumentException {
        ModalityResponse modality = modalityFacade.create(request);
        return new ResponseEntity<>(modality, HttpStatus.CREATED);
    }


    @ApiOperation(value = "Actualizacion de una Modalidad", notes = "Este metodo permite actualizar una Modalidad")
    @PutMapping(value = ModalityEndpoint.MODALITY_ID, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateModality(@RequestBody ModalityRequest request, @PathVariable Long modalityId) throws Exception {
        modalityFacade.update(request, modalityId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @ApiOperation(value = "Eliminacion de una Modalidad", notes = "Este metodo permite eliminar una Modalidad")
    @DeleteMapping(value = ModalityEndpoint.MODALITY_ID)
    public ResponseEntity<Void> deleteModality(@PathVariable Long modalityId) throws NonExistingResourceException {
        modalityFacade.delete(modalityId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
