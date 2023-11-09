package com.medical.presentation.controller;

import com.medical.business.facade.TimeConsultationFacade;
import com.medical.domain.dto.TimeConsultationDTO;
import com.medical.domain.dto.request.TimeConsultationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/time-consultation")
public class TimeConsultationController {

    @Autowired
    private TimeConsultationFacade timeConsultationFacade;

    @PostMapping
    public ResponseEntity<TimeConsultationDTO> createTimeConsultation(@RequestBody TimeConsultationRequest request) {
        TimeConsultationDTO timeConsultationDTO = timeConsultationFacade.createTimeConsultation(request);
        return new ResponseEntity<>(timeConsultationDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{timeConsultationId}")
    public ResponseEntity<TimeConsultationDTO> getTimeConsultation(@PathVariable Long timeConsultationId) throws Exception {
        TimeConsultationDTO timeConsultationDTO = timeConsultationFacade.getTimeConsultation(timeConsultationId);
        return new ResponseEntity<>(timeConsultationDTO, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<TimeConsultationDTO> updateTimeConsultation(@RequestBody TimeConsultationRequest request) throws Exception {
        TimeConsultationDTO timeConsultationDTO = timeConsultationFacade.updateTimeConsultation(request);
        return new ResponseEntity<>(timeConsultationDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{timeConsultationId}")
    public ResponseEntity<String> deleteTimeConsultation(@PathVariable Long timeConsultationId) throws Exception {
        timeConsultationFacade.deleteTimeConsultation(timeConsultationId);
        return new ResponseEntity<>("TimeConsultation deleted with success", HttpStatus.NO_CONTENT);
    }

}
