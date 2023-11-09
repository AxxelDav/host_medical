package com.medical.domain.dto;

import com.medical.domain.model.Professional;
import lombok.Data;

import java.util.List;

@Data
public class WorkingDayDTO {

    private Long id;
    private String day;
    private List<Professional> professionals;
}
