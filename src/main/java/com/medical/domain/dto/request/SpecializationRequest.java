package com.medical.domain.dto.request;

import com.medical.domain.model.Modality;
import lombok.Data;

@Data
public class SpecializationRequest {

    private String description;
    private Modality modality;
}
