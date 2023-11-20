package com.medical.presentation.controller;

import com.medical.business.facade.ProfessionalFacade;
import com.medical.business.facade.UserFacade;
import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.dto.response.UserResponse;
import com.medical.domain.dto.request.UserRequest;
import com.medical.presentation.controller.endpoint.UserEndpoint;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping(UserEndpoint.BASE)
public class UserController implements UserEndpoint {

    @Autowired
    private UserFacade userFacade;


    @Autowired
    private ProfessionalFacade professionalFacade;


    @ApiOperation(value = "Obtencion de un Usuario/Paciente", notes = "Este metodo permite obtener un Usuario/Paciente")
    @GetMapping(value = USER_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long userId) throws NonExistingResourceException {
        UserResponse user = userFacade.findById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @ApiOperation(value = "Creacion de un Usuario/Paciente", notes = "Este metodo permite crear un Usuario/Paciente")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) throws IllegalArgumentException {
        UserResponse user = userFacade.create(request);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }


    @ApiOperation(value = "Actualizacion de un Usuario/Paciente", notes = "Este metodo permite actualizar un Usuario/Paciente")
    @PutMapping(value = USER_ID, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateUser(@RequestBody UserRequest request, @PathVariable Long userId) throws Exception {
        UserResponse user = userFacade.update(request, userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @ApiOperation(value = "Eliminacion de un Usuario/Paciente", notes = "Este metodo permite eliminar un Usuario/Paciente")
    @DeleteMapping(value = USER_ID)
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) throws NonExistingResourceException {
        userFacade.delete(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
