package com.medical.domain.dto.request;

import lombok.Data;

@Data
public class WorkingShiftRequest {

    private String description;
    private Integer entryHour;
}
