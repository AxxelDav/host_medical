package com.medical.presentation.controller;

import com.medical.business.facade.WorkingShiftFacade;
import com.medical.domain.dto.WorkingShiftDTO;
import com.medical.domain.dto.request.WorkingShiftRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workshift")
public class WorkShiftController {

    @Autowired
    private WorkingShiftFacade workingShiftFacade;


    @PostMapping
    public ResponseEntity<WorkingShiftDTO> createWorkShift(@RequestBody WorkingShiftRequest request) {
        WorkingShiftDTO workingShiftCreated = workingShiftFacade.createWorkShift(request);
        return new ResponseEntity<>(workingShiftCreated, HttpStatus.CREATED);
    }


    @GetMapping("/{workingShiftId}")
    public ResponseEntity<WorkingShiftDTO> getWorkingShift(@PathVariable Long workingShiftId) throws Exception {
        WorkingShiftDTO workingShift = workingShiftFacade.getWorkShift(workingShiftId);
        return new ResponseEntity<>(workingShift, HttpStatus.OK);
    }


    @PutMapping("/{workingShiftId}")
    public ResponseEntity<WorkingShiftDTO> updateWorkShift(@RequestBody WorkingShiftRequest request, @PathVariable Long workingShiftId) throws Exception {
        WorkingShiftDTO workingShiftUpdated = workingShiftFacade.updateWorkShift(request, workingShiftId);
        return new ResponseEntity<>(workingShiftUpdated, HttpStatus.CREATED);
    }


    @DeleteMapping("/{workingShiftId}")
    public ResponseEntity<String> deleteWorkingShift(@PathVariable Long workingShiftId) throws Exception {
        workingShiftFacade.deleteWorkShift(workingShiftId);
        return new ResponseEntity<>("WorkingShift eliminado con éxito", HttpStatus.NO_CONTENT);
    }


    @GetMapping("/{locale}/{streetNumber}/{street}")
    public ResponseEntity<List<WorkingShiftDTO>> findByLocaleAndNumberAndStreet() {
        List<WorkingShiftDTO> workingShifts = workingShiftFacade.getAllWorkingShift();
        return new ResponseEntity<>(workingShifts, HttpStatus.OK);
    }

}
