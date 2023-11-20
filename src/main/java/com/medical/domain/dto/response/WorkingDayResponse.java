package com.medical.domain.dto.response;

import com.medical.domain.model.Professional;
import lombok.Data;

import java.util.List;

@Data
public class WorkingDayResponse {

    private Long id;
    private String day;
    private List<Professional> professionals;
}
