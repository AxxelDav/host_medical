package com.medical.presentation.controller;

import com.medical.business.facade.SpecializationFacade;
import com.medical.domain.dto.SpecializationDTO;
import com.medical.domain.dto.request.SpecializationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/specialization")
public class SpecializationController {

    @Autowired
    private SpecializationFacade specializationFacade;

    @PostMapping
    public ResponseEntity<SpecializationDTO> createSpecialization(@RequestBody SpecializationRequest request) {
        SpecializationDTO specialization = specializationFacade.createSpecialization(request);
        return new ResponseEntity<>(specialization, HttpStatus.CREATED);
    }

    @GetMapping("/{specializationId}")
    public ResponseEntity<SpecializationDTO> getSpecialization(@PathVariable Long specializationId) throws Exception {
        SpecializationDTO specialization = specializationFacade.getSpecialization(specializationId);
        return new ResponseEntity<>(specialization, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<SpecializationDTO> updateSpecialization(@RequestBody SpecializationRequest request) throws Exception {
        SpecializationDTO specialization = specializationFacade.updateSpecialization(request);
        return new ResponseEntity<>(specialization, HttpStatus.OK);
    }

    @GetMapping("/{specializationDescription}")
    public ResponseEntity<SpecializationDTO> findByDescription(@PathVariable String specializationDescription) {
        SpecializationDTO specialization = specializationFacade.findSpecializationByDescripcion(specializationDescription);
        return new ResponseEntity<>(specialization, HttpStatus.OK);
    }
}
