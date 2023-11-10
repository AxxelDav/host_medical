package com.medical.presentation.controller;

import com.medical.business.facade.ProfessionalFacade;
import com.medical.business.facade.UserFacade;
import com.medical.domain.dto.UserDTO;
import com.medical.domain.dto.request.UserRequest;
import com.medical.presentation.controller.endpoint.UserEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UserEndpoint.BASE)
public class UserController implements UserEndpoint {

    @Autowired
    private UserFacade userFacade;


    @Autowired
    private ProfessionalFacade professionalFacade;

    @GetMapping(value = USER_ID)
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long userId) throws Exception {
        UserDTO user = userFacade.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserRequest request) {
        UserDTO user = userFacade.createUser(request);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserRequest request, @PathVariable Long userId) throws Exception {
        UserDTO user = userFacade.updateUser(request, userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping(value = USER_ID)
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) throws Exception {
        userFacade.deleteUser(userId);
        return new ResponseEntity<>("User con ID: " + userId +  " eliminado con éxito", HttpStatus.NO_CONTENT);
    }

}
