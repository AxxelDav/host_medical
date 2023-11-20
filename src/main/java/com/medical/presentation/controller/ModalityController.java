package com.medical.presentation.controller;

import com.medical.business.facade.ProfessionalFacade;
import com.medical.business.facade.UserFacade;
import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.dto.request.UserRequest;
import com.medical.domain.dto.response.UserResponse;
import com.medical.presentation.controller.endpoint.ModalityEndpoint;
import com.medical.presentation.controller.endpoint.WorkingShiftEndpoint;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping(ModalityEndpoint.BASE)
public class ModalityController {

    @Autowired
    private UserFacade userFacade;


    @Autowired
    private ProfessionalFacade professionalFacade;


    @ApiOperation(value = "Obtencion de una Modalidad", notes = "Este metodo permite obtener una Modalidad")
    @GetMapping(value = ModalityEndpoint.MODALITY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long userId) throws NonExistingResourceException {
        UserResponse user = userFacade.findById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @ApiOperation(value = "Creacion de una Modalidad", notes = "Este metodo permite crear una Modalidad")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) throws IllegalArgumentException {
        UserResponse user = userFacade.create(request);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }


    @ApiOperation(value = "Actualizacion de una Modalidad", notes = "Este metodo permite actualizar una Modalidad")
    @PutMapping(value = ModalityEndpoint.MODALITY_ID, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateUser(@RequestBody UserRequest request, @PathVariable Long userId) throws Exception {
        UserResponse user = userFacade.update(request, userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @ApiOperation(value = "Eliminacion de una Modalidad", notes = "Este metodo permite eliminar una Modalidad")
    @DeleteMapping(value = ModalityEndpoint.MODALITY_ID)
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) throws NonExistingResourceException {
        userFacade.delete(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
