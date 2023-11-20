package com.medical.domain.dto.response;

import lombok.Data;

@Data
public class WorkingShiftResponse {

    private Long id;
    private String description;
    private Integer entryHour;
}
