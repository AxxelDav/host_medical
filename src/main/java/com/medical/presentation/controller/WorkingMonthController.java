package com.medical.presentation.controller;

import com.medical.business.facade.WorkingMonthFacade;
import com.medical.domain.dto.WorkingMonthDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workingmonth")
public class WorkingMonthController {

    @Autowired
    private WorkingMonthFacade workingMonthFacade;

    @GetMapping("/{workingMonthId}")
    public ResponseEntity<WorkingMonthDTO> getWorkingMonth(@PathVariable Long workingMonthId) throws Exception {
        WorkingMonthDTO workingMonth = workingMonthFacade.getWorkingMonth(workingMonthId);
        return new ResponseEntity<>(workingMonth, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<WorkingMonthDTO>> getWorkingMonths() {
        List<WorkingMonthDTO> workingMonths = workingMonthFacade.getWorkingMonths();
        return new ResponseEntity<>(workingMonths, HttpStatus.OK);
    }
}
