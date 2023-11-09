package com.medical.domain.dto.request;

import com.medical.domain.model.Professional;
import lombok.Data;

import java.util.List;

@Data
public class WorkingDayRequest {

    private String day;
    private List<Professional> professionals;
}
