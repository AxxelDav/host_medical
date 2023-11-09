package com.medical.presentation.controller;

import com.medical.business.facade.WorkingDayFacade;
import com.medical.domain.dto.WorkingDayDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workingday")
public class WorkingDayController {


    @Autowired
    private WorkingDayFacade workingDayFacade;


    @GetMapping("/{workingDayId}")
    public ResponseEntity<WorkingDayDTO> getWorkingDay(@PathVariable Long workingDayId) throws Exception {
        WorkingDayDTO workingDay = workingDayFacade.getWorkingDay(workingDayId);
        return new ResponseEntity<>(workingDay, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<WorkingDayDTO>> getAllWorkingDay() {
        List<WorkingDayDTO> workingDays = workingDayFacade.getAllWorkingDay();
        return new ResponseEntity<>(workingDays, HttpStatus.OK);
    }
}
