package com.medical.domain.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class TimeConsultationDTO {

    private Long id;
    private Integer minutes;
}
