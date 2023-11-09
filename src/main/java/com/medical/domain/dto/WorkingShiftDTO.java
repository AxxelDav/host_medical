package com.medical.domain.dto;

import lombok.Data;

@Data
public class WorkingShiftDTO {

    private Long id;
    private String description;
    private Integer entryHour;
}
