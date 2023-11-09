package com.medical.presentation.controller;

import com.medical.business.facade.MedicalBranchFacade;
import com.medical.domain.dto.MedicalBranchDTO;
import com.medical.domain.dto.request.MedicalBranchRequest;
import com.medical.domain.model.MedicalBranch;
import com.medical.business.service.MedicalBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medical-branch")
public class MedicalBranchController {

    @Autowired
    private MedicalBranchFacade medicalBranchFacade;


    @PostMapping
    public ResponseEntity<MedicalBranchDTO> createMedicalBranch(@RequestBody MedicalBranchRequest request) {
        MedicalBranchDTO medicalBranchCreated = medicalBranchFacade.createMedicalBranch(request);
        return new ResponseEntity<>(medicalBranchCreated, HttpStatus.CREATED);
    }


    @GetMapping("/{medicalBranchId}")
    public ResponseEntity<MedicalBranchDTO> getMedicalBranch(@PathVariable Long medicalBranchId) throws Exception {
        MedicalBranchDTO medicalBranch = medicalBranchFacade.getMedicalBranch(medicalBranchId);
        return new ResponseEntity<>(medicalBranch, HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<MedicalBranchDTO> updateMedicalBranch(@RequestBody MedicalBranchRequest request) throws Exception {
        MedicalBranchDTO medicalBranchUpdated = medicalBranchFacade.updateMedicalBranch(request);
        return new ResponseEntity<>(medicalBranchUpdated, HttpStatus.CREATED);
    }


    @DeleteMapping("/{medicalBranchId}")
    public ResponseEntity<String> deleteMedicalBranch(@PathVariable Long medicalBranchId) throws Exception {
        medicalBranchFacade.deleteMedicalBranch(medicalBranchId);
        return new ResponseEntity<>("MedicalBranch eliminado con éxito", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{locale}/{streetNumber}/{street}")
    public ResponseEntity<MedicalBranchDTO> findByLocaleAndNumberAndStreet(@PathVariable String locale, @PathVariable String streetNumber, @PathVariable String street) throws Exception {  //podria pasarse como parametro un DTO que contenga esos atributos
        MedicalBranchDTO medicalBranch = medicalBranchFacade.findByLocaleAndNumberAndStreet(locale, streetNumber, street);
        return new ResponseEntity<>(medicalBranch, HttpStatus.OK);
    }

    /*
    @GetMapping("/specialization-and-professional")  ///esta mal que a un get le pases RequestBody?? chequear bien este endpoint. O crear un DTO fijate que es lo correcto para hacer
    public ResponseEntity<?> findMedicalBranchBySpecializationAndProfessional(@RequestBody Specialization specialization, @RequestBody Professional professional) throws Exception {
        List<MedicalBranch> medicalBranches = medicalBranchService.findMedicalBranchBySpecializationAndProfessional(specialization, professional);
        return new ResponseEntity<>(medicalBranches, HttpStatus.OK);
    } */
    @GetMapping("/{specializationId}/{professionalId}")  ///esta mal que a un get le pases RequestBody?? chequear bien este endpoint. O crear un DTO fijate que es lo correcto para hacer
    public ResponseEntity<List<MedicalBranchDTO>> findMedicalBranchBySpecializationAndProfessional(@PathVariable Long specializationId, @PathVariable Long professionalId) throws Exception {
        List<MedicalBranchDTO> medicalBranches = medicalBranchFacade.findMedicalBranchBySpecializationAndProfessional(specializationId, professionalId);
        return new ResponseEntity<>(medicalBranches, HttpStatus.OK);
    }

}
